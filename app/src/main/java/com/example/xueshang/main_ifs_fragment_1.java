package com.example.xueshang;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by asus on 2019/3/19.
 */

public class main_ifs_fragment_1 extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.main_fragment_1, container, false);//绑定布局文件

        Button button_news = (Button) view.findViewById(R.id.main_fragment_1_news_button);
        button_news.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent news_intent = new Intent(getActivity(), PolicyInfo.class);
                startActivity(news_intent);
            }
        });

        return view;
    }
}
