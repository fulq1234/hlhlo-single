package com.hlhlo.hlhlocloudframeworkwx.service;

import com.hlhlo.hlhlocloudframeworkwx.entity.WxKfAccount;
import org.apache.ibatis.annotations.Select;

public interface WxKfAcccountService {
    /**
     *
     * @param account
     * @return
     */
    int updateKfAccount(WxKfAccount account);

    /**
     *
     * @param openid
     * @return
     */
    WxKfAccount queryInfoByOpenid(String openid);
}
