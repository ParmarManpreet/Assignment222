package com.example.manu.assignment2coen390;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Interpolator;
import android.widget.ArrayAdapter;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Random;

public class GradeActivity extends AppCompatActivity {

    protected static final String TAG = "Grade Activity";
    private ArrayList<Course> courses;
    private boolean isLetterGrade = false;
    private ExpandableListAdapter courseAdapter;
    private ExpandableListView courseListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grade);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent activityThatCalled = getIntent();
        String previousActivity = activityThatCalled.getExtras().getString("CallingActivity"); // Get key-value pair from last intent
        Log.d(TAG,"The calling activity was " + previousActivity);

        // Generate ListView
        courses = generateCourses();
        courseAdapter = new CourseExpandableListAdapter(this,courses);
        courseListView = (ExpandableListView) findViewById(R.id.courseExpandableListView);
        courseListView.setAdapter(courseAdapter);

        // Expand all courses by default
        for(int i = 0; i < courseAdapter.getGroupCount(); i++)
            courseListView.expandGroup(i);

    }

    private ArrayList<Course> generateCourses(){

        Course.resetCourseID(); // Reset the course counters for the new list of courses

        ArrayList<Course> tempCourseList = new ArrayList<Course>();

        // Generate between 3 and 4 courses
        Random rnd = new Random();
        int courseNo = rnd.nextInt(2) + 3;

        for (int i = 0 ; i < courseNo; i++)
            tempCourseList.add(Course.generateRandomCourse());

        return tempCourseList;
    }

    private void changeGradesFormat(CourseExpandableListAdapter listAdapter, ExpandableListView listView){
        listAdapter.toggleGradeFormat(); // toggle letter-number grades
        listAdapter.notifyDataSetChanged(); // Refresh the view so that we see the changes
        //listView.refreshDrawableState();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu to add the overflow icon to select grade format changes
        getMenuInflater().inflate(R.menu.toolbar_actions, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Take appropriate action for each action item click
        switch (item.getItemId()) {
            case R.id.changeGradeDisplay:
                changeGradesFormat( (CourseExpandableListAdapter) courseAdapter, courseListView);
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}





