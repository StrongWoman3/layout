package com.example.layout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class Calculator extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button calculate = (Button) findViewById(R.id.calc);
        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                calculateAnswer();
            }
        });
    }
    private void calculateAnswer(){
        EditText numberOne = findViewById(R.id.editTextNumberDecimal1);
        EditText numberTwo = findViewById(R.id.editTextNumberDecimal2);
        RadioButton add = (RadioButton) findViewById(R.id.add);
        RadioButton sub = (RadioButton) findViewById(R.id.subtract);
        RadioButton multiply = (RadioButton) findViewById(R.id.multiple);
        RadioButton divide = (RadioButton) findViewById(R.id.divide);

        TextView answer = (TextView) findViewById(R.id.result);
        float numone = Integer.parseInt(numberOne.getText().toString());
        float numtwo = Integer.parseInt(numberTwo.getText().toString());
        float solution = 0;
        if (add.isChecked()) {
            solution = numone + numtwo;
        }
        if (sub.isChecked()) {
            solution = numone - numtwo;
        }
        if (multiply.isChecked()) {
            solution = numone * numtwo;
        }
        if (divide.isChecked()) {
            if(numtwo ==0){
                Toast.makeText(this, "Number can't be zero", Toast.LENGTH_SHORT).show();
            return;
            }
            solution = numone / numtwo;
        }
answer.setText("The answer is " + solution);

    }
}