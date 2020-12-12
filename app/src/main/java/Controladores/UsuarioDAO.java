package Controladores;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import Entidades.Ordenes;
import Entidades.Usuario;

@Dao
public interface UsuarioDAO {

    @Insert
    public void insertarUsuario(Usuario usuarrio);


    @Query("SELECT * FROM Usuario WHERE usuario LIKE :io")
    Ordenes obtenerUno(String io);
}
