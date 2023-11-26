package com.example.quotes.adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.quotes.databinding.FavLayoutBinding;
import com.example.quotes.utils.FavsData;

import java.util.Collections;
import java.util.List;

public class favsAdapter extends RecyclerView.Adapter<favsAdapter.favViewHolder> {
    List<FavsData> list;

    public favsAdapter(List<FavsData> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public favsAdapter.favViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new favViewHolder(FavLayoutBinding.inflate(
                LayoutInflater.from(parent.getContext()),
                parent,
                false
        ));
    }

    @Override
    public void onBindViewHolder(@NonNull favViewHolder holder, int position) {
        holder.setData(list.get(position).d);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
    class favViewHolder extends RecyclerView.ViewHolder{
        FavLayoutBinding binding;
        favViewHolder(FavLayoutBinding binding){
            super(binding.getRoot());
            this.binding = binding;
        }
        void setData(String d){
            binding.fav.setText(d);
        }
    }
}
