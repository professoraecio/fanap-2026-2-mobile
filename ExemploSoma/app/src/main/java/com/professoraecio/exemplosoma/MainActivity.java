package com.professoraecio.exemplosoma;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    EditText p1EditText;
    EditText p2EditText;
    TextView resultadoTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        p1EditText = findViewById(R.id.p1EditText);
        p2EditText = findViewById(R.id.p2EditText);
        resultadoTextView = findViewById(R.id.resultadoTextView);

    }

    public void somarButton(View view){
        String p1String = p1EditText.getText().toString();
        String p2String = p2EditText.getText().toString();
        Double p1Double = Double.parseDouble(p1String);
        Double p2Double = Double.parseDouble(p2String);
        Double soma = p1Double + p2Double;
        resultadoTextView.setText("" + soma);
    }

}