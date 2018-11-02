package com.hlhlo.hlhlocloudjssdk.service;

import com.hlhlo.hlhlocloudjssdk.entity.BaseAccessTokenResponse;
import com.hlhlo.hlhlocloudjssdk.entity.JsapiResponse;

public interface WxKFService {

    /**
     * 获取access_token
     * @param appId：第三方用户唯一凭证
     * @param appSecret：第三方用户唯一凭证密钥，即appsecret
     * @return
     */
    public BaseAccessTokenResponse getAccessToken(String appId, String appSecret);

    public JsapiResponse getJaspi(String accessToken);

}
