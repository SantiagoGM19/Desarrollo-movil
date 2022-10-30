package com.example.agalludo;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Button btnDado1, btnDado2, btnSuma;
    Random random;
    int suma = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        conectar();
        btnSuma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                random = new Random();
                int dado1 = random.nextInt(5) + 1;
                int dado2 = random.nextInt(5) + 1;
                btnDado1.setText(dado1 + "");
                btnDado2.setText(dado2 + "");
                //btnSuma.setText(dado1 + dado2 + "");

                if(dado1 == 1 || dado2 == 1){
                    suma = 0;
                    btnSuma.setText(0 + "");
                    Toast.makeText(getApplicationContext(), "Perdiste", Toast.LENGTH_SHORT).show();
                    if(dado1 == 1){
                        btnDado1.setBackgroundColor(Color.RED);
                    }
                    if(dado2 == 1){
                        btnDado2.setBackgroundColor(Color.RED);
                    }
                }else{
                    btnDado1.setBackgroundColor(Color.rgb(55,0,179));
                    btnDado2.setBackgroundColor(Color.rgb(55,0,179));
                    suma += dado1+dado2;
                    btnSuma.setText(suma + "");
                    if(suma >= 50){
                        Toast.makeText(getApplicationContext(), "Ganaste", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }



    private void conectar() {
        btnDado1 = findViewById(R.id.btnDado1);
        btnDado2 = findViewById(R.id.btnDado2);
        btnSuma = findViewById(R.id.btnSuma);
    }
}