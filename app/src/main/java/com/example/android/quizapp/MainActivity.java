package com.example.android.quizapp;


import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RadioGroup radioGroup1 = ( RadioGroup ) findViewById(R.id.question1radioGroup);
        RadioGroup radioGroup2 = ( RadioGroup ) findViewById(R.id.question2radioGroup);
        RadioGroup radioGroup3 = ( RadioGroup ) findViewById(R.id.question3radioGroup);
        RadioButton question1answer1_RadioButton = findViewById(R.id.question1answer1);
        RadioButton question1answer2_RadioButton = findViewById(R.id.question1answer2);
        RadioButton question1answer3_RadioButton = findViewById(R.id.question1answer3);
        RadioButton question2answer1_RadioButton = findViewById(R.id.question2answer1);
        RadioButton question2answer2_RadioButton = findViewById(R.id.question2answer2);
        RadioButton question2answer3_RadioButton = findViewById(R.id.question2answer3);
        RadioButton question3answer1_RadioButton = findViewById(R.id.question3answer1);
        RadioButton question3answer2_RadioButton = findViewById(R.id.question3answer2);
        RadioButton question3answer3_RadioButton = findViewById(R.id.question3answer3);
        CheckBox question4answer1_CheckBox = findViewById(R.id.question4answer1);
        CheckBox question4answer2_CheckBox = findViewById(R.id.question4answer2);
        CheckBox question4answer3_CheckBox = findViewById(R.id.question4answer3);
        CheckBox question5answer1_CheckBox = findViewById(R.id.question5answer1);
        CheckBox question5answer2_CheckBox = findViewById(R.id.question5answer2);
        CheckBox question5answer3_CheckBox = findViewById(R.id.question5answer3);
        EditText nameInput = ( EditText ) findViewById(R.id.firstAnswer);

    }

    public void CheckAnswers(View view) {
        //setContentView(R.layout.activity_main);

        // Arrays for answer checking
        boolean[][] userCheckAnswers = {
                {false, false, false},
                {false, false, false},
                {false, false, false},
                {false, false, false},
                {false, false, false},
        };

        //Correct answers array
        boolean[][] correctAnswers = {
                {false, false, true},
                {false, true, false},
                {false, false, true},
                {false, true, true},
                {false, true, false},
        };

        // Get the name of user
        EditText nameInput = ( EditText ) findViewById(R.id.firstAnswer);
        String userName = nameInput.getText().toString();

        //1 question - take answers to array
        RadioButton question1answer1_RadioButton = findViewById(R.id.question1answer1);
        userCheckAnswers[0][0] = question1answer1_RadioButton.isChecked();
        RadioButton question1answer2_RadioButton = findViewById(R.id.question1answer2);
        userCheckAnswers[0][1] = question1answer2_RadioButton.isChecked();
        RadioButton question1answer3_RadioButton = findViewById(R.id.question1answer3);
        userCheckAnswers[0][2] = question1answer3_RadioButton.isChecked();

        //2 question - take answers to array
        RadioButton question2answer1_RadioButton = findViewById(R.id.question2answer1);
        userCheckAnswers[1][0] = question2answer1_RadioButton.isChecked();
        RadioButton question2answer2_RadioButton = findViewById(R.id.question2answer2);
        userCheckAnswers[1][1] = question2answer2_RadioButton.isChecked();
        RadioButton question2answer3_RadioButton = findViewById(R.id.question2answer3);
        userCheckAnswers[1][2] = question2answer3_RadioButton.isChecked();

        //3 question - take answers to array
        RadioButton question3answer1_RadioButton = findViewById(R.id.question3answer1);
        userCheckAnswers[2][0] = question3answer1_RadioButton.isChecked();
        RadioButton question3answer2_RadioButton = findViewById(R.id.question3answer2);
        userCheckAnswers[2][1] = question3answer2_RadioButton.isChecked();
        RadioButton question3answer3_RadioButton = findViewById(R.id.question3answer3);
        userCheckAnswers[2][2] = question3answer3_RadioButton.isChecked();

        //4 question - take answers to array
        CheckBox question4answer1_CheckBox = findViewById(R.id.question4answer1);
        userCheckAnswers[3][0] = question4answer1_CheckBox.isChecked();
        CheckBox question4answer2_CheckBox = findViewById(R.id.question4answer2);
        userCheckAnswers[3][1] = question4answer2_CheckBox.isChecked();
        CheckBox question4answer3_CheckBox = findViewById(R.id.question4answer3);
        userCheckAnswers[3][2] = question4answer3_CheckBox.isChecked();

        //5 question - take answers to array
        CheckBox question5answer1_CheckBox = findViewById(R.id.question5answer1);
        userCheckAnswers[4][0] = question5answer1_CheckBox.isChecked();
        CheckBox question5answer2_CheckBox = findViewById(R.id.question5answer2);
        userCheckAnswers[4][1] = question5answer2_CheckBox.isChecked();
        CheckBox question5answer3_CheckBox = findViewById(R.id.question5answer3);
        userCheckAnswers[4][2] = question5answer3_CheckBox.isChecked();

        //Checking arrays and making toast

        Context context = getApplicationContext();
        CharSequence text;
        int duration = Toast.LENGTH_LONG;
        int errorCount = 0;

        if (Arrays.deepEquals(userCheckAnswers, correctAnswers)) {
            text = "All answers is correct " + userName + "\nCongratulations !!";
        } else {

            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 3; j++) {
                    if (!(userCheckAnswers[i][j] == correctAnswers[i][j])) {
                        ++errorCount;
                    }
                    Log.v("MainActivity", "ErrorCount: " + errorCount + " at i= " + i + " j= " + j);
                }

            }

            text = "Sorry " + userName + "\nYou make " + errorCount + " mistakes...\nTry again";
        }

        Toast toast = Toast.makeText(context, text, duration);
        toast.show();

        //reset answers

        RadioGroup radioGroup1 = ( RadioGroup ) findViewById(R.id.question1radioGroup);
        RadioGroup radioGroup2 = ( RadioGroup ) findViewById(R.id.question2radioGroup);
        RadioGroup radioGroup3 = ( RadioGroup ) findViewById(R.id.question3radioGroup);

        radioGroup1.clearCheck();
        radioGroup2.clearCheck();
        radioGroup3.clearCheck();

        if (question4answer1_CheckBox.isChecked()) question4answer1_CheckBox.toggle();
        if (question4answer2_CheckBox.isChecked()) question4answer2_CheckBox.toggle();
        if (question4answer3_CheckBox.isChecked()) question4answer3_CheckBox.toggle();
        if (question5answer1_CheckBox.isChecked()) question5answer1_CheckBox.toggle();
        if (question5answer2_CheckBox.isChecked()) question5answer2_CheckBox.toggle();
        if (question5answer3_CheckBox.isChecked()) question5answer3_CheckBox.toggle();

    }
}