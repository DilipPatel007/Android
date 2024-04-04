package com.dilip.bmicalculatorinjava;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.example.bmicalculatorinjava.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText weightText = findViewById(R.id.etWeight);
        EditText heightText = findViewById(R.id.etHeight);
        Button calcButton = findViewById(R.id.btnCalculate);

//        calcButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                String weight = weightText.getText().toString();
//                String height = heightText.getText().toString();
//                if (validateInput(weight, height)) {
//                    // (cm/100) = meter
//                    float bmi = Float.parseFloat(weight) / ((Float.parseFloat(height) / 100) * (Float.parseFloat(height) / 100));
//                    // Get result with two decimal places
//                    float bmi2Digits = Float.parseFloat(String.format("%.2f", bmi));
//                    displayResult(bmi2Digits);
//                }
//            }
//        });

        calcButton.setOnClickListener(view -> {
            String weight = weightText.getText().toString();
            String height = heightText.getText().toString();
            if (validateInput(weight, height)) {
                // (cm/100) = meter
                float bmi = Float.parseFloat(weight) / ((Float.parseFloat(height) / 100) * (Float.parseFloat(height) / 100));
                // Get result with two decimal places
                float bmi2Digits = Float.parseFloat(String.format("%.2f", bmi));
                displayResult(bmi2Digits);
            }
        });
    }

    private boolean validateInput(String weight, String height) {
        if (weight.isEmpty()) {
            Toast.makeText(this, "Weight is empty", Toast.LENGTH_LONG).show();
            return false;
        } else if (height.isEmpty()) {
            Toast.makeText(this, "Height is empty", Toast.LENGTH_LONG).show();
            return false;
        } else {
            return true;
        }
    }

    private void displayResult(float bmi) {
        TextView resultIndex = findViewById(R.id.tvIndex);
        TextView resultDescription = findViewById(R.id.tvResult);
        TextView info = findViewById(R.id.tvInfo);

        resultIndex.setText(String.valueOf(bmi));
        info.setText("(Normal range is 18.5 - 24.9)");

        String resultText;
        int color;

        if (bmi < 18.50) {
            resultText = "Underweight";
            color = R.color.under_weight;
        } else if (bmi >= 18.50 && bmi <= 24.99) {
            resultText = "Healthy";
            color =R.color.normal;
        } else {
            // Handle other BMI ranges
            resultText = "Unknown";
            color =R.color.over_weight;
        }

        resultDescription.setTextColor(ContextCompat.getColor(this,color));
        resultDescription.setText(resultText);
    }
}
