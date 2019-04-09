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

public class main_ifs_fragment_2 extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.main_fragment_2, container, false);

        Button button_univ = (Button) view.findViewById(R.id.main_fragment_2_univ_button);
        Button button_maj = (Button) view.findViewById(R.id.main_fragment_2_maj_button);

        button_univ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent univ_intent = new Intent(getActivity(), College.class);
                startActivity(univ_intent);
            }
        });
        button_maj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent maj_intent = new Intent(getActivity(), ProfessionQuery.class);
                startActivity(maj_intent);
            }
        });

        return view;
    }
}
