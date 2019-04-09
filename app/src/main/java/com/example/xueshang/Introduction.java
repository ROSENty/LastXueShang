package com.example.xueshang;

import org.litepal.crud.DataSupport;

/**
 * Created by asus on 2019/3/8.
 */
//学校介绍的表
public class Introduction extends DataSupport {
    private String name;
    private String intr;

    public Introduction(String name, String intr) {
        this.name = name;
        this.intr = intr;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIntr() {
        return intr;
    }

    public void setIntr(String intr) {
        this.intr = intr;
    }
}
