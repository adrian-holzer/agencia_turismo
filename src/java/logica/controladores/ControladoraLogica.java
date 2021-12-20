/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica.controladores;


import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import logica.modelos.Cliente;
import logica.modelos.Empleado;
import logica.modelos.Paquete;
import logica.modelos.Servicio;
import logica.modelos.Usuario;
import logica.modelos.Venta;
import persistencia.controladoresJpa.exceptions.NonexistentEntityException;
import persistencia.cotroladoresPersistencia.ControladorPersistencia;




public class ControladoraLogica {
    
    ControladorPersistencia cpe = new ControladorPersistencia();
    
    
    
    // Empleado
    
    public List<Empleado> mostrarTodos(){
        
        return this.cpe.mostrarTodos();
        
    }
    
    
      
      
    public Empleado buscarEmpleado(int id){
        
        return this.cpe.buscarEmpleado(id);
        
    }
    
    
    public void editarEmpleado(Empleado e,Usuario u){
        

         this.cpe.editarEmpleado(e,u);
        
    }
    
    
    
    
       
     public void  crearEmpleado(String nombre , String apellido , String cargo , String celular,
             String direccion , String dni , String email , String nacionalidad , Date fechaNacimiento , 
             Double sueldo , 
   String nombreUsuario , String password, boolean habilitado
            ){
        
        Usuario user = new Usuario();
        user.setNombreUsuario("user");
        user.setPassword("admin");
        
        
        Empleado em = new Empleado();
         
        
        em.setNombre(nombre);
        em.setApellido(apellido);
        em.setCargo(cargo);
        em.setCelular(celular);
        em.setDireccion(direccion);
        em.setDni(dni);
        em.setEmail(email);
        em.setNacionalidad(nacionalidad);
        em.setSueldo(sueldo);
        em.setHabilitado(true);
        em.setFecha_nac(fechaNacimiento);
        em.setUsuario(user);

        
        this.cpe.crearEmpleado(em,user);

       
    } 
      
      
      
      
    public void eliminarEmpleado(int id){
        
        try {
            this.cpe.eliminarEmpleado(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraLogica.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
    
    
    
    
    
    
    
    
        ///----------------------------    -------------------   ---------------------------------------///

    
        // Cliente
    
    
    
    
    public List<Cliente> mostrarClientes(){
        
       return this.cpe.mostrarClientes();
    }
    
    
    
    public Cliente buscarCliente(int id){
        
        return this.cpe.buscarCliente(id);
        
    }
    
    
    
    
     public void  crearCliente(String nombre , String apellido  , String celular,
             String direccion , String dni , String email , String nacionalidad , Date fechaNacimiento){
        
        
        Cliente cli = new Cliente();
         
        
        cli.setNombre(nombre);
        cli.setApellido(apellido);
        
        cli.setCelular(celular);
        cli.setDireccion(direccion);
        cli.setDni(dni);
        cli.setEmail(email);
        cli.setNacionalidad(nacionalidad);
        cli.setHabilitado(true);
        cli.setFecha_nac(fechaNacimiento);
       
        
        this.cpe.crearCliente(cli);

       
    } 
      
      
    
    
    
    
    
    
    
    
    public void editarCliente(Cliente c){
        
        this.cpe.editarCliente(c);
    }
    
    
    
    
    
    public void eliminarCliente(int id){
        
        try {
            this.cpe.eliminarCliente(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraLogica.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
    ///----------------------------    -------------------   ---------------------------------------///
    
    // Servicios 
    
    
    
    
    public List<Servicio> mostrarServicios(){
        
         return this.cpe.mostrarServicios();
        
    }
    
    
    
    public void crearServicio(String nombre , String descripcion,String destino , boolean habilitado, double costo,Date fechaServicio){
        
        
        Servicio s = new Servicio();

        s.setNombre(nombre);
        s.setDescripcion(descripcion);
        s.setDestino_servicio(destino);
        s.setHabilitado(habilitado);
        s.setCosto_servicio(costo);
        s.setFecha_servicio(fechaServicio);
        
        this.cpe.crearServicio(s);
        
        
    }
    
    
    
    
      
    public void eliminarServicio(int id){
        
        try {
            this.cpe.eliminarServicio(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraLogica.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
    
     public Servicio buscarServicio(int id){
        
        return this.cpe.buscarServicio(id);
        
    }
     
     
     public void editarServicio(Servicio s){
        
          this.cpe.editarServicio(s);
        
    }
    
    
    
    
        ///----------------------------    -------------------   ---------------------------------------///

    
    // Paquetes 
    
    
     
     
     
     
      
      public List<Paquete> mostrarPaquetes(){
          
          return this.cpe.mostrarPaquetes();
          
      }
        
      
      
    public void crearPaquete(List<Servicio>listaServicios){
        
       
        Paquete p = new Paquete();
        
        
       
        p.setCosto_paquete(0);
        p.setHabilitado(true);
        p.setListaVentas(null);
        p.setCodigo_paquete(0);
        
        
        for (Servicio servi : listaServicios) {
            p.agregarServicio(servi);
        }
       
         p.setCosto_paquete(p.calcularCosto());
       
        
        this.cpe.crearPaquete(p);
        
       
      
        
        
    }
    
    
    
     
    public Paquete buscarPaquete(int id ){
        
        
        
        
        
        return this.cpe.buscarPaquete(id);
        
    }
    
    
      
     
      public void editarPaquete(int id, List<Servicio>listaServicios){
        
        
          Paquete p = buscarPaquete(id);
          
           
          p.getListaServicios().clear();
          
        
          for (Servicio s : listaServicios) {
              
              p.agregarServicio(s);
          }
          
          p.setCosto_paquete(p.calcularCosto());
          
        this.cpe.editarPaquete(p);
        

    }
    
    
    
     
    
     public void eliminarPaquete(int id) throws NonexistentEntityException{

         this.cpe.eliminarPaquete(id); 
        
    }
    
    
    
    
    
    
    
    
    
        ///----------------------------    -------------------   ---------------------------------------///

    
    // Ventas 
    
    public List<Venta> mostrarVentas(){
        
        return this.cpe.mostrarVentas();
        
    }
    

    
    
    public void crearVenta(String medio_pago ,Date fecha_Venta,int cliente_id,
            int empleado_id , int servicio_id , int paquete_id ){
        
        Venta v = new Venta();
        Cliente c = this.cpe.buscarCliente(cliente_id);
        Empleado e = this.cpe.buscarEmpleado(empleado_id);
        
        
        
        v.setMedio_pago(medio_pago);
        v.setFecha_venta(fecha_Venta);
        v.setCliente(c);
        v.setEmpleado(e);
        
        if (paquete_id==-1) {
             v.setPaquete(null);
        }else{
            Paquete p = this.cpe.buscarPaquete(paquete_id);
            
            v.setPaquete(p);
        }
        
        
         if (servicio_id==-1) {
             v.setCliente(null);
        }else{
            Servicio s = this.cpe.buscarServicio(servicio_id);
            
            v.setServicio(s);
        }
        
       
        v.setCliente(c);
        v.setEmpleado(e);
        
        v.setFecha_venta(fecha_Venta);
        v.setHabilitado(true);
        
        
       this.cpe.crearVenta(v);
    }
    
    
    
    
    public Venta buscarVenta(int id){
        
        return this.cpe.buscarVenta(id);
        
    }
    
    
    
      
    public void eliminarVenta(int id){
        
        try {
            this.cpe.eliminarVenta(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraLogica.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
    
    
    
     public void editarVenta(int cod_venta, String medio_pago, int cod_Empleado, int cod_Cliente,int radioServicio,
                       int radioPaquete, Date fechaVenta){
        
              Venta v = this.cpe.buscarVenta(cod_venta);
              Empleado e = this.cpe.buscarEmpleado(cod_Empleado);
              Cliente c = this.cpe.buscarCliente(cod_Cliente);
              
              if (radioServicio!=-1) {
             
                  Servicio s = this.cpe.buscarServicio(radioServicio);
                  v.setServicio(s);
                  
         }else{
                    v.setServicio(null);
              }
              
              if (radioPaquete!=-1) {
             
                  Paquete p = this.cpe.buscarPaquete(radioPaquete);
                  v.setPaquete(p);
         }else{
                  v.setPaquete(null);
              }
              
              v.setEmpleado(e);
              v.setCliente(c);
              v.setMedio_pago(medio_pago);
              v.setFecha_venta(fechaVenta);

          this.cpe.editarVenta(v);
         

    }
     
     
     
     
     
     // Login de Usuario
     
     
     public boolean verificarUsuario(String usuario , String password){
         List<Usuario> listaUsuarios = this.cpe.traerUsuarios();
     
     if(listaUsuarios!=null){
    
            for (Usuario u : listaUsuarios) {
                
                if(u.getNombreUsuario().equals(usuario) && u.getPassword().equals(password)){
                    
                    return true;
                }
            }
 
}
     return false;
     }
     
     
     
      
   
     
     
     
     
     
     
     
     
    
}
