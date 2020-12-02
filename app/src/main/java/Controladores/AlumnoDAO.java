package Controladores;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

import Entidades.Alumno;

@Dao
public interface AlumnoDAO {

    @Insert
    public void InsertarAlumnos(Alumno...Alumnos);

  //  @Delete

  //  @Update

    @Query("SELECT * from Alumno")
    List<Alumno> obtenerTodos();



}
