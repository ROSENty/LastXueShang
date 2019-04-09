package com.example.xueshang;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import org.litepal.LitePal;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Level_medium extends AppCompatActivity {

    private List<Level_2> level_2List = new ArrayList<>();
    private List<Level_3> level_3List = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_medium);

        Button medium_createDatabase = (Button) findViewById(R.id.level_Medium_create_database);
        Button medium_level_2Csv = (Button) findViewById(R.id.level_Medium_level_2Csv);
        Button medium_level_3Csv = (Button) findViewById(R.id.level_Medium_level_3Csv);
        Button delData = (Button) findViewById(R.id.level_Medium_delData);

        medium_createDatabase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //LitePal.getDatabase();
            }
        });

        medium_level_2Csv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //readLevel_2File();
            }
        });

        medium_level_3Csv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //readLevel_3File();
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

    private void readLevel_2File() {
        level_2List = readLevel_2Csv("/data/data/com.example.xueshang/files/level2.csv");
    }

    private ArrayList<Level_2> readLevel_2Csv(String path) {
        ArrayList<Level_2> readerArr = new ArrayList<>();
        File file = new File(path);
        FileInputStream fileInputStream;
        Scanner in;
        try {
            fileInputStream = new FileInputStream(file);
            in = new Scanner(fileInputStream, "UTF-8");
            while (in.hasNextLine()) {
                String[] lines = in.nextLine().split(",");
                Level_2 level_2 = new Level_2(lines[0], lines[1], lines[2], lines[3]);
                level_2.save();
                readerArr.add(level_2);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return readerArr;
    }

    private void readLevel_3File() {
        level_3List = readLevel_3Csv("/data/data/com.example.xueshang/files/level3.csv");
    }

    private ArrayList<Level_3> readLevel_3Csv(String path) {
        ArrayList<Level_3> readerArr = new ArrayList<>();
        File file = new File(path);
        FileInputStream fileInputStream;
        Scanner in;
        try {
            fileInputStream = new FileInputStream(file);
            in = new Scanner(fileInputStream, "UTF-8");
            while (in.hasNextLine()) {
                String[] lines = in.nextLine().split(",");
                int value = Integer.parseInt(lines[4]);
                Level_3 level_3 = new Level_3(lines[0], lines[1], lines[2], lines[3], value, lines[5], lines[6]);
                level_3.save();
                readerArr.add(level_3);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return readerArr;
    }
}
