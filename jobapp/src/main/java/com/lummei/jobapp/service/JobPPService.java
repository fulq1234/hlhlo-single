package com.lummei.jobapp.service;

import com.lummei.jobapp.entity.*;
import com.lummei.jobapp.mapper.*;
import com.lummei.jobapp.protocol.*;
import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.Position;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Service
public class JobPPService {

    @Autowired
    private UserServiceImpl userService;//用户

    @Autowired
    private ResumerMapper resumerMapper;//简历

    @Autowired
    private CareerObjectiveMapper careerObjectiveMapper;//求职意向

    @Autowired
    private WorkExperienceMapper workExperienceMapper;//工作经验

    @Autowired
    private EducationMapper educationMapper;//教育经验

    @Autowired
    private JobSeekerMapper jobSeekerMapper;//求职者信息

    @Autowired
    private IndustryZhilianMapper industryZhilianMapper;//对照表

    @Autowired
    private ProjectsMapper projectsMapper;//项目经验


    public int mainJobPP2(){
        dealUnderFile(new File("F:\\呼啦圈\\template\\智联招聘_丁泽斌_java开发工程师_中文_20180912_1536737999025.html"));
        return 1;
    }
    public int mainJobPP(){
        //File file = new File("F:\\file\\智联招聘_安玉璞_英文客服无销售双休_中文_20180911_1536666988677.html");
       File[] listFiles = new File("F:\\呼啦圈\\template").listFiles();
        //File[] listFiles = new File("F:\\呼啦圈\\file").listFiles();

        //创建定长线程池，可控制线程最大并发数，超过的县城会再队列中等待。
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(10);

        for(File file :listFiles){

            if(file.isDirectory()){
                continue;//如果是文件夹就不管，继续循环
            }
            String fileName = file.getName();
            //System.out.println("fileName="+fileName);
            String lastFileName = fileName.substring(fileName.indexOf("."),fileName.length());
            if(!lastFileName.equals(".html")){
                continue;//如果不是html文件，就不操作
            }
            dealUnderFile(file);
            /*fixedThreadPool.execute(new Runnable() {
                @Override
                public void run() {
                    dealUnderFile(file);
                }
            });*/


        }

        return 1;
    }

    /**
     * 解析一个html文件的所有简历信息。
     * @param file
     */
    private void dealUnderFile(File file){

        //插入用户
        HlhloUser user = this.getHlhloUser(file);
        Result<Boolean> result = userService.regUser(user);

        Long userId = user.getId();
        if(userId != null){
            //简历
            Resume resume = this.getResume(file,userId);
            int a = resumerMapper.save(resume);//插入简历



            Resume nn = resumerMapper.getResumeByUserId(userId);

            //求职意向
            CareerObjective careerObjective = this.getCareerObjective(file,nn);
            careerObjectiveMapper.save(careerObjective);

            //工作经历
            List<WorkExperience> workEList = this.getWorkExperienceList(file,nn);
            for(WorkExperience one : workEList){
                workExperienceMapper.save(one);
            }

            //根据工作经历，求最开始工作的时间
            Date earliest = null;
            for(WorkExperience one : workEList){
                Date startDate = one.getStartDate();
                if(startDate != null ){
                    if(earliest == null){
                        earliest = startDate;
                    }else if(earliest != null && startDate.after(earliest)){
                        earliest = startDate;
                    }
                }
            }

            //求职者信息
            JobSeeker jobSeeker = this.getJobSeeker(file,userId);
            if(earliest != null)
                jobSeeker.setStartWorkTime(earliest);
            else{
                //System.out.println("startWorkTime is null");
            }
            jobSeekerMapper.update(jobSeeker);

            //教育经历
            List<Education> educationList = this.getEductions(file,nn);
            for(Education one : educationList){
                educationMapper.save(one);
            }

            //项目经验
            List<Projects> projectsList = this.getProjectList(file,nn);
            for(Projects projects : projectsList){
                projectsMapper.save(projects);
            }

        }

    }

