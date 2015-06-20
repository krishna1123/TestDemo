package com.example.krishna.testdemo;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.widget.CalendarView;

import com.nostra13.universalimageloader.core.ImageLoader;

import java.text.SimpleDateFormat;
import java.util.Calendar;


public class MainTestActivity extends ActionBarActivity {

    private CalendarView cvSelectPlannerDate;
    private FragmentPlannerDayView fragmentPlannerDayView;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.samp);

        ImageLoader imageLoader=ImageLoader.getInstance();
        cvSelectPlannerDate = (CalendarView) findViewById(R.id.cvSelectPlannerDate);

        fragmentPlannerDayView = new FragmentPlannerDayView();

        // get current date
        Calendar date = Calendar.getInstance();
        // for date format
        SimpleDateFormat sdf = new SimpleDateFormat("yy-MM-dd");
        // set string to format current date
        String curDate = sdf.format(date.getTime());
        // print date in log cat
        Log.d("CUR_DATE", curDate);

        // get date changed
        cvSelectPlannerDate.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            public void onSelectedDayChange(CalendarView view, int year,
                                            int month, int day) {
                // add one because month starts at 0
                month = month + 1;
                // output to logcat
                String newDate = year + "-" + month + "-" + day;
                Log.d("NEW_DATE", newDate);

                send(day, month, year);
            }
        });
    }

    public void send(int day, int month, int year) {
        Bundle date = new Bundle();
        date.putInt("Day", day);
        date.putInt("Month", month);
        date.putInt("Year", year);

        FragmentPlannerDayView sendToFragment = new FragmentPlannerDayView();
        sendToFragment.setArguments(date);

        FragmentManager fragmentManager = getFragmentManager();
        FragmentTransaction fragmentTrans = fragmentManager.beginTransaction();
        fragmentTrans.replace(R.id.content_frame, sendToFragment);
        fragmentTrans.addToBackStack(FragmentPlannerDayView.class.getName());
        fragmentTrans.commit();
    }
}
