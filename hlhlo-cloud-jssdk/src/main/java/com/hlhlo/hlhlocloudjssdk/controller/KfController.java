package com.hlhlo.hlhlocloudjssdk.controller;

import com.hlhlo.hlhlocloudjssdk.entity.BaseAccessTokenResponse;
import com.hlhlo.hlhlocloudjssdk.entity.JsapiResponse;
import com.hlhlo.hlhlocloudjssdk.service.WxKFService;
import com.hlhlo.hlhlocloudjssdk.utils.CheckUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;

@Controller
@RequestMapping("/kf")
@Slf4j
public class KFController {
    private String appId = "wxec40750a90b478e5";
    private String appsecret = "87eb940de1cd6a9f02258162b2ccf80d";
    private String url = "http://335e9b8a.ngrok.io/kf/index";

    @Autowired
    private WxKFService wxKFService;

    @RequestMapping(value="/index")
    public ModelAndView say() {
        log.info("===go into say ===");
        ModelAndView mv = new ModelAndView();

        //指定领取者的openid，只有该用户能领取。bind_openid字段为true的卡券必须填写，bind_openid字段为false不必填写。
        mv.addObject("appId",appId);//appid

        //时间戳，商户生成从1970年1月1日00:00:00至今的秒数,即当前的时间,且最终需要转换为字符串形式;由商户生成后传入,不同添加请求的时间戳须动态生成，若重复将会导致领取失败！。
        Long timestamp = System.currentTimeMillis() / 1000;
        mv.addObject("timestamp",timestamp);

        //随机字符串，由开发者设置传入， 加强安全性（若不填写可能被重放请求） 。随机字符串，不长于32位。推荐使用大小写字母和数字，不同添加请求的nonce须动态生成，若重复将会导致领取失败。
        String nonceStr = CheckUtil.getRandomString(32);
        mv.addObject("nonceStr",nonceStr);

        //签名，商户将接口列表中的参数按照指定方式进行签名,签名方式使用SHA1,具体签名方案参见下文;由商户按照规范签名后传入。
        BaseAccessTokenResponse accessTokenResponse =wxKFService.getAccessToken(appId,appsecret);
        JsapiResponse jsapiResponse = wxKFService.getJaspi(accessTokenResponse.getAccessToken());
        String jsapi_ticket = jsapiResponse.getTicket();


        StringBuffer sb = new StringBuffer();
        sb.append("jsapi_ticket="+jsapi_ticket);
        sb.append("&noncestr="+nonceStr);
        sb.append("&timestamp="+timestamp);
        sb.append("&url="+url);


       log.info(sb.toString());
        //sha1加密
        String signature = CheckUtil.getSha1(sb.toString());
        log.info(signature);
        mv.addObject("signature",signature);

        mv.setViewName("index");

        return mv;
    }


}
