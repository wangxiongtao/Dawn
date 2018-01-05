package com.dawn.modules;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.dawn.R;

public class WebViewActivity extends AppCompatActivity {
    WebView webView;
    String html="<!DOCTYPE html>\n" +
            "<html>\n" +
            "   <head>\n" +
            "      <meta charset=\"UTF-8\">\n" +
            "      <title>菜鸟教程(runoob.com)</title>\n" +
            "   </head>\n" +
            "    \n" +
            "   <body>\n" +
            "    \n" +
            "      <math xmlns=\"http://www.w3.org/1998/Math/MathML\">\n" +
            "        \n" +
            "         <mrow>\n" +
            "            <msup><mi>a</mi><mn>2</mn></msup>\n" +
            "            <mo>+</mo>\n" +
            "                \n" +
            "            <msup><mi>b</mi><mn>2</mn></msup>\n" +
            "            <mo>=</mo>\n" +
            "                \n" +
            "            <msup><mi>c</mi><mn>2</mn></msup>\n" +
            "         </mrow>\n" +
            "            \n" +
            "      </math>\n" +
            "        \n" +
            "   </body>\n" +
            "</html> ";
    String content = "<p><font color='red'>hello baidu!</font></p>";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);
        webView=findViewById(R.id.web);
        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        webView.loadData(html,"text/html","UTF-8");
//        webView.loadUrl("https://0.baidu.com/?soft=134");
    }
}
