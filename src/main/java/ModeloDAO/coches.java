/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDAO;

/**
 *
 * @author Admin
 */
public class coches {
     int idvehiculos;
 int  idchofer;
  String placas;
  String marca;
  String modelo;
  String tipo;

    public coches() {
    }

    public coches(int idvehiculos, int idchofer, String placas, String marca, String modelo, String tipo) {
        this.idvehiculos = idvehiculos;
        this.idchofer = idchofer;
        this.placas = placas;
        this.marca = marca;
        this.modelo = modelo;
        this.tipo = tipo;
    }

    public int getIdvehiculos() {
        return idvehiculos;
    }

    public void setIdvehiculos(int idvehiculos) {
        this.idvehiculos = idvehiculos;
    }

    public int getIdchofer() {
        return idchofer;
    }

    public void setIdchofer(int idchofer) {
        this.idchofer = idchofer;
    }

    public String getPlacas() {
        return placas;
    }

    public void setPlacas(String placas) {
        this.placas = placas;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
  
  
    
}
