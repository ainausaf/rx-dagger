package com.example.myapplication.View;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.myapplication.Model.Example;
import com.example.myapplication.R;

import java.util.List;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ItemViewHolder> {

    private Context context;
    private List<Example> resList;

    public MainAdapter(Context context, List<Example> resList) {
       this.context = context;
       this.resList = resList;
    }

    public static class ItemViewHolder extends RecyclerView.ViewHolder{

        ImageView resImage;
        TextView resName;
        Button resLikeButton;

        public ItemViewHolder(@NonNull View itemView) {
            super(itemView);
            resImage = itemView.findViewById(R.id.resImage);
            resName = itemView.findViewById(R.id.resName);
            resLikeButton = itemView.findViewById(R.id.resButton);
        }
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.sample_adapter,viewGroup,false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder itemViewHolder, int i) {
        Example restaurantData = resList.get(i);

        itemViewHolder.resName.setText(restaurantData.getName());
        Glide.with(context).load(restaurantData.getCoverImgUrl()).placeholder(R.drawable.layout_placeholder)
                .error(R.drawable.layout_placeholder)
                .into(itemViewHolder.resImage);
    }



    @Override
    public int getItemCount() {
        if(resList!=null){
            return resList.size();
        }
        else{
            return 0;
        }
    }

    public void addAll(List<Example> resList){
        this.resList.addAll(resList);
        notifyDataSetChanged();
    }

}
