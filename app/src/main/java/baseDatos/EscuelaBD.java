package baseDatos;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import Controladores.AlumnoDAO;
import Entidades.Alumno;

@Database(entities = {Alumno.class}, version = 1, exportSchema = false)
public abstract class EscuelaBD extends RoomDatabase {

    public abstract AlumnoDAO alumnoDao();
    



}
