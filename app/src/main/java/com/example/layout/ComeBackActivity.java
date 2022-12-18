package com.example.layout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ComeBackActivity extends AppCompatActivity {
    EditText textView;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_come_back);
        textView = (EditText) findViewById(R.id.backtv);
        button = (Button) findViewById(R.id.sendback);
button.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Intent intent = new Intent();  // при нажатии на кнопку создан интент
        intent.putExtra("tv",textView.getText().toString()); //в интент положили текст вью по ключу тв и преобразовали в стринг
        setResult(RESULT_OK,intent); // интент выставили как результат активности, используя метор
        finish();
    }
});
    }
}