package com.view.ImagePicker.adapter;

import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.dawn.R;
import com.view.ImagePicker.ImagePicker;
import com.view.ImagePicker.bean.ImageItemBean;
import com.view.ImagePicker.view.SquareImageView;

import java.util.List;

/**
 * Created by Administrator on 2018/8/28 0028.
 */

public class ImageAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final int VIEWTYPE_CAMERA=0;
    private static final int VIEWTYPE_IMAGE=1;
    private FragmentActivity activity;
    private List<ImageItemBean>imageList;

    public ImageAdapter(FragmentActivity activity,List<ImageItemBean> imageList) {
        this.imageList = imageList;
        this.activity=activity;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if(viewType==VIEWTYPE_IMAGE){
            View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_image_adapter,parent,false);
            return new ImageHolder(view);
        }else {
            View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_camera_adapter,parent,false);
            return new ImageHolder(view);

        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
       int type=getItemViewType(position);
       switch (type){
           case VIEWTYPE_CAMERA:
               break;
           case VIEWTYPE_IMAGE:
               SquareImageView imageView=((ImageHolder)holder).imageView;
               ImageItemBean bean=imageList.get(position-1);
               ImagePicker.getInstance().getImageLoadListener().loadImage(activity,bean.filePath,imageView);
               break;
       }
    }

    @Override
    public int getItemViewType(int position) {
        if(position==0){
            return VIEWTYPE_CAMERA;
        }else {
           return VIEWTYPE_IMAGE;
        }
    }

    @Override
    public int getItemCount() {
        return imageList.size()+1;
    }

    class ImageHolder extends RecyclerView.ViewHolder{
        private SquareImageView imageView;

        public ImageHolder(View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.item_image);
        }
    }
    class CameraHolder extends RecyclerView.ViewHolder{
        private SquareImageView imageView;

        public CameraHolder(View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.item_image);
        }
    }
}
