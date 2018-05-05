package com.ramirez.parcialmoviles;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {


    TextView nombre, cel, correo, direccion, cumple;

    Bundle bund;
    String data = "Vacio";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent getinfo = this.getIntent();
        bund = getinfo.getExtras();

        nombre = findViewById(R.id.nom);
        cel = findViewById(R.id.cel);
       /* correo = findViewById(R.id.correo);
        direccion = findViewById(R.id.dir);
        nombre = findViewById(R.id.nom);
        cumple = findViewById(R.id.cumple);*/

        Datos variable = (Datos) bund.getSerializable("KEY");

        nombre.setText(variable.getNombre());
        cel.setText(variable.getNumero());
        /*direccion.setText(variable.getDireccion());
        correo.setText(variable.getCorreo());
        correo.setText(variable.getCumple());*/
    }


}

