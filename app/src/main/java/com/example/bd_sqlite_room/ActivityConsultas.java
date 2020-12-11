package com.example.bd_sqlite_room;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.room.Room;

import java.util.List;

import Entidades.Alumno;
import Entidades.Ordenes;
import baseDatos.EscuelaBD;
import baseDatos.RestaurantBD;

public class ActivityConsultas extends Activity {
    ListView listAlumnos;
    List<Alumno> listaAlumnos;
    ListView listOrdenes;
    List<Ordenes> listaOrdenes;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultas);
        new Thread(new Runnable() {
            @Override
            public void run() {

                //EscuelaBD bd = Room.databaseBuilder(getBaseContext(), EscuelaBD.class, "escuela").build();
                RestaurantBD bd = Room.databaseBuilder(getBaseContext(), RestaurantBD.class, "Restaurant").build();
                //bd.alumnoDao().InsertarAlumnos(new Alumno("01","jojo"));
                //bd.alumnoDao().InsertarAlumnos(new Alumno("02","hehe"));
                //bd.alumnoDao().InsertarAlumnos(new Alumno("03","sese"));
                listaOrdenes = bd.OrdenesDao().obtenerTodos();
                //listaAlumnos = bd.alumnoDao().obtenerTodos();
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        listOrdenes = findViewById(R.id.listViewAlumnos);
                        //listAlumnos = findViewById(R.id.listViewAlumnos);
                        //ArrayAdapter adaptador = new ArrayAdapter(getBaseContext(), android.R.layout.simple_list_item_1,listaAlumnos);
                        ArrayAdapter adapt = new ArrayAdapter(getBaseContext(), android.R.layout.simple_list_item_1,listaOrdenes);
                        listOrdenes.setAdapter(adapt);
                        //listAlumnos.setAdapter(adaptador);
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
