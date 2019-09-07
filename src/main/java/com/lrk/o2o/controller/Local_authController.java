package com.lrk.o2o.controller;

import com.google.code.kaptcha.Constants;
import com.lrk.o2o.entity.LocalAuth;
import com.lrk.o2o.entity.LogLogin;
import com.lrk.o2o.entity.PersonInfo;
import com.lrk.o2o.service.LogLoginService;
import com.lrk.o2o.service.PersonInfoService;
import com.lrk.o2o.service.LocalAuthService;
import com.lrk.o2o.utils.SysConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


import javax.servlet.http.HttpSession;
import java.util.Date;

@Controller
@RequestMapping("shop")
public class Local_authController {
    @Autowired
    private LocalAuthService localauthService;

    @Autowired
    private PersonInfoService personInfoService;

    @Autowired
    private LogLoginService logLoginService;

    @GetMapping("login.html")
    public String toLogin() {
        return "login";
    }


    //退出
    @GetMapping("logout")
    public String logout(HttpSession session) {
        session.removeAttribute("user");
        return "login";
    }

    //登录
    @PostMapping("login")
    public String login(LocalAuth localAuth,
                        HttpSession session,
                        String code) {
        LocalAuth loginUser=localauthService.login(localAuth);
        String sessCode= (String) session.getAttribute(Constants.KAPTCHA_SESSION_KEY);
        session.removeAttribute(sessCode);

        if (code.equalsIgnoreCase(sessCode)){
            if (loginUser!=null){
                PersonInfo personInfo = new PersonInfo();
                personInfo.setUserId(loginUser.getUserId());
                personInfo=personInfoService.getPerson_info(personInfo);

                session.setAttribute(SysConstants.SESSION_USER,loginUser);
                session.setAttribute(SysConstants.SESSION_PERSONINFO,personInfo);

                LogLogin logLogin = new LogLogin();
                logLogin.setLoginname(localAuth.getUserName());
                logLogin.setLoginip("");
                logLogin.setLogintime(new Date());

                logLoginService.addLog_login(logLogin);

                return "index";
            }else {
                return "redirect:login.html";
            }
        }else {
            return "redirect:login.html";
        }


    }

        //注册
        @GetMapping("register")
        public String register (){
            return "regist";
        }

//        @GetMapping("register")
//        public String register (@RequestParam("user_name") String username,
//                @RequestParam("password") String password){
//
//            LocalAuth user_name = localauthService.getUserById(username);
//            if (user_name.equals("user_name")) {
//                localauthService.regist(user_name);
//
//
//                return "success";
//            } else {
//                return "fail";
//            }
//
//        return "regist";
//        }

}
