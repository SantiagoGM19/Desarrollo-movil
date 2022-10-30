package com.example.intentos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class Pantalla2 extends AppCompatActivity {

    TextView tvInformacion;
    ArrayList<String> Mistery2 = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla2);

        tvInformacion = findViewById(R.id.tvInformacion);
        Bundle paqueteInfo = getIntent().getExtras();
        if(paqueteInfo != null){
            Mistery2 = paqueteInfo.getStringArrayList("Informacion");
            //tvInformacion.setText(paqueteInfo.getStringArrayList("Mi_Variable").get(0));
            String nombre = Mistery2.get(0);
            String telefono = Mistery2.get(1);
            String direccion = Mistery2.get(2);
            tvInformacion.setText(nombre + telefono + direccion);

        }
    }
}