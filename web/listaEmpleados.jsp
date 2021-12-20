

<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="logica.modelos.Empleado"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de Empleados</title>

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
                                                    <th>Nombre</th>
                                                    <th>Apellido</th>
                                                    <th>Celular</th>
                                                    <th>Dirección</th>
                                                    <th>Dni</th>
                                                    <th>Email</th>
                                                    <th>Nacionalidad</th>
                                                    <th>F. Nacimiento</th>
                                                    <th>Cargo</th>
                                                    <th>Sueldo</th>
                                                    <th>Eliminar</th>
                                                    <th>Editar</th>

                                                </tr>
                                            </thead>
                                            <tbody>


                                                <%
                                                    
                                                    List<Empleado> listaEmpleados = (List) request.getSession().getAttribute("listaEmpleados");
 
                                                    for (Empleado e : listaEmpleados) {
                                                    

                                                %> 



                                                <tr>
                                                    
                                                    <% 
                                                        SimpleDateFormat sf = new SimpleDateFormat("dd/MM/yyyy");
                                                        String fechaNacimiento = (e.getFecha_nac()!=null) ?  sf.format(e.getFecha_nac()): "";
                                                        
                                                    %>
                                                    
                                                    
                                                    <td><%= e.getNombre() %></td>
                                                    <td><%= e.getApellido() %></td>
                                                    <td><%= e.getCelular()%></td>
                                                    <td><%= e.getDireccion()%></td>
                                                    <td><%= e.getDni()%></td>
                                                    <td><%= e.getEmail()%></td>
                                                    <td><%= e.getNacionalidad()%></td>
                                                    <td><%= fechaNacimiento %></td>
                                                    <td><%= e.getCargo() %></td>
                                                    <td><%= e.getSueldo()%></td>
                                                    
                                                    <td > 
                                                       <form action="SvEliminar" method="GET">
                                                            
                                                            <input type="hidden" name="cod_persona" value="<%= e.getCodigo_persona() %>">
                                                            <input type="submit" class =" btn-danger btn-sm " value="Eliminar">
                                                        </form> 
                                                    <td>
                                                        <form action="SvModif" method="GET">
                                                            
                                                            <input type="hidden" name="cod_persona" value="<%= e.getCodigo_persona() %>">
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
