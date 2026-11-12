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
        }
    }
}