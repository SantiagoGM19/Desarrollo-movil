package com.example.intentos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class Pantalla1 extends AppCompatActivity {

    EditText etNombre, etTelefono, etDireccion;
    Button btnEnviarInfo;

    String nombre, telefono, direccion;

    ArrayList<String> informacion = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla1);
        conectar();
        btnEnviarInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nombre = etNombre.getText().toString();
                telefono = etTelefono.getText().toString();
                direccion = etDireccion.getText().toString();

                informacion.add(nombre);
                informacion.add(telefono);
                informacion.add(direccion);
                Intent P1ToP2 = new Intent(getApplicationContext(), Pantalla2.class);
                P1ToP2.putExtra("Informacion", informacion);
                startActivity(P1ToP2);
            }
        });
    }

    private void conectar() {
        etNombre = findViewById(R.id.etNombre);
        etTelefono = findViewById(R.id.etTelefono);
        etDireccion = findViewById(R.id.etDireccion);
        btnEnviarInfo = findViewById(R.id.btnEnviarInfo);
    }
}