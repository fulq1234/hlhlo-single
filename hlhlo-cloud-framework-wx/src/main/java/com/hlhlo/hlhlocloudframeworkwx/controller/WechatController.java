package com.hlhlo.hlhlocloudframeworkwx.controller;

import com.hlhlo.hlhlocloudframeworkwx.entity.*;
import com.hlhlo.hlhlocloudframeworkwx.service.WxKfAcccountService;
import com.hlhlo.hlhlocloudframeworkwx.service.WxKfSessionService;
import com.hlhlo.hlhlocloudframeworkwx.utils.CheckUtil;
import com.hlhlo.hlhlocloudframeworkwx.utils.JsonUtils;
import com.thoughtworks.xstream.XStream;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.security.NoSuchAlgorithmException;

@Controller
@RequestMapping("/")
@Slf4j
public class WechatController {

    @Autowired
    private WxKfAcccountService kfAcccountService;

    @Autowired
    private WxKfSessionService kfSessionService;

    //转接的客服账号
    private String account = "test1@test";

    @ResponseBody
    @GetMapping("/verifyWX")
    public String verifyWX(String signature,String timestamp,String nonce,String echostr){
        if(signature == null || timestamp == null || nonce == null || echostr == null) {
            log.error("微信接入错误","微信参数有空值");
        }
        try {
            if(CheckUtil.checkSignature(signature, timestamp, nonce)){
                return echostr;
            }
        } catch (NoSuchAlgorithmException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
            log.error("connection exception",e1);
        }
        log.error("微信接入错误");
        return "";
    }


    /**
     * 消息转发到客服
     */
    @PostMapping(value = "/verifyWX")
   public @ResponseBody String  weixinCreate(@RequestBody ScanRequest scan) {
        //public @ResponseBody Object weixinCreate(Scan scan) {
        if(scan == null) {
            log.error("接收到的字符串不能为空");
            return null;
        }
        log.info(JsonUtils.beanToJson(scan));

        String fromUserName = scan.getFromUserName();
        String toUserName = scan.getToUserName();
        KFScanResponse nscan = new KFScanResponse();
        nscan.setFromUserName(toUserName);
        nscan.setToUserName(fromUserName);
        nscan.setCreateTime(new java.util.Date().getTime());

        //插入数据到数据库
        WxKfSession wxKfSession = new WxKfSession();
        if(account != null && !account.equals("")){
            KFScanTransInfo info = new KFScanTransInfo();
            info.setKfAccount(account);
            nscan.setTransInfo(info);

            //opercode操作码，2002（客服发送信息），2003（客服接收消息）
            //select * from wx_kfaccount where kf_account='test1@test';
            //insert into wx_kfsession(kfaccountid,user_opeid,opercode,text) values(fromUserName,'2003',scan.getContent);
            WxKfAccount kfAccount = kfAcccountService.queryInfoByAccount(account);
            wxKfSession.setKfaccountid(kfAccount.getId());
        }
        wxKfSession.setUser_openid(fromUserName);
        wxKfSession.setOpercode("2003");
        wxKfSession.setText(scan.getContent());
        kfSessionService.insert(wxKfSession);


        //返回到页面信息
        XStream xStream = new XStream();
        xStream.alias("xml",nscan.getClass());;

        log.info(xStream.toXML(nscan));
        return xStream.toXML(nscan);
    }

    /**
     * 消息回复,测试使用
     * @param scan
     * @return
     *//*
    @PostMapping(value = "/verifyWX")
    public @ResponseBody String weixinCreate(@RequestBody ScanRequest scan) {
        //public @ResponseBody Object weixinCreate(Scan scan) {
        if(scan == null) {
            log.error("接收到的字符串不能为空");
            return null;
        }
        log.info(scan.toString());

        String fromUserName = scan.getFromUserName();
        String toUserName = scan.getToUserName();
        TextScanResponse nscan = new TextScanResponse();
        nscan.setFromUserName(toUserName);
        nscan.setToUserName(fromUserName);
        nscan.setCreateTime(new java.util.Date().getTime());
        nscan.setContent(scan.getContent());

        XStream xStream = new XStream();
        xStream.alias("xml",nscan.getClass());;

        return xStream.toXML(nscan);
    }

    *//**
     * 文本回复消息
     *//*
    @Data
    class TextScanResponse {
        private Integer id;

        //接收方帐号（收到的OpenID）
        //@XmlElement(name="ToUserName")
        private String ToUserName;


        //开发者微信号
        //@XmlElement(name="FromUserName")
        private String FromUserName;

        //消息创建时间 （整型）
        //@XmlElement(name="CreateTime")
        private Long CreateTime;

        //@XmlElement(name="MsgType")
        private String MsgType = "text";

        //@XmlElement(name="Content")
        private String Content;

    }*/

}
