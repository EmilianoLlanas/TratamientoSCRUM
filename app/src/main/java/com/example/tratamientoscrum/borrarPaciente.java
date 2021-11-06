package com.example.tratamientoscrum;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
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

public class borrarPaciente extends AppCompatActivity {

    EditText correoET;
    String correo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_borrar_paciente);
    }
    public void deleteOnClick(View view)
    {

        correoET =(EditText)findViewById(R.id.pacienteDCorreoText);
        correo = correoET.getText().toString();

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        String URL = "http://10.0.2.2:5000/patient/?correo="+correo;
        StringRequest stringRequest = new StringRequest(Request.Method.DELETE, URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(borrarPaciente.this,response,Toast.LENGTH_LONG).show();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(borrarPaciente.this,error.toString(),Toast.LENGTH_LONG).show();
                    }
                }){


        };

        requestQueue.add(stringRequest);
    }

    public void onClickMain(View view) {
        Intent myIntent = new Intent(view.getContext(), pantallaInicio.class);
        startActivity(myIntent);
    }




}