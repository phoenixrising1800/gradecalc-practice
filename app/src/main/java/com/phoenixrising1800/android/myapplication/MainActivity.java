package com.phoenixrising1800.android.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

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
        try {
            // init textbox for final calculation output
            finalCalculation = findViewById(R.id.finalCalculation);

            // Get input values from user
            EditText current =  findViewById(R.id.indivPointsEarned);
            String name = current.getText().toString();
            // calculate
            System.out.println(name);
            finalCalculation.setText(name);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private double calculateWeightedGrade() {
        return 0;
    }

    private char getGradingScheme(double grade) {
        return 'A';
    }
}
