package com.example.xueshang;

import org.litepal.crud.DataSupport;

/**
 * Created by asus on 2019/3/11.
 */

public class Level_3 extends DataSupport {
    private String PR_3;
    private String title_3;
    private String time;
    private String author;
    private int flag;
    private String qu;
    private String text;

    public Level_3( String PR_3, String title_3, String time, String author, int flag, String qu, String text) {
        this.PR_3 = PR_3;
        this.title_3 = title_3;
        this.time = time;
        this.author = author;
        this.flag = flag;
        this.qu = qu;
        this.text = text;
    }

    public String getPR_3() {
        return PR_3;
    }

    public void setPR_3(String PR_3) {
        this.PR_3 = PR_3;
    }

    public String getTitle_3() {
        return title_3;
    }

    public void setTitle_3(String title_3) {
        this.title_3 = title_3;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public String getQu() {
        return qu;
    }

    public void setQu(String qu) {
        this.qu = qu;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
