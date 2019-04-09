package com.example.xueshang;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.xueshang.dao.UserDao;
import com.example.xueshang.entity.User;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


public class LoginActivity extends AppCompatActivity {

    private ImageView logo;
    private EditText accountEdit;
    private EditText passwordEdit;
    private Button login;
    private Button register;

    //数据库操作类
    private UserDao userDao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

//注册组件
        userDao = new UserDao(this);
        accountEdit = (EditText) findViewById(R.id.account);
        passwordEdit = (EditText) findViewById(R.id.password);
        login = (Button) findViewById(R.id.login);
        register = (Button) findViewById(R.id.register);

//用户登录
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userName = accountEdit.getText() + "";
                String userPwd = passwordEdit.getText() + "";
//判断输入是否为空和只是空格
                if (userName.equals(null) || userName == ""
                        || userPwd.equals(null) || userPwd == "") {
                    Toast.makeText(LoginActivity.this, "用户名或密码不得为空!", Toast.LENGTH_SHORT).show();
                } else {
                    User user = userDao.dbQueryOneByUsername(userName);
                    if (userDao.dbQueryOneByUsername(userName) == null) {
                        Toast.makeText(LoginActivity.this, "此用户不存在", Toast.LENGTH_SHORT).show();
                    } else {
                        if (!user.getUserPwd().equals(userPwd)) {
                            Toast.makeText(LoginActivity.this, "密码错误", Toast.LENGTH_SHORT).show();
                        } else {
                            String notice = getTime();
                            notice = "          登录成功\n" + notice;
                            Toast.makeText(LoginActivity.this, notice, Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                            startActivity(intent);
                        }
                    }
                }
            }
        });

        register.setOnClickListener(new  View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
            }
        });
    }
    private String getTime() {
        Calendar CD = Calendar.getInstance();//获取calendar实例
        int YY = CD.get(Calendar.YEAR) ;//获取当年年份1

        String date = YY + "-06-07 00:00:00";//指定高考时间字符串
        SimpleDateFormat sdf   =   new   SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//指定时间格式

        Date gaoKaoDate = null;//高考日期
        try {
            gaoKaoDate = sdf.parse(date);//parse方法用于将字符串类型的日期/时间解析为Date类型。
        } catch (ParseException e) {
            e.printStackTrace();
        }
        long currentTime = System.currentTimeMillis();//当前时间毫秒数
        long gaoKaoTime = gaoKaoDate.getTime();//获取（高考时间）Date的毫秒数
        int day = (int) ((gaoKaoTime - currentTime)/1000/60/60/24);//相差天数

        String notice ="距离" + YY + "年高考还剩" + day + "天";
        return notice;
    }

}
