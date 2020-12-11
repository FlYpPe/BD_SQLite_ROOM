package com.example.bd_sqlite_room;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;

import baseDatos.RestaurantBD;

public class ActivityBajas extends Activity {
    EditText nombre, num;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bajas);
        //nombre = findViewById(R.id.caja_nombre);

        //String a = String.valueOf(nombre.getText());

        num = findViewById(R.id.idor);
    }

    public void eliminarRegistro(View v){


        new Thread(new Runnable() {
            @Override
            public void run() {
                RestaurantBD bd = RestaurantBD.getAppDatabase(getBaseContext());
                String b = String.valueOf(num.getText());

                /*-----------------------------------------------------------------------------
                            PRUEBA QUE NO DEBERIA IR AQUI
                 ------------------------------------------------------------------------------- */
                try {
                    bd.OrdenesDao().eliminarPoridOrden(b);
                }catch (Exception e){

                }

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(getBaseContext(), "ELIMINADO CON EXITO", Toast.LENGTH_LONG).show();
                    }
                });

            }
        }).start();
    }


}
