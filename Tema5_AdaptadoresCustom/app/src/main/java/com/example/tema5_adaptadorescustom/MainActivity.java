package com.example.tema5_adaptadorescustom;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        EdgeToEdge.enable(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Datos> datos = new ArrayList<>();
        datos.add(new Datos("España", "Madrid"));
        datos.add(new Datos("Francia", "Paris"));
        datos.add(new Datos("Italia", "Roma"));
        ListView listado = findViewById(R.id.listView);
        Adaptador miAdaptador = new Adaptador(this, datos);
        View miCabecera = getLayoutInflater().inflate(R.layout.cabecera, null);
        listado.addHeaderView(miCabecera);
        listado.setAdapter(miAdaptador);

        listado.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedItem = ((Datos) parent.getItemAtPosition(position)).getTexto1();
                Toast.makeText(MainActivity.this, "Elemento pulsado: " + selectedItem, Toast.LENGTH_SHORT).show();
            }
        });
    }
}