package com.example.manu.assignment2coen390;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    protected static final String TAG = "Main Activity";

    protected Button showGradesButton = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(TAG, "The onCreate() event");
        setupUI();
    }

    protected void setupUI()
    {
        showGradesButton = (Button) findViewById(R.id.showGradesbutton);
        showGradesButton.setOnClickListener(onClickShowGradesButton);
    }


    /**
     *  Button onclick listener
     */
    private Button.OnClickListener onClickShowGradesButton = new Button.OnClickListener(){

        public void onClick(View v){
            Log.d(TAG,"The onClick() ShowGradesButton Event");
            Intent getGradeScreenIntent = new  Intent(v.getContext(), GradeActivity.class);

            final int result = 1;
            getGradeScreenIntent.putExtra("CallingActivity","MainActivity");
            startActivityForResult(getGradeScreenIntent,result);
        }
    };
}
