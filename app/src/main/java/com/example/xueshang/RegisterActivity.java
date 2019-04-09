package com.example.xueshang;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.xueshang.dao.UserDao;

public class RegisterActivity extends AppCompatActivity {

//用户注册
    private EditText register_account;
    private EditText register_password;
    private EditText register_confirm;
    private Button register_determine;

//数据库操作
    private UserDao userDao;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        userDao = new UserDao(this);
        register_account = (EditText) findViewById(R.id.register_account);
        register_password = (EditText) findViewById(R.id.register_password);
        register_confirm = (EditText) findViewById(R.id.register_confirm);

        register_determine = (Button) findViewById(R.id.register_determine);

        register_determine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userName = register_account.getText() + "";
                String userPwd = register_password.getText() + "";
                if (userName.equals(null) || userName == "" || userPwd.equals(null) || userPwd == "") {
                    Toast.makeText(RegisterActivity.this, "用户名或密码不得为空", Toast.LENGTH_SHORT).show();
                } else {
                    String confirmPwd = register_confirm.getText() + "";
                    if (!userPwd.equals(confirmPwd)) {
                        Toast.makeText(RegisterActivity.this, "两次输入密码不一致", Toast.LENGTH_SHORT).show();
                    } else {
                        if (userDao.dbQueryOneByUsername(userName) == null) {
                            userDao.dbInsert(userName, userPwd);
                            Toast.makeText(RegisterActivity.this, "注册成功！", Toast.LENGTH_SHORT).show();
                            finish();
                            Intent intent =  new Intent(RegisterActivity.this, LoginActivity.class);
                            startActivity(intent);
                        } else {
                            Toast.makeText(RegisterActivity.this, "该用户名已被注册", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            }
        });


    }
}



















