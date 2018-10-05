package com.example.manu.assignment2coen390;
import java.util.ArrayList;
import java.util.Random;
import java.util.jar.Pack200;



public class Course {
    private static int courseID = 0;            // static ID increments with every new Course created
    private String courseTitle;                 // name of the course
    private ArrayList<Assignment> assignments;  // List of assignments given in class
    private int average = 0;                    // Average grade held in course

    private Course(String title, ArrayList<Assignment> assns)
    {
        courseTitle = title;
        assignments = assns;
        courseID++;
    }

    /**
     *  Generate a random course
     * @return a Course populated with random assignments
     */
    static public Course generateRandomCourse()
    {
        Random rnd = new Random();
        int assignmentNo = rnd.nextInt(4) + 1; // rnd number bw 1 and 4
        ArrayList<Assignment> tempAssns = new ArrayList<Assignment>();

        // Reset the assignment ID counter and populate course with assignments
        Assignment.resetAssignmentID();
        for(int i=0; i < assignmentNo; i++)
            tempAssns.add(Assignment.generateRandomAssignment());

        return new Course("Course " + courseID, tempAssns);
    }

    static public void resetCourseID(){ courseID = 0;} // resets the ID for new set of courses

    //******GETTERS*****//
    public String getCourseTitle() {return courseTitle;}
    public ArrayList<Assignment> getAssignments() {return assignments;}

    public int getAverage() {

        int tempTotal = 0;
        // Get the grades from each assignment
        for (Assignment ass:assignments) {
            tempTotal += ass.getAssignmentGrade();
        }
        if(assignments.size() > 0)
        average = tempTotal/assignments.size();
        else
            average = 0 ;

        return average;
    }
}
