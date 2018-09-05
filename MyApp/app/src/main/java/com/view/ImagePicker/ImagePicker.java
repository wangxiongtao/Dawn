package com.view.ImagePicker;

import com.view.ImagePicker.listener.ImageLoadListener;

/**
 * Created by Administrator on 2018/8/28 0028.
 */

public class ImagePicker {
    private ImageLoadListener imageLoadListener;
    public static ImagePicker getInstance(){
        return ImagePickerHolder.IMAGEPICKER;
    }

    private static class ImagePickerHolder{
        public static ImagePicker IMAGEPICKER=new ImagePicker();
    }

    public void setImageLoadListener(ImageLoadListener imageLoadListener) {
        this.imageLoadListener = imageLoadListener;
    }

    public ImageLoadListener getImageLoadListener() {
        return imageLoadListener;
    }
}
