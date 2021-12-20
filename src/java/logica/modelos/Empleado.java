/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica.modelos;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Basic;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import javax.persistence.OneToMany;
import javax.persistence.OneToOne;


//@PrimaryKeyJoinColumn(referencedColumnName = "empleado_id")
@Entity
@DiscriminatorValue("empleado")
public class Empleado extends Persona implements Serializable {
    
    
    
    @Basic 
    private String cargo;
    private double sueldo;
    
    
    
    @OneToOne
    private Usuario usuario;
    
    
     @OneToMany(mappedBy = "empleado")
     private List<Venta> listaVentas ;

    public Empleado(String cargo, double sueldo, Usuario usuario, String nombre, String apellido, String direccion, String dni, Date fecha_nac, String nacionalidad, String celular, String email, boolean habilitado) {
        super(nombre, apellido, direccion, dni, fecha_nac, nacionalidad, celular, email, habilitado);
        this.cargo = cargo;
        this.sueldo = sueldo;
        this.usuario = usuario;
    }

   
     
    
     
    
    
    
    public Empleado(){
        
        
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }
    

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public List<Venta> getListaVentas() {
        return listaVentas;
    }

    public void setListaVentas(List<Venta> listaVentas) {
        this.listaVentas = listaVentas;
    }

    @Override
    public String toString() {
        return "Empleado{" + "cargo=" + cargo + ", sueldo=" + sueldo + ", usuario=" + usuario + ", listaVentas=" + listaVentas + '}';
    }
    
    
   
    


    
    
    
    

}
