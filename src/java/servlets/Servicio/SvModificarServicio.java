/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets.Servicio;

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
import logica.modelos.Servicio;
import servlets.Empleado.SvAltaEmpleado;

/**
 *
 * @author usuario
 */
@WebServlet(name = "SvModificarServicio", urlPatterns = {"/SvModificarServicio"})
public class SvModificarServicio extends HttpServlet {

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
        
        
        ControladoraLogica cl = new ControladoraLogica();

        int id = Integer.parseInt(request.getParameter("cod_servicio"));
        Servicio s = cl.buscarServicio(id);

        HttpSession misesion = request.getSession();
        misesion.setAttribute("servicio", s);
        
        response.sendRedirect("editarServicio.jsp");
        
        
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
         
         Servicio s = (Servicio)request.getSession().getAttribute("servicio");

         
         System.out.println(s.getNombre());
         
         
String nombre = request.getParameter("nombre");
String descripcion = request.getParameter("descripcion");
String destino = request.getParameter("destino");
double costo = Double.parseDouble(request.getParameter("costo"));

       
        
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
            
        Date fechaServicio=null;
        try {
            fechaServicio =  sf.parse(request.getParameter("fechaServicio"));
        } catch (ParseException ex) {
            
            Logger.getLogger(SvAltaEmpleado.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        
        s.setNombre(nombre);
        s.setDescripcion(descripcion);
        s.setDestino_servicio(destino);
        s.setCosto_servicio(costo);
        s.setFecha_servicio(fechaServicio);
        
        
        
        cl.editarServicio(s);
        
        List<Servicio> listaServicios = cl.mostrarServicios();
        
        HttpSession session = request.getSession();
        
        session.setAttribute("listaServicios", listaServicios);
        
       
        response.sendRedirect("listaServicios.jsp");
        
      
        
        
        
        
        
        
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
