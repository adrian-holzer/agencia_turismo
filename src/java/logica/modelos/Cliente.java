/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica.modelos;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
@DiscriminatorValue("cliente")
public class Cliente extends Persona implements Serializable {

    
    
   
     @OneToMany(mappedBy = "cliente")
     private List<Venta> listaVentas ;

    public Cliente(String nombre, String apellido, String direccion, String dni, Date fecha_nac, String nacionalidad, String celular, String email, boolean habilitado) {
        super(nombre, apellido, direccion, dni, fecha_nac, nacionalidad, celular, email, habilitado);
    }

    
   
     
     
   
    public Cliente(){
        
    }
   
    
    

    public List<Venta> getListaVentas() {
        return listaVentas;
    }

    public void setListaVentas(List<Venta> listaVentas) {
        this.listaVentas = listaVentas;
    }
   

  
    
    
    
    
    
    
    
} 
