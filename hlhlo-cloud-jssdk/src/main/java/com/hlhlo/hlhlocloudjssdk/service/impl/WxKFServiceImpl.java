package com.hlhlo.hlhlocloudjssdk.service.impl;

import com.hlhlo.hlhlocloudjssdk.entity.BaseAccessTokenResponse;
import com.hlhlo.hlhlocloudjssdk.entity.JsapiResponse;
import com.hlhlo.hlhlocloudjssdk.service.WxKFService;

import com.hlhlo.hlhlocloudjssdk.utils.HttpUtils;
import com.hlhlo.hlhlocloudjssdk.utils.JsonUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


/**
 * 客服信息：https://mp.weixin.qq.com/wiki?t=resource/res_main&id=mp1421140547
 */
@Service
@Slf4j
public class WxKFServiceImpl implements WxKFService {

    @Autowired
    private HttpUtils httpUtils;

    //获取AccessToken
    private static String getAccessTokenUrl = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=%s&secret=%s";

    //得到微信js接口的临时票据
    private static String getJsapiTicket = "https://api.weixin.qq.com/cgi-bin/ticket/getticket?access_token=%s&type=jsapi";

    @Override
    public BaseAccessTokenResponse getAccessToken(String appId, String appSecret){
        //请求地址
        String url = String .format(getAccessTokenUrl,appId,appSecret);
        String respStr = this.httpUtils.doGet(url);
        log.info("【微信公众号获取AccessToken】请求地址：{}\r\n返回信息：\r\n{}", url, respStr);
        BaseAccessTokenResponse response = JsonUtils.jsonToBean(respStr, BaseAccessTokenResponse.class);
        return response;
    }

    /**
     * 获得令牌
     * @param accessToken
     * @return
     */
    @Override
    public JsapiResponse getJaspi(String accessToken) {
        //请求地址
        String url = String .format(getJsapiTicket,accessToken);
        String respStr = this.httpUtils.doGet(url);
        log.info("【微信公众号获取AccessToken】请求地址：{}\r\n返回信息：\r\n{}", url, respStr);
        JsapiResponse response = JsonUtils.jsonToBean(respStr, JsapiResponse.class);
        return response;
    }


}
