package com.blade.exception;

import com.blade.constant.ErrorCode;
import com.blade.model.ErrorEntity;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ExceptionHandler extends HttpServlet {

    private ErrorEntity error;

    @Override
    public void init() throws ServletException {
        error = new ErrorEntity();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("处理异常数据-开始");

        error.parseRequestParams(req);

        resp.setContentType("text/html;charset=utf-8");
        resp.getWriter().println(error.toString());

        System.out.println("处理异常数据-写入结束");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
