package com.noxdion.conexionbd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class ingresar extends AppCompatActivity {

    Button btnIr,btnRegistro;
    EditText cajaNom, cajaClave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingresar);

        btnIr = findViewById(R.id.btnIr);
        btnRegistro = findViewById(R.id.btnRegistro);
        cajaNom = findViewById(R.id.cajaNom);
        cajaClave = findViewById(R.id.cajaClave);

        btnIr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nombre = cajaNom.getText().toString();
                String contrasenha = cajaClave.getText().toString();
                validarUsuario("https://obrigadocara.000webhostapp.com/ingresar.php", nombre, contrasenha);
            }
        });

        btnRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), insertar.class);
                startActivity(intent);
            }
        });

    }

    private void validarUsuario(String URL, final String nombre, final String contrasenha) {
        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if (!response.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Mensaje: " + response, Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(), reservar.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(ingresar.this, "Nombre o contrasenha incorrecta", Toast.LENGTH_SHORT).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(ingresar.this, error.toString(), Toast.LENGTH_SHORT).show();
            }
        }) {

            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> parametros = new HashMap<String, String>();
                parametros.put("nombre", nombre);
                parametros.put("contrasenha", contrasenha);
                return parametros;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }
}