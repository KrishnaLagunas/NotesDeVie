package com.example.app4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class crearActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_craersesion);

        Button btnStart1 = findViewById(R.id.btnstart1);
        btnStart1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(crearActivity.this,iniciarsesionActivity.class);
                startActivity(intent);
            }
        });
    }
}