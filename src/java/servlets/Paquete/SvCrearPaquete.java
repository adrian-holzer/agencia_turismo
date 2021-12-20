/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets.Paquete;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import logica.controladores.ControladoraLogica;
import logica.modelos.Paquete;
import logica.modelos.Servicio;

/**
 *
 * @author usuario
 */
@WebServlet(name = "SvCrearPaquete", urlPatterns = {"/SvCrearPaquete"})
public class SvCrearPaquete extends HttpServlet {

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
        
        List<Servicio> listaServicios =  cl.mostrarServicios();
        
        HttpSession session = request.getSession();
        
        session.setAttribute("listaServicios", listaServicios);
        
       
        response.sendRedirect("AltaPaquete.jsp");
        
        
        
        
        
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
         String error =null;

        ControladoraLogica cl= new ControladoraLogica();
         HttpSession session = request.getSession();
        
        String[] c = request.getParameterValues("check");
        
    

        if (c==null || c.length<=1) {
            error="Debe seleccionar más de un servicio para crear un servicio";
        session.setAttribute("error", error);
        
       
        response.sendRedirect("AltaPaquete.jsp");
        
        
            
        }else{
        
        
        List<Servicio> listServicios= new ArrayList();
        
        for (String c1 : c) {
            Servicio s = cl.buscarServicio(Integer.parseInt(c1));
            listServicios.add(s);
        }
        
        
        cl.crearPaquete(listServicios);
        
        
        
        List<Paquete> listaPaquetes =  cl.mostrarPaquetes();
        
       
        
        session.setAttribute("listaPaquetes", listaPaquetes);
        
       
        response.sendRedirect("listaPaquetes.jsp");
        }
        
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
