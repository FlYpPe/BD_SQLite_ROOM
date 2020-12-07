package Entidades;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Alumno {

    @NonNull
    @PrimaryKey
    private String numControl;

    @NonNull
    @ColumnInfo(name ="nombre")
    private String nombre;

    public Alumno(@NonNull String numControl, @NonNull String nombre) {
        this.numControl = numControl;
        this.nombre = nombre;
    }

    @NonNull
    public String getNumControl() {
        return numControl;
    }
    public void setNumControl(@NonNull String numControl) {
        this.numControl = numControl;
    }

    @NonNull
    public String getNombre() {
        return nombre;
    }
    public void setNombre(@NonNull String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Alumno{" +
                "numControl='" + numControl + '\'' +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}