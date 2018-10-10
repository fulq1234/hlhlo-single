package com.lummei.jobapp;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JobappApplicationTests {

    @Test
    public void contextLoads() {
String temp = "    大专";
//temp = "   大专  ";
        temp = temp.replaceAll(" ", "");
        temp = temp.replaceAll(" ","");
        //temp = temp.trim();
        System.out.println("["+temp+"]");
    }

}
