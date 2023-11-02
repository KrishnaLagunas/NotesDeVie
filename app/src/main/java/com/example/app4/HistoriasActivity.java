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
    private EditText editTextHistorias;
    private Button guardarButton;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historias);
        editTextHistorias = findViewById(R.id.editTextHistorias);
        guardarButton = findViewById(R.id.guardarButton);

        guardarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                guardarHistoria();
            }
        });
    }
    private void guardarHistoria() {
        String historia = editTextHistorias.getText().toString();
        if (!historia.isEmpty()) {

            try {
                File file = new File(getFilesDir(), "historia.txt");
                FileWriter writer = new FileWriter(file);
                writer.write(historia);
                writer.close();
                // Devuelve el contenido de la historia como resultado
                Intent resultIntent = new Intent();
                resultIntent.putExtra("historia", historia);
                setResult(RESULT_OK, resultIntent);
                finish();
                Toast.makeText(getApplicationContext(), "Historia guardada", Toast.LENGTH_SHORT).show();

            } catch (IOException e) {
                e.printStackTrace();
                Toast.makeText(getApplicationContext(), "Error al guardar la historia", Toast.LENGTH_SHORT).show();
            }

            }
        }
    }

