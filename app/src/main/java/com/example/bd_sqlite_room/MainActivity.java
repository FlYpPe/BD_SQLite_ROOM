package com.example.bd_sqlite_room;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import Entidades.Usuario;
import baseDatos.UsuariosBD;

public class MainActivity extends AppCompatActivity {

    EditText usuario, contra;
    boolean aceptar = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        usuario = findViewById(R.id.caja_usuario);
        contra = findViewById(R.id.caja_contraseña);
    }

    public void abrirActivities(View v){


        Intent i;
        switch (v.getId()){
            case R.id.btn_acceder: i = new Intent(this, ActivityMenu.class);
                new Thread(new Runnable() {
                    @Override
                    public void run() {

                        System.out.println("Impresion: "+usuario.getText().toString().trim()+ contra.getText().toString().trim());
                        if (usuario.getText().toString().trim().equals("")||contra.getText().toString().trim().equals("")){
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    Toast.makeText(getBaseContext(), "checar informacion", Toast.LENGTH_LONG).show();
                                }
                            });
                        }else{
                        try {

                            String a = String.valueOf(usuario.getText());
                            String b = String.valueOf(contra.getText());
                            UsuariosBD ubd = UsuariosBD.getAppDatabase(getBaseContext());
                            Usuario uas = ubd.UsuarioDao().obtenerUno(a);
                            System.out.println(uas);
                            if (b.equals(uas.getContraseña())){
                                startActivity(i);
                            }else{
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        Toast.makeText(getBaseContext(), "Error de informacion", Toast.LENGTH_LONG).show();
                                    }
                                });
                            }


                        }catch (Exception e){
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    Toast.makeText(getBaseContext(), "Error de informacion", Toast.LENGTH_LONG).show();
                                }
                            });
                            e.printStackTrace();
                        }
                        }

                    }
                }).start();
           break;


            case R.id.btn_registro: i = new Intent(this, ActivityUsuario.class);
                startActivity(i);

                break;
    }
}

}