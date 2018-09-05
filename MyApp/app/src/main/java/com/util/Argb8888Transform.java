package com.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Shader;

import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation;

/**
 * Created by Administrator on 2018/4/23 0023.
 */

public class Argb8888Transform extends BitmapTransformation {
    public Argb8888Transform(Context context) {
        super(context);
    }

    @Override
    protected Bitmap transform(BitmapPool pool, Bitmap source, int outWidth, int outHeight) {
        LogUtil.i("==------------------------------------------------------------------==== Bitmap source=========>");
        int w=source.getWidth();
        int h=source.getHeight();
        Bitmap result = pool.get(w, h, Bitmap.Config.ARGB_8888);
        if (result == null) {
            result = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
        }
        LogUtil.i("====== Bitmap source==result======="+result);





        Canvas canvas = new Canvas(result);
        BitmapShader bitmapShader = new BitmapShader(result, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        Paint paint = new Paint();
        paint.setShader(bitmapShader);
        canvas.drawRect(0, 0, result.getWidth(), result.getHeight(), paint);







        return result;
//        if (source == null) return null;
//
//        int size = Math.min(source.getWidth(), source.getHeight());
//        int x = (source.getWidth() - size) / 2;
//        int y = (source.getHeight() - size) / 2;
//
//        // TODO this could be acquired from the pool too
//        Bitmap squared = Bitmap.createBitmap(source, x, y, size, size);
//
//        Bitmap result = pool.get(size, size, Bitmap.Config.ARGB_8888);
//        if (result == null) {
//            result = Bitmap.createBitmap(size, size, Bitmap.Config.ARGB_8888);
//        }
//
//        Canvas canvas = new Canvas(result);
//        Paint paint = new Paint();
//        paint.setShader(new BitmapShader(squared, BitmapShader.TileMode.CLAMP, BitmapShader.TileMode.CLAMP));
//        paint.setAntiAlias(true);
//        float r = size / 2f;
//        canvas.drawCircle(r, r, r, paint);
//        return result;


    }

    @Override
    public String getId() {
        return getClass().getName();
    }
}
