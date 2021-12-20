

<%@page import="java.util.List"%>
<%@page import="logica.modelos.Servicio"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Alta Paquete</title>
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


                        <%

                            if (request.getSession().getAttribute("error") != null) {


                        %>

                        <div class="alert alert-danger" role="alert">
                            <%= request.getSession().getAttribute("error")%>
                        </div>

                        <%
            request.getSession().setAttribute("error", null);

        }%>

                        <!-- /.row -->
                        <div class="row">
                            <div class="col-12">



                                <div class="card card-success">
                                    <div class="card-header">
                                        <h3 class="card-title">Alta de Paquete</h3>
                                    </div>

                                    <%

                                        List<Servicio> listaServicios = (List) request.getSession().getAttribute("listaServicios");


                                    %>
                                    <!-- /.card-header -->
                                    <!-- form start -->
                                    <form action="SvCrearPaquete" method="POST">
                                        <div class="card-body">

                                            <div class="col-sm-6">
                                                <!-- checkbox -->
                                                <div class="form-group">
                                                    <label for="apellido">Servicios : </label>


                                                    <%                                                        for (Servicio s : listaServicios) {

                                                    %>

                                                    <div class="form-check">
                                                        <input class="form-check-input" name="check" type="checkbox"  value="<%= s.getCodigo_servicio()%>">
                                                        <label class="form-check-label"><%= s.getNombre()%></label>
                                                    </div>


                                                    <% }%>
                                                </div>
                                            </div>


                                        </div>
                                        <!-- /.card-body -->

                                        <div class="card-footer">
                                            <button type="submit" class="btn btn-success">Guardar</button>
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
    </body>
     <% }%>
</html>
