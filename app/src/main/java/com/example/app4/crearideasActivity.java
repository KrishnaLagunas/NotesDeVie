package com.example.app4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

public class crearideasActivity extends AppCompatActivity {

    private ListView itemsList;
    private boolean isListVisible = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crearideas);
        Button openButton = findViewById(R.id.open);
        itemsList = findViewById(R.id.items_list);

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
    }

    private void toggleListVisibility() {
        if (isListVisible) {
            itemsList.setVisibility(View.GONE);
            isListVisible = false;
        } else {
            itemsList.setVisibility(View.VISIBLE);
            isListVisible = true;
        }
    }
}