<%-- 
    Document   : editarServicio
    Created on : 16 dic. 2021, 20:23:31
    Author     : usuario
--%>

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="logica.modelos.Servicio"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Editar Servicio</title>
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



                                <div class="card card-success">
                                    <div class="card-header">
                                        <h3 class="card-title">Editar Servicio</h3>
                                    </div>
                                    <!-- /.card-header -->
                                    <!-- form start -->

                                    <%
                                        Servicio s = (Servicio) request.getSession().getAttribute("servicio");
                                    %>

                                   <form action="SvModificarServicio" method="POST">
                                        <div class="card-body">

                                            <div class="form-group">
                                                <label for="nombre">Nombre</label>
                                                <input type="text" value="<%= s.getNombre() %>" class="form-control" name="nombre" id="nombre" placeholder="Nombre">
                                            </div>



                                            <div class="form-group">
                                                <label for="descripcion">Descripcion</label>
                                                <input type="text"value="<%= s.getDescripcion()%>" class="form-control" name="descripcion" id="descripcion" placeholder="Descripcion">
                                            </div>

                                            <div class="form-group">
                                                <label for="destino">Destino</label>
                                                <input type="text" value="<%= s.getDestino_servicio()%>" class="form-control" name="destino" id="destino" placeholder="Destino">
                                            </div>


                                            <div class="form-group">
                                                <label for="costo">Costo</label>
                                                <input type="text" value="<%= s.getCosto_servicio()%>" class="form-control" name="costo" id="costo" placeholder="Costo">
                                            </div>


                                            
                                                <%
                                                    SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
                                                    String fecha = (s.getFecha_servicio()!= null) ? sf.format(s.getFecha_servicio()) : "";

                                                %>
                                            <div class="form-group">
                                                <label for="fechaServicio">Fecha del Servicio</label>
                                                <input type="date" value="<%= fecha %>" class="form-control" name="fechaServicio" id="fechaServicio">
                                            </div>
                                        


                                        </div>
                                        <!-- /.card-body -->

                                        <div class="card-footer">
                                            <button type="submit" class="btn btn-success">Editar</button>
                                        </div>
                                    </form>
                                </div>

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
