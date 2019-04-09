package com.example.xueshang;

import org.litepal.crud.DataSupport;

/**
 * Created by asus on 2019/2/26.
 */

public class Profession extends DataSupport {
    private String subject;
    private String category;
    private String name;

    public Profession(String subject, String category, String name) {
        this.subject = subject;
        this.category = category;
        this.name = name;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
