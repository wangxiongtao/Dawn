package com.util;

import android.content.Context;
import android.graphics.PixelFormat;
import android.graphics.drawable.Drawable;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;

import com.dawn.R;
import com.view.toast.MyToast;
import com.view.toast.ToastAnimationView;

import static android.content.Context.WINDOW_SERVICE;


/**
 * Toast统一管理类
 */
public class ToastUtil {
	// Toast
	private static Toast toast;
	private static ToastAnimationView myToast;
	private static   MyToast t;

	/**
	 * 短时间显示Toast
	 * @param context
	 * @param message
	 */
	public static void showShort(Context context, CharSequence message) {
//		if (null == toast) {
//			toast = Toast.makeText(context, message, Toast.LENGTH_SHORT);
//			// toast.setGravity(Gravity.CENTER, 0, 0);
//		} else {
//			toast.setText(message);
//		}
//		toast.show();
		Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
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
//		if(null == dialog){
//			toast = new Toast(context);
//		}
////		toast.setDuration(Toast.LENGTH_SHORT);
////		toast.setGravity(Gravity.CENTER, 0, 0);
////		View view = LayoutInflater.from(context).inflate(R.layout.toast_wide, null);
////		TextView textView = (TextView) view.findViewById(R.id.toast_layout);
////		textView.setText(context.getResources().getString(message));
////
////		toast.setView(view);
////		toast.show();
//		toast = null;
	}

	/**
	 * 宽边Toast
	 * @param context
	 * @param message			显示内容
	 */
//	public static void showWide(Context context, CharSequence message){
//		if(null == toast){
//			toast = new Toast(context);
//		}
//		toast.setDuration(Toast.LENGTH_SHORT);
//		toast.setGravity(Gravity.CENTER, 0, 0);
//		View view = LayoutInflater.from(context).inflate(R.layout.toast_wide, null);
//		TextView textView = (TextView) view.findViewById(R.id.toast_layout);
//		textView.setText(message);
//
//		toast.setView(view);
//		toast.show();
//		toast = null;
//	}

	/** Hide the toast, if any. */
	public static void hideToast() {
		if (null != toast) {
			toast.cancel();
		}
	}



	public static void showWide(Context context, CharSequence message){
		if (android.text.TextUtils.isEmpty(message)) {
			return;
		}
		if(t==null){
		    t=new MyToast(context);
        }

//		myToast.showAnimaToast();
//        if(dialog==null){
//		    dialog=new ToastDialog(context);
//        }
//        dialog.showDialog();

		t.attach();


//
//		if(null == toast){
//			toast = new Toast(context);
//			toast.setDuration(Toast.LENGTH_SHORT);
//			toast.setGravity(Gravity.TOP, 0, 0);
//			View view = LayoutInflater.from(context).inflate(R.layout.toast_wide, null);
////			TextView textView = (TextView) view.findViewById(R.id.toast_layout);
////			textView.setText(message);
//			toast.setView(view);
//		} else {
//			//解决重复提示toast的bug
////			((TextView)toast.getView().findViewById(R.id.toast_layout)).setText(message);
//		}
//		toast.show();
	}



	public static void myToast(Context context) {
		// 1.0将自定义吐司的布局文件转换成view
		View view = View.inflate(context.getApplicationContext(), R.layout.toast_wide, null);
		ToastAnimationView view1=view.findViewById(R.id.toast1);
		// 2.0参照系统吐司写法
		WindowManager.LayoutParams params = new WindowManager.LayoutParams();
		params.height = 300;
		params.width = WindowManager.LayoutParams.WRAP_CONTENT;
		params.gravity=Gravity.TOP;
		// 当指定与左边对齐时，x为到左边的距离；为右边对齐时则为到右边的距离;y同理。

//		params.x = 0;
//		params.y =300;

		params.format = PixelFormat.TRANSLUCENT;
		params.type = WindowManager.LayoutParams.TYPE_TOAST;
		params.setTitle("Toast");
		params.flags = WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON
				| WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE
				| WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE
		        |WindowManager.LayoutParams.FLAG_LAYOUT_IN_SCREEN;

		// 3.0得到窗体管理类实例
		WindowManager wm = (WindowManager) context.getApplicationContext().getSystemService(WINDOW_SERVICE);
		wm.addView(view, params);
		view1.showAnimaToast();

	}
}
