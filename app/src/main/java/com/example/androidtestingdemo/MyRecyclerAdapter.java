package com.example.androidtestingdemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyRecyclerAdapter extends RecyclerView.Adapter<MyRecyclerAdapter.ViewHolder> {

    private Context context;
    private List<ItemDataBean> data;

    public MyRecyclerAdapter(Context context, List<ItemDataBean> data) {
        this.context = context;
        this.data = data;
    }

    @NonNull
    @Override
    public MyRecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recycler_item_layout , parent ,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.title.setText(data.get(position).getName());
        holder.btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(context , "p -> " + position , Toast.LENGTH_SHORT).show();
                data.get(position).setChecked(true);
            }
        });
    }

    @Override
    public int getItemCount() {
        if(data != null && data.size() > 0){
            return data.size();
        }
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView title;
        private Button btn;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.title);
            btn = itemView.findViewById(R.id.btn);
        }
    }
}
