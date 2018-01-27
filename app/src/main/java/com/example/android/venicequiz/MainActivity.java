package com.example.android.venicequiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    static int totalPoints;
    RadioButton questionOneAnswerThree;
    RadioButton questionTwoAnswerOne;
    RadioButton questionThreeAnswerTrue;
    RadioButton questionFourAnswerTrue;
    EditText questionFiveEditText;
    CheckBox questionSixAnswerOne;
    CheckBox questionSixAnswerFour;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        questionOneAnswerThree = findViewById(R.id.questionOneAnswerThree_radio);
        questionTwoAnswerOne = findViewById(R.id.questionTwoAnswerOne_radio);
        questionThreeAnswerTrue = findViewById(R.id.questionThreeAnswerTrue_radio);
        questionFourAnswerTrue = findViewById(R.id.questionFourAnswerTrue_radio);
        questionFiveEditText = findViewById(R.id.questionFive_editText);
        questionSixAnswerOne = findViewById(R.id.questionSixAnswerOne_checkbox);
        questionSixAnswerFour = findViewById(R.id.questionSixAnswerFour_checkbox);
    }

    public void submitAnswers(View v) {
        if(questionOneAnswerThree.isChecked()) {
            totalPoints += 1;
        }
        if(questionTwoAnswerOne.isChecked()) {
            totalPoints += 1;
        }
        if(questionThreeAnswerTrue.isChecked()) {
            totalPoints += 1;
        }
        if(questionFourAnswerTrue.isChecked()) {
            totalPoints += 1;
        }
        String questionFiveString = questionFiveEditText.getText().toString();
        if(questionFiveString.equals("Saint Mark")) {
            totalPoints += 1;
        }
        if((questionSixAnswerOne.isChecked()) && (questionSixAnswerFour.isChecked())) {
            totalPoints += 1;
        }

        String messageZero = getResources().getString(R.string.toast0);
        String lessPoints = getResources().getString(R.string.toast1);
        String messageLess = String.format(lessPoints, totalPoints);
        String mediumPoints = getResources().getString(R.string.toast2);
        String messageMedium = String.format(mediumPoints, totalPoints);
        String highPoints = getResources().getString(R.string.toast3);
        String messageHigh = String.format(highPoints, totalPoints);

        if(totalPoints == 0) {
            Toast.makeText(this, messageZero, Toast.LENGTH_LONG).show();
        } else if(totalPoints == 1 || totalPoints == 2) {
            Toast.makeText(this, messageLess, Toast.LENGTH_LONG).show();
        } else if(totalPoints == 3 || totalPoints == 4) {
            Toast.makeText(this, messageMedium, Toast.LENGTH_LONG).show();
        } else if(totalPoints == 5 || totalPoints == 6) {
            Toast.makeText(this, messageHigh, Toast.LENGTH_LONG).show();
        }
    }

    public void resetAnswers(View v) {
        totalPoints = 0;
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}
