package com.blade.ssm.dto;

import org.springframework.stereotype.Component;

public class LoginFailedResultJson extends ResultJson {

    // 完整继承方法属性
    // 重写构造方法
    public LoginFailedResultJson() {
        this.code = 500;
        this.msg = "登录身份失效";
        this.count = 0;
        this.data = null;
    }

}
