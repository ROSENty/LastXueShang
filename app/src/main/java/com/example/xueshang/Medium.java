package com.example.xueshang;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import org.litepal.LitePal;
import org.litepal.crud.DataSupport;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Medium extends AppCompatActivity {

    private List<Category> categoryList = new ArrayList<>();
    private List<Major> majorList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medium);

        Button medium_createDatabase = (Button) findViewById(R.id.Medium_create_database);
        Button intentActivity = (Button) findViewById(R.id.Medium_intent);
        Button medium_categoryCsv = (Button) findViewById(R.id.Medium_categoryCsv);
        Button medium_majorCsv = (Button) findViewById(R.id.Medium_majorCsv);
        Button delData = (Button) findViewById(R.id.Medium_delData);

        medium_createDatabase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //LitePal.getDatabase();
            }
        });


        intentActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent intentProfession = new Intent(Medium.this, MajAct.class);
                //startActivity(intentProfession);
            }
        });

        medium_categoryCsv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //readCategoryFile();
            }
        });

        medium_majorCsv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //readMajorFile();
            }
        });

        delData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //DataSupport.deleteAll(Category.class);
                //DataSupport.deleteAll(Major.class);
            }
        });
    }


    private void readCategoryFile() {
        categoryList = readCategoryCsv("/data/data/com.example.xueshang/files/category.csv");
    }

    private ArrayList<Category> readCategoryCsv(String path) {
        ArrayList<Category> readerArr = new ArrayList<>();
        File file = new File(path);
        FileInputStream fileInputStream;
        Scanner in;
        try {
            fileInputStream = new FileInputStream(file);
            in = new Scanner(fileInputStream, "UTF-8");
            while (in.hasNextLine()) {
                String[] lines = in.nextLine().split(",");
                Category category = new Category(lines[0], lines[1]);
                category.save();
                readerArr.add(category);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return readerArr;
    }

    private void readMajorFile() {
        majorList = readMajorCsv("/data/data/com.example.xueshang/files/major.csv");
    }

    private ArrayList<Major> readMajorCsv(String path) {
        ArrayList<Major> readerArr = new ArrayList<>();
        File file = new File(path);
        FileInputStream fileInputStream;
        Scanner in;
        try {
            fileInputStream = new FileInputStream(file);
            in = new Scanner(fileInputStream, "UTF-8");
            while (in.hasNextLine()) {
                String[] lines = in.nextLine().split(",");
                Major major = new Major(lines[0], lines[1], lines[2]);
                major.save();
                readerArr.add(major);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return readerArr;
    }
}
