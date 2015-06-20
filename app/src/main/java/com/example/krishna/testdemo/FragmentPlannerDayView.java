package com.example.krishna.testdemo;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class FragmentPlannerDayView extends Fragment {

    Context context;
    TextView tvPlannerDate;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_planner_day_view,
                container, false);

        context = rootView.getContext();

        tvPlannerDate = (TextView) rootView.findViewById(R.id.tv_date);

        Bundle bundle = this.getArguments();

        int day = bundle.getInt("Day");
        int month = bundle.getInt("Month");
        int year = bundle.getInt("Year");

        String date = day + "-" + month + "-" + year;
        tvPlannerDate.setText(date);

        return rootView;
    }
}