    //插入用户
    private HlhloUser getHlhloUser(File file){
        HlhloUser user = new HlhloUser();

        Document doc = null;
        try {
            doc = Jsoup.parse(file,"UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Elements ess = doc.select("div[class=resume-preview-main-title]");
        String s = doc.select("div[class=resume-preview-main-title]").text();
        //姓名
        String name = s;
        if(s.contains(" 手机")){
            name = s.substring(0,s.indexOf(" 手机"));
        }
        /*if(name.length() >20){
            System.out.println(file.getName()+",name:"+name);
        }*/
        user.setRealName(name);




        //女     24岁 (1994年4月)     本科 现居住地：石家庄 长安区 | 户口：石家庄 | 群众
        String topq = doc.select("div[class=summary-top]").text();

        String[] toparr = topq.split(" ");

        for(String temp : toparr){
            if(temp.equals("男")||temp.equals("女")){
                user.setSex(temp);//性别
            }else if(temp.contains("(") && temp.contains(")")){//出生年月
                //解析字符串类似“24岁 (1994年10月)”
                // String yearstr = temp.substring(temp.indexOf("("),temp.indexOf(")"));
                SimpleDateFormat df = new SimpleDateFormat("(yyyy年MM月)");
                try{
                    user.setBirthday(df.parse(temp));//出生年月
                }catch (ParseException e){
                    e.printStackTrace();
                }

            }

        }


        //身份证：130524199707122027 手机：13473741796 E-mail：749183884@qq.com
        String botm = doc.select("div[class=summary-bottom]").text();
        String[] arr = botm.split(" ");

        for(String temp : arr){
//            if(temp.contains("身份证")){
//                jobSeeker.setIdcard(temp.replaceAll("[^0-9]",""));
//            }else
            if(temp.contains("手机")){
                String mobile = temp.replaceAll("[^0-9]","");
                user.setUsername("in"+mobile);
                user.setMobile(mobile);
            }else if(temp.contains("E-mail")){
                user.setEmail(temp.replaceAll("E-mail：",""));
            }
        }

        user.setStatus(UserStatus.NORMAL.getCodeValue());//用户状态
        user.setCreateTime(new Date());//创建时间
        user.setPassword("123456");//密码
        return user;
    }

    //插入简历
    private Resume getResume(File file,Long UserId) {


         Resume resume = new Resume();
         //File file = new File("F:\\file\\智联招聘_安玉璞_英文客服无销售双休_中文_20180911_1536666988677.html");
         Document doc = null;
         try {
             doc = Jsoup.parse(file, "UTF-8");
         } catch (IOException e) {
             e.printStackTrace();
         }

         // Elements ess = doc.select("div[class=resume-preview-main-title]");
        String s = doc.select("div[class=resume-preview-main-title]").text();
        //姓名
        String name = s;
        if(s.contains(" 手机")){
            name = s.substring(0,s.indexOf(" 手机"));
        }
        /*if(name.length() >20){
            System.out.println(file.getName()+",name:"+name);
        }*/
        if(name != null && name.length() >=1){//可以取到姓

            String xing = name.substring(0,1);//姓
            String topq = doc.select("div[class=summary-top]").text();

            String[] toparr = topq.split(" ");

            for(String temp : toparr) {
                if (temp.equals("男") ) {
                    //jobSeeker.setSex(temp);//性别
                    resume.setTitle(xing + "先生的简历");
                }else if(temp.equals("女")){
                    resume.setTitle(xing + "女士的简历");
                }
            }
        }else{
            resume.setTitle("简历");
        }


         //自我介绍
         Elements elements = doc.select("div[class=resume-preview-all]");
         for (Element element : elements) {
             String rowTitle = element.select("h3:eq(0)").text();
             if (rowTitle != null && rowTitle.equals("自我评价")) {
                 String info = element.select("div[class=resume-preview-dl rd-break]").text();
                 //System.out.println(file.getName() + " length=" + info.length() + " info=" + info);

                //替换表情begin
                 info = info.replaceAll("\uD83D\uDE0A","");//自我介绍中有个笑脸符号，要替换掉。
                 info = info.replaceAll("\uD83D\uDC67","");
                 info = info.replaceAll("ღ","");
                 info = info.replaceAll("⌣˘","");
                 info = info.replaceAll("\uD83D\uDC4D","");
                 info = info.replaceAll("\uD83D\uDE0C","");
                //替换表情end

                 if (info != null && info.length() < 1000) {
                     resume.setInfo(info);
                 }

                 break;//直接退出
             }
         }

         resume.setCreateTime(new java.util.Date());
         //其他
         resume.setPublishStatus("PUBLIC");//公开状态
//         resume.setUserId(0l);
         resume.setDeleteFlag(0);
        resume.setUserId(UserId);
         return resume;

    }

    /**
     * 求职者信息
     * @param file
     * @param userId
     * @return
     */
    public JobSeeker getJobSeeker(File file,Long userId){
        JobSeeker jobSeeker = new JobSeeker();
        jobSeeker.setId(userId);
        Document doc = null;
        try {
            doc = Jsoup.parse(file,"UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        }



        //女     24岁 (1994年4月)     本科 现居住地：石家庄 长安区 | 户口：石家庄 | 群众
        String topq = doc.select("div[class=summary-top]").text();

        String[] toparr = topq.split(" ");


        for(int i = 0;i < toparr.length;i++){
            String temp = toparr[i];
            if(temp.contains("婚")){
                //婚姻状况
                jobSeeker.setMarriage(temp);
            }else if(temp != null && temp.contains("现居住地")){
                temp = temp.replace("现居住地：","");

               // System.out.println(temp);
                City city = (City) City.getDataDictionaryByKey(temp,City.class);//根据城市，求代码

                if(city != null){
                    jobSeeker.setCity(city.getCodeValue());
                }else{
                    System.out.println("城市:"+temp);
                    //jobSeeker.setCity(temp);
                }
            }else if(temp != null){
                //System.out.println("["+temp+"]");
               /* temp = temp.replaceAll(" ","");
                temp = temp.replaceAll(" ","");//看着像空格，但是不是空格
                if(temp.contains("本科")){
                    temp = "本科";
                }else if(temp.contains("专科")){
                    temp = "大专";
                }else if(temp.contains("中专")){
                    temp = "高中";
                }else{
                    System.out.println(temp);
                    temp = "其他";
                }

                Degree d = (Degree) Degree.getDataDictionaryByKey(temp,Degree.class);*/
                Degree d = this.dealDegree(temp);
                if(d != null){
                    jobSeeker.setDegree(d.getCodeValue());
                }
            }

        }


        //求职状态
        Elements elements = doc.select("div[class=resume-preview-all]");
        for(Element element : elements) {
            String rowTitle = element.select("h3:eq(0)").text();
            if (rowTitle != null && rowTitle.equals("求职意向")) {
                Elements trs = element.select("table").select("tr");
                for (Element tre : trs) {
                    String name1 = tre.select("td:eq(0)").text();
                    String value1 = tre.select("td:eq(1)").text();
                    if (name1.contains("目前状况")) {
                       if(value1.equals("我目前在职，正考虑换个新环境（如有合适的工作机会，到岗时间一个月左右）")){
                           jobSeeker.setJobStatus(JobStatus.MONTH_ARRIVE.getCodeValue());//在职-月内到岗
                       }else if(value1.equals("我目前处于离职状态，可立即上岗") || value1.equals("应届毕业生")){
                           jobSeeker.setJobStatus(JobStatus.ALL_TIME.getCodeValue());//离职，随时到岗
                       }else if(value1.equals("目前暂无跳槽打算")){
                           jobSeeker.setJobStatus(JobStatus.NO_CONSIDER.getCodeValue());//在职，暂不考虑
                       }else if(value1.equals("我对现有工作还算满意，如有更好的工作机会，我也可以考虑。（到岗时间另议）")){
                           jobSeeker.setJobStatus(JobStatus.CONSIDER.getCodeValue());//在职，考虑机会
                       }
                    }
                }
             break;
            }
        }


        return jobSeeker;
    }
    /**
     * 求职意向
     * @param file: 文件
     * @param resume: 简历
     * @return
     */
    public CareerObjective getCareerObjective(File file,Resume resume){
        CareerObjective careerObjective = new CareerObjective();
        careerObjective.setResumeId(resume.getId());//简历id

        Document doc = null;
        try {
            doc = Jsoup.parse(file,"UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        }

        Elements elements = doc.select("div[class=resume-preview-all]");
        for(Element element : elements){
            String rowTitle = element.select("h3:eq(0)").text();
            if(rowTitle != null && rowTitle.equals("求职意向")){
                Elements trs = element.select("table").select("tr");
                for(Element tre : trs){
                    String name = tre.select("td:eq(0)").text();
                    String value = tre.select("td:eq(1)").text();
                    if(name.contains("职业")){
                        //期望职位
                        //careerObjective.setFunction(value);
                        //如果有多个，就取第一项
                        String[] arr = value.split("、");
                        PositionType positionType = (PositionType) PositionType.getDataDictionaryByKey(arr[0],PositionType.class);
                        if(positionType!= null){
                            careerObjective.setFunction(positionType.getCodeValue());
                        }


                    }else if(name.contains("行业")){//互联网/电子商务、计算机软件、IT服务(系统/数据/维护)

                        String strs = this.dealIndustry(value);

                        careerObjective.setIndustry(strs);


                    }else if(name.contains("地区")){
                        //工作城市
                        /*if(value.length() >9){//石家庄、石家庄、石家庄
                           value = value.substring(0,9);
                        }*/
                        if(value.contains("、")){
                           // System.out.println("求职意向,location:" + value);
                            String[] arr = value.split("、");
                            value = arr[0];
                        }
                        City city = (City) City.getDataDictionaryByKey(value,City.class);
                        if(city !=null){
                            careerObjective.setLocation(city.getCodeValue());

                        }

                    }else if(name.contains("月薪")){//薪资要求
                        String svalue = this.getSalary(value);
                        careerObjective.setSalary(svalue);//薪资要求

                    }
                }

                break;//直接退出
            }
        }






        return careerObjective;
    }


    /**
     * 得到工作经验
     * @param file
     * @param resume
     * @return
     */
    public List<WorkExperience> getWorkExperienceList (File file, Resume resume){
        List<WorkExperience> list= new ArrayList<WorkExperience>();

        Document doc = null;
        try {
            doc = Jsoup.parse(file,"UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        }

        Elements elements = doc.select("div[class=resume-preview-all]");
        for(Element element : elements){
            String rowTitle = element.select("h3:eq(0)").text();
            if(rowTitle != null && rowTitle.contains("工作")){
                Elements trs = element.select("h2");
                for(int i =0;i<trs.size();i++){

                    WorkExperience workExperience = new WorkExperience();
                    workExperience.setResumeId(resume.getId());

                    //每个工作的第一行，字符串比如“2014.04 - 2016.09   安信联合（原中信信通国际物流有限公司）   (2年 6个月)”
                    Element element1 = trs.get(i);
                    String text = element1.text();//得到字符串，比如：2014.04 - 2016.09   安信联合（原中信信通国际物流有限公司）   (2年 6个月)
                    if(text != null){//解析字符串
                        String[] arr = text.split(" ");
                        if(arr.length >= 4){//arr[0]=2014.01,arr[1]=-,arr[2]=2016.09,arr[3]=安信联合（原中信信通国际物流有限公司） arr[4]=(2年 6个月)
                            String startdate = arr[0];
                            String enddate = arr[2];
                            SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM");
                            try {
                                //开始时间
                                workExperience.setStartDate(sdf.parse(startdate));

                            } catch (ParseException e) {
                                workExperience.setStartDate(new Date());
                                System.out.println("workExperience startDate="+startdate+" is error");
                            }

                            try {
                                //结束时间
                                workExperience.setEndDate(sdf.parse(enddate));
                            } catch (ParseException e) {
                                workExperience.setEndDate(new Date());
                                System.out.println("workExperience endDate="+enddate+" is error");
                            }

                            //公司名称
                            String str2 = arr[3];
                            workExperience.setCompanyName(str2);


                        }
                    }

                    Element e2 = element1.nextElementSibling();
                    //System.out.println(file.getName());
                    if(e2 != null){
                        //每个工作的第二行，比如“业务专员 | 2001-4000元/月”
                        String str2 = e2.text();

                        if(str2 !=null){
                            if(str2.contains("|")){
                                String[] arr = str2.split(" ");

                                workExperience.setPosition(arr[0]);
                                if(arr.length >= 3){
                                    if(arr[2].contains("-") || arr[2].contains("元")){//就是工资
                                        workExperience.setSalary(this.getSalary(arr[2]));//工资

                                    }else{
                                        //System.out.println("else1:"+arr[2]);
                                        if(arr.length>=4){
                                           // System.out.println("else2:"+arr[3]);
                                            workExperience.setSalary(this.getSalary(arr[3]));//工资
                                        }
                                    }
                                }
                            }else{//只有职业一项，没有工资。
                                workExperience.setPosition(str2);

                            }
                        }

                    }else{
                        System.out.println(file.getName()+",position is null");
                    }



                    //每个工作的第三行，比如“物流/仓储 | 企业性质：民营 | 规模：500-999人”
                    //int a = element.select("div[class=resume-preview-dl]").size();
                    Element e3 = e2.nextElementSibling();//element.select("div[class=resume-preview-dl]");
                    if(e3 != null){
                        String str3 = e3.text();
                        if(!str3.contains("工作描述")){
                            String[] arr = str3.split("\\|");
                            String hangyestrs = arr[0];//得到行业

                            //根据行业字符串得到行业代码。
                            String strs = this.dealIndustry(hangyestrs);

                            workExperience.setIndustry(strs);
                        }
                    }



                    list.add(workExperience);

                }

                break;//直接退出
            }
        }

        return list;
    }


    /**
     * 教育经历
     * @param file
     * @param resume
     * @return
     */
    public List<Education> getEductions(File file, Resume resume){
        List<Education> list = new ArrayList<Education>();

        Document doc = null;
        try {
            doc = Jsoup.parse(file,"UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        }

        Elements elements = doc.select("div[class=resume-preview-all]");
        for(Element element : elements) {
            String rowTitle = element.select("h3:eq(0)").text();
            if (rowTitle != null && rowTitle.contains("教育")) {
                Elements elements1 = element.select("div[class=resume-preview-dl]");
                for(Element elements1_one : elements1){
                    String text = elements1_one.text();//字符串比如“2012.09 - 2015.06   石家庄学院   音乐表演   大专”
                    String[] arr = text.split(" ");
                    Education education = new Education();
                    education.setResumeId(resume.getId());//简历ID

                    String degreeStr = "";//学历数据库存储的是编码，这个字符串记录学历的名称。

                    //最后一项一般是学历
                    boolean degreeFlag = false;//是否找到了学历了。
                    String temp = arr[arr.length - 1];
                    Degree degree = this.dealDegree(temp);
                    if(degree != null){
                        education.setDegree(degree.getCodeValue());//学历
                        degreeFlag = true;//已经找到这个学历
                        degreeStr = temp;
                    }

                    SimpleDateFormat df = new SimpleDateFormat("yyyy.MM");
                    for(int i =0 ;i<arr.length;i++){
                        if(i == 0){
                            //开始时间
                            try {
                                education.setStartDate(df.parse(arr[i]));//开始时间
                            } catch (ParseException e) {
                                education.setStartDate(new Date());
                                System.out.println("eduction startDate=" + arr[i] + " is error");
                            }
                        }else  if(i ==1){//-
                            continue;
                        } else if(i == 2){
                            try {
                                education.setEndDate(df.parse(arr[i]));//结束时间
                            } catch (ParseException e) {
                                education.setEndDate(new Date());
                                System.out.println("eduction endDate=" + arr[i] + " is error");
                            }
                        }else if(i == 3){
                            education.setSchool(arr[i].replaceAll(" ",""));//学校
                        }else{// 学历
                            if(!degreeFlag){//还没有找到学历的时候，找学历
                                degree = this.dealDegree(arr[i]);
                                if(degree != null){
                                    education.setDegree(degree.getCodeValue());//学历
                                    degreeStr = arr[i];
                                }else{
                                    if(education.getMajor() == null)
                                        education.setMajor(arr[i].trim());//专业
                                }
                            }else{
                                if(education.getMajor() == null)
                                    education.setMajor(arr[i].trim());//专业
                            }

                        }
                    }

                    if(education.getDegree() == null){//“学历”，不能为空
                        System.out.println("degree is null "+ file.getName());
                    }

                    if(education.getMajor() == null){//如果“专业”为空，就保存“学历”
                        education.setMajor(degreeStr);
                    }

                    list.add(education);


                }
            }
        }


        return list;
    }

    /**
     * 项目经验
     * @param file
     * @param resume
     * @return
     */
    public List<Projects> getProjectList (File file, Resume resume){
        List<Projects> list= new ArrayList<Projects>();

        Document doc = null;
        try {
            doc = Jsoup.parse(file,"UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        }

        Elements elements = doc.select("div[class=resume-preview-all]");
        for(Element element : elements){
            String rowTitle = element.select("h3:eq(0)").text();
            if(rowTitle != null && rowTitle.contains("项目")){
                Elements trs = element.select("h2");
                for(int i =0;i<trs.size();i++){

                    Projects project = new Projects();
                    project.setResumeId(resume.getId());

                    //每个项目的第一行，字符串比如“2014.04 - 2016.09   电动汽车管理系统”
                    Element element1 = trs.get(i);
                    String text = element1.text();//得到字符串，比如：2014.04 - 2016.09   安信联合（原中信信通国际物流有限公司）   (2年 6个月)
                    if(text != null){//解析字符串
                        String[] arr = text.split(" ");
                        if(arr.length >= 4){//arr[0]=2014.01,arr[1]=-,arr[2]=2016.09,arr[3]=安信联合（原中信信通国际物流有限公司） arr[4]=(2年 6个月)
                            String startdate = arr[0];
                            String enddate = arr[2];
                            SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM");
                            try {
                                //开始时间
                                project.setStartDate(sdf.parse(startdate));

                            } catch (ParseException e) {
                                project.setStartDate(new Date());
                                System.out.println("workExperience startDate="+startdate+" is error");
                            }

                            try {
                                //结束时间
                                project.setEndDate(sdf.parse(enddate));
                            } catch (ParseException e) {
                                project.setEndDate(new Date());
                                System.out.println("workExperience endDate="+enddate+" is error");
                            }

                            //项目名称
                            String str2 = arr[3];
                            project.setProjectName(str2);


                        }
                    }


                    Elements ess = element1.nextElementSibling().select("table").select("tr");
                    for(Element es : ess){
                        String tx = es.text();
                        if(tx.length() < 5){
                            continue;
                        }
                        String firststrs = tx.substring(0,4);
                        tx = tx.substring(5,tx.length());//有个冒号，
                        tx = tx.replace("：","")
                                .replace(":","")
                                .replace("\uD83D\uDC25","")
                                .replace("\uF06C",".");
                        //System.out.println(firststrs + " "+tx.length() +" "+tx);
                        if(firststrs.equals("责任描述")){
                            project.setProjectRole(tx);
                        }else if(firststrs.equals("项目描述")){
                            project.setProjectExp(tx);
                        }
                    }

                    list.add(project);

                }

                break;//直接退出
            }
        }

        return list;
    }

    /**
     * 处理行业列表
     * @param hangyestrs
     * @return
     */
    private String dealIndustry(String hangyestrs){

        String[] arr = hangyestrs.split("、");
        String strs = "";

        //行业最多3个
        int len = arr.length;
        if(len > 3){
            len = 3;
        }

        for(int i = 0;i<len;i++){
            //如果对照表industryZhilian有对照内容，就使用对照表中正确的内容。
            IndustryZhilian zlbean = industryZhilianMapper.queryByZLKey(arr[i]);
            if(zlbean != null && zlbean.getKey() != null){
                arr[i] = zlbean.getKey();
            }
            String values = "";
            if(zlbean != null && zlbean.getValue() != null){
                values = zlbean.getValue();
            }
            //end

            String temp = "";
            if(values != null && !values.equals("")){
                temp = values;
            }else{
                arr[i] = arr[i].trim();
                Industry ii = (Industry) Industry.getDataDictionaryByKey(arr[i],Industry.class);

                //期望行业
                if(ii != null){
                    temp = ii.getCodeValue();
                }else{
                    IndustryZhilian zltemp = industryZhilianMapper.queryByZLKey(arr[i]);
                    if(zltemp == null){
                        zltemp = new IndustryZhilian();//实例化
                        zltemp.setZlkey(arr[i]);
                        industryZhilianMapper.insert(zltemp);
                    }
                    temp = arr[i];

                }
            }
            //期望行业,多个之间以,分隔
            if(!temp.equals("")){

                if(!strs.equals("")){
                    strs += ",";
                }
                strs += temp;
            }else{
                //  System.out.println(arr[i]);
            }



        }
        return strs;
    }
    /**
     * 处理学历
     * @param temp：处理字符串
     * @return
     */
    private Degree dealDegree(String temp){
        temp = temp.replaceAll(" ","");
        temp = temp.replaceAll(" ","");//看着像空格，但是不是空格
        if(temp.contains("本科")){
            temp = "本科";
        }else if(temp.contains("专科")){
            temp = "大专";
        }else if(temp.contains("中专")){
            temp = "高中";
        }else if(temp.contains("中技")){
            temp = "高中";
        }else{
            //System.out.println("degree:"+temp);
            // temp = "其他";
        }
        Degree degree = (Degree) Degree.getDataDictionaryByKey(temp,Degree.class);
        return degree;
    }
    /**
     * 得到Salary的value
     * @param name
     * @return
     */
    private String getSalary(String name){
        if(name.contains("1000元")){
            return Salary.LESS_ONE.getCodeValue();
        }else if(name.contains("1000-2000元")){
            return Salary.ONE2TWO.getCodeValue();

        }else if(name.contains("2001-4000元")){
            return Salary.TOW2FOUR.getCodeValue();

        }else if(name.contains("4001-6000元")){
            return Salary.FOUR2SIX.getCodeValue();

        }else if(name.contains("6001-8000元")){
            return Salary.SIX2EIGHT.getCodeValue();

        }else if(name.contains("8001-10000")){
            return Salary.EIGHT2TEN.getCodeValue();

        }else if(name.contains("10001-1500")){
            return Salary.TEN2FIFTEEN.getCodeValue();

        }else if(name.contains("15000-2500")){
            return Salary.MORE_FIFTEEN.getCodeValue();

        }else{
            return Salary.MORE_FIFTEEN.getCodeValue();
        }
    }
}
