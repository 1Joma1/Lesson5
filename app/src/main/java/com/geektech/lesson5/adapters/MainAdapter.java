package com.geektech.lesson5.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.geektech.lesson5.R;
import com.geektech.lesson5.interfaces.IOnTaskListener;
import com.geektech.lesson5.models.Task;
import com.geektech.lesson5.viewHolders.MainViewHolder;

import java.util.ArrayList;

public class MainAdapter extends RecyclerView.Adapter<MainViewHolder> {

    private ArrayList<Task> data;
    private IOnTaskListener taskListener;

    public MainAdapter(ArrayList<Task> data, IOnTaskListener listener) {
        this.data = data;
        taskListener = listener;
    }

    @NonNull
    @Override
    public MainViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.viewholder_main, viewGroup, false);
        MainViewHolder mainViewHolder = new MainViewHolder(view, taskListener);
        return mainViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MainViewHolder mainViewHolder, int i) {
        mainViewHolder.onBind(data.get(i % data.size()));
    }

    @Override
    public int getItemCount() {
        return 1000;
    }
}
