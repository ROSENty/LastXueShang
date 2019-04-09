package com.example.xueshang;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.litepal.LitePal;
import org.litepal.crud.DataSupport;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FractionQuery extends BaseActivity {

//    private List<School> schoolList = new ArrayList<>();
//   private List<Profession> schoolList1 = new ArrayList<>();
    private static final String TAG = "MainActivity";
    private EditText fraction_query_editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fraction_query);

        Button button_query = (Button) findViewById(R.id.fraction_query_query);
        fraction_query_editText = (EditText) findViewById(R.id.fraction_query_edit_text);
/*
        Button createDatabase = (Button) findViewById(R.id.create_database);
        createDatabase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //LitePal.getDatabase();//创建数据库
                //readCsvFile();//将模拟机中的文件读取到数据库
                //DataSupport.deleteAll(School.class);//删除School表中的所有数据
                if (schoolList.size() > 0) {
                    String str = schoolList.size() + "";
                    Toast.makeText(FractionQuery.this, str, Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(FractionQuery.this, "文件读取失败", Toast.LENGTH_SHORT).show();
                }
            }
        });*/
        button_query.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputText = fraction_query_editText.getText().toString();
                query(inputText);
            }
        });
    }
    private void query(String string) {
        List<School> schools = DataSupport.where("highest >= ? and lowest <= ?", string, string )
                .find(School.class);//模糊查询

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.fraction_query_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        SchoolAdapter adapter = new SchoolAdapter(schools);
        recyclerView.setAdapter(adapter);
    }
/*
    private  void readCsvFile() {//读文件
        //schoolList = readCsv("/data/data/com.example.xueshang/files/C.csv");
        //schoolList1 = readCsv("/sdcard/test/C.csv");
        schoolList1 = readCsv("/data/data/com.example.xueshang/files/B.csv");
    }*/
/*    private ArrayList<Profession> readCsv(String path) {//读专业数据文件
        ArrayList<Profession> readerArr = new ArrayList<>();
        File file = new File(path);
        FileInputStream fileInputStream;
        Scanner in;
        try {
            fileInputStream = new FileInputStream(file);
            in = new Scanner(fileInputStream, "UTF-8");
            in.nextLine();
            while (in.hasNextLine()) {
                String[] lines = in.nextLine().split(",");
                Profession profession = new Profession(lines[0], lines[1], lines[2]);
                profession.save();
                readerArr.add(profession);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return readerArr;
    }*/
/*
    private  ArrayList<School> readCsv(String path) {//读取大学数据csv文件
        ArrayList<School> readerArr = new ArrayList<>();
        File file = new File(path);
        FileInputStream fileInputStream;
        Scanner in;
        try {
            fileInputStream = new FileInputStream(file);
            in = new Scanner(fileInputStream, "UTF-8");
            in.nextLine();
            while (in.hasNextLine()) {
                String[] lines = in.nextLine().split(",");
                int value1 = Integer.parseInt(lines[2]);
                double value2= Double.parseDouble(lines[3]);
                double value3 = Double.parseDouble(lines[4]);
                double value4 = Double.parseDouble(lines[5]);
                School school = new School(lines[0], lines[1], value1, value2, value3, value4);
                school.save();//写入数据库
                readerArr.add(school);//添加到list中
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return readerArr;
    }*/
}
