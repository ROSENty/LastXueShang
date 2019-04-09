package com.example.xueshang;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by asus on 2019/3/13.
 */

public class PolicyInfoAdapter extends RecyclerView.Adapter<PolicyInfoAdapter.ViewHolder>{

    private List<Level_2> mLevel_2List;
    private Context mContext;
    private int[] colorId = {R.color.color_1,
            R.color.color_2,R.color.color_3,R.color.color_4,
            R.color.color_5,R.color.color_6,R.color.color_7,
            R.color.color_8,R.color.color_9,R.color.color_10};

    static class ViewHolder extends RecyclerView.ViewHolder {

        TextView info;
        CardView item_cardview;
        View infoView;

        public ViewHolder(View view) {
            super(view);
            infoView = view;
            info = (TextView) view.findViewById(R.id.info_text);
            item_cardview = (CardView) view.findViewById(R.id.item_cardview);
        }
    }

    public PolicyInfoAdapter(List<Level_2> level_2ListList, Context context ) {
        this.mContext = context;
        mLevel_2List = level_2ListList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.info_item, parent, false);
        final ViewHolder holder = new ViewHolder(view);
        holder.infoView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                Level_2 level_2 = mLevel_2List.get(position);

                Intent intentPolicyInfo = new Intent(mContext, Specific_info.class);
                intentPolicyInfo.putExtra("extra_data", level_2.getTitle_2());
                mContext.startActivity(intentPolicyInfo);
            }
        });

        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Level_2 level_2 = mLevel_2List.get(position);
        holder.info.setText(level_2.getTitle_2());
        int i = (int)(0 + Math.random() * (9 - 1 + 1));
        int id = colorId[i];
        holder.item_cardview.setCardBackgroundColor(mContext.getResources().getColor(id));
    }

    @Override
    public int getItemCount() {
        return mLevel_2List.size();
    }
}
