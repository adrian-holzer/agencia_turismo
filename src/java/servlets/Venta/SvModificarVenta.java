/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets.Venta;

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
import logica.modelos.Empleado;
import logica.modelos.Paquete;
import logica.modelos.Servicio;
import logica.modelos.Venta;

/**
 *
 * @author usuario
 */
@WebServlet(name = "SvModificarVenta", urlPatterns = {"/SvModificarVenta"})
public class SvModificarVenta extends HttpServlet {

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
        
        ControladoraLogica cl  = new ControladoraLogica();
        
        
        int cod_venta = Integer.parseInt(request.getParameter("cod_venta"));
        
        Venta v  = cl.buscarVenta(cod_venta);
        
        
         HttpSession session = request.getSession();
        
        List<Servicio> listaServicios = cl.mostrarServicios();
        List<Empleado> listaEmpleados = cl.mostrarTodos();
        List<Cliente> listaClientes = cl.mostrarClientes();
        List<Paquete> listaPaquetes = cl.mostrarPaquetes();

      
        session.setAttribute("listaServicios", listaServicios);
        session.setAttribute("listaEmpleados", listaEmpleados);
        session.setAttribute("listaClientes", listaClientes);
        session.setAttribute("listaPaquetes", listaPaquetes);
        session.setAttribute("venta", v);
        
        response.sendRedirect("editarVenta.jsp");
        
        
        
        
        
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
int cod_venta = Integer.parseInt(request.getParameter("cod_venta"));





String medio_pago = request.getParameter("medio_pago");
int cod_Empleado = Integer.parseInt(request.getParameter("cod_Empleado"));
int  cod_Cliente = Integer.parseInt(request.getParameter("cod_Cliente"));
 int radioServicio =(request.getParameter("radioServicio")!= null) ? Integer.parseInt(request.getParameter("radioServicio")) : -1 ;
 int radioPaquete=(request.getParameter("radioPaquete")!= null) ? Integer.parseInt(request.getParameter("radioPaquete")) : -1 ;
 String sp =  request.getParameter("servicioOPaquete");
       


        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
            
        Date fechaVenta=null;
       try {
            fechaVenta =  sf.parse(request.getParameter("fechaVenta"));
        } catch (ParseException ex) {
            
            Logger.getLogger(SvCrearVenta.class.getName()).log(Level.ALL.SEVERE, null, ex);
        }
       
       
       
        if (sp.equals("paquete")) {
            
            radioServicio=-1;
            
            
        }else if(sp.equals("servicio")) {
            
            radioPaquete=-1;
            
        }
        
        
        
       cl.editarVenta(cod_venta , medio_pago,cod_Empleado,cod_Cliente,radioServicio,radioPaquete,fechaVenta);

       
       
       
        
          
        List<Venta> listaVentas = cl.mostrarVentas();
        
        HttpSession session = request.getSession();
        
        session.setAttribute("listaVentas", listaVentas);
        
        response.sendRedirect("listaVentas.jsp");
        
        
        
        
        
        
        
        
        
        
        
        
        
        
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
