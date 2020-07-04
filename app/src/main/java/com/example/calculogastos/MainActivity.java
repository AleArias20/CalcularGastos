package com.example.calculogastos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText editNombre;
    private EditText editPuntoSalida;
    private EditText editPuntoLlegada;
    private EditText editHoraSalida;
    private EditText editCostoGasolina;
    private EditText editDistancia;
    private EditText editTiempoLlegada;
    private EditText editCostoViaje;
    private Button btnCalcular;

    private void iniciar (){
        editNombre =(EditText)findViewById(R.id.editNombre);
        editPuntoSalida = (EditText)findViewById(R.id.editPuntoSalida);
        editPuntoLlegada = (EditText)findViewById(R.id.editPuntoLlegada);
        editHoraSalida = (EditText)findViewById(R.id.editHoraSalida);
        editCostoGasolina = (EditText) findViewById(R.id.editCostoGasolina);
        editDistancia = (EditText)findViewById(R.id.editDistancia);

        editTiempoLlegada = (EditText) findViewById(R.id.editTiempoLLegada);
        editCostoViaje = (EditText) findViewById(R.id.editCostoViaje);
        btnCalcular = (Button)findViewById(R.id.btnCalcular);

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                costoTiempo();
            }
        });

    }

    private void costoTiempo(){
        int distancia = Integer.parseInt(editDistancia.getText().toString());

        int segundos = (distancia * 3600)/100;
        int horas = segundos /3600;
        int minutos = (segundos - horas * 3600) / 60;
        int total = segundos - horas *3600 - minutos *60;

        int gasolina = Integer.parseInt(editCostoGasolina.getText().toString());
        int kilometros = Integer.parseInt(editDistancia.getText().toString());

        int rendGasolina = 12;
        int costo = (kilometros / rendGasolina) * gasolina;

        editTiempoLlegada.setText(String.valueOf(horas + " Horas " + minutos +" Minutos " + total + " Segundos" ));
        editCostoViaje.setText(String.valueOf("$ " + costo + ".00"));
    }





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        iniciar();
    }
}