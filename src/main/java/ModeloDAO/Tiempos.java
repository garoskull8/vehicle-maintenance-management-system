/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModeloDAO;

/**
 *
 * @author edwin
 */
public class Tiempos {
    
    public String idTiempo;
    public String idOper;
    public String FechaE;
    public String horaE;
     public String horaS;
      public String nombre;
       public String ap;
        public String am;
        public String Tiempo;

    public String getTiempo() {
        return Tiempo;
    }

    public void setTiempo(String Tiempo) {
        this.Tiempo = Tiempo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAp() {
        return ap;
    }

    public void setAp(String ap) {
        this.ap = ap;
    }

    public String getAm() {
        return am;
    }

    public void setAm(String am) {
        this.am = am;
    }
    public static  int var = 0;
    public static String idestatico;
    public static String name;
    
    public static String fecha_entrada;

    public String getHoraS() {
        return horaS;
    }

    public void setHoraS(String horaS) {
        this.horaS = horaS;
    }
    

    public static String getFecha_entrada() {
        return fecha_entrada;
    }

    public static void setFecha_entrada(String fecha_entrada) {
        Tiempos.fecha_entrada = fecha_entrada;
    }


    public static String getName() {
        return name;
    }

    public static void setName(String name) {
        Tiempos.name = name;
    }
    
    

    public static String getIdestatico() {
        return idestatico;
    }

    public static void setIdestatico(String idestatico) {
        Tiempos.idestatico = idestatico;
    }
    
    public static int getVar() {
        return var;
    }

    public static void setVar(int var) {
        Tiempos.var = var;
    }
    

    public String getHoraE() {
        return horaE;
    }

    public void setHoraE(String horaE) {
        this.horaE = horaE;
    }
    

    public String getFechaE() {
        return FechaE;
    }

    public void setFechaE(String FechaE) {
        this.FechaE = FechaE;
    }
    
    

    public String getIdTiempo() {
        return idTiempo;
    }

    public void setIdTiempo(String idTiempo) {
        this.idTiempo = idTiempo;
    }

    public String getIdOper() {
        return idOper;
    }

    public void setIdOper(String idOper) {
        this.idOper = idOper;
    }

 
    
    
    
}
