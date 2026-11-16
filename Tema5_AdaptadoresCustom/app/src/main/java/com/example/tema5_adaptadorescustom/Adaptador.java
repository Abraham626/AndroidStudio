package com.example.tema5_adaptadorescustom;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class Adaptador extends ArrayAdapter<Datos> {

    private List<Datos> datos;

    public Adaptador(Context context, List<Datos> datos) {
        super(context, R.layout.elemento, datos);
        this.datos = datos;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        //Localizar su contexto
        LayoutInflater mostrado = LayoutInflater.from(getContext());
        //Inflar el layout
        View elemento = mostrado.inflate(R.layout.elemento, parent, false);
        //Obtener referencias a los elementos del layout personalizado
        TextView text1 = elemento.findViewById(R.id.text1);
        TextView text2 = elemento.findViewById(R.id.text2);
        //Configurar los datos
        text1.setText(datos.get(position).getTexto1());
        text2.setText(datos.get(position).getTexto2());
        return elemento;
    }
}