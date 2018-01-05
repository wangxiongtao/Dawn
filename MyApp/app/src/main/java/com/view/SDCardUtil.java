package com.view;

import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.os.storage.StorageManager;
import android.text.TextUtils;
import android.text.format.Formatter;
import android.widget.Toast;

import java.io.File;
import java.lang.reflect.Method;

/**
 * Created by Administrator on 2017/12/6.
 */

public class SDCardUtil {
    /**
     * 获取ROM总大小
     * @param context
     * @return
     */
    public static String getMaxRomSpace(Context context) {
        StatFs fs = new StatFs(getInnerSDCardPath(context));
        String romSpace;
        if (Build.VERSION.SDK_INT  >=18) {
            long blockCount = fs.getBlockCountLong();
            long bloackSize = fs.getBlockSizeLong();
            long totalSpace = bloackSize*blockCount;
            romSpace = Formatter.formatFileSize(context, totalSpace);
        }else{
            long blockCount = fs.getBlockCount();
            long bloackSize = fs.getBlockSize();
            long totalSpace = bloackSize*blockCount;
            romSpace = Formatter.formatFileSize(context, totalSpace);
        }
        return romSpace;
    }
    /**
     * 获取SD卡总大小
     * @param context
     * @return
     */
    public static String getMaxSDSpace(Context context) {
        String extPath = getExtSDCardPath(context);
        if (TextUtils.isEmpty(extPath)) {
            Toast.makeText(context, "无SD卡", 0).show();
            return null;
        }
        File path = new File(extPath);
        StatFs fs = new StatFs(path.getPath());
        String sdSpace;
        if (Build.VERSION.SDK_INT  >=18) {
            long blockCount = fs.getBlockCountLong();
            long bloackSize = fs.getBlockSizeLong();
            long totalSpace = bloackSize*blockCount;
            sdSpace = Formatter.formatFileSize(context, totalSpace);
        }else{
            long blockCount = fs.getBlockCount();
            long bloackSize = fs.getBlockSize();
            long totalSpace = bloackSize*blockCount;
            sdSpace = Formatter.formatFileSize(context, totalSpace);
        }
        return sdSpace;
    }
    /**
     * 获取rom可用大
     * 小
     * @param context
     * @return
     */
    public static String getAvailableRomSpace(Context context) {
        File path = Environment.getDataDirectory();
        StatFs fs = new StatFs(path.getPath());
        String Space = null ;
        if (Build.VERSION.SDK_INT  >=18) {

            long blockCount = fs.getAvailableBlocksLong();
            long bloackSize = fs.getBlockSizeLong();
            long totalSpace = bloackSize*blockCount;
            Space = Formatter.formatFileSize(context, totalSpace);
        }else{
            long blockCount = fs.getAvailableBlocks();
            long bloackSize = fs.getBlockSize();
            long totalSpace = bloackSize*blockCount;
            Space = Formatter.formatFileSize(context, totalSpace);
        }
        return Space;
    }
    /**
     * 获取SD卡可用大小
     * @param context
     * @return
     */
    public static String getAvailableSdSpace(Context context) {
        String extPath = getExtSDCardPath(context);
        if (TextUtils.isEmpty(extPath)) {
            Toast.makeText(context, "无SD卡", 0).show();
            return null;
        }
        File path = new File(extPath);
        StatFs fs = new StatFs(path.getPath());
        String Space;
        if (Build.VERSION.SDK_INT >=18) {
            long blockCount = fs.getAvailableBlocksLong();
            long bloackSize = fs.getBlockSizeLong();
            long totalSpace = bloackSize*blockCount;
            Space = Formatter.formatFileSize(context, totalSpace);
        }else{
            long blockCount = fs.getAvailableBlocks();
            long bloackSize = fs.getBlockSize();
            long totalSpace = bloackSize*blockCount;
            Space = Formatter.formatFileSize(context, totalSpace);
        }
        return Space;
    }
    /**
     * 获取外置SD卡路径
     * @return  应该就一条记录或空
     */
    public static String getExtSDCardPath(Context context){
        StorageManager sm = (StorageManager) context.getSystemService(Context.STORAGE_SERVICE);
        try {
            Method getPathsMethod = sm.getClass().getMethod("getVolumePaths", null);
            String[] path = (String[]) getPathsMethod.invoke(sm, null);
            return path[1];
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    /**
     * 获取内置内存路径
     * @return  应该就一条记录或空
     */
    public static String getInnerSDCardPath(Context context){
        StorageManager sm = (StorageManager) context.getSystemService(Context.STORAGE_SERVICE);
        try {
            Method getPathsMethod = sm.getClass().getMethod("getVolumePaths", null);
            String[] path = (String[]) getPathsMethod.invoke(sm, null);
            return path[0];
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
