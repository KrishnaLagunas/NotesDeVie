package com.example.app4;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class crearideasActivity extends AppCompatActivity {

    private ListView itemsList;
    private boolean isListVisible = false;



    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crearideas);

        final TextView textViewHistoria = findViewById(R.id.textViewHistoria);
        Button botonAbrirArchivo = findViewById(R.id.botonAbrirArchivo);


        Button openButton = findViewById(R.id.open);
        itemsList = findViewById(R.id.items_list);
        Button botonCrearHistoria = findViewById(R.id.botonCrearHistoria);
        botonCrearHistoria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(crearideasActivity.this, HistoriasActivity.class);
                startActivity(intent);
            }
        });


        botonAbrirArchivo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Obtén el texto del TextView y pásalo a VisualizarHistoriaActivity
                String contenido = textViewHistoria.getText().toString();

                // Crea un Intent para abrir VisualizarHistoriaActivity
                Intent intent = new Intent(crearideasActivity.this, VisualizarHistoriaActivity.class);
                intent.putExtra("historia", contenido);
                startActivity(intent);
            }
        });





        // Define las opciones para mostrar (texto e icono)
        final ItemModel[] items = {
                new ItemModel("Carpetas", R.drawable.ic_icon3),
                new ItemModel("Favoritos", R.drawable.ic_icon2),
                new ItemModel("Papelera", R.drawable.ic_icon4),
                new ItemModel("Compartir", R.drawable.ic_icon6),
                new ItemModel("Configuración", R.drawable.ic_icon1),
                new ItemModel("Ayuda y Comentarios", R.drawable.ic_icon5)
        };

        // Crea un adaptador personalizado para los ítems
        CustomItemAdapter adapter = new CustomItemAdapter(this, R.layout.list_item, items);
        itemsList.setAdapter(adapter);

        // Configura el botón para mostrar/ocultar los ítems al presionarlo
        openButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toggleListVisibility();
            }
        });

        // Configura un listener para manejar los clics en los elementos de la lista
        itemsList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Abre la actividad correspondiente según el elemento seleccionado
                switch (position) {
                    case 0:
                        // Abre la actividad de Carpetas
                        Intent intent = new Intent(crearideasActivity.this, CarpetasActivity.class);
                        startActivity(intent);
                        break;
                    case 1:
                        // Abre la actividad de Favoritos
                        Intent intent1 = new Intent(crearideasActivity.this, FavoritosActivity.class);
                        startActivity(intent1);
                        break;
                    case 2:
                        // Abre la actividad de Papelera
                        Intent intent2 = new Intent(crearideasActivity.this, PapeleraActivity.class);
                        startActivity(intent2);
                        break;
                    case 3:
                        // Abre la actividad de Compartir
                        Intent intent3 = new Intent(crearideasActivity.this, CompartirActivity.class);
                        startActivity(intent3);
                        break;
                    case 4:
                        // Abre la actividad de Configuración
                        Intent intent4 = new Intent(crearideasActivity.this, ConfiguracionActivity.class);
                        startActivity(intent4);
                        break;
                    case 5:
                        // Abre la actividad de Ayuda y Comentarios
                        Intent intent5 = new Intent(crearideasActivity.this, AyudaYcomActivity.class);
                        startActivity(intent5);
                        break;
                }
            }
        });


    }



    private void toggleListVisibility() {
        if (isListVisible) {
            itemsList.setVisibility(View.GONE);
            isListVisible = false;
        } else {
            itemsList.setVisibility(View.VISIBLE);
            isListVisible = true;
        }


    }};


