package com.example.tratamientoscrum;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class pantallaInicio extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pantalla_inicio);
    }

    public void onClickRegistroDR(View view) {
        Intent myIntent = new Intent(view.getContext(), MainActivity.class);
        startActivity(myIntent);
    }
    public void onClickRegistroPaciente(View view) {
        Intent myIntent = new Intent(view.getContext(), datosPaciente.class);
        startActivity(myIntent);
    }
    public void onClickModifyPaciente(View view) {
        Intent myIntent = new Intent(view.getContext(), modificarDatosPaciente.class);
        startActivity(myIntent);
    }
    public void onClickBorrarPaciente(View view) {
        Intent myIntent = new Intent(view.getContext(), borrarPaciente.class);
        startActivity(myIntent);
    }
    public void onClickReceta(View view) {
        Intent myIntent = new Intent(view.getContext(), datosReceta.class);
        startActivity(myIntent);
    }

    public void onClickPacientesDr(View view) {
        Intent myIntent = new Intent(view.getContext(), consultarPacientesDr.class);
        startActivity(myIntent);
    }
}