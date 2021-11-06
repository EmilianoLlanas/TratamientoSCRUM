package com.example.tratamientoscrum;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.NetworkResponse;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.HttpHeaderParser;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    EditText nombreET,especialidadET,idCedulaET,edadET,contactoET,correoET,contraseñaET;
    String nombre,especialidad;
    String idCedula;
    String edad;
    String contacto;
    String correo;
    String contraseña;
    Button botonDatos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View view)
    {
        botonDatos=(Button)findViewById(R.id.enviarDatosBtn);

        nombreET= findViewById(R.id.nombreText);
        nombre=nombreET.getText().toString();

        especialidadET=(EditText)findViewById(R.id.especialidadText);
        especialidad=especialidadET.getText().toString();

        idCedulaET=(EditText)findViewById(R.id.cedulaText);
        idCedula=idCedulaET.getText().toString();

        edadET=(EditText)findViewById(R.id.edadText);
        edad=edadET.getText().toString();

        contactoET=(EditText)findViewById(R.id.contactoText);
        contacto=contactoET.getText().toString();

        correoET=(EditText)findViewById(R.id.correoText);
        correo=correoET.getText().toString();

        contraseñaET=(EditText)findViewById(R.id.contraseñaText);
        contraseña=contraseñaET.getText().toString();

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        String URL = "http://10.0.2.2:5000/medic/";
        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(MainActivity.this,response,Toast.LENGTH_LONG).show();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(MainActivity.this,error.toString(),Toast.LENGTH_LONG).show();
                    }
                }){
            @Override
            protected Map<String,String> getParams(){
                Map<String,String> params = new HashMap<String, String>();
                params.put("correo",correo);
                params.put("contraseña",contraseña);
                params.put("nombre",nombre);
                params.put("especialidad",especialidad);
                params.put("id_cedula",idCedula);
                params.put("contraseña",contraseña);
                params.put("edad",edad);
                params.put("numero_contacto",contacto);
                return params;
            }

        };

        requestQueue.add(stringRequest);


    }
}