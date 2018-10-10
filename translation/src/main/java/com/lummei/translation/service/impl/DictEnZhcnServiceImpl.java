package com.lummei.translation.service.impl;

import com.lummei.translation.entity.DictEnZhcn;
import com.lummei.translation.mapper.DictEnZhcnMapper;
import com.lummei.translation.service.DictEnZhcnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DictEnZhcnServiceImpl implements DictEnZhcnService {

    @Autowired
    private DictEnZhcnMapper dictEnZhcnMapper;

    /**
     *
     * @param list
     * @return
     */
    @Override
    @Transactional
    public int insert(List<DictEnZhcn> list) {
        int r = 0;
        int i = 0;
        for(DictEnZhcn dictEnZhcn : list){
            //dictEnZhcn.setExample(dictEnZhcn.getSource());
            int a = dictEnZhcnMapper.queryBySource(dictEnZhcn.getSource());
            if(a > 0){
                continue;
            }
            a = dictEnZhcnMapper.queryByTran(dictEnZhcn.getTran());
            if(a >0){
                continue;
            }
            if(dictEnZhcn.getExample() != null){
                System.out.println(dictEnZhcn.getExample());
                System.out.println("======="+dictEnZhcn.getExample().length());


            }
            r = dictEnZhcnMapper.insert(dictEnZhcn);
        }
        return r;
    }
}
