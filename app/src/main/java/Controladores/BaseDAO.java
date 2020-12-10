package Controladores;


import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import Entidades.Alumno;
import Entidades.Ordenes;

@Dao
public interface BaseDAO {

    @Insert
    public void insertarAlumno(Ordenes ordenes);

    @Insert
    public void InsertarAlumnos(Ordenes...Ordenes);

    //Bajas
    @Query("DELETE FROM Ordenes WHERE idOrden = :io")
    void eliminarPoridOrden(String io);

    //Cambios
    @Query("UPDATE Ordenes SET fecha =:f, cantidad =:c, tipoPago =:p, idMesero =:m WHERE idOrden = :io")
    void modificarPoridOrden(String io, String f, String c, String p, String m);

    //Consultas
    @Query("SELECT * FROM Ordenes")
    List<Ordenes> obtenerTodos();

    @Query("SELECT * FROM Ordenes WHERE idOrden LIKE :io")
    Ordenes obtenerUno(String io);


}
