

<%@page import="logica.modelos.Venta"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="logica.modelos.Empleado"%>
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
                                                    <th>Código</th>
                                                    <th>Medio de Pago</th>
                                                    <th>Fecha</th>
                                                    <th>Eliminar</th>
                                                    <th>Editar</th>
                                                    <th>Ver</th>

                                                </tr>
                                            </thead>
                                            <tbody>


                                                <%
                                                    
                                                    List<Venta> listaVentas = (List) request.getSession().getAttribute("listaVentas");
 
                                                    for (Venta v : listaVentas) {
                                                    

                                                %> 



                                                <tr>
                                                  
                                                    <td><%= v.getNum_venta() %></td>
                                                    <td><%= v.getMedio_pago()%></td>
                                                    
                                                      <% 
                                                        SimpleDateFormat sf = new SimpleDateFormat("dd/MM/yyyy");
                                                        String fechaVenta = (v.getFecha_venta()!=null) ?  sf.format(v.getFecha_venta()): "";
                                                        
                                                    %>
                                                    
                                                    <td><%= fechaVenta %></td>
                                                    <td > 
                                                       <form action="SvEliminarVenta" method="GET">
                                                            
                                                           <input type="hidden" name="cod_venta" value="<%= v.getNum_venta() %>">
                                                            <input type="submit" class =" btn-danger btn-sm " value="Eliminar">
                                                        </form> 
                                                        
                                                            </td>
                                                    <td>
                                                        <form action="SvModificarVenta" method="GET">
                                                            
                                                            <input type="hidden" name="cod_venta" value="<%= v.getNum_venta() %>">
                                                            <input type="submit" class =" btn-warning btn-sm " value="Editar">
                                                        </form> 
                                                    
                                                    </td>
                                                    
                                                    
                                                    <td>
                                                        <form action="SvDetalleVenta" method="GET">
                                                            
                                                            <input type="hidden" name="cod_venta" value="<%= v.getNum_venta() %>">
                                                            <input type="submit" class =" btn-primary btn-sm " value="Ver Venta">
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
