package com.blade.ssm.controller;

import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/api/test")
public class TestController {

    @RequestMapping(value = "/re")
    @ResponseBody
    public String sayRe() {
        //
        return "forward:/api/test/yes";
    }

    @RequestMapping(value = "/yes")
    @ResponseBody
    public String sayYes() {
        //
        return "23333";
    }

    @RequestMapping(value = "/cookie")
    @ResponseBody
    public String sayCookie(@CookieValue(value = "JSESSIONID") String id) {

        int a = 12;
        a += 1;
        int b = a + 12;
        System.out.println(id);

        return "23333";
    }
//HttpMessageConverter
}
