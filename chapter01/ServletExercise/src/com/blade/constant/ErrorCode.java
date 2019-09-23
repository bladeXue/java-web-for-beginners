package com.blade.constant;

public interface ErrorCode {

    // 整型
    String status_code = "javax.servlet.error.status_code";

    // Class类型
    String exception_type = "javax.servlet.error.exception_type";

    // 字符串
    String message = "javax.servlet.error.message";

    // 字符串
    String request_url = "javax.servlet.error.request_uri";

    // Throwable
    String exception = "javax.servlet.error.exception";

    // 字符串
    String servlet_name = "javax.servlet.error.servlet_name";

}
