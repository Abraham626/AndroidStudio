package com.example.gestiondecuentaabraham;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    AutoCompleteTextView autoCompleteCamarero;
    EditText editTextTotal;
    CheckBox checkBoxPropina;
    TextView textViewPorcentaje;
    SeekBar seekBarPropina;
    RadioGroup radioGroupPago;
    RatingBar ratingBar;
    Button buttonCalcular;
    TextView textViewResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        autoCompleteCamarero = findViewById(R.id.autoCompleteCamarero);
        editTextTotal = findViewById(R.id.editTextTotal);
        checkBoxPropina = findViewById(R.id.checkBoxPropina);
        textViewPorcentaje = findViewById(R.id.textViewPorcentaje);
        seekBarPropina = findViewById(R.id.seekBarPropina);
        radioGroupPago = findViewById(R.id.radioGroupPago);
        ratingBar = findViewById(R.id.ratingBar);
        buttonCalcular = findViewById(R.id.buttonCalcular);
        textViewResultado = findViewById(R.id.textViewResultado);

        String[] camareros = {"Abraham", "Maria", "Hugo", "Sandra", "Antonio"};
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, camareros);
        autoCompleteCamarero.setAdapter(adaptador);

        /* En esto me he ayudado de la IA ya que no sabia que el OnSeekBarChangeListener obliga a poner sus 3 métodos aunque no se usen todos.
        onProgressChanged se ejecuta al mover la barra y es el que actualiza el porcentaje.
        onStartTrackingTouch (al tocar la barra) y onStopTrackingTouch (al soltarla) se dejan vacíos porque no hace falta hacer nada ahí, pero si se borran da error
       */
        seekBarPropina.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                textViewPorcentaje.setText(getString(R.string.propina) + " " + progress + "%");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

        buttonCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String texto = editTextTotal.getText().toString();

                if (texto.isEmpty()) {
                    textViewResultado.setTextColor(Color.RED);
                    textViewResultado.setText(getString(R.string.error_vacio));
                    return;
                }

                if (texto.equals(".")) {
                    textViewResultado.setTextColor(Color.RED);
                    textViewResultado.setText(getString(R.string.error_formato));
                    return;
                }

                double cuenta = Double.parseDouble(texto);

                if (cuenta <= 0) {
                    textViewResultado.setTextColor(Color.RED);
                    textViewResultado.setText(getString(R.string.error_minimo));
                    return;
                }

                double propina = 0;

                if (checkBoxPropina.isChecked()) {
                    propina = cuenta * seekBarPropina.getProgress() / 100;
                }

                int selectedId = radioGroupPago.getCheckedRadioButtonId();

                if (selectedId == -1) {
                    textViewResultado.setTextColor(Color.RED);
                    /*
                    E esto he usado IA porque en los mensajes de alerta de color rojo no me lo
                    traducía al English y siempre estaba en español y no sabía solucionarlo entonces
                    le pedí a la IA que me lo explicara
                     */
                    textViewResultado.setText(getString(R.string.error_pago));
                    return;
                }

                RadioButton selectedRadioButton = findViewById(selectedId);
                String pago = selectedRadioButton.getText().toString();

                textViewResultado.setTextColor(Color.BLACK);
                /*
                he usado IA para que redondear a dos decimales porque con algunos números el total sale con muchos decimales y no sabía arreglarlo.
                */
                textViewResultado.setText(getString(R.string.total) + " " + String.format("%.2f", cuenta + propina) + " € - " + getString(R.string.pago) + " " + pago + " - " + getString(R.string.calificacion) + " " + ratingBar.getRating());            }
        });
    }
}