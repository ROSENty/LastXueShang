package com.example.xueshang;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import org.litepal.crud.DataSupport;

import java.util.ArrayList;
import java.util.List;

public class ProfessionQuery extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    private Spinner spinner1, spinner2, spinner3;
    private TextView textView;
    private List<String> categoryList = new ArrayList<String>();
    private List<String> majorList = new ArrayList<String>();
    private String content;
    private ArrayAdapter<String> categoryAdapter;
    private ArrayAdapter<String> majorAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profession_query);

        spinner1 = (Spinner) findViewById(R.id.majQuery_spinner1);
        spinner2 = (Spinner) findViewById(R.id.majQuery_spinner2);
        spinner3 = (Spinner) findViewById(R.id.majQuery_spinner3);

        textView = (TextView) findViewById(R.id.majQuery_text);
        textView.setMovementMethod(ScrollingMovementMethod.getInstance());

        spinner1.setOnItemSelectedListener(this);
        spinner2.setOnItemSelectedListener(this);
        spinner3.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        content = parent.getItemAtPosition(position).toString();
        switch (parent.getId()) {
            case R.id.majQuery_spinner1:
                categoryList.clear();
                categoryList = loadCategory(content);

                categoryAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, categoryList);
                spinner2.setAdapter(categoryAdapter);
                break;

            case R.id.majQuery_spinner2:
                majorList.clear();
                majorList = loadMajor(content);

                majorAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, majorList);
                spinner3.setAdapter(majorAdapter);
                break;

            case R.id.majQuery_spinner3:
                String str = query(content);
                textView.setText(str);

                String[] lines = str.split(";");
                String string = "";
                //textView.setText(str[0]);
                for (int i = 0; i < lines.length; i++) {
                    string += lines[i];
                    string += "\n";
                }
                textView.setText(string);
                break;

            default:
                break;
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
    }

    private String query(String string) {
        List<Major> introductions = DataSupport.where("maj_major = ?", string)
                .find(Major.class);
        String str = introductions.get(0).getMaj_intro();
        return str;
    }

    public List<String> loadCategory(String content) {
        List<Category> categories = DataSupport.where("cat_subject = ?", content)
                .find(Category.class);
        List<String> cats = new ArrayList<String>();
        for (Category category : categories) {
            cats.add(category.getCat_catetory());
        }
        return cats;
    }

    public List<String> loadMajor(String content) {
        List<Major> majors = DataSupport.where("maj_subect = ?", content)
                .find(Major.class);
        List<String> names = new ArrayList<String>();

        List<String> majs = new ArrayList<String>();
        for (Major major : majors) {
            majs.add(major.getMaj_major());
        }
        return majs;
    }
}
