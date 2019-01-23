package com.mooracle.smellslikecooking;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class NewListAdapter extends RecyclerView.Adapter<NewListAdapter.NewListViewHolder> {
    //instantiate the OnSelectedRecipeInterface to be used as listener:
    private final ListFragment.OnRecipeSelectedInterface mListener;

    public NewListAdapter(ListFragment.OnRecipeSelectedInterface listener) {
        mListener = listener;
    }

    @NonNull
    @Override
    public NewListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //return view form the list_item layout inflated into the list adapter
        return new NewListViewHolder(LayoutInflater.from(parent.getContext())
        .inflate(R.layout.list_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull NewListViewHolder holder, int position) {
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

    public class NewListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        //field for all of our views:
        TextView mTextView;
        ImageView mImageView;

        //field for our index in onCLick listener
        private int mIndex;

        public NewListViewHolder(@NonNull View itemView) {
            super(itemView);
            mTextView = itemView.findViewById(R.id.itemText);
            mImageView = itemView.findViewById(R.id.itemImage);

            //set the onClick listeners for each of our views in the list to be clickable:
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            //set the action onClick
            mListener.onListRecipeSelected(mIndex);
        }

        public void setIndex(int position) {
            mIndex = position;
        }
    }
}
