package com.view.ImagePicker;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.dawn.R;
import com.view.ImagePicker.adapter.ImageAdapter;
import com.view.ImagePicker.bean.ImageFolderBean;
import com.view.ImagePicker.bean.ImageItemBean;
import com.view.ImagePicker.listener.ImageDataListener;
import com.view.ImagePicker.listener.ImageLoadListener;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ImagePickerActivity extends AppCompatActivity implements ImageDataListener {
    private ImageDataSource dataSource;
    private List<ImageFolderBean> mFolderList;
    private List<ImageItemBean> mImageList;
    private RecyclerView recyclerView;
    private ImageAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_picker);
        dataSource=new ImageDataSource(this);
        dataSource.setImageDataListener(this);
        recyclerView=findViewById(R.id.image_data);
        recyclerView.setLayoutManager(new GridLayoutManager(this,3));
        mImageList=new ArrayList<>();
        ImagePicker.getInstance().setImageLoadListener(new ImageLoadListener() {
            @Override
            public void loadImage(Activity activity, String filePath, ImageView imageView) {
                Glide.with(activity)                             //配置上下文
                        .load(Uri.fromFile(new File(filePath)))      //设置图片路径(fix #8,文件名包含%符号 无法识别和显示)
                        .error(R.drawable.ic_default_image)           //设置错误图片
                        .placeholder(R.drawable.ic_default_image)     //设置占位图片
                        .diskCacheStrategy(DiskCacheStrategy.ALL)//缓存全尺寸
                        .into(imageView);
            }
        });


        adapter=new ImageAdapter(this,mImageList);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onLoadSuccess(List<ImageFolderBean> folderList) {
        this.mFolderList=folderList;
        if(mFolderList.size()>0){
            mImageList.clear();
            mImageList.addAll(mFolderList.get(0).imageList);
            adapter.notifyDataSetChanged();
        }


    }
}
