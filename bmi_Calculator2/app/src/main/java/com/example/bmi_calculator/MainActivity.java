package com.example.bmi_calculator;

import static com.example.bmi_calculator.BMICalcUtil.BMI_CATEGORY_HEALTHY;
import static com.example.bmi_calculator.BMICalcUtil.BMI_CATEGORY_OBESE;
import static com.example.bmi_calculator.BMICalcUtil.BMI_CATEGORY_OVERWEIGHT;
import static com.example.bmi_calculator.BMICalcUtil.BMI_CATEGORY_UNDERWEIGHT;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText weightKgEditText, heightCmEditText;
    private Button calculateButton;
    private TextView bmiTextView, categoryTextView;
    private CardView bmiResultCardView;
    private boolean inMetricUnits;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        weightKgEditText = findViewById(R.id.activity_main_weightkgs);
        heightCmEditText = findViewById(R.id.activity_main_heightcm);


        calculateButton = findViewById(R.id.activity_main_calculate);


        bmiTextView = findViewById(R.id.activity_main_bmi);
        categoryTextView = findViewById(R.id.activity_main_category);
        bmiResultCardView = findViewById(R.id.activity_main_resultcard);

        inMetricUnits = true;
        updateInputsVisibility();
        bmiResultCardView.setVisibility(View.GONE);

        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (inMetricUnits) {
                    if (weightKgEditText.length() == 0 || heightCmEditText.length() == 0) {
                        Toast.makeText(MainActivity.this, "Populate Weight and Height to Calculate BMI", Toast.LENGTH_SHORT).show();
                    } else {
                        double heightInCms = Double.parseDouble(heightCmEditText.getText().toString());
                        double weightInKgs = Double.parseDouble(weightKgEditText.getText().toString());
                        double bmi = BMICalcUtil.getInstance().calculateBMIMetric(heightInCms, weightInKgs);
                        displayBMI(bmi);
                    }
                }
            }
        });
    }

    private void updateInputsVisibility() {
        if (inMetricUnits) {
            heightCmEditText.setVisibility(View.VISIBLE);
            weightKgEditText.setVisibility(View.VISIBLE);
        } else {
            heightCmEditText.setVisibility(View.GONE);
            weightKgEditText.setVisibility(View.GONE);
        }
    }

    private void displayBMI(double bmi) {
        bmiResultCardView.setVisibility(View.VISIBLE);

        bmiTextView.setText(String.format("%.2f", bmi));

        String bmiCategory = BMICalcUtil.getInstance().classifyBMI(bmi);
        categoryTextView.setText(bmiCategory);

        switch (bmiCategory) {
            case BMI_CATEGORY_UNDERWEIGHT:
            case BMI_CATEGORY_OVERWEIGHT:
                bmiResultCardView.setCardBackgroundColor(Color.YELLOW);
                break;
            case BMI_CATEGORY_HEALTHY:
                bmiResultCardView.setCardBackgroundColor(Color.GREEN);
                break;
            case BMI_CATEGORY_OBESE:
                bmiResultCardView.setCardBackgroundColor(Color.RED);
                break;
        }
    }
}