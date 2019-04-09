package com.example.xueshang;

import org.litepal.crud.DataSupport;

/**
 * Created by asus on 2019/3/9.
 */
//城市所拥有的大学的表
public class CityUniv extends DataSupport {
    private String cityUnivName;
    private String univ;

    public CityUniv(String cityUnivName, String univ) {
        this.cityUnivName = cityUnivName;
        this.univ = univ;
    }

    public String getCityUnivName() {
        return cityUnivName;
    }

    public void setCityUnivName(String cityUnivName) {
        this.cityUnivName = cityUnivName;
    }

    public String getUniv() {
        return univ;
    }

    public void setUniv(String univ) {
        this.univ = univ;
    }
}
