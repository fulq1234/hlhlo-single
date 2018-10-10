package com.lummei.translation.service.impl;

import com.lummei.translation.entity.DictEnZhcn;
import com.lummei.translation.entity.Knowledge;
import com.lummei.translation.mapper.KnowledgeMapper;
import com.lummei.translation.service.KnowledgeService;
import com.lummei.translation.util.BaseTool;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class KnowledgeServiceImpl implements KnowledgeService {

    @Autowired
    private KnowledgeMapper knowledgeMapper;

    @Override
    public List<DictEnZhcn> list() {
        List<Knowledge> list = knowledgeMapper.select();
        List<DictEnZhcn> dlist = new ArrayList<DictEnZhcn>();
        for(int i = 0;i<list.size();i++){
            Knowledge knowledge = list.get(i);
            DictEnZhcn dictEnZhcn = new DictEnZhcn();

            dictEnZhcn.setSource(knowledge.getTitle());

            dictEnZhcn.setId(knowledge.getId());

            String content = knowledge.getContent();
            if(content != null){
                content = content.replaceAll("\n|\t|\r","");
                if(!content.contains("</h4><p>")){
                    dictEnZhcn.setTran(content);
                }else{
                    String[] arr = content.split("</h4><p>");
                    String str1 = arr[0];
                    str1 = str1.replaceAll("<h4>|</h4>|<span>|</span>|\n|\\s|<br/>|<br />|&nbsp;|<p>|</p>","");//去掉所有非法字符。\n是换行，\\s是空格
                    dictEnZhcn.setTran(str1);

                    String str2 = "<p>" + arr[1];
                    //System.out.println(str2);


                    //处理Base64文件，保存文件，并存到数据库中

                    str2 = str2.replaceAll("\n","");
                    String example = "";
                    if(!str2.contains("img")){//不包括图片，就不处理图片了。
                        example = str2;
                    }else{
                        //用Jsoup解析图片
                        Document document = Jsoup.parse(str2);
                        Elements elements = document.select("img");
                        for(int a = 0;a<elements.size();a++){
                            Element element = elements.get(a);
                            String base64strsrc = element.attr("src");

                        /*求图片的扩展名
                        data:image/gif;base64,base64编码的gif图片数据
                        data:image/png;base64,base64编码的png图片数据
                        data:image/jpeg;base64,base64编码的jpeg图片数据

                        data:image/x-icon;base64,base64编码的icon图片数据
                                */
                            String lastname = ".png";
                            if(base64strsrc.contains("data:image/gif;")){
                                lastname = ".gif";
                            }else if(base64strsrc.contains("data:data:image/jpeg;")){
                                lastname = ".jpg";
                            }else if(base64strsrc.contains("data:image/x-icon;")){
                                lastname = ".icon";
                            }
                            //filename
                            String filename = "f:/"+knowledge.getId()+lastname;
                            if(elements.size() > 1){
                                filename = "f:/"+knowledge.getId()+"_" + (a + 1) + lastname;
                            }

                            //base64字符串转变成文件
                            BaseTool.dealBase64File(base64strsrc,filename);
                            element.attr("src",filename);


                        }
                        example = document.select("body").html().toString();
                        example = example.replace("\n","");
                        example = example.replace("\\\"","\"");
                    }

                    //保存到数据库
                    dictEnZhcn.setExample(example);
                }
            }

            dlist.add(dictEnZhcn);

        }
        return dlist;
    }
}
