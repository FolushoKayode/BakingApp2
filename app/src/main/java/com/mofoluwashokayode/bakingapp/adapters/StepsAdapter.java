package com.mofoluwashokayode.bakingapp.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import java.util.ArrayList;

import com.mofoluwashokayode.bakingapp.R;
import com.mofoluwashokayode.bakingapp.pojo.Steps;

public class StepsAdapter extends RecyclerView.Adapter<StepsAdapter.StepsViewHolder> {

    final private ListItemClickListener mOnClickListener;
    final private ArrayList<Steps> steps;

    public StepsAdapter(ListItemClickListener listener, ArrayList<Steps> steps) {
        mOnClickListener = listener;
        this.steps = steps;
    }


    @Override
    public StepsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        int layoutIdForListItem = R.layout.steps_item;

        LayoutInflater inflater = LayoutInflater.from(context);
        boolean shouldAttachToParentImmediately = false;

        View view = inflater.inflate(layoutIdForListItem, parent, shouldAttachToParentImmediately);
        StepsViewHolder viewHolder = new StepsViewHolder(view);

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(StepsViewHolder holder, int position) {

        holder.onBind(position);

    }

    @Override
    public int getItemCount() {
        return steps.size();
    }

    public interface ListItemClickListener {
        void onListItemClick(int clickedItemIndex);
    }


    class StepsViewHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener {

        TextView short_description;


        public StepsViewHolder(View itemView) {
            super(itemView);

            short_description = itemView.findViewById(R.id.short_desc);
            itemView.setOnClickListener(this);
        }

        void onBind(int position) {
            if (!steps.isEmpty()) {
                short_description.setText(steps.get(position).getShortDescription());

            }
        }

        @Override
        public void onClick(View v) {
            int clickedPosition = getAdapterPosition();
            mOnClickListener.onListItemClick(clickedPosition);
        }
    }

}
