package com.example.bmi_calculator;

public class BMICalcUtil {
    public static final BMICalcUtil instance = new BMICalcUtil();

    private static final int CENTIMETERS_IN_METER = 100;

    public static final String BMI_CATEGORY_UNDERWEIGHT = "Underweight";
    public static final String BMI_CATEGORY_HEALTHY = "Healthy Weight Range";
    public static final String BMI_CATEGORY_OVERWEIGHT = "Overweight";
    public static final String BMI_CATEGORY_OBESE = "Obese";

    public static BMICalcUtil getInstance() {
        return instance;
    }

    public double calculateBMIMetric(double heightCm, double weightKg) {
        return (weightKg / ((heightCm / CENTIMETERS_IN_METER) * (heightCm / CENTIMETERS_IN_METER)));
    }


    public String classifyBMI(double bmi) {
        if (bmi < 18.5) {
            return BMI_CATEGORY_UNDERWEIGHT;
        } else if (bmi >= 18.5 && bmi < 25) {
            return BMI_CATEGORY_HEALTHY;
        } else if (bmi >= 25 && bmi < 30){
            return BMI_CATEGORY_OVERWEIGHT;
        } else {
            return BMI_CATEGORY_OBESE;
        }
    }
}

