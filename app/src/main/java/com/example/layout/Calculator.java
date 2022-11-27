package com.example.layout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class Calculator extends AppCompatActivity {
    private static final String LogcatTag = "CALCULATOR_ACTIVITY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button calculate = (Button) findViewById(R.id.calc);
        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(LogcatTag," Button have been pushed");
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
        Log.d(LogcatTag,"Succesfully grabbed data from input fields");
        Log.d(LogcatTag,"numone is: "+ numberOne +"numtwo is "+ numberTwo);
        float numone = Integer.parseInt(numberOne.getText().toString());
        float numtwo = Integer.parseInt(numberTwo.getText().toString());
        float solution = 0;
        if (add.isChecked()) {
            Log.d(LogcatTag,"Operation is add");
            solution = numone + numtwo;
        }
        if (sub.isChecked()) {
            Log.d(LogcatTag,"Operation is sub");
            solution = numone - numtwo;
        }
        if (multiply.isChecked()) {
            Log.d(LogcatTag,"Operation is mult");
            solution = numone * numtwo;
        }
        if (divide.isChecked()) {
            Log.d(LogcatTag,"Operation is divided");
            if(numtwo ==0){
                Toast.makeText(this, "Number can't be zero", Toast.LENGTH_SHORT).show();
            return;
            }
            solution = numone / numtwo;
        }
        Log.d(LogcatTag,"The result of the operation is" + solution);
answer.setText("The answer is " + solution);

    }
}