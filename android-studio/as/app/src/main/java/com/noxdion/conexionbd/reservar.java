package com.noxdion.conexionbd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class reservar extends AppCompatActivity {

    Button btnIr1, btnIr2, btnIr3, btnIr4, btnIr5;
    Button[] buttons = new Button[5];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservar);

        btnIr1 = findViewById(R.id.btnIr1);
        btnIr2 = findViewById(R.id.btnIr2);
        btnIr3 = findViewById(R.id.btnIr3);
        btnIr4 = findViewById(R.id.btnIr4);
        btnIr5 = findViewById(R.id.btnIr5);

        buttons[0] = btnIr1;
        buttons[1] = btnIr2;
        buttons[2] = btnIr3;
        buttons[3] = btnIr4;
        buttons[4] = btnIr5;

        final Class<?>[] activities = {
                crearReserva.class,
                crearReserva.class,
                crearReserva.class,
                crearReserva.class,
                crearReserva.class
        };

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int index = -1;
                for (int i = 0; i < buttons.length; i++) {
                    if (v == buttons[i]) {
                        index = i;
                        break;
                    }
                }

                if (index != -1) {
                    if (index < activities.length) {
                        Intent intent = new Intent(getApplicationContext(), activities[index]);
                        startActivity(intent);
                    }
                }
            }
        };

        for (Button button : buttons) {
            button.setOnClickListener(listener);
        }
    }
}

