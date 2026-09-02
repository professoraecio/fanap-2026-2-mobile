package com.professoraecio.projeto05;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.professoraecio.projeto05.util.UtilDate;

public class MainActivity extends AppCompatActivity {

    TextView dataEscolhidaTextView;

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

        dataEscolhidaTextView = findViewById(R.id.dataEscolhidaTextView);
    }

    public void escolherDataButtonAction(View view){
        UtilDate utilDate = new UtilDate();
        DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int ano, int mes, int dia) {
                        dataEscolhidaTextView.setText("" + dia + "/" + mes + "/" + ano);
                    }
                }, utilDate.getAnoAtual(),utilDate.getMesAtual() , utilDate.getDiaAtual());
        datePickerDialog.show();
    }
}