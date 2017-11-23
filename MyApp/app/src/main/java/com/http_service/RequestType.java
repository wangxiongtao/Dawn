package com.http_service;

import android.support.annotation.IntDef;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import static com.http_service.HttpRequest.DOWNLOAD;
import static com.http_service.HttpRequest.GET;
import static com.http_service.HttpRequest.POST;
import static com.http_service.HttpRequest.UPLOAD;


/**
 * Created by Administrator on 2017/11/23.
 */
@IntDef({GET,POST,DOWNLOAD,UPLOAD})
@Retention(RetentionPolicy.SOURCE) //表示注解所存活的时间,在运行时,而不会存在. class 文件.
public @interface RequestType {
}
