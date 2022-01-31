package com.example.recyclerviewpinterestcells_16_injava.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recyclerviewpinterestcells_16_injava.R;
import com.example.recyclerviewpinterestcells_16_injava.model.Member;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private List<Member> members;
    public CustomAdapter(Context context,List<Member> members){
        this.context = context;
        this.members = members;
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_custom_layout,viewGroup,false);
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        Member member = members.get(position);

        if (holder instanceof CustomViewHolder) {
           if (position % 3 == 0) {
               ((CustomViewHolder)holder).item_image.setImageResource(R.drawable.image1);
           }else if (position % 4 == 0) {
               ((CustomViewHolder)holder).item_image.setImageResource(R.drawable.image2);
           }else if (position % 5 == 0) {
               ((CustomViewHolder)holder).item_image.setImageResource(R.drawable.image4);
           }
           else {
               ((CustomViewHolder)holder).item_image.setImageResource(R.drawable.image3);
           }
        }
    }

    @Override
    public int getItemCount() {
        return members.size();
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder{
        public View view;
        public ImageView item_image;

        public CustomViewHolder(View itemView) {
            super(itemView);
            view = itemView;
            item_image = view.findViewById(R.id.item_image);
        }
    }
}