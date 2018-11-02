package com.hlhlo.hlhlocloudjssdk.entity;

import lombok.Data;

@Data
public class JsapiResponse extends BaseResponse {
    private String ticket;
    private Long expires_in;
}
