package com.blade.ssm.controller;

import com.blade.ssm.dto.ResultJson;
import com.blade.ssm.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping(value = "/api/user")
public class UserController {

    @Autowired
    ResultJson resultJson;

    @RequestMapping(value = "/login")
    @ResponseBody
    public Object login(@RequestParam("username") String username, HttpServletRequest request) {

        HttpSession httpSession = request.getSession();
        User user = new User();

//        if (httpSession.isNew()) {
//            System.out.println("这是第一次访问");
//        } else {
//            System.out.println("这是不第一次访问");
//        }
//        CaptchaUtil
        if (username.equals("xuezhijian")) {
            user.setUserId(new Long("160330138"));
            user.setUserName(username);

            httpSession.setAttribute("user", user);
            httpSession.setAttribute("loginStatus", true);
            resultJson.setCode(200);
            resultJson.setCount(2);
            resultJson.setMsg(username + " Login Success");
            System.out.println("用户xuezhijian登录成功");
            resultJson.setData(null);

            return resultJson;
        } else {
            resultJson.setCode(201);
            resultJson.setCount(0);
            resultJson.setMsg(username+" Login Failed");
            resultJson.setData(null);
            return resultJson;
        }

    }

}
