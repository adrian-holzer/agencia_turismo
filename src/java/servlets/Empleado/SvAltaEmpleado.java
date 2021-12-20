/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets.Empleado;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import logica.controladores.ControladoraLogica;
import logica.modelos.Empleado;


/**
 *
 * @author usuario
 */
@WebServlet(name = "SvAltaEmpleado", urlPatterns = {"/SvAltaEmpleado"})
public class SvAltaEmpleado extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        
   
        
        ControladoraLogica cl = new ControladoraLogica();
        // Guardado de Empleado
        





  String nombre = request.getParameter("nombre");
  String apellido = request.getParameter("apellido");
  String cargo = request.getParameter("cargo");
  String celular = request.getParameter("celular");
  String direccion = request.getParameter("direccion");
  String dni = request.getParameter("dni");
  String email = request.getParameter("email");
  String nacionalidad = request.getParameter("nacionalidad");
  
  


      SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
            
        Date fechaNacimiento=null;
        try {
            fechaNacimiento =  sf.parse(request.getParameter("fechaNacimiento"));
        } catch (ParseException ex) {
            
            Logger.getLogger(SvAltaEmpleado.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    
 
  double sueldo = Double.parseDouble(request.getParameter("sueldo"));
  String nombreUsuario = request.getParameter("nombreUsuario");
  String password = request.getParameter("password");

          
  boolean habilitado = true;
   
        cl.crearEmpleado(nombre,apellido,cargo,celular,direccion,dni,email, 
               nacionalidad, fechaNacimiento, sueldo,nombreUsuario, password,habilitado);
        
        
        List<Empleado> listaEmpleados = cl.mostrarTodos();
        
        HttpSession session = request.getSession();
        
        session.setAttribute("listaEmpleados", listaEmpleados);
        
        response.sendRedirect("listaEmpleados.jsp");

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
