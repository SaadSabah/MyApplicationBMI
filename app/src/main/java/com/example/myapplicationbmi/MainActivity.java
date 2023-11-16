package com.example.myapplicationbmi;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    private EditText heightEditText;
    private EditText weightEditText;
    private TextView resultTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView bmiImage = findViewById(R.id.bmiimge);
        TextView bmiText = findViewById(R.id.BMI);

        heightEditText = findViewById(R.id.H);
        weightEditText = findViewById(R.id.W);
        resultTextView = findViewById(R.id.The_result);

        Button calculateButton = findViewById(R.id.Butt);
        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculateBMI();
            }
        });
    }

    private void calculateBMI() {
        String heightStr = heightEditText.getText().toString();
        String weightStr = weightEditText.getText().toString();

        if (!heightStr.isEmpty() && !weightStr.isEmpty()) {
            float height = Float.parseFloat(heightStr);
            float weight = Float.parseFloat(weightStr);

            float heightInMeters = height / 100;
            float bmi = weight / (heightInMeters * heightInMeters);

            String bmiResult = "Your BMI: " + String.format("%.2f", bmi);
            resultTextView.setText(bmiResult);
        } else {
            resultTextView.setText("Please enter both height and weight");
        }
    }
}
