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
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    //general variables that store information
    RadioGroup radioGroup1;
    RadioGroup radioGroup2;
    RadioGroup radioGroup3;
    RadioGroup radioGroup4;
    RadioButton question1answer1_sudan;
    RadioButton question1answer2_kenya;
    RadioButton question1answer3_south_sudan;
    RadioButton question2answer1_mogadishu;
    RadioButton question2answer2_addis;
    RadioButton question2answer3_cairo;
    RadioButton question3answer1_Siad_barre;
    RadioButton question3answer2_mandela;
    RadioButton question3answer3_mbeki;
    CheckBox question4answer1_surad;
    CheckBox question4answer2_m_kilimanjaro;
    CheckBox question4answer3_kilimanjaro;
    RadioButton question5answer1_nairobi;
    RadioButton question5answer2_lagos;
    RadioButton question5answer3_kinshasa;
    EditText nameInput;
    EditText answerInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radioGroup1 = ( RadioGroup ) findViewById(R.id.question1radioGroup);
        radioGroup2 = ( RadioGroup ) findViewById(R.id.question2radioGroup);
        radioGroup3 = ( RadioGroup ) findViewById(R.id.question3radioGroup);
        radioGroup4 = (RadioGroup) findViewById(R.id.question4radioGroup);
        question1answer1_sudan = findViewById(R.id.question1answer1_sudan);
        question1answer2_kenya = findViewById(R.id.question1answer2_kenya);
        question1answer3_south_sudan = findViewById(R.id.question1answer3_south_sudan);
        question2answer1_mogadishu = findViewById(R.id.question2answer1_mogadishu);
        question2answer2_addis = findViewById(R.id.question2answer2_addis);
        question2answer3_cairo = findViewById(R.id.question2answer3_cairo);
        question3answer1_Siad_barre = findViewById(R.id.question3answer1_Siad_barre);
        question3answer2_mandela = findViewById(R.id.question3answer2_mandela);
        question3answer3_mbeki = findViewById(R.id.question3answer3_mbeki);
        question4answer1_surad = findViewById(R.id.question4answer1_surad);
        question4answer2_m_kilimanjaro = findViewById(R.id.question4answer2_m_kilimanjaro);
        question4answer3_kilimanjaro = findViewById(R.id.question4answer3_kilimanjaro);
        question5answer1_nairobi = findViewById(R.id.question5answer1_nairobi);
        question5answer2_lagos = findViewById(R.id.question5answer2_lagos);
        question5answer3_kinshasa = findViewById(R.id.question5answer3_kinshasa);
        nameInput = ( EditText ) findViewById(R.id.firstAnswer);
        answerInput = (EditText) findViewById(R.id.answerInput);

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
        String userName = nameInput.getText().toString();


        //1 question - take answers to array
        userCheckAnswers[0][0] = question1answer1_sudan.isChecked();
        userCheckAnswers[0][1] = question1answer2_kenya.isChecked();
        userCheckAnswers[0][2] = question1answer3_south_sudan.isChecked();

        //2 question - take answers to array
        userCheckAnswers[1][0] = question2answer1_mogadishu.isChecked();
        userCheckAnswers[1][1] = question2answer2_addis.isChecked();
        userCheckAnswers[1][2] = question2answer3_cairo.isChecked();

        //3 question - take answers to array
        userCheckAnswers[2][0] = question3answer1_Siad_barre.isChecked();
        userCheckAnswers[2][1] = question3answer2_mandela.isChecked();
        userCheckAnswers[2][2] = question3answer3_mbeki.isChecked();

        //4 question - take answers to array
        userCheckAnswers[3][0] = question4answer1_surad.isChecked();
        userCheckAnswers[3][1] = question4answer2_m_kilimanjaro.isChecked();
        userCheckAnswers[3][2] = question4answer3_kilimanjaro.isChecked();

        //5 question - take answers to array
        userCheckAnswers[4][0] = question5answer1_nairobi.isChecked();
        userCheckAnswers[4][1] = question5answer2_lagos.isChecked();
        userCheckAnswers[4][2] = question5answer3_kinshasa.isChecked();

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

        RadioGroup radioGroup1 = (RadioGroup) findViewById(R.id.question1radioGroup);
        RadioGroup radioGroup2 = (RadioGroup) findViewById(R.id.question2radioGroup);
        RadioGroup radioGroup3 = (RadioGroup) findViewById(R.id.question3radioGroup);
        RadioGroup radioGroup4 = (RadioGroup) findViewById(R.id.question4radioGroup);
        EditText answerInput = (EditText) findViewById(R.id.answerInput);
        EditText nameInput = (EditText) findViewById(R.id.firstAnswer);


        radioGroup1.clearCheck();
        radioGroup2.clearCheck();
        radioGroup3.clearCheck();
        radioGroup4.clearCheck();


        if (question4answer1_surad.isChecked()) question4answer1_surad.toggle();
        if (question4answer2_m_kilimanjaro.isChecked()) question4answer2_m_kilimanjaro.toggle();
        if (question4answer3_kilimanjaro.isChecked()) question4answer3_kilimanjaro.toggle();


    }
}