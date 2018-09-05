package com.view.ImagePicker.listener;

import com.view.ImagePicker.bean.ImageFolderBean;

import java.util.List;

/**
 * Created by Administrator on 2018/8/28 0028.
 */

public interface ImageDataListener {
    void onLoadSuccess(List<ImageFolderBean> folderList);
}
