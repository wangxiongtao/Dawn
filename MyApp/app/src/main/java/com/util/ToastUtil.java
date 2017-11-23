package com.util;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.Gravity;
import android.widget.Toast;


/**
 * Toast统一管理类
 */
public class ToastUtil {
	// Toast
	private static Toast toast;

	/**
	 * 短时间显示Toast
	 * @param context
	 * @param message
	 */
	public static void showShort(Context context, CharSequence message) {
		if (null == toast) {
			toast = Toast.makeText(context, message, Toast.LENGTH_SHORT);
			// toast.setGravity(Gravity.CENTER, 0, 0);
		} else {
			toast.setText(message);
		}
		toast.show();
	}

	/**
	 * 短时间显示Toast
	 * @param context
	 * @param message
	 */
	public static void showShort(Context context, int message) {
		if (null == toast) {
			toast = Toast.makeText(context, message, Toast.LENGTH_SHORT);
			// toast.setGravity(Gravity.CENTER, 0, 0);
		} else {
			toast.setText(message);
		}
		toast.show();
	}

	/**
	 * 长时间显示Toast
	 * @param context
	 * @param message
	 */
	public static void showLong(Context context, CharSequence message) {
		if (null == toast) {
			toast = Toast.makeText(context, message, Toast.LENGTH_LONG);
			// toast.setGravity(Gravity.CENTER, 0, 0);
		} else {
			toast.setText(message);
		}
		toast.show();
	}

	/**
	 * 长时间显示Toast
	 * @param context
	 * @param message
	 */
	public static void showLong(Context context, int message) {
		if (null == toast) {
			toast = Toast.makeText(context, message, Toast.LENGTH_LONG);
			// toast.setGravity(Gravity.CENTER, 0, 0);
		} else {
			toast.setText(message);
		}
		toast.show();
	}

	/**
	 * 自定义显示Toast时间
	 * @param context
	 * @param message
	 * @param duration
	 */
	public static void show(Context context, CharSequence message, int duration) {
		if (null == toast) {
			toast = Toast.makeText(context, message, duration);
		} else {
			toast.setText(message);
		}
		toast.show();
	}

	/**
	 * 
	 * @Description:自定义显示Toast时间的居中Toast
	 * @Title: showInCenter 
	 * @param context
	 * @param message
	 * @param duration  
	 * @return void   
	 */
	public static void showInCenter(Context context, CharSequence message, int duration) {
		Toast centerToast = Toast.makeText(context, message, duration);
		centerToast.setGravity(Gravity.CENTER, 0, 0);
		centerToast.show();
	}

	/**
	 * 自定义显示Toast时间
	 * @param context
	 * @param message
	 * @param duration
	 */
	public static void show(Context context, int message, int duration) {
		if (null == toast) {
			toast = Toast.makeText(context, message, duration);
			// toast.setGravity(Gravity.CENTER, 0, 0);
		} else {
			toast.setText(message);
		}
		toast.show();
	}

	/**
	 * 带图片Toast，图片在字上部
	 * @param context
	 * @param str			显示内容
	 * @param drawable		图片
	 */
	public static void showImg(Context context, String str, Drawable drawable){
		if(null == toast){
			toast = new Toast(context);
		}
//		toast.setDuration(Toast.LENGTH_SHORT);
//		toast.setGravity(Gravity.CENTER, 0, 0);
//		View view = LayoutInflater.from(context).inflate(R.layout.toast_layout, null);
//		TextView textView = (TextView) view.findViewById(R.id.toast_layout);
//		textView.setText(str);
//		if(null != drawable) {
//			drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
//			textView.setCompoundDrawables(null, drawable, null, null);
//		}
//		toast.setView(view);
//		toast.show();
		toast = null;
	}

	/**
	 * 宽边Toast
	 * @param context
	 * @param message			显示内容
	 */
	public static void showWide(Context context, int message){
		if(null == toast){
			toast = new Toast(context);
		}
//		toast.setDuration(Toast.LENGTH_SHORT);
//		toast.setGravity(Gravity.CENTER, 0, 0);
//		View view = LayoutInflater.from(context).inflate(R.layout.toast_wide, null);
//		TextView textView = (TextView) view.findViewById(R.id.toast_layout);
//		textView.setText(context.getResources().getString(message));
//
//		toast.setView(view);
//		toast.show();
		toast = null;
	}

	/**
	 * 宽边Toast
	 * @param context
	 * @param message			显示内容
	 */
	public static void showWide(Context context, CharSequence message){
		if(null == toast){
			toast = new Toast(context);
		}
//		toast.setDuration(Toast.LENGTH_SHORT);
//		toast.setGravity(Gravity.CENTER, 0, 0);
//		View view = LayoutInflater.from(context).inflate(R.layout.toast_wide, null);
//		TextView textView = (TextView) view.findViewById(R.id.toast_layout);
//		textView.setText(message);
//
//		toast.setView(view);
//		toast.show();
		toast = null;
	}

	/** Hide the toast, if any. */
	public static void hideToast() {
		if (null != toast) {
			toast.cancel();
		}
	}
}
