package com.dawn.domain.mananger;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

/**
 * Created by Administrator on 2017/10/25.
 */

public class IntentMananger {
    private static IntentMananger m;
    private Context context;


    public static IntentMananger getInstance() {
        if(m==null){
            m=new IntentMananger();
        }
        return m;
    }

    public IntentMananger setContext(Context context) {
        this.context = context;
        return this;
    }

    public void toActivity(Class<?> cls ){
        Intent intent=new Intent(context,cls);
        context.startActivity(intent);
    }
    public void toActivity(Bundle b,Class<?> cls ){
        Intent intent=new Intent(context,cls);
        intent.putExtra("bundle",b);
        context.startActivity(intent);
    }
    public Bundle getBundle(){
        return ((Activity)context).getIntent().getBundleExtra("bundle");
    }


}
