/*
 * Copyright (c) 2016. Subhash Kumar
 */

package zaps.com.reycycleheader;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by subh on 5/4/2016.
 */
public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {

    HashMap<String, ArrayList<String>> arrayListHashMap;
    List<String> indexes;

    public MainAdapter(HashMap<String, ArrayList<String>> arrayListHashMap) {
        this.arrayListHashMap = arrayListHashMap;
        indexes = new ArrayList<>(arrayListHashMap.keySet());
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.items, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.recyclerView.setAdapter(new InnerAdapter(arrayListHashMap.get(indexes.get(position))));
        holder.section.setText(indexes.get(position));
        holder.viewall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), indexes.get(position), Toast.LENGTH_SHORT).show();
            }
        });


    }

    @Override
    public int getItemCount() {
        return arrayListHashMap.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        protected RecyclerView recyclerView;
        private TextView section;
        private TextView viewall;

        public ViewHolder(View itemView) {
            super(itemView);
            recyclerView = (RecyclerView) itemView.findViewById(R.id.list);
            recyclerView.setHasFixedSize(true);
            LinearLayoutManager layoutManager = new LinearLayoutManager(itemView.getContext());
            layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
            recyclerView.setLayoutManager(layoutManager);
            section = (TextView) itemView.findViewById(R.id.section);
            viewall = (TextView) itemView.findViewById(R.id.viewall);


        }
    }
}
