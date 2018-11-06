package com.hlhlo.hlhlocloudframeworkwx.service.impl;

import com.hlhlo.hlhlocloudframeworkwx.entity.WxKfAccount;
import com.hlhlo.hlhlocloudframeworkwx.mapper.WxKfAccountMapper;
import com.hlhlo.hlhlocloudframeworkwx.service.WxKfAcccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WxKfAccountServiceImpl implements WxKfAcccountService {

    @Autowired
    private WxKfAccountMapper kfAccountMapper;

    @Override
    public int updateOpenIdByKfwx(String openid,String kf_wx) {
        int a = kfAccountMapper.updateOpenIdByKfwx(openid,kf_wx);
        return a;
    }

    @Override
    public WxKfAccount queryInfoByOpenid(String openid) {
        WxKfAccount w = kfAccountMapper.queryInfoByOpenid(openid);
        return w;
    }

    @Override
    public List<WxKfAccount> queryKfList(String kf_openid, Integer status) {
        List<WxKfAccount> list = kfAccountMapper.queryKfList(kf_openid,status);
        return list;
    }

    @Override
    public WxKfAccount queryInfoByAccount(String kf_account) {
        WxKfAccount kfAccount = kfAccountMapper.queryInfoByAccount(kf_account);
        return kfAccount;
    }

}
