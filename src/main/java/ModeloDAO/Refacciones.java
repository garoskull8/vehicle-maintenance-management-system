/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDAO;

/**
 *
 * @author edgar
 */
public class Refacciones {
    private String id;
    private String nombre;
    private String cantidad;
    private String cantidadStock;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public String getCantidadStock() {
        return cantidadStock;
    }

    public void setCantidadStock(String cantidadStock) {
        this.cantidadStock = cantidadStock;
    }
    
}
