package com.blade.ssm.service.impl;

import com.blade.ssm.dao.ImageDao;
import com.blade.ssm.model.Image;
import com.blade.ssm.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("imageService")
public class ImageServiceImpl implements ImageService {

    @Autowired
    ImageDao imageDao;

    @Override
    /*
     * 2019-2-11创建，向数据库注册图像信息，如果写入不成功，则拒绝保存图像，避免僵尸图片
     * 作者 薛志健
     * 入参 图片对象
     * 返回 {int 1: "注册图片成功", int 0: "注册图片失败"}
     */
    public Integer registerImage(Image image) {
        if (image.checkNull()) {
            try {
                // 尝试插入数据
                return imageDao.saveIgnorePK(image);
            } catch (Exception e) {
                System.out.println(e.getClass().toString());
                throw e;
            }
        }
        return 0;
    }

    @Override
    /*
     * 2019-2-11创建，清空所有图片数据，包括图片文件夹和数据库中的注册信息，完成操作后重新检查一下文件夹和数据库，并返回值
     * 作者 薛志健
     * 入参 无
     * 返回 {int n: "删除了n张图片", int 0: "注册图片失败", int -n: "残留了多少图片？？数据库？？"}
     */
    public Integer CleanAllImages() {
        return null;
    }

    @Override
    /*
     * 2019-2-12创建，比对数据库和文件夹中的图片数目，查看僵尸图片和幽灵图片
     * 作者 薛志健
     * 入参 无
     * 返回 {int 1: "有问题", int 0: "没有问题"}
     */
    public Integer CheckImages() {
        return null;
    }
}
