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
import android.widget.Toast;

public class crearActivity extends AppCompatActivity {
    private EditText passwordEditText;
    private Button showHidePasswordButton;
    private boolean passwordVisible = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_craersesion);

        passwordEditText = findViewById(R.id.editTextTextPassword);
        showHidePasswordButton = findViewById(R.id.showHidePasswordButton);

        // Agregar la funcionalidad del botón "Mostrar Contraseña"
        showHidePasswordButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (passwordVisible) {
                    // Si la contraseña es visible, ocultarla
                    passwordEditText.setInputType(InputType.TYPE_CLASS_TEXT | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                    showHidePasswordButton.setText("");
                } else {
                    // Si la contraseña está oculta, mostrarla
                    passwordEditText.setInputType(InputType.TYPE_CLASS_TEXT);
                    showHidePasswordButton.setText("");
                }
                passwordVisible = !passwordVisible;

                // Mover el cursor al final del texto para mantener la visibilidad
                passwordEditText.setSelection(passwordEditText.getText().length());
            }
        });

        Button btnStart1 = findViewById(R.id.btnstart1);
        btnStart1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText ETNombre = findViewById(R.id.txtescriibirnom1);
                EditText ETClave = findViewById(R.id.editTextTextPassword);

                String txtescriibirnom1 = ETNombre.getText().toString();
                String txtClave = ETClave.getText().toString();

                if (validateNombre(txtescriibirnom1) && validateClave(txtClave)) {
                    // Almacenar la contraseña de manera segura (por ejemplo, en SharedPreferences)
                    SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("password", txtClave);
                    editor.apply();

                    Intent intent = new Intent(crearActivity.this, iniciarsesionActivity.class);
                    intent.putExtra("Nombre", txtescriibirnom1);
                    startActivity(intent);
                } else {
                    Toast.makeText(crearActivity.this, "No cumple con los requisitos de sesión", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    // Función para validar el nombre
    private boolean validateNombre(String nombre) {
        return !nombre.isEmpty() && Character.isUpperCase(nombre.charAt(0));
    }

    // Función para validar la clave
    private boolean validateClave(String clave) {
        // Asegúrate de que la contraseña contenga al menos una letra mayúscula, una letra minúscula y un número.
        return clave.matches(".*[A-Z].*") && clave.matches(".*[a-z].*") && clave.matches(".*\\d.*");
    }
}