package com.hlhlo.hlhlocloudframeworkwx.service.impl;

import com.hlhlo.hlhlocloudframeworkwx.entity.WxKfAccount;
import com.hlhlo.hlhlocloudframeworkwx.entity.WxKfSession;
import com.hlhlo.hlhlocloudframeworkwx.mapper.WxKfSessionMapper;
import com.hlhlo.hlhlocloudframeworkwx.service.WxKfSessionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WxKfSessionServiceImpl implements WxKfSessionService {

    @Autowired
    private WxKfSessionMapper kfSessionMapper;

    @Override
    public List<WxKfSession> getContent(String kf_openid, String user_openid) {
        List<WxKfSession> list = kfSessionMapper.getContent(kf_openid,user_openid);
        return list;
    }

    @Override
    public List<WxKfSession> getUsersByKfOpenid(String openid) {
        List<WxKfSession> list = kfSessionMapper.getUsersByKfOpenid(openid);
        return list;
    }

    @Override
    public int insert(WxKfSession account) {
        int a = kfSessionMapper.insert(account);
        return a;
    }
}
