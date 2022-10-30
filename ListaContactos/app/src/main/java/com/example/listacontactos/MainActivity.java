package com.example.listacontactos;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Comparator;

public class MainActivity extends AppCompatActivity {

    EditText etNombre, etApellido, etCorreo, etEstatura;
    Button btnAdd, btnVerMayoresAlPromedio, btnMostrarTodos;
    ListView lvContactos;
    TextView tvPromedio;

    ArrayList<String> misContactos = new ArrayList<>();
    ArrayList<Contacto> objetosContactos = new ArrayList<>();
    ArrayAdapter adapter;
    String strNombre, strApellido, strCorreo;
    int intEstatura;
    Integer estaturaPromedio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        conectar();

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View view) {
                strNombre = etNombre.getText().toString();
                strApellido = etApellido.getText().toString();
                strCorreo = etCorreo.getText().toString();
                intEstatura = Integer.parseInt(etEstatura.getText().toString());
                Contacto nuevoContacto = new Contacto(strNombre, strApellido, strCorreo, intEstatura);
                objetosContactos.add(nuevoContacto);
                ordenarPorEstatura();
                misContactos.clear();
                for (Contacto contacto: objetosContactos) {
                    misContactos.add(contacto.toString());
                }
                estaturaPromedio = calcularPromedio();
                tvPromedio.setText("Estatura promedio: " + estaturaPromedio+" CM");
                adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, misContactos);
                lvContactos.setAdapter(adapter);
                Toast.makeText(getApplicationContext(), "Contacto agregado", Toast.LENGTH_SHORT).show();
            }
        });

        btnVerMayoresAlPromedio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mostrarMayoresAlPromedio();
                btnMostrarTodos.setVisibility(View.VISIBLE);
            }
        });

        btnMostrarTodos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mostrarTodosLosContactos();
                btnMostrarTodos.setVisibility(View.GONE);
            }
        });

        lvContactos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                misContactos.remove(i);
                objetosContactos.remove(i);
                if(!objetosContactos.isEmpty()){
                    estaturaPromedio = calcularPromedio();
                    tvPromedio.setText("Estatura promedio: " + estaturaPromedio+" CM");
                }else{
                    tvPromedio.setText("Estatura promedio: 0 CM");
                }
                adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, misContactos);
                lvContactos.setAdapter(adapter);
            }
        });
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    private void ordenarPorEstatura(){
        objetosContactos.sort(Comparator.comparing(Contacto::getIntEstatura).reversed());
    }

    private Integer calcularPromedio(){
        Integer suma = 0;
        for (Contacto contacto : objetosContactos) {
            suma += contacto.getIntEstatura();
        }
        return suma/objetosContactos.size();
    }

    private void mostrarMayoresAlPromedio(){
        ArrayList<String> contactosMayoresAlpromedio = new ArrayList<>();
        for (Contacto contacto: objetosContactos) {
            if(contacto.getIntEstatura() > estaturaPromedio){
                contactosMayoresAlpromedio.add(contacto.toString());
            }
        }
        adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, contactosMayoresAlpromedio);
        lvContactos.setAdapter(adapter);
    }

    private void mostrarTodosLosContactos(){
        adapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, misContactos);
        lvContactos.setAdapter(adapter);
    }

    private void conectar() {
        etNombre = findViewById(R.id.etNombre);
        etApellido = findViewById(R.id.etApellido);
        etCorreo = findViewById(R.id.etCorreo);
        etEstatura = findViewById(R.id.etEstatura);
        btnAdd = findViewById(R.id.btnAdd);
        btnVerMayoresAlPromedio = findViewById(R.id.btnVerMayoresAlPromedio);
        btnMostrarTodos = findViewById(R.id.btnMostrarTodos);
        lvContactos = findViewById(R.id.lvContactos);
        tvPromedio = findViewById(R.id.tvPromedio);
    }


}