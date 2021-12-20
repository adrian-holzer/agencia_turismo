
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Alta Empleado</title>
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
                                        <h3 class="card-title">Alta de Empleado</h3>
                                    </div>
                                    <!-- /.card-header -->
                                    <!-- form start -->
                                    <form action="SvAltaEmpleado" method="POST">
                                        <div class="card-body">

                                            <div class="form-group">
                                                <label for="nombre">Nombre</label>
                                                <input type="text" class="form-control" name="nombre" id="nombre" placeholder="Nombre">
                                            </div>



                                            <div class="form-group">
                                                <label for="apellido">Apellido</label>
                                                <input type="text" class="form-control" name="apellido" id="apellido" placeholder="Apellido">
                                            </div>

                                            <div class="form-group">
                                                <label for="celular">Celular</label>
                                                <input type="text" class="form-control" name="celular" id="celular" placeholder="Celular">
                                            </div>


                                            <div class="form-group">
                                                <label for="direccion">Direccion</label>
                                                <input type="text" class="form-control" name="direccion" id="direccion" placeholder="Direccion">
                                            </div>

                                            <div class="form-group">
                                                <label for="dni">Dni</label>
                                                <input type="text" class="form-control" name="dni" id="dni" placeholder="DNI">
                                            </div>

                                            <div class="form-group">
                                                <label for="email">Email</label>
                                                <input type="email" class="form-control" name="email" id="email" placeholder="Email">
                                            </div>

                                            <div class="form-group">
                                                <label for="nacionalidad">Nacionalidad</label>
                                                <input type="text" class="form-control" name="nacionalidad" id="nacionalidad" placeholder="Nacionalidad">
                                            </div>

                                            <div class="form-group">
                                                <label for="fechaNacimiento">Fecha Nacimiento</label>
                                                <input type="date"  class="form-control" name="fechaNacimiento" id="fechaNacimiento" placeholder="Fecha Nacimiento">
                                            </div>
                                           
                                            <div class="form-group">
                                                 <label for="cargo">Cargo</label>
                                                <select  class="custom-select rounded-0" name="cargo" id="cargo" id="exampleSelectRounded0">
                                                    <option>Administrador</option>
                                                    <option>Soporte Tecnico</option>
                                                    <option>Vendedor</option>
                                                    <option>Secretario</option>
                                                    
                                                </select>
                                            </div>
                                            <div class="form-group">
                                                <label for="sueldo">Sueldo</label>
                                                <input type="text" class="form-control" name="sueldo" id="sueldo" placeholder="Sueldo">
                                            </div>




                                            <div class="form-group">
                                                <label for="nombreUsuario">Nombre de Usuario</label>
                                                <input type="text" class="form-control" name="nombreUsuario" id="nombreUsuario" placeholder="Nombre de Usuario">
                                            </div>

                                            <div class="form-group">
                                                <label for="password">Password</label>
                                                <input type="password" class="form-control" name="password" id="password" placeholder="Contraseña">
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
        
         <% }%>
    </body>
</html>
