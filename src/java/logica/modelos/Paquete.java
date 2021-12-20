/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica.modelos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;



@Entity
public class Paquete implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int  codigo_paquete ;
    
    @Basic
    private double costo_paquete ;
    private boolean habilitado;

    
    
    @ManyToMany()
    @JoinTable(
            name = "paquete_servicio",
            joinColumns = {@JoinColumn(name = "paquete_id")},
            inverseJoinColumns = {@JoinColumn(name = "servicio_id")}
    )
    private List<Servicio> listaServicios=new ArrayList<>();
   

    
    
    
     @OneToMany(mappedBy = "paquete")
     private List<Venta> listaVentas =new ArrayList<>();;
   
     
     
    public Paquete() {
        
    }

    public int getCodigo_paquete() {
        return codigo_paquete;
    }

    public void setCodigo_paquete(int codigo_paquete) {
        this.codigo_paquete = codigo_paquete;
    }

   

    public double getCosto_paquete() {
        return this.costo_paquete;
    }

    public void setCosto_paquete(double costo_paquete) {
        this.costo_paquete = costo_paquete;
    }

    public List<Servicio> getListaServicios() {
        return listaServicios;
    }

    public void setListaServicios(List<Servicio> listaServicios) {
        this.listaServicios = listaServicios;
    }

    public List<Venta> getListaVentas() {
        return listaVentas;
    }

    public void setListaVentas(List<Venta> listaVentas) {
        this.listaVentas = listaVentas;
    }

    public boolean isHabilitado() {
        return habilitado;
    }

    public void setHabilitado(boolean habilitado) {
        this.habilitado = habilitado;
    }
    
    
    public double calcularCosto(){
        
        this.costo_paquete=0;
       
        for (Servicio s : listaServicios) {
            this.costo_paquete+=s.getCosto_servicio();
        }
        
        this.costo_paquete= this.costo_paquete - (this.costo_paquete*0.10);
        
        return this.costo_paquete ;
        
    }
    
    
 
    public void agregarServicio(Servicio s){
        
        listaServicios.add(s);
        s.getListaPaquetes().add(this);
        
    }
    
    public void removerServicio(Servicio s){
        
        listaServicios.remove(s);
        s.getListaPaquetes().remove(this);
        
    }
    
    
    
    

    @Override
    public String toString() {
        return "Paquete{" + "codigo_paquete=" + codigo_paquete + ", costo_paquete=" + costo_paquete + '}';
    }

   
    
    
    
    
 
    
    
    
    
    
}
