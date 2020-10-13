package com.chayan_27.cricketscorer;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ScoreAdapter extends RecyclerView.Adapter<ScoreAdapter.ScoreModel> {

    List<String> list;
    Context context;

    public ScoreAdapter(List<String> list,Context context) {
        this.list = list;
        this.context=context;
    }

    @NonNull
    @Override
    public ScoreModel onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.scorecard, parent, false);

        return new ScoreModel(view);
    }


    @Override
    public void onBindViewHolder(@NonNull ScoreModel holder, int position) {
          holder.textView.setText(list.get(position));
          if(list.get(position).contains("not")){
              holder.textView.setTextColor(Color.RED);
          }else{
              holder.textView.setTextColor(Color.parseColor("#EFC484"));
          }
    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ScoreModel extends RecyclerView.ViewHolder{
        TextView textView;
        public ScoreModel(@NonNull View itemView) {
            super(itemView);
            textView=(TextView)itemView.findViewById(R.id.result);
        }
    }
}
