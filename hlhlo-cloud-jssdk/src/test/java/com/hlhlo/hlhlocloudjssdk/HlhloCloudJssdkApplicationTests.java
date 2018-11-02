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

    @Test
    public void aa(){
        String s = "jsapi_ticket=HoagFKDcsGMVCIY2vOjf9gZmfpRcmA2ue4LIGQYQDu0bWW1r89ThJIBy1lWoTnWpHSt1xd14mdpPcm4GfwmDdQ&noncestr=ZLeaY1ttP3uThDuRgUVkRnbXiVGYRILR&timestamp=1541148308&url=http://06dae542.ngrok.io/kf/index";
        String signature = CheckUtil.getSha1(s);
        System.out.println(signature);
    }

}
