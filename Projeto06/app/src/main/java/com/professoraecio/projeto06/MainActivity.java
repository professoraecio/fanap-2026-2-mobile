package com.professoraecio.projeto06;

import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.professoraecio.projeto06.util.UtilTime;

public class MainActivity extends AppCompatActivity {

    TextView horaSelecionadaTextView;
    Button selecionarHoraButton;

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

        horaSelecionadaTextView = findViewById(R.id.horaSelecionadaTextView);
        selecionarHoraButton = findViewById(R.id.selecionarHoraButton);

        horaSelecionadaTextView.setText("Hora selecionada: Nenhuma");
        selecionarHoraButton.setText("Selecionar Hora");

    }

    public void selecionarHoraButtonAction(View view){
        TimePickerDialog timePickerDialog = new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker timePicker, int horas, int minutos) {
                horaSelecionadaTextView.setText("" + horas + ":" + minutos);
            }
        }, UtilTime.getHoraAtual(), UtilTime.getMinutoAtual(), true);
        timePickerDialog.show();
    }

}