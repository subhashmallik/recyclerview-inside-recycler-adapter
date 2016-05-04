/*
 * Copyright (c) 2016. Subhash Kumar
 */

package zaps.com.reycycleheader;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by subh on 5/4/2016.
 */
public class InnerAdapter extends RecyclerView.Adapter<InnerAdapter.HolderClass> {

    ArrayList<String> item;

    public InnerAdapter(ArrayList<String> item) {
        this.item = item;
    }

    @Override
    public InnerAdapter.HolderClass onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.inneritems, parent, false);
        return new HolderClass(view);
    }

    @Override
    public void onBindViewHolder(final InnerAdapter.HolderClass holder, final int position) {
        holder.textView.setText(item.get(position));
        holder.textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), item.get(position), Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return item.size();
    }

    public class HolderClass extends RecyclerView.ViewHolder {

        protected TextView textView;

        public HolderClass(View itemView) {
            super(itemView);

            textView = (TextView) itemView.findViewById(R.id.item);

        }
    }
}
