package com.dawn.bean;

/**
 * Created by Administrator on 2017/12/11.
 */

public class TreeBean {
    public String content;
    public int level;
    public int pid;
    public int id;
    public boolean isVisible=true;
    public boolean isClick=true;

    public TreeBean(String content, int level, int pid,int id) {
        this.content = content;
        this.level = level;
        this.pid = pid;
        this.id=id;
    }
}
