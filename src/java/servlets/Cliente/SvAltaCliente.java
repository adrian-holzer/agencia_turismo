/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets.Cliente;

import java.io.IOException;
import java.io.PrintWriter;
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
import logica.modelos.Cliente;
import servlets.Empleado.SvAltaEmpleado;

/**
 *
 * @author usuario
 */
@WebServlet(name = "SvAltaCliente", urlPatterns = {"/SvAltaCliente"})
public class SvAltaCliente extends HttpServlet {

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
            
            
            
            
            
            String nombre = request.getParameter("nombre");
            String apellido = request.getParameter("apellido");
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
            Logger.getLogger(SvAltaCliente.class.getName()).log(Level.SEVERE, null, ex);
        }
            
         
            cl.crearCliente(nombre,apellido, celular,direccion,dni,email, nacionalidad, fechaNacimiento);
            
            
            List<Cliente> listaClientes = cl.mostrarClientes();
            
            HttpSession session = request.getSession();
            
            session.setAttribute("listaClientes", listaClientes);
            
            response.sendRedirect("listaClientes.jsp");
        

        
        
        
        
        
        
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
