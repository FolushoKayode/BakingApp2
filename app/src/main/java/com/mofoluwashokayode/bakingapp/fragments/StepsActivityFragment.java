package com.mofoluwashokayode.bakingapp.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import com.mofoluwashokayode.bakingapp.R;
import com.mofoluwashokayode.bakingapp.StepsDetailsActivity;
import com.mofoluwashokayode.bakingapp.adapters.IngredientsAdapter;
import com.mofoluwashokayode.bakingapp.adapters.StepsAdapter;
import com.mofoluwashokayode.bakingapp.pojo.Steps;

import static com.mofoluwashokayode.bakingapp.MainActivity.isTablet;
import static com.mofoluwashokayode.bakingapp.fragments.MainActivityFragment.bakes;

/**
 * A placeholder fragment containing a simple view.
 */
public class StepsActivityFragment extends Fragment implements StepsAdapter.ListItemClickListener {

    public static ArrayList<Steps> steps = new ArrayList<>();
    private RecyclerView stepsRecyclerView;
    private RecyclerView ingredientRecyclerView;
    private StepsAdapter stepsAdapter;
    private IngredientsAdapter ingredientsAdapter;
    private int index = 0;


    public StepsActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_steps, container, false);


        stepsRecyclerView = view.findViewById(R.id.stepslist);
        ingredientRecyclerView = view.findViewById(R.id.ingredients_list);
        stepsRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        ingredientRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        index = getActivity().getIntent().getExtras().getInt("item");
        getActivity().setTitle(bakes.get(index).getName());
        steps = bakes.get(index).getSteps();
        stepsAdapter = new StepsAdapter(this, steps);
        ingredientsAdapter = new IngredientsAdapter(bakes.get(index).getIngredients());
        stepsRecyclerView.setAdapter(stepsAdapter);
        ingredientRecyclerView.setAdapter(ingredientsAdapter);

        return view;
    }

    @Override
    public void onListItemClick(int clickedItemIndex) {
        if (!isTablet) {
            Intent intent = new Intent(getActivity(), StepsDetailsActivity.class);
            intent.putExtra("item", clickedItemIndex);
            startActivity(intent);
        } else {
            FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
            StepsDetailsActivityFragment stepsDetailsFragment = new StepsDetailsActivityFragment();
            stepsDetailsFragment.index = clickedItemIndex;
            fragmentManager.beginTransaction()
                    .replace(R.id.stepsdetailsframe, stepsDetailsFragment)
                    .commit();
        }
    }

}
