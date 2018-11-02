package com.hlhlo.hlhlocloudframeworkwx.service.impl;

import com.hlhlo.hlhlocloudframeworkwx.entity.WxKfAccount;
import com.hlhlo.hlhlocloudframeworkwx.mapper.WxKfAccountMapper;
import com.hlhlo.hlhlocloudframeworkwx.service.WxKfAcccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WxKfAccountServiceImpl implements WxKfAcccountService {

    @Autowired
    private WxKfAccountMapper kfAccountMapper;

    @Override
    public int updateKfAccount(WxKfAccount account) {
        int a = kfAccountMapper.updateKfAccount(account);
        return a;
    }

    @Override
    public WxKfAccount queryInfoByOpenid(String openid) {
        WxKfAccount w = kfAccountMapper.queryInfoByOpenid(openid);
        return w;
    }
}
