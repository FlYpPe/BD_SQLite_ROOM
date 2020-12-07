package com.example.bd_sqlite_room;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;

import Entidades.Alumno;
import baseDatos.EscuelaBD;

public class ActivityModificaciones extends Activity {

    EditText num, nombre;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modificaciones);

        nombre = findViewById(R.id.caja_nombre);
        num = findViewById(R.id.caja_num_control);


    }

    public void refrescar(View v){

        new Thread(new Runnable() {
            @Override
            public void run() {
                //EscuelaBD bd = Room.databaseBuilder(getBaseContext(),EscuelaBD.class, "escuela").build();


                try {

                    String b = String.valueOf(num.getText());

                    EscuelaBD bd = EscuelaBD.getAppDatabase(getBaseContext());

                    Alumno alum = bd.alumnoDao().obtenerUno(b);

                    nombre.setText(alum.getNombre());

                }catch (Exception e){

                }



                //bd.alumnoDao().modificarPorNumControl("01", "SALVATORE");
                /*-----------------------------------------------------------------------------
                            PRUEBA QUE NO DEBERIA IR AQUI
                 ------------------------------------------------------------------------------- */
                //bd.alumnoDao().eliminarPorNumControl("04");

                /*-----------------------------------------------------------------------------
                            PRUEBA QUE NO DEBERIA IR AQUI
                 ------------------------------------------------------------------------------- */
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(getBaseContext(), "REFRESCADO CON EXITO", Toast.LENGTH_LONG).show();
                    }
                });

            }
        }).start();

    }


    public void modificarRegistro(View v){


        new Thread(new Runnable() {
            @Override
            public void run() {
                //EscuelaBD bd = Room.databaseBuilder(getBaseContext(),EscuelaBD.class, "escuela").build();

                String a = String.valueOf(num.getText());
                String b = String.valueOf(nombre.getText());

                EscuelaBD bd = EscuelaBD.getAppDatabase(getBaseContext());

                bd.alumnoDao().modificarPorNumControl(a, b);
                /*-----------------------------------------------------------------------------
                            PRUEBA QUE NO DEBERIA IR AQUI
                 ------------------------------------------------------------------------------- */
                //bd.alumnoDao().eliminarPorNumControl("04");

                /*-----------------------------------------------------------------------------
                            PRUEBA QUE NO DEBERIA IR AQUI
                 ------------------------------------------------------------------------------- */
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(getBaseContext(), "AGREGADO CON EXITO", Toast.LENGTH_LONG).show();
                    }
                });

            }
        }).start();
    }


}
