package com.blade.ssm.service;

import com.blade.ssm.model.Image;

public interface ImageService {

    Integer registerImage(Image image);

    Integer CleanAllImages();

    Integer CheckImages();


}
