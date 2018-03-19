package com.util;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.util.DisplayMetrics;
import android.view.View;

/**
 * Created by Administrator on 2017/7/6.
 *
 */

public class ScreenUtil {
    /**
     *
     * @param context
     * @return 屏幕宽
     */
    public static int getScreenWidth(Context context){
        LogUtil.i("=====width======>"+context.getResources().getDisplayMetrics().widthPixels);
           return context.getResources().getDisplayMetrics().widthPixels;
    }

    /**
     *
     * @param context
     * @return 屏幕高
     */
    public static int getScreenHeight(Context context){
           return context.getResources().getDisplayMetrics().heightPixels;
    }
    public static float getScreenDensity(Context context){
        DisplayMetrics metric = new DisplayMetrics();
        ((Activity)context).getWindowManager().getDefaultDisplay().getMetrics(metric);
        float density = metric.density;  // 屏幕密度（0.75 / 1.0 / 1.5）
        LogUtil.i("==density=====>"+density);







//        try {
//            // 服务器端需要验证的客户端证书，其实就是客户端的keystore
//            KeyStore keyStore = KeyStore.getInstance("BKS");
//            // 客户端信任的服务器端证书
//            KeyStore trustStore = KeyStore.getInstance("BKS");
//
//            //读取证书
//            InputStream ksIn = getResources().getAssets().open("client.bks");
//            InputStream tsIn = getResources().getAssets().open("truststore.bks");
//
//            //加载证书
//            keyStore.load(ksIn,"123456".toCharArray());
//            trustStore.load(tsIn,"123456".toCharArray());
//            IOUtils.close(ksIn);
//            IOUtils.close(tsIn);
//
//            //初始化SSLContext
//            SSLContext sslContext = SSLContext.getInstance("TLS");
//            TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance("X509");
//            KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance("X509");
//            trustManagerFactory.init(trustStore);
//            keyManagerFactory.init(keyStore, "123456".toCharArray());
//            sslContext.init(keyManagerFactory.getKeyManagers(), trustManagerFactory.getTrustManagers(), null);
//
//            //通过HttpsURLConnection设置链接
//            SSLSocketFactory socketFactory = sslContext.getSocketFactory();
//            HttpsURLConnection.setDefaultSSLSocketFactory(socketFactory);
//
//            URL connectUrl = new URL(url);
//            HttpsURLConnection conn = (HttpsURLConnection) connectUrl.openConnection();
//            //设置ip授权认证：如果已经安装该证书，可以不设置，否则需要设置
//            conn.setHostnameVerifier(new HostnameVerifier() {
//                @Override
//                public boolean verify(String hostname, SSLSession session) {
//                    return true;
//                }
//            });
//
//            InputStream inputStream = conn.getInputStream();
//            String content = getString(inputStream);
//            IOUtils.close(inputStream);
//            showLog(content);
//
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }











        return density;

    }


//    private Intent getExplicitIapIntent() {
//        PackageManager pm = mContext.getPackageManager();
//        Intent implicitIntent = new Intent("com.android.vending.billing.InAppBillingService.BIND");
//        List<ResolveInfo> resolveInfos = pm.queryIntentServices(implicitIntent, 0);
//
//        // Is somebody else trying to intercept our IAP call?
//        if (resolveInfos == null || resolveInfos.size() != 1) {
//            return null;
//        }
//
//        ResolveInfo serviceInfo = resolveInfos.get(0);
//        String packageName = serviceInfo.serviceInfo.packageName;
//        String className = serviceInfo.serviceInfo.name;
//        ComponentName component = new ComponentName(packageName, className);
//        Intent iapIntent = new Intent();
//        iapIntent.setComponent(component);
//        return iapIntent;
//    }







    /**
     * 获取一个 View 的缓存视图
     *
     * @param view
     * @return
     */

    private Bitmap getCacheBitmapFromView(View view) {
        final boolean drawingCacheEnabled = true;
        view.setDrawingCacheEnabled(drawingCacheEnabled);
        view.buildDrawingCache(drawingCacheEnabled);
        final Bitmap drawingCache = view.getDrawingCache();
        Bitmap bitmap;
        if (drawingCache != null) {
            bitmap = Bitmap.createBitmap(drawingCache);
            view.setDrawingCacheEnabled(false);
        } else {
            bitmap = null;
        }
        return bitmap;
    }









}
