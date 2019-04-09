package com.example.xueshang.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by asus on 2018/8/18.
 */

public class DBOpenHelper extends SQLiteOpenHelper {

    public static final String CREATE_USER = "create table User("
            + "id integer primary key autoincrement, "
            + "userName varchar(255), "
            + "userPwd varchar(255), "
            + "isDel integer default 0) ";     //建表语句写成字符串常量

    public DBOpenHelper(Context context, String name,
                        SQLiteDatabase.CursorFactory factory, int version) {
        super(context, "User.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_USER);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oleVersion, int newVersion) {
    }

}
