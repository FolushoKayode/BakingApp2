package com.mofoluwashokayode.bakingapp.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mofoluwashokayode.bakingapp.R;
import com.mofoluwashokayode.bakingapp.pojo.Recipe;


import java.util.ArrayList;

public class RecipeAdapter extends RecyclerView.Adapter<RecipeAdapter.RecipeViewHolder> {

    final private ListItemClickListener mOnClickListener;
    final private ArrayList<Recipe> recipe;

    public RecipeAdapter(ListItemClickListener listener, ArrayList<Recipe> recipe) {
        mOnClickListener = listener;
        this.recipe = recipe;
    }


    @Override
    public RecipeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        int layoutIdForListItem = R.layout.card_item;

        LayoutInflater inflater = LayoutInflater.from(context);
        boolean shouldAttachToParentImmediately = false;

        View view = inflater.inflate(layoutIdForListItem, parent, shouldAttachToParentImmediately);
        RecipeViewHolder viewHolder = new RecipeViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecipeViewHolder holder, int position) {

        holder.onBind(position);

    }

    @Override
    public int getItemCount() {
        return recipe.size();
    }

    public interface ListItemClickListener {
        void onListItemClick(int clickedItemIndex);
    }


    class RecipeViewHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener {


        TextView name;


        public RecipeViewHolder(View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.recipes_name);
            itemView.setOnClickListener(this);
        }

        void onBind(int position) {
            if (!recipe.isEmpty()) {

                name.setText(recipe.get(position).getName());
            }
        }

        @Override
        public void onClick(View v) {
            int clickedPosition = getAdapterPosition();
            mOnClickListener.onListItemClick(clickedPosition);
        }
    }

}
