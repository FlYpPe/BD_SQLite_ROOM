package com.example.bd_sqlite_room;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;

import Entidades.Ordenes;
import baseDatos.RestaurantBD;

public class AtcivityAltas extends ActivityMenu{

    EditText idOrden, fecha, cantidad, tipo, mesero;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_altas);

        fecha = findViewById(R.id.caja_fecham);
        tipo = findViewById(R.id.caja_tipom);
        cantidad = findViewById(R.id.caja_cant);
        idOrden = findViewById(R.id.caja_idordenm);
        mesero = findViewById(R.id.caja_meserom);
    }


    public void agregarRegistro(View v){


        new Thread(new Runnable() {
            @Override
            public void run() {

                if (fecha.getText().toString().trim().equals("")||idOrden.getText().toString().trim().equals("")
                        ||cantidad.getText().toString().trim().equals("")|| tipo.getText().toString().trim().equals("")
                        ||mesero.getText().toString().trim().equals("")){
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(getBaseContext(), "checar informacion", Toast.LENGTH_LONG).show();
                        }
                    });
                }else{
                try {

                        String a = String.valueOf(idOrden.getText());
                    String b = String.valueOf(fecha.getText());
                    int c = Integer.parseInt(String.valueOf(cantidad.getText()));
                    String d = String.valueOf(tipo.getText());
                    String e = String.valueOf(mesero.getText());
                    RestaurantBD bd = RestaurantBD.getAppDatabase((getBaseContext()));
                    bd.OrdenesDao().insertarAlumno(new Ordenes(a,b,c,d,e));

                }catch (Exception e){
                    System.out.println();e.printStackTrace();
                }

                }
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                      //  Toast.makeText(getBaseContext(), "AGREGADO CON EXITO", Toast.LENGTH_LONG).show();
                    }
                });

            }
        }).start();
    }

}
