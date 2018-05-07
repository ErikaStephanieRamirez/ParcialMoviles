package com.ramirez.parcialmoviles;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;
import java.io.FileOutputStream;

public class Main2Activity extends AppCompatActivity {


    TextView nombre, cel, correo, direccion, cumple;

    ImageView llamar;
    ImageView enviar;
    ImageView editar;

    Bundle bund;
    String data = "Vacio";
    de.hdodenhof.circleimageview.CircleImageView share;

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

        llamar = findViewById(R.id.llamar);
        enviar = findViewById(R.id.enviar);
        editar = findViewById(R.id.editar);
        share=(de.hdodenhof.circleimageview.CircleImageView)findViewById(R.id.pic);

        final Datos variable = (Datos) bund.getSerializable("KEY");

        nombre.setText(variable.getNombre());
        cel.setText(variable.getNumero());
        /*direccion.setText(variable.getDireccion());
        correo.setText(variable.getCorreo());
        correo.setText(variable.getCumple());*/

        llamar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (variable.getNumero() != null) {

                    //Comprobación, Se requiere permiso para Marshmallow en adelante
                    if (ContextCompat.checkSelfPermission(Main2Activity.this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                        ActivityCompat.requestPermissions(Main2Activity.this, new String[]{Manifest.permission.CALL_PHONE}, 7);
                    } else {
                        Intent call = new Intent(Intent.ACTION_CALL);
                        call.setData(Uri.parse("tel:" + variable.getNumero()));
                        startActivity(call);
                    }
                }
            }
        });

        editar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    Log.d("tag","selecciono editar");

            }
        });

        enviar.setOnClickListener(new View.OnClickListener() {
            private String externalCacheDir;

            public String getExternalCacheDir() {
                return externalCacheDir;
            }

            @Override
            public void onClick(View v) {
                Log.d("tag", "selecciono enviar");
                Enviar(v);
            }
        });
    }


    public void Enviar(View view) {

        Bitmap BitM;

        BitM = getBitmapFromView(share);

        try {
            File file = new File(this.getExternalCacheDir(), "Contacto.png");
            FileOutputStream Ou = new FileOutputStream(file);
            BitM.compress(Bitmap.CompressFormat.PNG, 100, Ou);
            Ou.flush();
            Ou.close();
            file.setReadable(true, false);
            final Intent intent = new Intent(Intent.ACTION_SEND);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            intent.putExtra(Intent.EXTRA_STREAM, Uri.fromFile(file));
            intent.putExtra(Intent.EXTRA_TEXT, "Contacto...\nNombre: " + nombre.getText() + "\nTelefono: " + cel.getText());
            intent.setType("*/*");
            startActivity(Intent.createChooser(intent, "Enviar a"));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private Bitmap getBitmapFromView(View view) {

        Bitmap Result = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas One = new Canvas(Result);
        Drawable Background = view.getBackground();

        if (Background != null)
            Background.draw(One);

        else
            One.drawColor(Color.WHITE);

        view.draw(One);
        return Result;
    }
}
