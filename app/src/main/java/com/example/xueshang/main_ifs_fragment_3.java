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

public class main_ifs_fragment_3 extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.main_fragment_3, container, false);

        Button button_fraction = (Button) view.findViewById(R.id.main_fragment_3_fraction_button);
        Button button_univChoose = (Button) view.findViewById(R.id.main_fragment_3_univChoose_button);

        button_fraction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent univ_intent = new Intent(getActivity(), FractionQuery.class);
                startActivity(univ_intent);
            }
        });
        button_univChoose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent maj_intent = new Intent(getActivity(), CollegeChoosing.class);
                startActivity(maj_intent);
            }
        });

        return view;
    }
}
