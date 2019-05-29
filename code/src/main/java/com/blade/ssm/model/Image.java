package com.blade.ssm.model;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.sql.Timestamp;

@Component
public class Image {

    private Long imageId;
    private String imageName;
    private String imageType;
    private Long imageSize;
    private String imageLocation;
    private Long likeCount;
    private Long downloadCount;
    private Long uploaderId;
    private java.sql.Timestamp uploadTime;
    private java.sql.Timestamp updateTime;

    public Image() {

    }

    @Override
    public String toString() {
        return "Image Id Is: " + this.imageId;
    }

    // 部分字段是要求非空的
    public Boolean checkNull() {
        // 这个写法很有意思
        return  this.imageName != null &&
                this.imageType != null &&
                this.imageSize != null &&
                this.imageLocation != null &&
                this.uploaderId != null;
    }

    public void setFromFile(MultipartFile file, User user) {
        this.setImageName(file.getOriginalFilename());
        this.setImageType(file.getContentType());
        this.setImageLocation("/home/blade/mysql/images");
        this.setImageSize(file.getSize());
        this.setLikeCount(0);
        this.setDownloadCount(0);
        this.setUploaderId(user.getUserId());
        this.setUpdateTime(new Timestamp(System.currentTimeMillis()));
        this.setUploadTime(new Timestamp(System.currentTimeMillis()));
    }

    // getter和setter
    public long getImageId() {
        return imageId;
    }

    public void setImageId(long imageId) {
        this.imageId = imageId;
    }


    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }


    public String getImageType() {
        return imageType;
    }

    public void setImageType(String imageType) {
        this.imageType = imageType;
    }


    public long getImageSize() {
        return imageSize;
    }

    public void setImageSize(long imageSize) {
        this.imageSize = imageSize;
    }


    public String getImageLocation() {
        return imageLocation;
    }

    public void setImageLocation(String imageLocation) {
        this.imageLocation = imageLocation;
    }


    public long getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(long likeCount) {
        this.likeCount = likeCount;
    }


    public long getDownloadCount() {
        return downloadCount;
    }

    public void setDownloadCount(long downloadCount) {
        this.downloadCount = downloadCount;
    }


    public long getUploaderId() {
        return uploaderId;
    }

    public void setUploaderId(long uploaderId) {
        this.uploaderId = uploaderId;
    }


    public java.sql.Timestamp getUploadTime() {
        return uploadTime;
    }

    public void setUploadTime(java.sql.Timestamp uploadTime) {
        this.uploadTime = uploadTime;
    }


    public java.sql.Timestamp getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(java.sql.Timestamp updateTime) {
        this.updateTime = updateTime;
    }

}

