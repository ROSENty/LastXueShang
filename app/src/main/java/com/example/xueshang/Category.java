package com.example.xueshang;

import org.litepal.crud.DataSupport;

/**
 * Created by asus on 2019/3/10.
 */

public class Category extends DataSupport {
    private String cat_subject;
    private String cat_catetory;

    Category(String cat_subject, String cat_catetory) {
        this.cat_subject = cat_subject;
        this.cat_catetory = cat_catetory;
    }

    public String getCat_subject() {
        return cat_subject;
    }

    public void setCat_subject(String cat_subject) {
        this.cat_subject = cat_subject;
    }

    public String getCat_catetory() {
        return cat_catetory;
    }

    public void setCat_catetory(String cat_catetory) {
        this.cat_catetory = cat_catetory;
    }
}
