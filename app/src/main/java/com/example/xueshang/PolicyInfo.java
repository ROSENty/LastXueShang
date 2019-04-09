package com.example.xueshang;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;

import org.litepal.crud.DataSupport;

import java.util.ArrayList;
import java.util.List;


public class PolicyInfo extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    private String content;
    private Spinner spinner;
    private List<Level_2> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_policy_info);

        spinner = (Spinner) findViewById(R.id.info_spinner);
        spinner.setOnItemSelectedListener(this);

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        content = parent.getItemAtPosition(position).toString();
        switch (parent.getId()) {
            case R.id.info_spinner:

                query(content);
                break;
            default:
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
    }

    private void query(String string) {
        List<Level_2> level_2s = DataSupport.where("PR_2 = ?", string)
                .find(Level_2.class);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.info_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        PolicyInfoAdapter adapter = new PolicyInfoAdapter(level_2s, PolicyInfo.this);
        recyclerView.setAdapter(adapter);
    }
}

