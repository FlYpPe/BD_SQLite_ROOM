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
/*
    @Insert
    public void InsertarAlumnos(Alumno...Alumnos);

    @Query("DELETE FROM alumno WHERE numControl = :nc")
    void eliminarPorNumControl(String nc);

    @Delete
    void eliminar(Alumno alumno);

    @Update
    public void actualizarAlumno(Alumno a);

    @Query("Select * FROM alumnos WHERE numControl LIKE :nc AND last_name LIKE :last")
    Alumno findByName(String nc, String nombre);

    @Query("SELECT * from Alumno")
    List<Alumno> obtenerTodos();
*/
    //Altas
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
    Alumno findByName(String nc);

}
