package com.lummei.jobapp.service;

import com.lummei.jobapp.entity.*;
import com.lummei.jobapp.mapper.*;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Service
public class JobPPService {
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
            String lastFileName = fileName.substring(fileName.indexOf("."),fileName.length());
            if(!lastFileName.equals(".html")){
                continue;//如果不是html文件，就不操作
            }
            //dealUnderFile(file);
            fixedThreadPool.execute(new Runnable() {
                @Override
                public void run() {
                    dealUnderFile(file);
                }
            });


        }

        return 1;
    }

    /**
     * 解析一个html文件的所有简历信息。
     * @param file
     */
    private void dealUnderFile(File file){
        //简历
        Resume resume = this.getResume(file);
        int a = resumerMapper.save(resume);//插入简历

        //刚刚插入的简历信息
        //Resume resume = resumerMapper.getResumeByTitle(job.getTitle());

        //求职者信息
        JobSeeker jobSeeker = this.getJobSeeker(file,resume);

        jobSeekerMapper.insert(jobSeeker);
        //求职意向
        CareerObjective careerObjective = this.getCareerObjective(file,resume);
        careerObjectiveMapper.save(careerObjective);

        //工作经历
        List<WorkExperience> workEList = this.getWorkExperienceList(file,resume);
        for(WorkExperience one : workEList){
            workExperienceMapper.save(one);
        }

        //教育经历
        List<Education> educationList = this.getEductions(file,resume);
        for(Education one : educationList){
            educationMapper.save(one);
        }
    }


    //插入简历
    private Resume getResume(File file) {


         Resume resume = new Resume();
         //File file = new File("F:\\file\\智联招聘_安玉璞_英文客服无销售双休_中文_20180911_1536666988677.html");
         Document doc = null;
         try {
             doc = Jsoup.parse(file, "UTF-8");
         } catch (IOException e) {
             e.printStackTrace();
         }

//        Elements elements = doc.select("div[class=resume-preview-title]").select("span[class=resume-preview-list]");
//
//        String ypzw = elements.get(1).select("strong").text();
         //简历名称，求职者姓名
//        Elements e = doc.select("div[class=resume-preview-main-title]");
//        String title = e.select("div:eq(0)").text();
//        if(title != null){
//            resume.setTitle(title);
//        }

         //自我介绍
         Elements elements = doc.select("div[class=resume-preview-all]");
         for (Element element : elements) {
             String rowTitle = element.select("h3:eq(0)").text();
             if (rowTitle != null && rowTitle.equals("自我评价")) {
                 String info = element.select("div").text();
                 //System.out.println(file.getName() + " length=" + info.length() + " info=" + info);

                 if(info.substring(0,"自我评价 ".length()).equals("自我评价 ")){
                     info = info.substring("自我评价 ".length(),info.length());
                 }
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

         //resume.setCreateTime(new java.util.Date());
         //其他
         resume.setPublishStatus("PUBLIC");//公开状态
         resume.setUserId(0l);
         resume.setDeleteFlag(0);
         return resume;

    }

    /**
     * 求职者信息
     * @param file
     * @param resume
     * @return
     */
    public JobSeeker getJobSeeker(File file,Resume resume){
        JobSeeker jobSeeker = new JobSeeker();
        jobSeeker.setResumeid(resume.getId());
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
        if(name.length() >20){
            System.out.println(file.getName()+",name:"+name);
        }
        jobSeeker.setName(name);

        //女     24岁 (1994年4月)     本科 现居住地：石家庄 长安区 | 户口：石家庄 | 群众
        String topq = doc.select("div[class=summary-top]").text();

        String[] toparr = topq.split(" ");

        for(String temp : toparr){
            if(temp.equals("男")||temp.equals("女")){
                jobSeeker.setSex(temp);//性别
            }else if(temp.contains("(") && temp.contains(")")){//出生年月
                //解析字符串类似“24岁 (1994年10月)”
               // String yearstr = temp.substring(temp.indexOf("("),temp.indexOf(")"));
                SimpleDateFormat df = new SimpleDateFormat("(yyyy年MM月)");
                try{
                    jobSeeker.setBorndate(df.parse(temp));//出生年月
                }catch (ParseException e){
                    e.printStackTrace();
                }

            }else if(temp.contains("工作经验")){//几年工作经验
                temp = temp.replaceAll("[^0-9]","");//去掉所有非数字
                jobSeeker.setWorktime(Integer.parseInt(temp));
            }else if(temp.contains("科")){
                jobSeeker.setDegree(temp);//学历
            }else if(temp.contains("婚")){
                //婚姻状况
                jobSeeker.setMarriage(temp);
            }else if(temp != null && temp.contains("现居住地")){
                jobSeeker.setResidence(temp.replace("现居住地：",""));
            }else if(temp != null && temp.contains("户口")){
                jobSeeker.setCensusregister(temp.replace("户口：",""));
            }

        }


        //最后一个有可能是政治面貌

        if(!toparr[toparr.length - 1].contains(("现居住地")) && !toparr[toparr.length - 1].contains("户口")){
            if((toparr[toparr.length - 1]).length()> 20){
                System.out.println(toparr[toparr.length - 1]);
            }
            jobSeeker.setPoliticalstatus(toparr[toparr.length - 1]);
        }





        //身份证：130524199707122027 手机：13473741796 E-mail：749183884@qq.com
        String botm = doc.select("div[class=summary-bottom]").text();
        String[] arr = botm.split(" ");

        for(String temp : arr){
            if(temp.contains("身份证")){
                jobSeeker.setIdcard(temp.replaceAll("[^0-9]",""));
            }else if(temp.contains("手机")){
                jobSeeker.setMobile(temp.replaceAll("[^0-9]",""));
            }else if(temp.contains("E-mail")){
                jobSeeker.setEmail(temp.replaceAll("E-mail：",""));
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
                        if(value1.length()>39){
                            System.out.println(file.getName()+",jobstatus="+value1);
                        }
                        jobSeeker.setJobStatus(value1);
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
                        if(value.length()>=70){//数据库字段长度，如果超出，打印出来
                            System.out.println("function,length="+value.length()+",file="+file.getName()+",value="+value);
                        }
                        //期望职位
                        careerObjective.setFunction(value);
                    }else if(name.contains("行业")){
                        if(value.length() >= 520){
                            System.out.println("industry,length="+value.length()+",file="+file.getName()+",value="+value);
                        }

                        //期望行业
                        careerObjective.setIndustry(value);
                    }else if(name.contains("地区")){
                        //工作城市
                        if(value.length() >9){//石家庄、石家庄、石家庄
                           value = value.substring(0,9);
                        }
                        careerObjective.setLocation(value);

                    }else if(name.contains("月薪")){

                        //长度限制10
                        if(value!= null && value.length()>10){
                            value = value.substring(0,10);
                        }

                        //薪资要求
                       careerObjective.setSalary(value);
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

                        if(str2 != null && str2.contains("|")){
                            //解析字符串
                            String[] arr = str2.split(" ");
                            workExperience.setPosition(arr[0]);//职位名称
                            if(arr.length >= 3){
                                workExperience.setSalary(arr[2]);//工资
                            }
                        }
                    }else{
                        System.out.println(file.getName()+",position is null");
                    }



//                    //每个工作的第三行，比如“物流/仓储 | 企业性质：民营 | 规模：500-999人”
//                    int a = element.select("div[class=resume-preview-dl]").size();
//                    String str3 = element.select("div[class=resume-preview-dl]:eq(0)").text();
//
//
//                    //每个工作的第四行,比如“工作描述：	客服专员以及工作外出安排”
//                    String str4 = element.select("div[class=resume-preview-dl]:eq(1)").text();

                    //把内容加在列表中
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

                    SimpleDateFormat df = new SimpleDateFormat("yyyy.MM");
                    if(arr.length >=3) {
                        try {
                            education.setStartDate(df.parse(arr[0]));//开始时间
                        } catch (ParseException e) {
                            education.setStartDate(new Date());
                            System.out.println("eduction startDate=" + arr[0] + " is error");
                        }
                        try {
                            education.setEndDate(df.parse(arr[2]));//结束时间
                        } catch (ParseException e) {
                            education.setEndDate(new Date());
                            System.out.println("eduction endDate=" + arr[2] + " is error");
                        }
                    }
                    if(arr.length>=4){
                        education.setSchool(arr[3]);//学校
                    }
                    if(arr.length>=5){
                        education.setMajor(arr[4]);//专业
                    }else{
                        System.out.println(file.getName()+",major is null");
                    }
                    if(arr.length>=6){
                        education.setDegree(arr[5]);//学历
                    }else{
                        //System.out.println("education:"+text);
                    }


                    list.add(education);


                }
            }
        }


        return list;
    }
}
