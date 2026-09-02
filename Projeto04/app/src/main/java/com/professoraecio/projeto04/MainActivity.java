package com.professoraecio.projeto04;

import android.os.Bundle;

import android.widget.ImageView;
import android.widget.NumberPicker;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    String [] personagens = new String[3];

    TextView personagemTextView;
    ImageView personagemImageView;
    NumberPicker personagemNumberPicker;

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

        personagemTextView = findViewById(R.id.personagemTextView);
        personagemImageView = findViewById(R.id.personagemImageView);
        personagemNumberPicker = findViewById(R.id.personagemNumberPicker);

        personagemTextView.setText("");

        personagens[0] = "Donald";
        personagens[1] = "Mickey";
        personagens[2] = "Tio Patinhas";

        personagemNumberPicker.setDisplayedValues(personagens);

        personagemNumberPicker.setMinValue(0);
        personagemNumberPicker.setMaxValue(2);

        personagemNumberPicker.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker numberPicker, int antigo, int atual) {
                String personagem = personagens[atual];
                // Trocar a imagem conforme personagem selecionado
                if(personagem.equalsIgnoreCase("Donald")){
                    personagemImageView.setImageResource(R.drawable.donald);
                    personagemTextView.setText("Donald");
                }else{
                    if(personagem.equalsIgnoreCase("Mickey")){
                        personagemImageView.setImageResource(R.drawable.mickey);
                        personagemTextView.setText("Mickey");
                    }else{
                        personagemImageView.setImageResource(R.drawable.tio_patinhas);
                        personagemTextView.setText("Tio Patinhas");
                    }
                }
            }
        });

    }
}