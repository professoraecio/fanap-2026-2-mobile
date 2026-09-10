package com.example.projeto13;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.projeto13.util.UtilSharedPreferences;

public class MainActivity extends AppCompatActivity {

    EditText usuarioEditText;
    EditText senhaEditText;


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

        usuarioEditText = findViewById(R.id.usuarioEditText);
        senhaEditText = findViewById(R.id.senhaEditText);
    }

    public void salvar(View view){
        String usuario = usuarioEditText.getText().toString();
        String senha = senhaEditText.getText().toString();
        UtilSharedPreferences.salvarString(this, "usuario", usuario);
        UtilSharedPreferences.salvarString(this, "senha", senha);
    }

    public void ler(View view){
        String usuario = UtilSharedPreferences.lerString(this, "usuario", "admin");
        String senha = UtilSharedPreferences.lerString(this, "senha", "admin");
        usuarioEditText.setText(usuario);
        senhaEditText.setText(senha);
    }

    public void apagar(View view){
        UtilSharedPreferences.clearPreferences(this);
    }
}