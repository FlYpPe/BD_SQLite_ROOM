package Entidades;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Ordenes {

    @NonNull
    @PrimaryKey
    private String idOrden;

    @NonNull
    @ColumnInfo(name ="fecha")
    private String fecha;

    @NonNull
    @ColumnInfo(name ="cantidad")
    private int cantidad;

    @NonNull
    @ColumnInfo(name ="tipoPago")
    private String tipoPago;

    @NonNull
    @ColumnInfo(name ="idMesero")
    private String idMesero;


}
