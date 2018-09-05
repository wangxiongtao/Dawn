package com.view.ImagePicker.listener;

import android.app.Activity;
import android.widget.ImageView;

/**
 * Created by Administrator on 2018/8/28 0028.
 */

public interface ImageLoadListener {
    void loadImage(Activity activity, String filePath, ImageView imageView);
}
