package com.example.xueshang;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.litepal.crud.DataSupport;

import java.util.List;

public class CollegeChoosing extends BaseActivity {

    private EditText college_choosing_editText;
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_college_choosing);

        Button button_query = (Button) findViewById(R.id.college_choosing_query);
        college_choosing_editText = (EditText) findViewById(R.id.college_choosing_edit_text);

        button_query.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String inputText = college_choosing_editText.getText().toString();
                query(inputText);
            }
        });
    }

    private void query(String string) {
        //List<School> schools = DataSupport.where("school = ?", string)
          //      .find(School.class);
        List<School> schools = DataSupport.where("school like ?", "%" + string + "%" )
                .find(School.class);//模糊查询

        /*for (School school: schools) {//打印测试
            Log.d(TAG, "大学名字是 " + school.getSchool() +"");
            Log.d(TAG, "平均分数线是  " + school.getMedian() + "");
            Log.d(TAG, "是  " + school.getType() + "");
        }*/
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.college_choosing_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        SchoolAdapter adapter = new SchoolAdapter(schools);
        recyclerView.setAdapter(adapter);
    }
}
