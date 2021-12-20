/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistencia.cotroladoresPersistencia;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import logica.modelos.Cliente;
import persistencia.controladoresJpa.EmpleadoJpaController;
import logica.modelos.Empleado;
import logica.modelos.Paquete;
import logica.modelos.Servicio;
import logica.modelos.Usuario;
import logica.modelos.Venta;
import persistencia.controladoresJpa.ClienteJpaController;
import persistencia.controladoresJpa.PaqueteJpaController;
import persistencia.controladoresJpa.ServicioJpaController;

import persistencia.controladoresJpa.UsuarioJpaController;
import persistencia.controladoresJpa.VentaJpaController;
import persistencia.controladoresJpa.exceptions.NonexistentEntityException;


/**
 *
 * @author usuario
 */
public class ControladorPersistencia {
    
    
    EmpleadoJpaController ec = new EmpleadoJpaController();
    ClienteJpaController clienteC = new ClienteJpaController();

    UsuarioJpaController usuarioC = new UsuarioJpaController();
    VentaJpaController ventaC = new VentaJpaController();
    ServicioJpaController serviC = new ServicioJpaController();
    PaqueteJpaController paqueteC = new PaqueteJpaController();
  
    
    
    // Empleados 
    
    public List<Empleado> mostrarTodos(){
        
        List<Empleado> listaEmpleados =  this.ec.findEmpleadoEntities();
        
        
        return listaEmpleados;
        
    }
    
    
    public Empleado buscarEmpleado(int id){
        
        Empleado e = this.ec.findEmpleado(id);
        
        return e;
        
    }
    
    
    
    public void crearEmpleado(Empleado e, Usuario u){
        
        this.usuarioC.create(u);
        this.ec.create(e);
        
    }
    
    
     public void editarEmpleado(Empleado e,Usuario u){
        
        try {
         //   this.usuarioC.edit(u);
            this.ec.edit(e);
        } catch (Exception ex) {
            Logger.getLogger(ControladorPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
   
    
    
    
        public void eliminarEmpleado(int id) throws NonexistentEntityException{

         Empleado e = this.ec.findEmpleado(id);this.ec.destroy(id); 
         this.usuarioC.destroy(e.getUsuario().getId());
         this.ec.destroy(id); 
        
    }
        
        
        
        
        
        
        
        
        // -------------------    --------------------    ----------------- ///
      
        // Clientes
        
        
        
        
        
    
    public List<Cliente> mostrarClientes(){
        
       return this.clienteC.findClienteEntities();
       
    }
    
    
    public Cliente buscarCliente(int id){
        
        Cliente c= this.clienteC.findCliente(id);
        
        return c;
        
    }
    
    
    public void crearCliente(Cliente c){
        
        this.clienteC.create(c);
        
    }
    
    
     public void editarCliente(Cliente c){
        
        try {
            this.clienteC.edit(c);
        } catch (Exception ex) {
            Logger.getLogger(ControladorPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
        
    
      public void eliminarCliente(int id) throws NonexistentEntityException{

         this.clienteC.destroy(id); 
        
    }
        
        
        
 // -------------------    --------------------    ----------------- ///
      
        // Servicios
        
        
        public List<Servicio> mostrarServicios(){
        
        List<Servicio> listaServicios =  this.serviC.findServicioEntities();
        
        
        return listaServicios;
        
    }
        
        
     public void crearServicio(Servicio s){
        
        this.serviC.create(s);
         
    }
        
     
    
     public void eliminarServicio(int id) throws NonexistentEntityException{

         this.serviC.destroy(id); 
        
    }
     
     
     
     public Servicio buscarServicio(int id){
        
        Servicio s = this.serviC.findServicio(id);
        
        return s;
        
    }
     
     
     
     
     
      public void editarServicio(Servicio s){
        
        try {
            this.serviC.edit(s);
        } catch (Exception ex) {
            Logger.getLogger(ControladorPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
        
      
      
      
      
      
      // -------------------    --------------------    ----------------- ///
      
      // Paquetes
      
      
      
      public List<Paquete> mostrarPaquetes(){
          
          return this.paqueteC.findPaqueteEntities();
          
      }
        
      
      
    public void crearPaquete(Paquete p){
        
       this.paqueteC.create(p);
    }
    
    
    
        
     
    public Paquete buscarPaquete(int id){
        
        return this.paqueteC.findPaquete(id);
        
    }
      
     
      public void editarPaquete(Paquete p){
        
        try {
            this.paqueteC.edit(p);
        } catch (Exception ex) {
            Logger.getLogger(ControladorPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
     
    
     public void eliminarPaquete(int id) throws NonexistentEntityException{

         this.paqueteC.destroy(id); 
        
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
        
        // -------------------    --------------------    ----------------- ///
        
        
    // Ventas 
    
    public List<Venta> mostrarVentas(){
        
        return this.ventaC.findVentaEntities();
        
    }
    
     public Venta buscarVenta(int id){
        
        return this.ventaC.findVenta(id);
        
    }
    
     public void editarVenta(Venta v){
        
        try {
            this.ventaC.edit(v);
        } catch (Exception ex) {
            Logger.getLogger(ControladorPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void crearVenta(Venta v){
        
       this.ventaC.create(v);
    }
        
      public void eliminarVenta(int id) throws NonexistentEntityException{
        
       this.ventaC.destroy(id);
    }
      
      
      
      
      // Login Usuario
      
      
      
      public List<Usuario> traerUsuarios(){
          
          return this.usuarioC.findUsuarioEntities();
      }
        
      public Usuario buscarUsuario(int id){
          
          return this.usuarioC.findUsuario(id);
          
      }
      
      
      
    
}
