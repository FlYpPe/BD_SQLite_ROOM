package com.example.bd_sqlite_room;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.Nullable;

import Entidades.Ordenes;
import Entidades.Usuario;
import baseDatos.RestaurantBD;
import baseDatos.UsuariosBD;

public class ActivityUsuario extends Activity {

    EditText usuario, contra;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_usuarios);

        usuario = findViewById(R.id.cajanombre);
        contra = findViewById(R.id.cajacontra);

    }
    public void darAlta(View v){

        new Thread(new Runnable() {
            @Override
            public void run() {

                try {
                    String a = String.valueOf(usuario.getText());
                    String b = String.valueOf(contra.getText());
                    UsuariosBD ubd = UsuariosBD.getAppDatabase(getBaseContext());
                    ubd.UsuarioDao().insertarUsuario(new Usuario(a,b));
                    Usuario uas = ubd.UsuarioDao().obtenerUno(a);
                    System.out.println(uas);



                }catch (Exception e){
                    e.printStackTrace();
                }

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(getBaseContext(), "INSERTADO CON EXITO", Toast.LENGTH_LONG).show();
                    }
                });

            }
        }).start();

    }
}
