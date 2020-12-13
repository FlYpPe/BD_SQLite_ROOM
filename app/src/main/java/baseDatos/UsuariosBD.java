package baseDatos;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;


import Controladores.AlumnoDAO;
import Controladores.UsuarioDAO;
import Entidades.Usuario;

@Database(entities = {Usuario.class}, version = 1, exportSchema = false)
public abstract class UsuariosBD extends RoomDatabase {


    public abstract UsuarioDAO UsuarioDao();

    private static UsuariosBD INSTANCE;

    public static UsuariosBD getAppDatabase(Context context) {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(), UsuariosBD.class, "Usuarios").build();
        }
        return INSTANCE;
    }

    public static void destroyInstance() {
        INSTANCE = null;
    }





}
