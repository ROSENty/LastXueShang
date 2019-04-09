package com.example.xueshang.dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.xueshang.entity.User;

import java.util.ArrayList;

/**
 * Created by asus on 2018/8/18.
 */

public class UserDao {

    private DBOpenHelper dbOpenHelper;
    private SQLiteDatabase sqLiteDatabase;
    //构造函数，初始化DBOpenHelper对象
    public UserDao(Context context) {
        dbOpenHelper = new DBOpenHelper(context, null, null, 0);
    }

    //插入数据
    public void dbInsert(String userName, String userPwd) {
        sqLiteDatabase = dbOpenHelper.getWritableDatabase();
        String sql = "insert into User(userName, userPwd, isDel) values(?, ?, 0)";
        Object bindArgs[] =new Object[] {userName, userPwd};
        sqLiteDatabase.execSQL(sql, bindArgs);
    }

    //查询数据
    public int dbGetUserSize() {
        sqLiteDatabase = dbOpenHelper.getWritableDatabase();
        String sql = "select count(*) from User where isDel=0 ";
        Cursor cursor = sqLiteDatabase.rawQuery(sql, null);
        if (cursor.moveToNext()) {              //判断Cursor中是否有数据
            return cursor.getInt(0);           //返回总记录数
        }
        return 0;                              //如果没有数据，则返回0
    }

    public User dbQueryOneByUsername(String userName) {
        sqLiteDatabase = dbOpenHelper.getWritableDatabase();
        String sql = "select * from User where userName=? and isDel=0";
        String[] selectionArgs = new String[] { userName };
        Cursor cursor = sqLiteDatabase.rawQuery(sql, selectionArgs);
        if (cursor.moveToNext()) {           //判断Cursor中是否有数据
            User user = new User();
            user.setId(cursor.getInt(cursor.getColumnIndex("id")));
            user.setUserName(cursor.getString(cursor.getColumnIndex("userName")));
            user.setUserPwd(cursor.getString(cursor.getColumnIndex("userPwd")));
            return user;                    //返回总记录行数
        }
        return null;
    }

    //查询新增数
    public ArrayList<User> dbQueryAll() {
        ArrayList<User> userArrayList = new ArrayList<User>();
        sqLiteDatabase = dbOpenHelper.getWritableDatabase();
        String sql = "select from * User where isDel=0";
        Cursor cursor = sqLiteDatabase.rawQuery(sql, null);
        for (cursor.moveToFirst(); !(cursor.isAfterLast()); cursor.moveToNext()) {
            if (cursor.getInt(cursor.getColumnIndex("isDel")) != 1) {
                User user = new User();
                user.setId(cursor.getInt(cursor.getColumnIndex("id")));
                user.setUserName(cursor.getString(cursor.getColumnIndex("userName")));
                user.setUserPwd(cursor.getString(cursor.getColumnIndex("userPwd")));
                userArrayList.add(user);
            }
        }
        return userArrayList;
    }

    //更新数据
    public void dbDeleteUser(int id) {
        sqLiteDatabase = dbOpenHelper.getWritableDatabase();
        String sql = "update User set isDel=1 where id=?";
        Object bindArgs[] = new Object[] {id};
        sqLiteDatabase.execSQL(sql,bindArgs);
    }















}
