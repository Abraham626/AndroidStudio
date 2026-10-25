package com.example.calculadora_abraham;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private TextView resultado;
    private double valorMemoria = 0;
    private String operacionActual = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resultado = findViewById(R.id.resultado);
        Button boton1 = findViewById(R.id.boton1);
        Button boton2 = findViewById(R.id.boton2);
        Button boton3 = findViewById(R.id.boton3);
        Button boton4 = findViewById(R.id.boton4);
        Button boton5 = findViewById(R.id.boton5);
        Button boton6 = findViewById(R.id.boton6);
        Button boton7 = findViewById(R.id.boton7);
        Button boton8 = findViewById(R.id.boton8);
        Button boton9 = findViewById(R.id.boton9);
        Button boton0 = findViewById(R.id.boton0);
        Button botonAC = findViewById(R.id.botonAC);
        Button botonC = findViewById(R.id.botonC);
        Button botonDividir = findViewById(R.id.botonDividir);
        Button botonMultiplicar = findViewById(R.id.botonMultiplicar);
        Button botonIgual = findViewById(R.id.botonIgual);
        Button botonSumar = findViewById(R.id.botonSumar);
        Button botonRestar = findViewById(R.id.botonRestar);
        Button botonDecimales = findViewById(R.id.botonDecimales);

        boton1.setOnClickListener(v -> agregarDigito("1"));
        boton2.setOnClickListener(v -> agregarDigito("2"));
        boton3.setOnClickListener(v -> agregarDigito("3"));
        boton4.setOnClickListener(v -> agregarDigito("4"));
        boton5.setOnClickListener(v -> agregarDigito("5"));
        boton6.setOnClickListener(v -> agregarDigito("6"));
        boton7.setOnClickListener(v -> agregarDigito("7"));
        boton8.setOnClickListener(v -> agregarDigito("8"));
        boton9.setOnClickListener(v -> agregarDigito("9"));
        boton0.setOnClickListener(v -> agregarDigito("0"));

        botonDecimales.setOnClickListener(v -> agregarDigito("."));

        botonAC.setOnClickListener(v -> resultado.setText("0"));
        botonC.setOnClickListener(v -> borraUltimoNumero());

        botonSumar.setOnClickListener(v -> apretarOperacion("+"));
        botonRestar.setOnClickListener(v -> apretarOperacion("-"));
        botonIgual.setOnClickListener(v -> apretarOperacion("="));
        botonDividir.setOnClickListener(v -> apretarOperacion("/"));
        botonMultiplicar.setOnClickListener(v -> apretarOperacion("*"));

    }

    private void agregarDigito(String digito) {
        String resultadoAnterior = resultado.getText().toString();
        String actual = resultadoAnterior;

        switch (digito) {
            case "0":
                if (!actual.equals("0"))
                    actual += "0";
                break;
            case ",":
                if (!actual.contains(","))
                    actual += ",";
                break;

            // El resto
            default:
                if (actual.equals("0"))
                    actual = digito;
                else
                    actual += digito;
        }

        resultado.setText(actual);
    }

    private void borraUltimoNumero () {
        String actual = resultado.getText().toString();

        if (actual.length() > 1)
            actual = actual.substring(0, actual.length() - 1);
        else
            actual = "0";

        resultado.setText(actual);
    }

    private void apretarOperacion(String operacion) {
        switch (operacion) {
            case "+":
                valorMemoria = Double.parseDouble(resultado.getText().toString());
                operacionActual = "+";
                resultado.setText("0");
                break;
            case "-":
                valorMemoria = Double.parseDouble(resultado.getText().toString());
                operacionActual = "-";
                resultado.setText("0");
                break;
            case "/":
                valorMemoria = Double.parseDouble(resultado.getText().toString());
                operacionActual = "/";
                resultado.setText("0");
                break;
            case "*":
                valorMemoria = Double.parseDouble(resultado.getText().toString());
                operacionActual = "*";
                resultado.setText("0");
                break;
            case "=":
                Double segundoValor = Double.parseDouble(resultado.getText().toString());
                Double actual;
                switch (operacionActual) {
                    case "+":
                        actual = valorMemoria + segundoValor;
                        resultado.setText(actual.toString());
                        operacionActual = "";
                        break;
                    case "-":
                        actual = valorMemoria - segundoValor;
                        resultado.setText(actual.toString());
                        operacionActual = "";
                        break;
                    case "/":
                        actual = valorMemoria / segundoValor;
                        resultado.setText(actual.toString());
                        operacionActual = "";
                        break;
                    case "*":
                        actual = valorMemoria * segundoValor;
                        resultado.setText(actual.toString());
                        operacionActual = "";
                        break;
                }
                break;
        }
    }
}