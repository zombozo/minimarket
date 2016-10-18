/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BaseDatos;

/**
 *
 * @author zombozo
 */
public class ventas {
private int     Id_venta;
private int	Id_producto;
private int	Id_vendedor;
private int	Total_venta;
private float	Monto_total;
private String	Fecha_venta;
private String	Hora_venta;
private String	Info;

    public int getId_venta() {
        return Id_venta;
    }

    public void setId_venta(int Id_venta) {
        this.Id_venta = Id_venta;
    }

    public int getId_producto() {
        return Id_producto;
    }

    public void setId_producto(int Id_producto) {
        this.Id_producto = Id_producto;
    }

    public int getId_vendedor() {
        return Id_vendedor;
    }

    public void setId_vendedor(int Id_vendedor) {
        this.Id_vendedor = Id_vendedor;
    }

    public int getTotal_venta() {
        return Total_venta;
    }

    public void setTotal_venta(int Total_venta) {
        this.Total_venta = Total_venta;
    }

    public float getMonto_total() {
        return Monto_total;
    }

    public void setMonto_total(float Monto_total) {
        this.Monto_total = Monto_total;
    }

    public String getFecha_venta() {
        return Fecha_venta;
    }

    public void setFecha_venta(String Fecha_venta) {
        this.Fecha_venta = Fecha_venta;
    }

    public String getHora_venta() {
        return Hora_venta;
    }

    public void setHora_venta(String Hora_venta) {
        this.Hora_venta = Hora_venta;
    }

    public String getInfo() {
        return Info;
    }

    public void setInfo(String Info) {
        this.Info = Info;
    }

}
