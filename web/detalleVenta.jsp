<%-- 
    Document   : detalleVenta
    Created on : 20 dic. 2021, 5:33:07
    Author     : usuario
--%>

<%@page import="logica.modelos.Servicio"%>
<%@page import="logica.modelos.Venta"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <%

        Venta v = (Venta) request.getSession().getAttribute("venta");

    %>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Detalle Venta</title>

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


                                    </div>
                                    <!-- /.card-header -->
                                    <div class="card-body table-responsive p-0 text-lg-left ml-4 p-4">

                                        <div class="card card-primary">
                                            <div class="card-header">
                                                <h3 class="card-title">Detalle Venta</h3>
                                            </div>
                                            <!-- /.card-header -->
                                            <div class="card-body">
                                                <strong> Código</strong>

                                                <p class="text-muted">
                                                    <%= v.getNum_venta()%>
                                                </p>

                                                <hr>

                                                <strong>Medio de pago</strong>

                                                <p class="text-muted"><%= v.getMedio_pago()%></p>

                                                <hr>



                                                <strong> Costo</strong>

                                               

                                                <%

                                                    if (v.getServicio() != null) {


                                                %>

                                                <p>$<%=  v.getServicio().getCosto_servicio()%></p>

                                                <%  }

                                                    if (v.getPaquete() != null) {


                                                %>

                                                <p>$<%= v.getPaquete().getCosto_paquete() %></p>

                                                <%  }%>
                                                </p>

                                                <hr>

                                                <strong>Cliente</strong>

                                                <p class="text-muted">



                                                <hr>  

                                                <p>Nombre y Apellido :  <%= v.getCliente().getNombre() + " " + v.getCliente().getApellido()%></p>
                                                <p>Dni :  <%= v.getCliente().getDni()%></p>
                                                <p>Dirección :  <%= v.getCliente().getDireccion()%></p>

                                                </p>





 <hr> 
                                                <strong>Empleado</strong>

                                                <p class="text-muted">



                                                <hr>  

                                                <p>Nombre y Apellido :  <%= v.getEmpleado().getNombre() + " " + v.getEmpleado().getApellido()%></p>
                                                <p>Dni :  <%= v.getEmpleado().getDni()%></p>
                                                <p>Cargo :  <%= v.getEmpleado().getCargo()%></p>


                                                </p>
                                                
                                                
                                                
                                                
                                                
                                                
                                                
                                                
                                                <% 
                                                
                                                if (v.getServicio()!=null) {
                                                        
                                                    
                                                
                                                
                                                %>
                                                 <strong>Servicio</strong>

                                                <p class="text-muted">

                                                <hr>  
                                                
                                                <%= v.getServicio().getNombre()  %>
                                                </p>
                                                <p class="text-muted">

                                               $ <%= v.getServicio().getCosto_servicio()%>
                                                
                                               
                                                </p>
                                                
                                                <%}%>
                                                
                                                
                                                
                                                   
                                                <% 
                                                
                                                if (v.getPaquete()!=null) {
                                                        
                                                %>
                                                
                                                  <hr> 
                                                <strong >Paquete de Servicios</strong>
 <hr> 
                                                 <%  for (Servicio s : v.getPaquete().getListaServicios()) {
                                                         
                                                     
                                                 %>
                                                 
                                                  <p class="text-muted">

                                                      <%=  s.getCodigo_servicio() +"-"+ s.getNombre()  %>
                                                </p>
                                                 <p class="text-muted">

                                               $<%= s.getCosto_servicio() %>
                                                
                                               
                                                </p>
                                                 
                                                 <%   
                                                     }
                                                 
                                                 %>
                                               
                                                
                                                
                                                <%}%>
                                               

                                            </div>
                                            <!-- /.card-body -->
                                        </div>
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
