package com.example.xueshang;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by asus on 2019/2/26.
 */

public class ProfessionAdapter extends RecyclerView.Adapter<ProfessionAdapter.ViewHolder>{
    private List<Profession> mProfessionList;

    static class ViewHolder extends RecyclerView.ViewHolder {//内部类
        TextView subject, category ,name;
        public ViewHolder(View view) {
            super(view);
            subject = (TextView) view.findViewById(R.id.profession_item_subject);
            category = (TextView) view.findViewById(R.id.profession_item_category);
            name = (TextView) view.findViewById(R.id.profession_item_name);
        }
    }

    public ProfessionAdapter(List<Profession> professionList) {
        mProfessionList = professionList;
    }

    @Override
    public ProfessionAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.school_item, parent, false);
        ProfessionAdapter.ViewHolder holder = new ProfessionAdapter.ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ProfessionAdapter.ViewHolder holder, int position) {
        Profession profession = mProfessionList.get(position);
        holder.subject.setText(profession.getSubject());
        holder.category.setText(profession.getCategory());
        holder.name.setText(profession.getName());
    }

    @Override
    public int getItemCount() {
        return mProfessionList.size();
    }
}
