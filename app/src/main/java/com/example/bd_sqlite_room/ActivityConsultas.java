package com.example.bd_sqlite_room;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.room.Room;

import java.util.List;

import Entidades.Alumno;
import Entidades.Ordenes;
import baseDatos.EscuelaBD;
import baseDatos.RestaurantBD;

public class ActivityConsultas extends Activity {

    //ListView listAlumnos;
    //List<Alumno> listaAlumnos;
    ListView listOrdenes;
    List<Ordenes> listaOrdenes;
    EditText editable;
    ArrayAdapter<String> adaptador;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultas);

        editable = (EditText) findViewById(R.id.caja_editable);
        listOrdenes = findViewById(R.id.listViewAlumnos);


        editable.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            adaptador.getFilter().filter(s);

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        new Thread(new Runnable() {
            @Override
            public void run() {

                RestaurantBD bd = Room.databaseBuilder(getBaseContext(), RestaurantBD.class, "Restaurant").build();
                listaOrdenes = bd.OrdenesDao().obtenerTodos();


                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        adaptador = new ArrayAdapter(getBaseContext(), android.R.layout.simple_list_item_1,listaOrdenes);
                        listOrdenes.setAdapter(adaptador);
                    }
                });


            }
        }).start();


/*
        try {
            Thread.sleep(1000);
        }catch (Exception e){

        }*/

    }





}
