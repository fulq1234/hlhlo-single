package com.hlhlo.hlhlocloudjssdk.controller;

import com.hlhlo.hlhlocloudjssdk.entity.BaseAccessTokenResponse;
import com.hlhlo.hlhlocloudjssdk.entity.JsapiResponse;
import com.hlhlo.hlhlocloudjssdk.service.WxKFService;
import com.hlhlo.hlhlocloudjssdk.utils.CheckUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.Formatter;
import java.util.Map;
import java.util.UUID;

@Controller
@RequestMapping("/kf")
@Slf4j
public class KFController {
    private String appId = "wxec40750a90b478e5";
    private String appsecret = "87eb940de1cd6a9f02258162b2ccf80d";
    private String url = "http://e036e158.ngrok.io/kf/index";

    @Autowired
    private WxKFService wxKFService;

    @RequestMapping("/a")
    @ResponseBody
    public String say2(){
        log.info("========say2");
        return "bac";
    }
    @RequestMapping(value="/index")
    public ModelAndView say() {
        log.info("===go into say ===");
        ModelAndView mv = new ModelAndView();

        //签名，商户将接口列表中的参数按照指定方式进行签名,签名方式使用SHA1,具体签名方案参见下文;由商户按照规范签名后传入。
        BaseAccessTokenResponse accessTokenResponse =wxKFService.getAccessToken(appId,appsecret);
        JsapiResponse jsapiResponse = wxKFService.getJaspi(accessTokenResponse.getAccessToken());
        String jsapi_ticket = jsapiResponse.getTicket();

        // 注意 URL 一定要动态获取，不能 hardcode
        Map<String, String> ret = CheckUtil.sign(jsapi_ticket, url);
        for (Map.Entry entry : ret.entrySet()) {
            log.info(entry.getKey() + ", " + entry.getValue());
        }
        //指定领取者的openid，只有该用户能领取。bind_openid字段为true的卡券必须填写，bind_openid字段为false不必填写。
        mv.addObject("appId",appId);//appid
        mv.addObject("nonceStr",ret.get("nonceStr"));
        mv.addObject("timestamp",ret.get("timestamp"));
        mv.addObject("signature",ret.get("signature"));

        mv.setViewName("index");

        return mv;
    }



}
