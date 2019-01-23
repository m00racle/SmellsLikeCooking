package com.mooracle.smellslikecooking;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**This class is used to represent the fragment_list layout.
 * Since this is a Fragment this class must extends Fragment class*/
public class ListFragment extends Fragment {
    //: create an interface to process when a recipe is selected:
    public interface OnRecipeSelectedInterface {
        //: create method to process when a recipe in the list is selected
        //since this is an interface we just need to make abstract method
        void onListRecipeSelected(int index);
    }

    //override onCreateView method
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        //: create new OnRecipeSelectedInterface object:
        OnRecipeSelectedInterface listener = (OnRecipeSelectedInterface) getActivity();

        View view = inflater.inflate(R.layout.fragment_list, container, false);

        //add the recycler view layout
        RecyclerView recyclerView = view.findViewById(R.id.listRecyclerView);

        //add the List Adapter object
        ListAdapter listAdapter = new ListAdapter(listener);

        //set the List Adapter to recycler view:
        recyclerView.setAdapter(listAdapter);

        //set the layout manager
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());

        //attach the layput manager to the recycler view
        recyclerView.setLayoutManager(layoutManager);
        return view;
    }

    public class ListAdapter extends RecyclerView.Adapter {

        private final OnRecipeSelectedInterface mListener;

        public ListAdapter(OnRecipeSelectedInterface listener) {
            mListener = listener;
        }



        @NonNull
        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
            return new ListViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
            //cast the list view holder into the holder and call the bind view method to pass the position:

            ((ListViewHolder) holder).mImageView.setImageResource(Recipes.resourceIds[position]);
            ((ListViewHolder) holder).mTextView.setText(Recipes.names[position]);
            ((ListViewHolder) holder).setIndex(position);
        }

        @Override
        public int getItemCount() {
            return Recipes.names.length;
        }

        private class ListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
            private int mIndex;
            TextView mTextView;
            ImageView mImageView;

            public ListViewHolder(@NonNull View itemView) {
                super(itemView);
                mImageView = itemView.findViewById(R.id.itemImage);
                mTextView = itemView.findViewById(R.id.itemText);

                //: fix the item view set on click listener constructor:
                itemView.setOnClickListener(this);
            }

            //give onClick listeners for mImageView and mTextView which by default non clickable.
            @Override
            public void onClick(View v) {
                mListener.onListRecipeSelected(mIndex);
            }

            // :set index that will be used in the onClick listener
            public void setIndex(int index){
                mIndex = index;
            }
        }
    }
}
