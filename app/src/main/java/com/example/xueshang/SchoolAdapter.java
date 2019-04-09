package com.example.xueshang;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;


public class SchoolAdapter extends RecyclerView.Adapter<SchoolAdapter.ViewHolder>{
    private List<School> mSchoolList;

    static class ViewHolder extends RecyclerView.ViewHolder {//内部类
        TextView name, highest, lowest, type, year;
        public ViewHolder(View view) {
            super(view);
            name = (TextView) view.findViewById(R.id.item_name);
            highest = (TextView) view.findViewById(R.id.item_highest);
            lowest  = (TextView) view.findViewById(R.id.item_lowest);
            type = (TextView) view.findViewById(R.id.item_type);
            year = (TextView) view.findViewById(R.id.item_year);
        }
    }

    public SchoolAdapter(List<School> schoolList) {
        mSchoolList = schoolList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.school_item, parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        School school = mSchoolList.get(position);
        holder.type.setText(school.getType());
        holder.name.setText(school.getSchool());
        holder.lowest.setText(school.getLowest()+"");
        holder.highest.setText(school.getHighest()+"");
        holder.year.setText(school.getTag() + "");
    }

    @Override
    public int getItemCount() {
        return mSchoolList.size();
    }
}
