package com.example.manu.assignment2coen390;
import java.util.Random;
import java.util.StringTokenizer;

/**
 * Created by Manu on 2018-09-17.
 */

public class Assignment {
    private static int assID = 0;   // Static ID increments with every new assignment created
    private String assignmentTitle; // title of assignment
    private int assignmentGrade;    // grade of assignment

    //private constructor, increments ID
    private Assignment(String title, int grade)
    {
        assignmentTitle = title;
        assignmentGrade = grade;
        assID++;
    }

    /**
     *  Generates random assignment with randomized grade
     * @return new assignment instance with random values
     */
    static public Assignment generateRandomAssignment()
    {
        Random rnd = new Random();
        String tempTitle = "Assignment " + assID;
        int tempGrade = rnd.nextInt(100) + 1; // value bw 1 and 100

        return new Assignment(tempTitle,tempGrade);
    }

    static public void resetAssignmentID(){ assID = 0;} // resets the ID for new courses

    //*****GETTERS*****//
    public String getAssignmentTitle() {return assignmentTitle;}
    public int getAssignmentGrade() {return assignmentGrade;}

    // To get the assignment grade as a string
    public String getAssignmentGrade(boolean getLetterGrade) {

        if(getLetterGrade){
            // Convert number to letter
            if(assignmentGrade >= 90) return "A+";
            else if (assignmentGrade < 90 && assignmentGrade >= 85) return "A";
            else if (assignmentGrade < 85 && assignmentGrade >= 80) return "A-";
            else if (assignmentGrade < 80 && assignmentGrade >= 77) return "B+";
            else if (assignmentGrade < 77 && assignmentGrade >= 73) return "B";
            else if (assignmentGrade < 73 && assignmentGrade >= 70) return "B-";
            else if (assignmentGrade < 70 && assignmentGrade >= 67) return "C+";
            else if (assignmentGrade < 67 && assignmentGrade >= 63) return "C";
            else if (assignmentGrade < 63 && assignmentGrade >= 60) return "C-";
            else if (assignmentGrade < 60 && assignmentGrade >= 57) return "D+";
            else if (assignmentGrade < 57 && assignmentGrade >= 53) return "D";
            else if (assignmentGrade < 53 && assignmentGrade >= 50) return "D-";
            else return "F";
        }
        else{
            String grade = "" + assignmentGrade;
            return grade;
        }
    }

}
