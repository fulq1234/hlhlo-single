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
    public List<WxKfSession> getContent(WxKfSession kfSession) {
        kfSession.setStatus(1);
        List<WxKfSession> list = kfSessionMapper.getContent(kfSession);
        return list;
    }

    @Override
    public List<WxKfSession> getUsersByAccountId(Long kfaccountid) {
        List<WxKfSession> list = kfSessionMapper.getUsersByAccountId(kfaccountid);
        return list;
    }

    @Override
    public int insert(WxKfSession account) {
        int a = kfSessionMapper.insert(account);
        return a;
    }

    @Override
    public int updateStatusByAccountId(Integer status, Long accountid) {
        int a = kfSessionMapper.updateStatusByAccountId(status,accountid);
        return a;
    }
}
