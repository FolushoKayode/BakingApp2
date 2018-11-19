package com.mofoluwashokayode.bakingapp.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import com.mofoluwashokayode.bakingapp.R;
import com.mofoluwashokayode.bakingapp.pojo.Ingredient;

public class IngredientsAdapter extends RecyclerView.Adapter<IngredientsAdapter.IngredientViewHolder> {

    final private ArrayList<Ingredient> ingredients;

    public IngredientsAdapter(ArrayList<Ingredient> ingredients) {

        this.ingredients = ingredients;
    }


    @Override
    public IngredientViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        int layoutIdForListItem = R.layout.ingredient_item;

        LayoutInflater inflater = LayoutInflater.from(context);
        boolean shouldAttachToParentImmediately = false;

        View view = inflater.inflate(layoutIdForListItem, parent, shouldAttachToParentImmediately);
        IngredientViewHolder viewHolder = new IngredientViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(IngredientViewHolder holder, int position) {

        holder.onBind(position);

    }

    @Override
    public int getItemCount() {
        return ingredients.size();
    }


    class IngredientViewHolder extends RecyclerView.ViewHolder {

        TextView ingredient;
        TextView quantity;
        TextView measure;

        public IngredientViewHolder(View itemView) {
            super(itemView);

            ingredient = itemView.findViewById(R.id.ingredient);
            quantity = itemView.findViewById(R.id.quantity);
            measure = itemView.findViewById(R.id.measure);

        }

        void onBind(int position) {
            if (!ingredients.isEmpty()) {

                ingredient.setText(ingredients.get(position).getIngredient());
                quantity.setText(String.valueOf(ingredients.get(position).getQuantity()));
                measure.setText(ingredients.get(position).getMeasure());
            }
        }


    }

}
