package baseDatos;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;


import Controladores.AlumnoDAO;
import Entidades.Usuario;

@Database(entities = {Usuario.class}, version = 1, exportSchema = false)
public abstract class UsuariosBD {


    public abstract Usuario UsuarioDao();

    private static EscuelaBD INSTANCE;

    public static EscuelaBD getAppDatabase(Context context) {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(), EscuelaBD.class, "escuela").build();
        }
        return INSTANCE;
    }

    public static void destroyInstance() {
        INSTANCE = null;
    }





}
