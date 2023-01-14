package com.example.layout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.RadioButton;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.text.BreakIterator;

public class Calculator extends AppCompatActivity {
    private static final String LogcatTag = "CALCULATOR_ACTIVITY";
    private static final String LifecycleTag = "LIFECYCLE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(LifecycleTag,"Im on create");
        setContentView(R.layout.activity_main);

        final Button calculate = (Button) findViewById(R.id.calc);
// context training
       /* TextView textView = new TextView(this);

        ListAdapter adapter = new SimpleCursorAdapter(getApplicationContext(),);
        // доступ из класса активити -- наследник контекст
        getSystemService(LAYOUT_INFLATER_SERVICE);

        // shared prefs - доступ с использованием контекста приложения
        SharedPreferences prefs = getApplicationContext().getSharedPreferences("PREFS", MODE_PRIVATE);*/



        // intent - посылка



        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(LogcatTag," Button have been pushed");
                calculateAnswer();
                Intent i = new Intent(Calculator.this,MainActivity.class); // написать письмо
              //  startActivity(i); // отправить по почте
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

/*numberOne.setText("0");
numberTwo.setText("0");
add.setChecked(true);*/


        TextView answer = (TextView) findViewById(R.id.result);

        Log.d(LogcatTag,"All views have have been founded");
        //обработка ошибок, чтобы не вылетало
        //try {
       //    int a = 25/0;
       // } catch (ArithmeticException e){
       //     e.printStackTrace();
      //  }

float numtwo = 0;
float numone=0;
        String num1 = numOne.getText().toString();
        String num2 = numTwo.getText().toString();
     /*   if (num1.equals("") && num1!=null){
            numone = Integer.parseInt(numberOne.getText().toString());
        }
        if (num2.equals("") && num1!=null){
            numtwo = Integer.parseInt(numberOne.getText().toString());
        }*/
Log.d(LogcatTag,"Sucessfully grabbed data from fields");
        Log.d(LogcatTag,"numone is "+numone+ "and"+ "numtwo is"+numtwo);
        float solution = 0;
        if (add.isChecked()) {
            Log.d(LogcatTag,"Operation is add");
            solution = num1 + num2;
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
        // Log.wtf() What a terrible failure - error
answer.setText("The answer is " + solution);
        Context contextApp = getApplicationContext();
        Context context = getBaseContext();
    }
}