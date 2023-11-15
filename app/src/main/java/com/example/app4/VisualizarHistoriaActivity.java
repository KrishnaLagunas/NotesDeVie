package com.example.app4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class VisualizarHistoriaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visualizar_historia);

        TextView textViewHistoria = findViewById(R.id.textViewHistoria);

        // Obtener la historia desde el intent
        String historia = getIntent().getStringExtra("historia");
        textViewHistoria.setText(historia);

    }
}