package com.example.demo11;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class AAC {
    @RequestMapping(value="/say")
    public String say() {
        return "index";
    }
}
