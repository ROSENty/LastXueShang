package com.example.xueshang;

import org.litepal.crud.DataSupport;

/**
 * Created by asus on 2019/3/10.
 */

public class Major extends DataSupport {
    private String maj_subect;
    private String maj_major;
    private String maj_intro;

    Major(String maj_subect, String maj_major, String maj_intro) {
        this.maj_subect = maj_subect;
        this.maj_major = maj_major;
        this.maj_intro = maj_intro;
    }

    public String getMaj_subect() {
        return maj_subect;
    }

    public void setMaj_subect(String maj_subect) {
        this.maj_subect = maj_subect;
    }

    public String getMaj_major() {
        return maj_major;
    }

    public void setMaj_major(String maj_major) {
        this.maj_major = maj_major;
    }

    public String getMaj_intro() {
        return maj_intro;
    }

    public void setMaj_intro(String maj_intro) {
        this.maj_intro = maj_intro;
    }
}
