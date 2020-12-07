package Controladores;


import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

import Entidades.Alumno;

@Dao
public interface BaseDAO {

    @Insert
    public void insertarAlumno(Alumno alumno);

    @Insert
    public void InsertarAlumnos(Alumno...Alumnos);

    //Bajas
    @Query("DELETE FROM alumno WHERE numControl = :nc")
    void eliminarPorNumControl(String nc);

    //Cambios
    @Query("UPDATE alumno SET nombre=:n WHERE numControl = :nc")
    void modificarPorNumControl(String nc, String n);

    //Consultas
    @Query("SELECT * FROM alumno")
    List<Alumno> obtenerTodos();

    @Query("SELECT * FROM alumno WHERE numControl LIKE :nc")
    Alumno obtenerUno(String nc);


}
