<%-- 
    Document   : detallePaquete
    Created on : 18 dic. 2021, 16:31:58
    Author     : usuario
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="logica.modelos.Servicio"%>
<%@page import="java.util.List"%>
<%@page import="logica.modelos.Paquete"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html> <%
            
             Paquete p = (Paquete) request.getSession().getAttribute("paquete");
            
        %>
        
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de Servicios</title>

        <%@include file="head.jsp" %>
    </head>
    <body class="hold-transition sidebar-mini">



        <div class="wrapper">

            <%@include file="navbar.jsp" %>

            <%@include file="aside.jsp" %>


            <div class="content-wrapper">
                <!-- Content Header (Page header) -->
                <section class="content-header">
                    <div class="container-fluid">




                    </div><!-- /.container-fluid -->
                </section>

                <!-- Main content -->
                <section class="content">
                    <div class="container-fluid">
                        <!-- /.row -->
                        <div class="row">
                            <div class="col-12">
                                <div class="card">
                                    <div class="card-header">
                                        <h3 class="card-title">Lista de Empleados</h3>


                                    </div>
                                    <!-- /.card-header -->
                                    <div class="card-body table-responsive p-0">
                                        <table class="table table-hover text-nowrap">
                                            <thead>
                                                <tr>
                                                    <th>Código</th>
                                                    <th>Nombre</th>
                                                    <th>Descripcion</th>
                                                    <th>Destino</th>
                                                    <th>Costo</th>
                                                    <th>Fecha</th>
                                                
                                                </tr>
                                            </thead>
                                            <tbody>


                                                <%
                                                    
                                                    List<Servicio> listaServicios = (List) p.getListaServicios();
 
                                                    for (Servicio s : listaServicios) {
                                                    


                                                %> 



                                                <tr>
                                                    
                                                     <% 
                                                        SimpleDateFormat sf = new SimpleDateFormat("dd/MM/yyyy");
                                                        String fecha = (s.getFecha_servicio()!=null) ?  sf.format(s.getFecha_servicio()): "";
                                                        
                                                    %>
                                                  
                                                     <td><%= s.getCodigo_servicio()  %></td>
                                                    <td><%= s.getNombre()  %></td>
                                                    <td><%= s.getDescripcion()  %></td>
                                                    <td><%= s.getDestino_servicio() %></td>
                                                    <td><%= s.getCosto_servicio() %></td>
                                                    <td><%= fecha %></td>
                                                    
                                                 
                                                </tr>

                                            </tbody>

                                            <% }

                                            %>   
                                        </table>
                                    </div>
                                    <!-- /.card-body -->
                                </div>
                                <!-- /.card -->
                            </div>
                        </div>
                        <!-- /.row -->

                    </div><!-- /.container-fluid -->
                </section>
                <!-- /.content -->
            </div>



            <%@include file="footer.jsp" %>
        </div>




        <%@include file="linkscript.jsp" %>
         <% }%>
    </body>
</html>
