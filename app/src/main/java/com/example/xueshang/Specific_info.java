package com.example.xueshang;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

import org.litepal.crud.DataSupport;

import java.util.List;

public class Specific_info extends AppCompatActivity {

    private Level_3 level_3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_specific_info);

        TextView Specific_info_title  = (TextView) findViewById(R.id.specific_info_title);
        TextView Specific_info_time  = (TextView) findViewById(R.id.specific_info_time);
        TextView Specific_info_author  = (TextView) findViewById(R.id.specific_info_author);
        TextView Specific_info_littleTitle  = (TextView) findViewById(R.id.specific_info_littleTitle);
        TextView Specific_info_text  = (TextView) findViewById(R.id.specific_info_text);
        Specific_info_text.setMovementMethod(ScrollingMovementMethod.getInstance());

        Intent intent = getIntent();
        String data = intent.getStringExtra("extra_data");
        L3_obj(data);

        Specific_info_title.setText(level_3.getTitle_3());
        Specific_info_time.setText(level_3.getTime());
        Specific_info_author.setText(level_3.getAuthor());
        if (level_3.getFlag() == 1) {
            String[] littleTitlelines = level_3.getQu().split(";");
            String littleTitleStr = "";
            for (int i = 0; i < littleTitlelines.length; i++) {
                littleTitleStr += littleTitlelines[i];
                littleTitleStr += "\n";
            }
            Specific_info_littleTitle.setText(littleTitleStr);
        }
        else {
            Specific_info_littleTitle.setText("无小标题");
        }
        String[] textlines = level_3.getText().split(";");
        String textStr = "";
        for (int i = 0; i < textlines.length; i++) {
            textStr += textlines[i];
            textStr += "\n";
        }
        Specific_info_text.setText(textStr);
    }

    private void L3_obj(String string) {
        List<Level_3> level_3s = DataSupport.where("title_3 = ?", string)
                .find(Level_3.class);
        level_3 =  level_3s.get(0);
    }
}
