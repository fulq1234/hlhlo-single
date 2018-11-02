package com.hlhlo.hlhlocloudframeworkwx.controller;

import com.hlhlo.hlhlocloudframeworkwx.entity.*;
import com.hlhlo.hlhlocloudframeworkwx.service.WxKFService;
import com.hlhlo.hlhlocloudframeworkwx.service.WxKfAcccountService;
import com.hlhlo.hlhlocloudframeworkwx.service.WxKfSessionService;
import com.hlhlo.hlhlocloudframeworkwx.utils.HttpUtils;
import com.hlhlo.hlhlocloudframeworkwx.utils.JsonUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/kf")
@Slf4j
public class KFController {

    @Autowired
    private HttpUtils httpUtils;

    private String wx_appid = "wxec40750a90b478e5";

    private String wx_appsecret = "87eb940de1cd6a9f02258162b2ccf80d";

    private String redirectUrl = "http://335e9b8a.ngrok.io/kf/callback";

    @Autowired
    private WxKfAcccountService kfAcccountService;

    @Autowired
    private WxKfSessionService kfSessionService;

    @Autowired
    private WxKFService wxKFService;

    @RequestMapping(value="/index")
    public String say() {
        return "index";
    }

    /**
     * 微信网络授权，1 第一步：用户同意授权，获取code
     * @return
     */
    @RequestMapping("/login")
    public String wxLogin(String wxid){
        redirectUrl = redirectUrl + "?wxid=" + wxid;

        StringBuffer sb = new StringBuffer("https://open.weixin.qq.com/connect/oauth2/authorize?appid=");
        sb.append("wxec40750a90b478e5");
        sb.append("&redirect_uri=");
        sb.append(URLEncoder.encode(redirectUrl));
        sb.append("&response_type=code&scope=snsapi_base&state=STATE#wechat_redirect");
        return "redirect:" +sb.toString();
    }

    /**
     * 回调地址
     * @param code
     * @return
     * @throws IOException
     */
    @RequestMapping("/callback")
    public ModelAndView callback(
            @RequestParam(value="wxid",required = false) String wxid,
            @RequestParam(value="code",required = false) String code
            ) throws IOException {
        ModelAndView mv = new ModelAndView();

        //第二步：通过code换取网页授权access_token
        StringBuffer sb = new StringBuffer("https://api.weixin.qq.com/sns/oauth2/access_token?appid=");
        sb.append(wx_appid);
        sb.append("&secret=");
        sb.append(wx_appsecret);
        sb.append("&code=");
        sb.append(code);
        sb.append("&grant_type=authorization_code");

        String respStr = httpUtils.doGet(sb.toString());
        AccessTokenRes res = JsonUtils.jsonToBean(respStr, AccessTokenRes.class);

        String openid = res.getOpenid();//得到客服的openid

        //绑定openid和微信号。
        WxKfAccount account = new WxKfAccount();
        account.setOpenid(openid);
        account.setKf_wx(wxid);
        kfAcccountService.updateKfAccount(account);

        WxKfAccount kfAccount = kfAcccountService.queryInfoByOpenid(openid);

        if(kfAccount != null && kfAccount.getOpenid() != null){
            mv.addObject("current_kfopenid",kfAccount.getOpenid());
        }
       // String openid = "o36WF0kwKQEOq9-l9bqAiM5Nqlf8";
        mv.addObject("current_kfopenid",openid);

        List<WxKfSession> list = kfSessionService.getUsersByKfOpenid(openid);
        mv.addObject("list",list);
        mv.setViewName("msg-list");
        return mv;
    }

    @RequestMapping("/msgContent")
    public ModelAndView msgContent(@RequestParam(value="kf_openid",required = false) String kf_openid,
                                   @RequestParam(value="user_openid",required = false) String user_openid){
        ModelAndView mv = new ModelAndView();

        mv.addObject("kf_openid",kf_openid);
        mv.addObject("user_openid",user_openid);
        List<WxKfSession> list = kfSessionService.getContent(kf_openid,user_openid);
        mv.addObject("list",list);
        mv.setViewName("msg-cont");
        return mv;
    }

    @RequestMapping("/sendMsg")
    @ResponseBody
    public BaseResponse sendMsg(WxKfSession kfSession){
        log.info("======begin to send msg======");
        kfSession.setOpercode("2002");//操作码，2002（客服发送信息），2003（客服接收消息）
        kfSession.setTime(new Date());

        //微信发送客服消息
        BaseAccessTokenResponse baseAccessTokenResponse = wxKFService.getAccessToken(this.wx_appid,this.wx_appsecret);
        String accessToken = baseAccessTokenResponse.getAccessToken();//得到accessToken
        KFMsgBaseRequest param = new KFMsgBaseRequest();
        param.setAccessToken(accessToken);
        param.setTouser(kfSession.getUser_openid());
        BaseResponse baseResponse = wxKFService.sendMessage(param);
        log.info(baseResponse.getErrCode() + ":" + baseResponse.getErrMsg());

        //插入数据库
        int a = kfSessionService.insert(kfSession);

        return baseResponse;
    }

    /**
     * 跳转页面
     * @return
     */
    @RequestMapping("/transfer")
    public ModelAndView Transfer(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("transfer-success");
        return mv;
    }
}
