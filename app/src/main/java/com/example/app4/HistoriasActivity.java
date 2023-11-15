package com.example.app4;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class HistoriasActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historias);

        final EditText editTextHistoria = findViewById(R.id.editTextHistoria);
        Button botonGuardar = findViewById(R.id.botonGuardar);

        botonGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String historia = editTextHistoria.getText().toString();
                // Guardar la historia (puedes usar SharedPreferences, base de datos, etc.)

                // Lanzar la actividad de visualización
                Intent intent = new Intent(HistoriasActivity.this, crearideasActivity.class);
                intent.putExtra("historia", historia);
                startActivity(intent);
            }
        });

    }


}