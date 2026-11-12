package com.example.bmicalculate;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    private EditText etWeight, etHeight;
    private Button btnCalculate;
    private TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        etWeight = findViewById(R.id.editTextWeight);
        etHeight = findViewById(R.id.editTextHeight);
        btnCalculate = findViewById(R.id.buttonCalculate);
        tvResult = findViewById(R.id.textViewResult);

        btnCalculate.setOnClickListener(v->{
            displayBmiResult();
        });
    }

    private void displayBmiResult(){
        String weightStr = etWeight.getText().toString().strip();
        String heightStr = etHeight.getText().toString().strip();

        if (weightStr.isEmpty() || heightStr.isEmpty()){
            tvResult.setText("Wprowadź wszystkie dane!");
            return;
        }

        try{
            double weight = Double.parseDouble(weightStr);
            double heightCm = Double.parseDouble(heightStr);

            BmiResult score = calculate(weight,heightCm);
            tvResult.setText(score.toString());

        } catch (NumberFormatException e) {
            tvResult.setText("Dane powinny być liczbami!");
        }
    }

    private BmiResult calculate(double weight, double heightCm){
        double heightMeters = heightCm / 100;
        double score = weight / heightMeters / heightMeters;

        BmiNote status;
        if (score < 18.5){
            status = BmiNote.NIEDOWAGA;
        } else if (score < 25){
            status = BmiNote.NORMA;
        }else if (score < 30){
            status = BmiNote.NADWAGA;
        }else {
            status = BmiNote.OTYŁOŚĆ;
        }


        return new BmiResult(score,status);

    }
}