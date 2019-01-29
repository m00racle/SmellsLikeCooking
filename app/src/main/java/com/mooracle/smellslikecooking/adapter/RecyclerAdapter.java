package com.mooracle.smellslikecooking.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.mooracle.smellslikecooking.R;
import com.mooracle.smellslikecooking.model.Recipes;

public abstract class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.RecyclerViewHolder> {

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //return view form the list_item layout inflated into the list adapter
        return new RecyclerViewHolder(LayoutInflater.from(parent.getContext())
        .inflate(getLayoutId(), parent, false));
    }

    protected abstract int getLayoutId();

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {
        // bind the views to POJO object:
        holder.mImageView.setImageResource(Recipes.resourceIds[position]);
        holder.mTextView.setText(Recipes.names[position]);

        //send the position as index for the onClick listener:
        holder.setIndex(position);
    }

    @Override
    public int getItemCount() {
        return Recipes.names.length;
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        //field for all of our views:
        TextView mTextView;
        ImageView mImageView;

        //field for our index in onCLick listener
        private int index;

        RecyclerViewHolder(@NonNull View itemView) {
            super(itemView);
            mTextView = itemView.findViewById(R.id.itemText);
            mImageView = itemView.findViewById(R.id.itemImage);

            //set the onClick listeners for each of our views in the list to be clickable:
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            //set the action onClick
            onRecipeSelected(index);
        }

        void setIndex(int position) {
            index = position;
        }
    }

    protected abstract void onRecipeSelected(int index);

}
