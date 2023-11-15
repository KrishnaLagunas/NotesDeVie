package com.example.app4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class iniciarsesionActivity extends AppCompatActivity {
    TextView textView;
    private EditText passwordEditText1;
    private Button showHidePasswordButton1;
    private boolean passwordVisible = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iniciarsesion);
        textView=findViewById(R.id.txtnom1);
        Intent intent = getIntent();

        String txtescriibirnom1 = intent.getExtras().getString("Nombre");
        textView.setText(txtescriibirnom1);

        Button button1 = findViewById(R.id.button);
        passwordEditText1 = findViewById(R.id.editTextTextPassword1);
        showHidePasswordButton1 = findViewById(R.id.showHidePasswordButton1);
        // Agregar la funcionalidad del botón "Mostrar Contraseña"


        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Recuperar la contraseña almacenada de manera segura (por ejemplo, en SharedPreferences)
                SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
                String storedPassword = sharedPreferences.getString("password", "");

                EditText ETClave = findViewById(R.id.editTextTextPassword1);
                String enteredPassword = ETClave.getText().toString();

                if (enteredPassword.equals(storedPassword)) {
                    // Contraseña correcta, mostrar mensaje de sesión exitosa
                    Toast.makeText(iniciarsesionActivity.this, "Sesión exitosa", Toast.LENGTH_SHORT).show();
                    // Iniciar la actividad de inicio de sesión
                    Intent intent = new Intent(iniciarsesionActivity.this, crearideasActivity.class);
                    startActivity(intent);
                } else {
                    // Contraseña incorrecta, mostrar mensaje de error
                    Toast.makeText(iniciarsesionActivity.this, "Error de sesión", Toast.LENGTH_SHORT).show();
                }
            }
        });

        showHidePasswordButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (passwordVisible) {
                    // Si la contraseña es visible, ocultarla
                    passwordEditText1.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                    showHidePasswordButton1.setText("Mostrar Contraseña");
                } else {
                    // Si la contraseña está oculta, mostrarla
                    passwordEditText1.setInputType(InputType.TYPE_CLASS_TEXT);
                    showHidePasswordButton1.setText("Ocultar Contraseña");
                }
                passwordVisible = !passwordVisible;

                // Mover el cursor al final del texto para mantener la visibilidad
                passwordEditText1.setSelection(passwordEditText1.getText().length());
            }
        });
    }
}