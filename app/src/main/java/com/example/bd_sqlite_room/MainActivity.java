package com.example.bd_sqlite_room;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void abrirActivities(View v){
        Intent i;
        switch (v.getId()){
            case R.id.btn_acceder: i = new Intent(this, ActivityMenu.class);
            startActivity(i);
            break;

            //case R.id.btn_registro: i = new Intent(this, ActivityRegistro.class);
            //startActivity(i);
            //break;
        }
    }

    public void abrirRegistro(View v){

    }

    public void abirMenu(View v){

    }

}