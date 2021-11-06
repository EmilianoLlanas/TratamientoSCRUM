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

public class datosPaciente extends AppCompatActivity {

    EditText nombreET, correoET,numeroSSET,polizaSSET;
    String nombre, correo,numeroSS,polizaSS;
    Button botonDatos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos_paciente);
    }

    public void pacienteonClick(View view)
    {
        botonDatos=(Button)findViewById(R.id.pacienteEliminarBtn);

        nombreET= findViewById(R.id.pacienteNameText);
        nombre=nombreET.getText().toString();

        correoET =(EditText)findViewById(R.id.pacienteDCorreoText);
        correo = correoET.getText().toString();

        numeroSSET=(EditText)findViewById(R.id.numeroSSText);
        numeroSS=numeroSSET.getText().toString();

        polizaSSET=(EditText)findViewById(R.id.polizaSeguroText);
        polizaSS=polizaSSET.getText().toString();

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        String URL = "http://10.0.2.2:5000/patient/";
        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(datosPaciente.this,response,Toast.LENGTH_LONG).show();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(datosPaciente.this,error.toString(),Toast.LENGTH_LONG).show();
                    }
                }){
            @Override
            protected Map<String,String> getParams(){
                Map<String,String> params = new HashMap<String, String>();
                params.put("nombre",nombre);
                params.put("correo", correo);
                params.put("numeroSeguroSocial",numeroSS);
                params.put("polizaSeguroSocial",polizaSS);
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