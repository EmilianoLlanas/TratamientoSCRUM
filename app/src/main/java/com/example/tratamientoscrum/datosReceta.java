package com.example.tratamientoscrum;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class datosReceta extends AppCompatActivity {
    EditText correoDrET, correoPacET,tratamientoET,idCedulaET,diagnosticoET;
    String correoDr, correoPac,tratamiento,idCedula,diagnostico;
    Button botonDatos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos_receta);
    }

    public void pacienteonClick(View view)
    {
        botonDatos=(Button)findViewById(R.id.datosRecetaBtn);

        correoDrET= findViewById(R.id.correoDrConsText);
        correoDr=correoDrET.getText().toString();

        correoPacET =(EditText)findViewById(R.id.correoPacienteText);
        correoPac = correoPacET.getText().toString();

        tratamientoET=(EditText)findViewById(R.id.tratamientoText);
        tratamiento=tratamientoET.getText().toString();

        idCedulaET=(EditText)findViewById(R.id.idCedulaText);
        idCedula=idCedulaET.getText().toString();

        diagnosticoET=(EditText)findViewById(R.id.diagnosticoText);
        diagnostico=diagnosticoET.getText().toString();

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        String URL = "http://10.0.2.2:5000/prescription/";
        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(datosReceta.this,response,Toast.LENGTH_LONG).show();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(datosReceta.this,error.toString(),Toast.LENGTH_LONG).show();
                    }
                }){
            @Override
            protected Map<String,String> getParams(){
                Map<String,String> params = new HashMap<String, String>();
                params.put("medico",correoDr);
                params.put("paciente", correoPac);
                params.put("tratamiento",tratamiento);
                params.put("idCedula",idCedula);
                params.put("diagnostico",diagnostico);
                return params;
            }

        };

        requestQueue.add(stringRequest);
    }

    public void onClickMain(View view) {
        Intent myIntent = new Intent(view.getContext(), pantallaInicio.class);
        startActivity(myIntent);
    }
}