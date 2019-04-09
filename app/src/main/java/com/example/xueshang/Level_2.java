package com.example.xueshang;

import org.litepal.crud.DataSupport;

/**
 * Created by asus on 2019/3/11.
 */

public class Level_2 extends DataSupport {
    private String PR_2;
    private String title_2;
    private String sketch;
    private String url;

    public Level_2(String PR_2, String title_2, String sketch, String url) {
        this.PR_2 = PR_2;
        this.title_2 = title_2;
        this.sketch = sketch;
        this.url = url;
    }

    public String getPR_2() {
        return PR_2;
    }

    public void setPR_2(String PR_2) {
        this.PR_2 = PR_2;
    }

    public String getTitle_2() {
        return title_2;
    }

    public void setTitle_2(String title_2) {
        this.title_2 = title_2;
    }

    public String getSketch() {
        return sketch;
    }

    public void setSketch(String sketch) {
        this.sketch = sketch;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
