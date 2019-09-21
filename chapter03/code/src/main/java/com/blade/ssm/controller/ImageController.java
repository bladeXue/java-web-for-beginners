package com.blade.ssm.controller;

import com.blade.ssm.dto.ResultJson;
import com.blade.ssm.model.Image;
import com.blade.ssm.model.User;
import com.blade.ssm.service.ImageService;
import com.blade.ssm.utils.CaptchaUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/api/image")
public class ImageController {

    @Autowired
    ResultJson res;

    @Autowired
    Image image;

    @Autowired
    ImageService imageService;

    @RequestMapping("/upload")
    @ResponseBody
    public ResultJson uploadImage(@RequestParam("file")MultipartFile file,
//                                  HttpServletRequest request,
                                  HttpSession httpSession) {

        User user = (User) httpSession.getAttribute("user");
        if (file != null && user != null) {
            // 这里应该有个异常处理
            image.setFromFile(file, user);

            // 有效耦合，尝试注册图片，失败则终止，成功则保存图片
            Integer registerImage =imageService.registerImage(image);
            if (registerImage == 1) try {
                // 完成注册后的Image对象获得了mybatis注入的auto_increase的image_id
                // 且Linux上无需后缀名，考虑到同名文件问题，就直接用image_id作为文件名了
		// 这里没有做文件后缀过滤和体积切割，一般情况下甚至要考虑重编码之类的安全问题
		// 还有过载文件的报错跳转，需要在mvc中额外设置，这些都是要考虑的要点
                file.transferTo(new File(image.getImageLocation() + File.separator + image.getImageId()));
                System.out.println("保存图片 "+image.getImageName()+" 至 "+image.getImageLocation()+" >> "+image.getImageId());

                res.setCode(200);
                res.setMsg("save image success");
                res.setCount(0);
                List<Image> list = new ArrayList<>();
                list.add(image);
                res.setData(list.toArray());
                return res;
            } catch (IOException e) {
                System.out.println(e.toString());
                res.setCode(500);
                res.setMsg("save image failed IOException");
                res.setCount(0);
                res.setData(null);
                return res;
            } catch (IllegalStateException e) {
                System.out.println(e.toString());
                res.setCode(500);
                res.setMsg("save image failed IllegalStateException");
                res.setCount(0);
                res.setData(null);
            } finally {
                System.out.println("file operation end");
            }
            else {
                res.setCode(500);
                res.setMsg("register failed");
                res.setCount(0);
                res.setData(null);
                return res;
            }
        }
        res.setCode(0);
        res.setMsg("file or user error");
        System.out.println("未验证的登录状态");
        res.setCount(0);
        res.setData(null);
        return res;
    }

    @RequestMapping(value = "/captcha")
    public String getCaptcha(HttpServletRequest request, HttpServletResponse response) {
        try {
            CaptchaUtil.outputCaptcha(request, response);
        } catch (ServletException | IOException e) {
            e.printStackTrace();
        }

        return "233";
    }
}
