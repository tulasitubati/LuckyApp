package com.example.myapplication.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.databinding.BindingAdapter;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.databinding.ItemLayoutBinding;
import com.example.myapplication.model.Row;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.RecyclerViewHolder> {
    private List<Row> rowList;


    public RecyclerAdapter() {
        rowList = new ArrayList<>();
    }
    public void addRowList(List<Row> rows){
        this.rowList=rows;


    }



    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemLayoutBinding binding= DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_layout,parent,false);

        return new RecyclerViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {
        holder.binding.setModel(rowList.get(position));

    }



    @Override
    public int getItemCount() {
        return rowList.size();
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder{

ItemLayoutBinding binding;
        public RecyclerViewHolder( ItemLayoutBinding binding) {
            super(binding.getRoot());
            this.binding=binding;
        }
    }

    @BindingAdapter({"android:src"})
    public static void setImageViewResource(ImageView imageView, String imageUri ) {
        Picasso.get().load(imageUri).into(imageView);
    }
}
