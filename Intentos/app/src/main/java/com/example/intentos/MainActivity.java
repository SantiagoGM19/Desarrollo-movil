package com.example.intentos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnPantalla1, btnPantalla2, btnPantalla3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        conectar();
        String Mistery = "despues del ultimo no hay nadie";
        //Implementar Intent

        btnPantalla1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent IMainToP1 = new Intent(getApplicationContext(), Pantalla1.class);
                startActivity(IMainToP1);
            }
        });

        btnPantalla2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent IMainToP2 = new Intent(getApplicationContext(), Pantalla2.class);
                //IMainToP2.putExtra("Mi_Variable", Mistery);
                startActivity(IMainToP2);
            }
        });

        btnPantalla3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent IMainToP3 = new Intent(getApplicationContext(), Pantalla3.class);
                startActivity(IMainToP3);
            }
        });
    }

    private void conectar() {
        btnPantalla1 = findViewById(R.id.btnP1);
        btnPantalla2 = findViewById(R.id.btnP2);
        btnPantalla3 = findViewById(R.id.btnP3);
    }
}