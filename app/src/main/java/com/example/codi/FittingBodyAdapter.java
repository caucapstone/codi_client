package com.example.codi;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class FittingBodyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private ArrayList<Integer> itemList;

    public FittingBodyAdapter(ArrayList<Integer> itemList) {
        this.itemList = itemList;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        // context 와 parent.getContext() 는 같다.
        View view = null;
        Context context = parent.getContext();
        LayoutInflater inflater = (LayoutInflater) parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(R.layout.fitting_bodyitem, parent, false);
        ViewHolder body = new ViewHolder(view);
        return body;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        int item = itemList.get(position);

        final ViewHolder itemColtroller = (ViewHolder) holder;
        itemColtroller.imageView.setBackgroundResource(item);
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    private static class ViewHolder extends RecyclerView.ViewHolder {

        public ImageView imageView;

        public ViewHolder(View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.Body_image);
        }
    }
}
