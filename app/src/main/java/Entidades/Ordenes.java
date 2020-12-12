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

    public Ordenes(@NonNull String idOrden, @NonNull String fecha, int cantidad, @NonNull String tipoPago, @NonNull String idMesero) {
        this.idOrden = idOrden;
        this.fecha = fecha;
        this.cantidad = cantidad;
        this.tipoPago = tipoPago;
        this.idMesero = idMesero;
    }

    @NonNull
    public String getIdOrden() {
        return idOrden;
    }

    public void setIdOrden(@NonNull String idOrden) {
        this.idOrden = idOrden;
    }

    @NonNull
    public String getFecha() {
        return fecha;
    }

    public void setFecha(@NonNull String fecha) {
        this.fecha = fecha;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @NonNull
    public String getTipoPago() {
        return tipoPago;
    }

    public void setTipoPago(@NonNull String tipoPago) {
        this.tipoPago = tipoPago;
    }

    @NonNull
    public String getIdMesero() {
        return idMesero;
    }

    public void setIdMesero(@NonNull String idMesero) {
        this.idMesero = idMesero;
    }


    @Override
    public String toString() {
        return  idOrden +
                " Fecha : " + fecha  +
                " Cantidad : " + cantidad +
                " Tipo de pago : " + tipoPago +
                " Mesero : " + idMesero  ;
    }
}
