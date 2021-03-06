package com.example.bd_sqlite_room;

import android.app.Activity;
import android.os.Bundle;
import android.os.Looper;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;

import Entidades.Ordenes;
import baseDatos.EscuelaBD;
import baseDatos.RestaurantBD;

public class ActivityModificaciones extends Activity {

    EditText idOrden, fecha, cantidad, tipo, meserom;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modificaciones);

        fecha = findViewById(R.id.caja_fecham);
        tipo = findViewById(R.id.caja_tipom);
        cantidad = findViewById(R.id.caja_cantidadm);
        idOrden = findViewById(R.id.caja_idordenm);
        meserom = findViewById(R.id.caja_meserom);



    }

    public void refrescar(View v){

        meserom.setText(" ");
        fecha.setText(" ");
        tipo.setText(" ");

        new Thread(new Runnable() {
            @Override
            public void run() {

                if (fecha.getText().toString().trim().equals("")||idOrden.getText().toString().trim().equals("")
                        ||cantidad.getText().toString().trim().equals("")|| tipo.getText().toString().trim().equals("")
                        ||meserom.getText().toString().trim().equals("")){
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            Toast.makeText(getBaseContext(), "checar informacion", Toast.LENGTH_LONG).show();
                        }
                    });
                }else{




                try {



                    String b = String.valueOf(idOrden.getText());
                    RestaurantBD bd = RestaurantBD.getAppDatabase(getBaseContext());
                    Ordenes ord = bd.OrdenesDao().obtenerUno(b);
                    String c = String.valueOf(ord.getFecha());
                    String d = String.valueOf(ord.getCantidad());
                    String e = String.valueOf(ord.getTipoPago());
                    String f = String.valueOf(ord.getIdMesero());

                    cantidad.setText(d);
                    meserom.setText(f);
                    fecha.setText(c);
                    tipo.setText(e);






                    //nombre.setText(alum.getNombre());

                }catch (Exception e){
                    e.printStackTrace();
                }

                }

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
                String b = String.valueOf(idOrden.getText());
                RestaurantBD bd = RestaurantBD.getAppDatabase(getBaseContext());
                String c = String.valueOf(fecha.getText());
                String d = String.valueOf(cantidad.getText());
                String e = String.valueOf(tipo.getText());
                String f = String.valueOf(meserom.getText());
                bd.OrdenesDao().modificarPoridOrden(b,c,d,e,f);

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
