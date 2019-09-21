// 施工版文件上传控制器
package com.blade.ssm.controller.dev;

import com.blade.ssm.dto.LayuiResultJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;

@Controller
@RequestMapping(value = "/api/dev")
public class FileController {

    @Autowired
    LayuiResultJson res;

    @RequestMapping(value = "/upload")
    @ResponseBody
    public LayuiResultJson uploadFile(HttpServletRequest request, @RequestParam ("file")MultipartFile file) throws Exception {
        System.out.println("***************request start***************");

        // 打印参数
        System.out.println("The Request URL: " + request.getRequestURI());
        System.out.println("The uploaded file's name: " + file.getOriginalFilename());

        if (!file.isEmpty()) {
            // 获取tomcat中存放文件目录的绝对地址
            String path = request.getServletContext().getRealPath("/images");
            path = "/home/blade/mysql/images";
            System.out.println(path);

            // 捕获上传文件名
            String filename = file.getOriginalFilename();

            // 判断tomcat容器中目标文件夹的的/images目录是否存在，不存在就创建（因为我们的路径是context拼接出来的）
            File filepath = new File(path, filename);
            if (!filepath.getParentFile().exists()) {
                filepath.getParentFile().mkdirs();
            }

            byte[] d = file.getBytes();
            System.out.println("d->length: "+d.length);
            System.out.println(d.toString());

            // 保存文件，这里直接封装了一个流，开发者甚至不需要自己new一个stream，直接调用file对象的方法即可
            // File.separator代表分隔符，因为Unix和Windows的分隔符是不一样的，所以用File.separator更加安全
            file.transferTo(new File(path+File.separator+filename));
            System.out.println("上传文件路径: "+ (path+File.separator+filename));

            System.out.println("***************request end***************");
            res.setCode(200);
            res.setMsg(filename + "'s upload success");
            res.setCount(0);
            res.setData(null);
            return res;
        } else {
            System.out.println("***************handle error***************");
            res.setCode(400);
            res.setMsg("error");
            res.setCount(0);
            res.setData(null);
            return res;
        }
    }

    @RequestMapping(value = "/upload/jpg")
    @ResponseBody
    public LayuiResultJson jpgFileUpload(HttpServletRequest httpRequest, @RequestParam("file")MultipartFile file) throws Exception {

        System.out.println(file.getContentType());

        // 限定图片后缀
        if (!file.isEmpty() && file.getContentType().equals("image/jpeg")) {
            System.out.println("Request Path: "+httpRequest.getServletPath());
            System.out.println("Upload File: "+file.getOriginalFilename());
//            System.out.println(httpRequest.getServerName());

            file.transferTo(new File(httpRequest.getServletContext().getRealPath("/images")+File.separator+file.getOriginalFilename()));
            res.setCode(200);
            res.setMsg(file.getOriginalFilename()+"upload success");
            res.setCount(1);
            res.setData(null);
            return res;
        } else {
            res.setCode(400);
            res.setMsg("file empty or type error");
            res.setCount(0);
            res.setData(null);
            return res;
        }
    }
}
