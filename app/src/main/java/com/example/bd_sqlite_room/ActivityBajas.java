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
                //EscuelaBD bd = Room.databaseBuilder(getBaseContext(),EscuelaBD.class, "escuela").build();
                //EscuelaBD bd = EscuelaBD.getAppDatabase(getBaseContext());
                RestaurantBD bd = RestaurantBD.getAppDatabase(getBaseContext());
                //bd.alumnoDao().insertarAlumno(new Alumno("05", "Luke"));
                //String a = String.valueOf(nombre.getText());
                String b = String.valueOf(num.getText());

                /*-----------------------------------------------------------------------------
                            PRUEBA QUE NO DEBERIA IR AQUI
                 ------------------------------------------------------------------------------- */
                try {
                    bd.OrdenesDao().eliminarPoridOrden(b);
                    //bd.alumnoDao().eliminarPorNumControl(b);
                }catch (Exception e){

                }

                //bd.alumnoDao().modificarPorNumControl("01", "SALVATORE");
                /*-----------------------------------------------------------------------------
                            PRUEBA QUE NO DEBERIA IR AQUI
                 ------------------------------------------------------------------------------- */
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
