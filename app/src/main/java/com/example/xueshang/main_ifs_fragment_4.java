package com.example.xueshang;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by asus on 2019/3/19.
 */

public class main_ifs_fragment_4 extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.main_fragment_4, container, false);

        Button button_test = (Button) view.findViewById(R.id.main_fragment_4_test_button);
        Button button_professor = (Button) view.findViewById(R.id.main_fragment_4_professor_button);

        button_test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("https://www.xinli001.com/ceshi/838"));
                startActivity(intent);


                //Intent univ_intent = new Intent(getActivity(), CharacterTest.class);
                //startActivity(univ_intent);
            }
        });
        button_professor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent maj_intent = new Intent(getActivity(), Chat.class);
                startActivity(maj_intent);
            }
        });

        return view;
    }
}
