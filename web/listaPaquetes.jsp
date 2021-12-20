<%-- 
    Document   : listaPaquetes
    Created on : 17 dic. 2021, 19:32:45
    Author     : usuario
--%>

<%@page import="logica.modelos.Paquete"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html> 
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de Ventas</title>

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
                                        <h3 class="card-title">Lista de Ventas</h3>


                                   
                                        
                                        
                                        
                                        
                                    </div>
                                    <!-- /.card-header -->
                                    <div class="card-body table-responsive p-0">
                                        <table class="table table-hover text-nowrap">
                                            <thead>
                                                <tr>
                                                    <th>Código de Paquete</th>
                                                    <th>Costo</th>
                                                    <th>Ver</th>
                                                    <th>Eliminar</th>
                                                    <th>Editar</th>

                                                </tr>
                                            </thead>
                                            <tbody>
                                                <%

                                                    List<Paquete> listaPaquetes = (List) request.getSession().getAttribute("listaPaquetes");

                                                    for (Paquete p : listaPaquetes) {


                                                %> 



                                                <tr >

                                                    <td><%= p.getCodigo_paquete()%></td>
                                                    <td><%= p.getCosto_paquete()%></td>
                                                    
                                                    <td > 
                                                     
                                                        <form action="SvDetallePaquete" method="GET">

                                                            <input type="hidden" name="cod_paquete" value="<%= p.getCodigo_paquete() %>">
                                                            <input type="submit" class =" btn-primary btn-sm " value="Ver Servicios">
                                                        </form>  
                                                    </td>

                                                    <td > 
                                                        <form action="SvEliminarPaquete" method="GET">

                                                            <input type="hidden" name="cod_paquete" value="<%= p.getCodigo_paquete() %>">
                                                            <input type="submit" class =" btn-danger btn-sm " value="Eliminar">
                                                        </form> 
                                                        
                                                    </td>
                                                    <td>
                                                        <form action="SvModificarPaquete" method="GET">

                                                            <input type="hidden" name="cod_paquete" value="<%= p.getCodigo_paquete() %>">
                                                            <input type="submit" class =" btn-warning btn-sm " value="Editar">
                                                        </form> 

                                                    </td>
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
