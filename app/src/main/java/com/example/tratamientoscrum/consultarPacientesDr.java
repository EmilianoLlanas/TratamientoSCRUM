package com.example.tratamientoscrum;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class consultarPacientesDr extends AppCompatActivity {
    EditText correoDrET;
    TextView tV;
    String correoDr;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultar_pacientes);
    }


    public void pacienteonClick(View view)
    {
        correoDrET= findViewById(R.id.correoDrConsText);
        correoDr=correoDrET.getText().toString();

        tV=(TextView)findViewById(R.id.consultaText);


        RequestQueue requestQueue = Volley.newRequestQueue(this);
        String URL = "http://10.0.2.2:5000/patients-of-medic/?correo="+correoDr;
        JsonObjectRequest jsObjRequest = new JsonObjectRequest
                (Request.Method.GET, URL, null, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {

                        try {
                            JSONArray jsonArray = response.getJSONArray("data");
                            JSONObject jsonObject = jsonArray.getJSONObject(0);
                            String email = jsonObject.getString("email");
                            tV.setText("Response: " + email);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // TODO Auto-generated method stub

                    }
                });

        requestQueue.add(jsObjRequest);
    }

    public void onClickMain(View view) {
        Intent myIntent = new Intent(view.getContext(), pantallaInicio.class);
        startActivity(myIntent);
    }
}