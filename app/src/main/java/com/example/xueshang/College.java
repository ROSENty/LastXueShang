package com.example.xueshang;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.litepal.LitePal;
import org.litepal.crud.DataSupport;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class College extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

//    private List<Introduction> schoolList2 = new ArrayList<>();
//    private List<CityUniv> schoolList3 = new ArrayList<>();

    private Spinner college_spinner1, college_spinner2;
    private TextView college_textView;
    private List<String> univList = new ArrayList<String>();
    private String content;
    private ArrayAdapter<String> univAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_college);

        college_spinner1 = (Spinner) findViewById(R.id.college_spinner1);
        college_spinner2 = (Spinner) findViewById(R.id.college_spinner2);

        college_textView = (TextView) findViewById(R.id.college_text);
        college_textView.setMovementMethod(ScrollingMovementMethod.getInstance());

        college_spinner1.setOnItemSelectedListener(this);
        college_spinner2.setOnItemSelectedListener(this);

/*        Button createDatabase = (Button) findViewById(R.id.college_createDatabase);
        Button readCsv1 = (Button) findViewById(R.id.college_readCsc1);
        Button readCsv2 = (Button) findViewById(R.id.college_readCsc2);

        createDatabase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LitePal.getDatabase();//创建数据库
                //DataSupport.deleteAll(School.class);//删除School表中的所有数据
            }
        });
        readCsv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                readCsvFileCityUniv();
            }
        });
        readCsv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                readCsvFileUnivIntro();
            }
        });*/
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        content = parent.getItemAtPosition(position).toString();
        switch (parent.getId()) {
            case R.id.college_spinner1:
                univList.clear();
                univList = loadUniv(content);
                univAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, univList);
                college_spinner2.setAdapter(univAdapter);
                break;
            case R.id.college_spinner2:
                String[] str = query(content);
                String string = "";
                //textView.setText(str[0]);
                for (int i = 0; i < str.length; i++) {
                    string += str[i];
                    string += "\n";
                }
                college_textView.setText(string);
                break;
            default:
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
    }

    private String[] query(String string) {
        List<Introduction> introductions = DataSupport.where("name = ?", string)
                .find(Introduction.class);
        String str = introductions.get(0).getIntr();
        String[] lines = str.split(";");
        return lines;
    }

    public List<String> loadUniv(String content) {
        List<CityUniv> cityUnivs = DataSupport.where("cityUnivName = ?", content)
                .find(CityUniv.class);
        List<String> names = new ArrayList<String>();
        String string = cityUnivs.get(0).getUniv();
        String[] str = string.split(";");
        for (int i = 0; i < str.length; i++) {
            names.add(str[i]);
        }
        return names;
    }
/*
    private void readCsvFileCityUniv() {
        schoolList3 = readCsvCityUniv("/data/data/com.example.xueshang/files/cityUniv.csv");
    }

    private ArrayList<CityUniv> readCsvCityUniv(String path) {
        ArrayList<CityUniv> readerArr = new ArrayList<>();
        File file = new File(path);
        FileInputStream fileInputStream;
        Scanner in;
        try {
            fileInputStream = new FileInputStream(file);
            in = new Scanner(fileInputStream, "UTF-8");
            while (in.hasNextLine()) {
                String[] lines = in.nextLine().split(",");
                CityUniv cityUniv = new CityUniv(lines[0], lines[1]);
                cityUniv.save();
                readerArr.add(cityUniv);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return readerArr;
    }


    private void readCsvFileUnivIntro() {
        schoolList2 = readCsvUnivIntro("/data/data/com.example.xueshang/files/univIntro.csv");
    }

    private ArrayList<Introduction> readCsvUnivIntro(String path) {
        ArrayList<Introduction> readerArr = new ArrayList<>();
        File file = new File(path);
        FileInputStream fileInputStream;
        Scanner in;
        try {
            fileInputStream = new FileInputStream(file);
            in = new Scanner(fileInputStream, "UTF-8");
            while (in.hasNextLine()) {
                String[] lines = in.nextLine().split(",");
                Introduction introduction = new Introduction(lines[0], lines[1]);
                introduction.save();
                readerArr.add(introduction);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return readerArr;
    }*/
}
