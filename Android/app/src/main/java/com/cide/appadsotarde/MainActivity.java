package com.cide.appadsotarde;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

Button btnIr;
EditText cajaNombre, cajaClave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Control
        btnIr = findViewById(R.id.btnIr);
        cajaNombre = findViewById(R.id.cajaNombre);
        cajaClave = findViewById(R.id.cajaClave);

        btnIr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Toast.makeText(MainActivity.this, "Welcome to the Madness", Toast.LENGTH_SHORT).show();

                String miNombre = cajaNombre.getText().toString();
                String miClave = cajaClave.getText().toString();

                Toast.makeText(MainActivity.this, "mi nombre: " + miNombre + "\nmi clave: " + miClave, Toast.LENGTH_SHORT).show();

                startActivity(new Intent(MainActivity.this, MenuPrincipal.class));

            }
        });
    }
}