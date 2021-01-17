/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ModeloDAO;

/**
 *
 * @author Alondra Jelinet
 */
public class TareaAdmin {
    private String id;
    private String tarea;
    private String descripcion;
    private String vehiculo;
    private String fechaEntrada;
    private String fechaSalida;
    private String prioridad;
    private String estado;
    private String operarios;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTarea() {
        return tarea;
    }

    public void setTarea(String tarea) {
        this.tarea = tarea;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(String vehiculo) {
        this.vehiculo = vehiculo;
    }

    public String getFechaEntrada() {
        return fechaEntrada;
    }

    public void setFechaEntrada(String fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    public String getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(String fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public String getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(String prioridad) {
        this.prioridad = prioridad;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
    
    public String getOperarios() {
        return operarios;
    }

    public void setOperarios(String operarios) {
        this.operarios = operarios;
    }
    
/*public TareaAdmin ( String id,String tarea,String descripcion,String vehiculo,String fechaEntrada;
String fechaSalida,String prioridad,String estado,String operarios) {
  super();
    this.id = id;
    this.tarea = tarea;
    this.descripcion = descripcion;
    this.vehiculo = vehiculo;
    this.fechaEntrada = fechaEntrada;
    this.fechaSalida = fechaSalida;
    this.prioridad = prioridad;
    this.estado = estado;
    this.operarios = operarios;
 }*/
}


