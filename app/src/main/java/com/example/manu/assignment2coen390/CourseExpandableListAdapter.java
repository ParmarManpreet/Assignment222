package com.example.manu.assignment2coen390;

import android.content.Context;
import android.view.ContextMenu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.TextView;

import java.util.ArrayList;


public class CourseExpandableListAdapter extends BaseExpandableListAdapter {

    private Context context;
    private ArrayList<Course> courseList;
    private boolean getLetterGrade = false;
    // Constructor

    public void toggleGradeFormat(){
        getLetterGrade = !getLetterGrade;
    }

    public CourseExpandableListAdapter(Context context, ArrayList<Course> courseList) {
        this.context = context;
        this.courseList = courseList;
    }

    @Override
    public int getGroupCount() {
        return courseList.size();
    }

    @Override
    public int getChildrenCount(int i) {
        return courseList.get(i).getAssignments().size();
    }

    @Override
    public Object getGroup(int i) {
        return courseList.get(i);
    }

    @Override
    public Object getChild(int i, int i1) {
        return courseList.get(i).getAssignments().get(i1);
    }

    @Override
    public long getGroupId(int ID) {
        return ID;
    }

    @Override
    public long getChildId(int i, int childID) {
        return childID;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int i, boolean b, View courseView, ViewGroup parent) {
        if(courseView == null){
            courseView = View.inflate(context,R.layout.course_row,null);
        }

        // Add course title and course average grade textviews
        TextView courseTitle = (TextView) courseView.findViewById(R.id.courseTitle);
        courseTitle.setText(courseList.get(i).getCourseTitle());

        TextView courseAverage = (TextView) courseView.findViewById(R.id.courseAverage);
        courseAverage.setText("Average: " + courseList.get(i).getAverage());

        return courseView;
    }

    @Override
    public View getChildView(int courseIndex, int assignmentIndex, boolean b, View assignmentView, ViewGroup parent) {
        if(assignmentView == null){
            assignmentView = View.inflate(context,R.layout.assignment_row,null);
        }

        // Add Assignment TextView
        TextView assignmentText = (TextView) assignmentView.findViewById(R.id.assignmentText);
        assignmentText.setText(courseList.get(courseIndex).getAssignments().get(assignmentIndex).getAssignmentTitle()
        + " " + courseList.get(courseIndex).getAssignments().get(assignmentIndex).getAssignmentGrade(getLetterGrade) );

        return assignmentView;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return false;
    }
}
