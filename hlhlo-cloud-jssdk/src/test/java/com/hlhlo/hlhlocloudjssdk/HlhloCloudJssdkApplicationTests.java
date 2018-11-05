package com.hlhlo.hlhlocloudjssdk;

import com.hlhlo.hlhlocloudjssdk.utils.CheckUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;

@RunWith(SpringRunner.class)
@SpringBootTest
public class HlhloCloudJssdkApplicationTests {

    @Test
    public void contextLoads() {
        String[] arr = new String[]{"noncestr","jsapi_ticket","timestamp","url"};
        Arrays.sort(arr);
        for(String s:arr){
            System.out.println(s);
        }
    }


}
