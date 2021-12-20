/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets.Paquete;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import logica.controladores.ControladoraLogica;
import logica.modelos.Paquete;
import logica.modelos.Servicio;

@WebServlet(name = "SvModificarPaquete", urlPatterns = {"/SvModificarPaquete"})
public class SvModificarPaquete extends HttpServlet {

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

        int id = Integer.parseInt(request.getParameter("cod_paquete"));
        Paquete p = cl.buscarPaquete(id);

        HttpSession misesion = request.getSession();
        misesion.setAttribute("paquete", p);
        
         List<Servicio> listaServicios = cl.mostrarServicios();
        
        misesion.setAttribute("listaServicios", listaServicios);
        
      
        
        response.sendRedirect("EditarPaquete.jsp");
        
        
        
        
        
        
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
          int id = Integer.parseInt(request.getParameter("cod_paquete"));
          
           
        String[] c = request.getParameterValues("check");
        List<Servicio> listServicios= new ArrayList();
        
        System.out.print(c.length);
        
        
        for (String c1 : c) {
            Servicio s = cl.buscarServicio(Integer.parseInt(c1));
            listServicios.add(s);
        }
        
        
        
          
          cl.editarPaquete(id,listServicios);
          
        
        List<Paquete> listaPaquetes =  cl.mostrarPaquetes();
        
        HttpSession session = request.getSession();
        
        session.setAttribute("listaPaquetes", listaPaquetes);
        
       
        response.sendRedirect("listaPaquetes.jsp");
        
        
        
        
        
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
