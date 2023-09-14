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

public class crearReserva extends AppCompatActivity {

    Button btnReservar;

    EditText cajaIdHabitacion, cajaDoc, cajaCantPersonas, cajaFechaIngreso, cajaFechaSalida;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crear_reserva);

        cajaIdHabitacion = findViewById(R.id.cajaIdHabitacion);
        cajaDoc = findViewById(R.id.cajaDoc);
        cajaCantPersonas = findViewById(R.id.cajaCantPersonas);
        cajaFechaIngreso = findViewById(R.id.cajaFechaIngreso);
        cajaFechaSalida = findViewById(R.id.cajaFechaSalida);

        btnReservar = findViewById(R.id.btnReservar);

        btnReservar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                creaReserva("https://obrigadocara.000webhostapp.com/reservar.php");
            }
        });
    }

    private void creaReserva(String URL) {
        StringRequest stringRequest = new StringRequest(Request.Method.POST,URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(getApplicationContext(), "Reserva correctamente realizada", Toast.LENGTH_SHORT).show();

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

                parametros.put("id_habitacion", cajaIdHabitacion.getText().toString());
                parametros.put("documento", cajaDoc.getText().toString());
                parametros.put("cant_personas", cajaCantPersonas.getText().toString());
                parametros.put("fecha_ingreso", cajaFechaIngreso.getText().toString());
                parametros.put("fecha_salida", cajaFechaSalida.getText().toString());
                return parametros;
            }
        };
        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

}