package com.example.bd_sqlite_room;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;

import Entidades.Alumno;
import baseDatos.EscuelaBD;

public class AtcivityAltas extends ActivityMenu{

    EditText nombre, num;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_altas);

        nombre = findViewById(R.id.caja_nombre);

        //String a = String.valueOf(nombre.getText());

        num = findViewById(R.id.caja_num_control);

    }


    public void agregarRegistro(View v){


        new Thread(new Runnable() {
            @Override
            public void run() {
                //EscuelaBD bd = Room.databaseBuilder(getBaseContext(),EscuelaBD.class, "escuela").build();
                String a = String.valueOf(nombre.getText());
                String b = String.valueOf(num.getText());
                EscuelaBD bd = EscuelaBD.getAppDatabase(getBaseContext());
                bd.alumnoDao().insertarAlumno(new Alumno(a, b));

                /*-----------------------------------------------------------------------------
                            PRUEBA QUE NO DEBERIA IR AQUI
                 ------------------------------------------------------------------------------- */
                //bd.alumnoDao().eliminarPorNumControl("04");
                //bd.alumnoDao().modificarPorNumControl("01", "SALVATORE");
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
