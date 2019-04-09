package com.example.xueshang;

import org.litepal.crud.DataSupport;

/**
 * Created by asus on 2019/2/14.
 */

public class School extends DataSupport {
    private String type;
    private String school;
    private double lowest;
    private double highest;
    private double median;
    private int tag;

    public School(String type, String school ,int tag, double lowest,
                  double highest, double median) {
        this.type = type;
        this.school = school;
        this.lowest = lowest;
        this.highest = highest;
        this.median = median;
        this.tag = tag;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public double getLowest() {
        return lowest;
    }

    public void setLowest(double lowest) {
        this.lowest = lowest;
    }

    public double getHighest() {
        return highest;
    }

    public void setHighest(double highest) {
        this.highest = highest;
    }

    public double getMedian() {
        return median;
    }

    public void setMedian(double median) {
        this.median = median;
    }

    public int getTag() { return tag; }

    public void setTag(int tag) { this.tag = tag; }
}