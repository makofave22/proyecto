package com.uni.trabajo.proyecto;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button calculadora;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*calculadora=(Button)findViewById(R.id.btnCalculadora);
        calculadora.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intetCalcu = new Intent(MainActivity.this, CalculadoraActivity.class);
                startActivity(intetCalcu);

            }
        });*/


    }
}
