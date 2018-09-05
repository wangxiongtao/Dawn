package com.view.ImagePicker.bean;

import java.util.ArrayList;

/**
 * Created by Administrator on 2018/8/28 0028.
 */

public class ImageFolderBean {
    public String folderName;
    public String folderPath;
    public ImageItemBean coverImage;
    public ArrayList<ImageItemBean>imageList;
    /** 只要文件夹的路径和名字相同，就认为是相同的文件夹 */
    @Override
    public boolean equals(Object o) {
        try {
            ImageFolderBean other = (ImageFolderBean) o;
            return this.folderPath.equalsIgnoreCase(other.folderPath) && this.folderName.equalsIgnoreCase(other.folderName);
        } catch (ClassCastException e) {
            e.printStackTrace();
        }
        return super.equals(o);
    }


}
