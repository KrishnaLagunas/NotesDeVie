package com.example.app4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class crearActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_craersesion);

        Button btnStart1 = findViewById(R.id.btnstart1);
        btnStart1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText ETNombre=(EditText) findViewById(R.id.txtescriibirnom1);
                String txtescriibirnom1=ETNombre.getText().toString();
                Intent intent = new Intent(crearActivity.this,iniciarsesionActivity.class);
                intent.putExtra("Nombre", txtescriibirnom1);
                startActivity(intent);
            }
        });
    }
}