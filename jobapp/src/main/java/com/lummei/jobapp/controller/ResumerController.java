package com.lummei.jobapp.controller;

import com.lummei.jobapp.entity.Resume;
import com.lummei.jobapp.mapper.ResumerMapper;
import com.lummei.jobapp.service.JobPPService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class ResumerController {
    @Autowired
    private JobPPService jobPPService;


    @RequestMapping("/aa")
    public int aa(){
        return jobPPService.mainJobPP();
    }
}
