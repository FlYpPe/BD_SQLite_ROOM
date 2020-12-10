package baseDatos;

import android.content.Context;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import Controladores.BaseDAO;
import Entidades.Ordenes;

@Database(entities = {Ordenes.class}, version = 1, exportSchema = false)
public abstract class RestaurantBD extends RoomDatabase {

    public abstract BaseDAO OrdenesDao();
    private static RestaurantBD INSTANCE;

    public static RestaurantBD getAppDatabase(Context context) {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(), RestaurantBD.class, "Restaurant").build();
        }
        return INSTANCE;
    }

    public static void destroyInstance() {
        INSTANCE = null;
    }

}
