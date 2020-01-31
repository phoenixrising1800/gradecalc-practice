package com.phoenixrising1800.android.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private TextView finalCalculation;
    private EditText userText;
    private final double INDIV_WEIGHT = 0.2;
    private final double TEAMPROJ_WEIGHT = 0.3;
    private final double MIDTERM_WEIGHT = 0.3;
    private final double FINAL_WEIGHT = 0.2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View view) {
        // init textbox for final calculation output
        finalCalculation = findViewById(R.id.finalCalculation);

        try {
            ArrayList<Double> inputValues = new ArrayList<Double>();

            // Get input values from user, compile values

            EditText current =  findViewById(R.id.indivPointsEarned);
            inputValues.add(Double.parseDouble(receiveUserText(current)));

            current = findViewById(R.id.indivPointsPossible);
            inputValues.add(Double.parseDouble(receiveUserText(current)));

            current = findViewById(R.id.projPointsEarned);
            inputValues.add(Double.parseDouble(receiveUserText(current)));

            current = findViewById(R.id.projPointsPossible);
            inputValues.add(Double.parseDouble(receiveUserText(current)));

            current = findViewById(R.id.midtermPointsEarned);
            inputValues.add(Double.parseDouble(receiveUserText(current)));

            current = findViewById(R.id.midtermPointsPossible);
            inputValues.add(Double.parseDouble(receiveUserText(current)));

            current = findViewById(R.id.finalPointsEarned);
            inputValues.add(Double.parseDouble(receiveUserText(current)));

            current = findViewById(R.id.finalPointsPossible);
            inputValues.add(Double.parseDouble(receiveUserText(current)));


            // TODO: can remove?
            // error, not all values found input
            if (inputValues.isEmpty() || inputValues.size() != 8) {
                throw new Exception("Please input all values");
            }

            // calculate
            String weightedGrade = calculateWeightedGrade(inputValues);
            if (Double.valueOf(weightedGrade) < 0 || Double.valueOf(weightedGrade) > 100)
                throw new IllegalArgumentException();
            char gradingScheme = getGradingScheme(Double.parseDouble(weightedGrade));
            String output = gradingScheme + ": " + weightedGrade;
            finalCalculation.setText(output);

        } catch (IllegalArgumentException e) {
            finalCalculation.setText("Please input all values correctly.");
        } catch (Exception e) {
            e.printStackTrace();
            finalCalculation.setText(e.getMessage());
        } finally {
        }
    }

    private String receiveUserText(EditText current) {
        if (current.getText().toString().isEmpty()) {
            return "Please input all values.";
        }
        return current.getText().toString();
    }

    /**
     * Get list of values found from user input and calculate the weighted grade as a String
     * to be output.
     * @param values
     * @return
     */
    private String calculateWeightedGrade(ArrayList<Double> values) {
        return "99";
    }

    private char getGradingScheme(double grade) {
        if (grade >= 90)
            return 'A';
        else if (grade >= 80 && grade < 90)
            return 'B';
        else if (grade >= 70 && grade < 80)
            return 'C';
        else if (grade >= 60 && grade < 70)
            return 'D';
        else if (grade < 60)
            return 'F';
        return 'x';
    }
}
