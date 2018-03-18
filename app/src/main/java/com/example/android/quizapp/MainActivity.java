package com.example.android.quizapp;


import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //general variables that store information

    RadioButton question1answer3_south_sudan;
    RadioButton question2answer2_addis;
    RadioButton question3answer3_mbeki;
    CheckBox question4answer1_surad;
    CheckBox question4answer2_m_kilimanjaro;
    CheckBox question4answer3_kilimanjaro;
    RadioButton question5answer2_lagos;
    EditText answerInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void CheckAnswers(View view) {
        CharSequence resultsDisplay;
        int answer1_score;
        int editText_score;
        int answer2_score;
        int answer3_score;
        int answer4_score;
        int answer5_score;
        int final_score;


        //------------------------------------------------------------------------------------------
        // EditText - Correct Answer is "54"
        //------------------------------------------------------------------------------------------
        String editText;
        answerInput = (EditText) findViewById(R.id.answerInput);
        editText = answerInput.getText().toString().toLowerCase();
        if (editText.equals("54")) {
            editText_score = 1;
        } else {
            editText_score = 0;
        }

        //------------------------------------------------------------------------------------------
        // Question 1 - Correct Answer is #3 (South Sudan)
        //------------------------------------------------------------------------------------------
        boolean answer1;

        question1answer3_south_sudan = (RadioButton) findViewById(R.id.question1answer3_south_sudan);
        answer1 = question1answer3_south_sudan.isChecked();
        if (answer1) {
            answer1_score = 1;
        } else {
            answer1_score = 0;
        }

        //------------------------------------------------------------------------------------------
        // Question 2  - Correct Answers is #2 "Addis"
        //------------------------------------------------------------------------------------------
        boolean answer2;
        question2answer2_addis = (RadioButton) findViewById(R.id.question2answer2_addis);
        answer2 = question2answer2_addis.isChecked();
        if (answer2) {
            answer2_score = 1;
        } else {
            answer2_score = 0;
        }

        //------------------------------------------------------------------------------------------
        // Question 3  - Correct Answers is #3 "Thabo Mbeki"
        //------------------------------------------------------------------------------------------
        boolean answer3;
        question3answer3_mbeki = (RadioButton) findViewById(R.id.question3answer3_mbeki);
        answer3 = question3answer3_mbeki.isChecked();
        if (answer3) {
            answer3_score = 1;
        } else {
            answer3_score = 0;
        }

        //------------------------------------------------------------------------------------------
        // Question 4  - Correct Answers are #2 (Kalimanjaro) and #3 (Mount Kalimanjaro)
        //------------------------------------------------------------------------------------------
        boolean answer4_surad;
        boolean answer4_m_kilimanjaro;
        boolean answer4_kilimanjaro;
        question4answer1_surad = (CheckBox) findViewById(R.id.question4answer1_surad);
        question4answer2_m_kilimanjaro = (CheckBox) findViewById(R.id.question4answer2_m_kilimanjaro);
        question4answer3_kilimanjaro = (CheckBox) findViewById(R.id.question4answer3_kilimanjaro);
        answer4_surad = question4answer1_surad.isChecked();
        answer4_m_kilimanjaro = question4answer2_m_kilimanjaro.isChecked();
        answer4_kilimanjaro = question4answer3_kilimanjaro.isChecked();

        if (!answer4_m_kilimanjaro && !answer4_kilimanjaro) {
            answer4_score = 1;
        } else {
            answer4_score = 0;
        }

        //------------------------------------------------------------------------------------------
        // Question 5  - Correct Answers is #2 "Lagos"
        //------------------------------------------------------------------------------------------
        boolean answer5;
        question5answer2_lagos = (RadioButton) findViewById(R.id.question5answer2_lagos);
        answer5 = question5answer2_lagos.isChecked();
        if (answer5) {
            answer5_score = 1;
        } else {
            answer5_score = 0;
        }
        //------------------------------------------------------------------------------------------
        // Final Score
        //------------------------------------------------------------------------------------------
        final_score = answer1_score + answer2_score + answer3_score + answer4_score + answer5_score + editText_score;


        if (final_score == 5) {
            resultsDisplay = "Congrats! You scored 5 out of 5";
        } else {
            resultsDisplay = "Sorry try again. You scored " + final_score + " out of 5";
        }

        Context context = getApplicationContext();
        int duration = Toast.LENGTH_LONG;
        Toast toast = Toast.makeText(context, resultsDisplay, duration);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();

        //reset all answers
        RadioGroup radioGroup1 = (RadioGroup) findViewById(R.id.question1radioGroup);
        RadioGroup radioGroup2 = (RadioGroup) findViewById(R.id.question2radioGroup);
        RadioGroup radioGroup3 = (RadioGroup) findViewById(R.id.question3radioGroup);
        RadioGroup radioGroup4 = (RadioGroup) findViewById(R.id.question4radioGroup);
        EditText answerInput = (EditText) findViewById(R.id.answerInput);


        radioGroup1.clearCheck();
        radioGroup2.clearCheck();
        radioGroup3.clearCheck();
        radioGroup4.clearCheck();


        if (question4answer1_surad.isChecked()) question4answer1_surad.toggle();
        if (question4answer2_m_kilimanjaro.isChecked()) question4answer2_m_kilimanjaro.toggle();
        if (question4answer3_kilimanjaro.isChecked()) question4answer3_kilimanjaro.toggle();

    }
}
