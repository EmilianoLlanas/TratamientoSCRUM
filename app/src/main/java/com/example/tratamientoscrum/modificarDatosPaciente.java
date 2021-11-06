package com.example.tratamientoscrum;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class modificarDatosPaciente extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modificar_datos_paciente);
    }
    public void onClickMain(View view) {
        Intent myIntent = new Intent(view.getContext(), pantallaInicio.class);
        startActivity(myIntent);
    }
}