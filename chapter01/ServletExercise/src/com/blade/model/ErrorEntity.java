package com.blade.model;

import com.blade.constant.ErrorCode;

import javax.servlet.http.HttpServletRequest;

public class ErrorEntity {

    private Integer status_code;
    private String request_url;
    private Throwable exception;
    private Class exception_type;
    private String message;
    private String servlet_name;

    public Integer getStatus_code() {
        return status_code;
    }

    public void setStatus_code(Integer status_code) {
        this.status_code = status_code;
    }

    public String getRequest_url() {
        return request_url;
    }

    public void setRequest_url(String request_url) {
        this.request_url = request_url;
    }

    public Throwable getException() {
        return exception;
    }

    public void setException(Throwable exception) {
        this.exception = exception;
    }

    public Class getException_type() {
        return exception_type;
    }

    public void setException_type(Class exception_type) {
        this.exception_type = exception_type;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getServlet_name() {
        return servlet_name;
    }

    public void setServlet_name(String servlet_name) {
        this.servlet_name = servlet_name;
    }

    public void parseRequestParams(HttpServletRequest request) {
        this.setStatus_code((Integer) request.getAttribute(ErrorCode.status_code));
        this.setServlet_name((String) request.getAttribute(ErrorCode.servlet_name));
        this.setRequest_url((String) request.getAttribute(ErrorCode.request_url));
        this.setException((Throwable) request.getAttribute(ErrorCode.exception));
        this.setException_type((Class) request.getAttribute(ErrorCode.exception_type));
        this.setMessage((String) request.getAttribute(ErrorCode.message));
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        if (servlet_name == null){ servlet_name = "Unknown";}
        if (request_url == null){ request_url = "Unknown";}

        builder.append("status_code: ").append(this.getStatus_code()).append("<br>");
        builder.append("request_url: ").append(this.getRequest_url()).append("<br>");
        builder.append("exception: ").append(this.getException()).append("<br>");
        builder.append("exception_type: ").append(this.getException_type()).append("<br>");
        builder.append("message: ").append(this.getMessage()).append("<br>");
        builder.append("servlet_name: ").append(this.getServlet_name()).append("<br>");

        return builder.toString();
    }
}
