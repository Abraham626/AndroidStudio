package com.example.tema4;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.graphics.Color;
import android.graphics.Typeface;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.TextView;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);



// AUTOCOMPLETADO
        String[] opciones = {
                "Star Wars",
                "Reservoir dogs",
                "El Club de la lucha",

                "Snatch: Cerdos y Diamantes"
        };
        AutoCompleteTextView textoLeido =
                findViewById(R.id.miTexto);
        ArrayAdapter<String> adaptador = new ArrayAdapter<>(
                this,
                android.R.layout.simple_dropdown_item_1line,
                opciones
        );
        textoLeido.setAdapter(adaptador);

// SPINNER CON PELICULAS
        Spinner miSpinner = findViewById(R.id.miSpinner);
        String[] opcionesSpinner = {
                "Selecciona una película",
                "Star Wars",
                "Reservoir dogs",
                "El Club de la lucha",

                "Snatch: Cerdos y Diamantes"
        };
        ArrayAdapter<String> adaptadorSpinner = new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_item,
                opcionesSpinner
        );
        adaptadorSpinner.setDropDownViewResource(
                android.R.layout.
                        simple_spinner_dropdown_item
        );
        miSpinner.setAdapter(adaptadorSpinner);

// DETECTAR LA SELECCION
        miSpinner.setOnItemSelectedListener(
                new AdapterView.OnItemSelectedListener() {

                    @Override
                    public void onItemSelected(
                            AdapterView<?> parent,
                            View view,
                            int position,
                            long id) {
                        String seleccion =
                                parent.getItemAtPosition(position).toString();
                        Log.d("MI_SPINNER",
                                "Has seleccionado: " + seleccion);
                    }

                    @Override
                    public void onNothingSelected(
                            AdapterView<?> parent) {
                        Log.d("MI_SPINNER",
                                "No has seleccionado nada");
                    }
                });

        RadioGroup radioGroup = findViewById(R.id.radioGroup);
        Button buttonCheck = findViewById(R.id.button_check);
        TextView textViewResult = findViewById(R.id.textViewResult);

        buttonCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                int selectedId = radioGroup.getCheckedRadioButtonId();
                if (selectedId != -1){
                    RadioButton selectedRadioButton = findViewById(selectedId);
                    String selectedOption = selectedRadioButton.getText().toString();
                    textViewResult.setText("Seleccionado: " + selectedOption);
                }else {
                    textViewResult.setText("No se ha seleccionado ninguna opcion");
                }
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        Button boton1 = findViewById(R.id.miToggleButton);
        TextView miTexto = findViewById(R.id.texto);

// ACCION DEL BOTON
        boton1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                miTexto.setText("Se ha pulsado el boton");
            }
        });

// CAMBIAR EL TEXTO
        miTexto.setText("Nuevo texto a mostrar");

// CAMBIAR EL COLOR A AZUL
        miTexto.setTextColor(Color.parseColor("#0000FF"));

// CAMBIAR LA FUENTE Y EL ESTILO
        miTexto.setTypeface(
                Typeface.create(
                        Typeface.SANS_SERIF,
                        Typeface.
                                ITALIC
                )
        );

// CAMBIAR EL TAMAÑO
        miTexto.setTextSize(24);

// CARGAR LA ANIMACION
        Animation miAnimacion = AnimationUtils.loadAnimation(
                this,
                R.anim.
                        animacion
        );
        miAnimacion.setRepeatMode(Animation.RESTART);
        miAnimacion.setRepeatCount(20);
        miTexto.startAnimation(miAnimacion);

        TextView textViewStatus =findViewById(R.id.tv);
        Switch sw =findViewById(R.id.switch1);
        sw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    textViewStatus.setText("Estado: Encendido");
                } else {
                    textViewStatus.setText("Estado: Apagado");
                }
            }
        });
    }


}