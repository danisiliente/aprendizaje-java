package com.noxdion.conexionbd;

import androidx.annotation.Nullable;
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
/*import com.noxdion.conexionbd.MainActivity;*/

import java.util.HashMap;
import java.util.Map;

public class insertar extends AppCompatActivity {

    Button btnRegistrar;

    EditText cajaDocumento, cajaNombre, cajaContrasenha, cajaTelefono, cajaCorreo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insertar);

        cajaDocumento = findViewById(R.id.cajaDocumento);
        cajaNombre = findViewById(R.id.cajaNombre);
        cajaContrasenha = findViewById(R.id.cajaContrasenha);
        cajaTelefono = findViewById(R.id.cajaTelefono);
        cajaCorreo = findViewById(R.id.cajaCorreo);

        btnRegistrar = findViewById(R.id.btnRegistrar);

        btnRegistrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                insertarUsuario("https://obrigadocara.000webhostapp.com/insert.php");
            }
        });
    }

    private void insertarUsuario(String URL) {
        StringRequest stringRequest = new StringRequest(Request.Method.POST,URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(getApplicationContext(), "Insercion correctamente realizada", Toast.LENGTH_SHORT).show();

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(getApplicationContext(), "Se ha identificado un error", Toast.LENGTH_SHORT).show();
            }
        }) {
            @Nullable
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {

                Map<String, String> parametros = new HashMap<String, String>();

                parametros.put("documento", cajaDocumento.getText().toString());
                parametros.put("nombre", cajaNombre.getText().toString());
                parametros.put("contrasenha", cajaContrasenha.getText().toString());
                parametros.put("telefono", cajaTelefono.getText().toString());
                parametros.put("correo", cajaCorreo.getText().toString());
                return parametros;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }
}