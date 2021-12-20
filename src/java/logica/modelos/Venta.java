/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica.modelos;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class Venta implements Serializable{
    
   
    

    
     @Id
     @GeneratedValue(strategy = GenerationType.AUTO)
     private int num_venta;
     
     
     @Basic
     private Date fecha_venta;
     private String medio_pago;
     private boolean habilitado;

     
     @ManyToOne
     @JoinColumn(name="cliente")
     private Cliente cliente ;
     
     @ManyToOne
     @JoinColumn(name="empleado")
     private Empleado empleado ;
     
     @ManyToOne
     @JoinColumn(name="servicio")
     private Servicio servicio ;
     
     @ManyToOne
     @JoinColumn(name="paquete")
     private Paquete paquete;

    public Venta(int num_venta, Date fecha_venta, String medio_pago, Cliente cliente, Empleado empleado, Servicio servicio,boolean habilitado) {
        this.num_venta = num_venta;
        this.fecha_venta = fecha_venta;
        this.medio_pago = medio_pago;
        this.cliente = cliente;
        this.empleado = empleado;
        this.servicio = servicio;
        this.habilitado= habilitado;
        
    }
     

     
     
     public Venta(){
         
         
     }

    public int getNum_venta() {
        return num_venta;
    }

    public void setNum_venta(int num_venta) {
        this.num_venta = num_venta;
    }

    public Date getFecha_venta() {
        return fecha_venta;
    }

    public void setFecha_venta(Date fecha_venta) {
        this.fecha_venta = fecha_venta;
    }

    public String getMedio_pago() {
        return medio_pago;
    }

    public void setMedio_pago(String medio_pago) {
        this.medio_pago = medio_pago;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public Servicio getServicio() {
        return servicio;
    }

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }

    public Paquete getPaquete() {
        return paquete;
    }

    public void setPaquete(Paquete paquete) {
        this.paquete = paquete;
    }

    public boolean isHabilitado() {
        return habilitado;
    }

    public void setHabilitado(boolean habilitado) {
        this.habilitado = habilitado;
    }

    
    
    
    
    
    
    @Override
    public String toString() {
        return "Venta{" + "num_venta=" + num_venta + ", fecha_venta=" + fecha_venta + ", medio_pago=" + medio_pago + ", habilitado=" + habilitado + ", cliente=" + cliente + ", empleado=" + empleado + ", servicio=" + servicio + ", paquete=" + paquete + '}';
    }

    
    
    
   
    
    
    
}
