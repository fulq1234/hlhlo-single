package com.lummei.translation.controller;

import com.lummei.translation.entity.DictEnZhcn;
import com.lummei.translation.service.DictEnZhcnService;
import com.lummei.translation.service.KnowledgeService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
public class TransactionController {
    @Autowired
    private KnowledgeService knowledgeService;

    @Autowired
    private DictEnZhcnService dictEnZhcnService;

    @ResponseBody
    @RequestMapping("/aa")
    public List<DictEnZhcn> contextLoads() {
        List<DictEnZhcn> list = knowledgeService.list();
        int a = dictEnZhcnService.insert(list);
        return list;
    }


}
