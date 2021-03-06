
<%@page import="logica.modelos.Servicio"%>
<%@page import="logica.modelos.Paquete"%>
<%@page import="logica.modelos.Cliente"%>
<%@page import="logica.modelos.Empleado"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Alta Venta</title>
        <%@include file="head.jsp" %>
    </head>
    <body class="hold-transition sidebar-mini">

        <div class="wrapper">

            <%@include file="navbar.jsp" %>

            <%@include file="aside.jsp" %>

            <%
                List<Empleado> listaEmpleados = (List) request.getSession().getAttribute("listaEmpleados");
                List<Cliente> listaClientes = (List) request.getSession().getAttribute("listaClientes");
                List<Servicio> listaServicios = (List) request.getSession().getAttribute("listaServicios");
                List<Paquete> listaPaquetes = (List) request.getSession().getAttribute("listaPaquetes");

                System.out.println(listaEmpleados.size());
                System.out.println(listaClientes.size());
                System.out.println(listaServicios.size());
                System.out.println(listaPaquetes.size());

            %>

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
                                        <h3 class="card-title">Crear Venta</h3>
                                    </div>


                                    <!-- /.card-header -->
                                    <!-- form start -->
                                    <form action="SvCrearVenta" method="POST">
                                        <div class="card-body">

                                            <div class="col-sm-6">
                                                <div class="form-group">
                                                    <label for="medio_pago">Medio de Pago</label>
                                                    <select  class="custom-select rounded-0" name="medio_pago" id="medio_pago" >
                                                        <option>Efectivo</option>
                                                        <option>Tarjeta de Debito</option>
                                                        <option>Tarjeta de Credito</option>
                                                        <option>Monedero Virtual</option>
                                                        <option>Transferencia</option>

                                                    </select>
                                                </div>


                                                <div class="form-group">
                                                    <label for="fechaVenta">Fecha de Venta</label>
                                                    <input type="date"  class="form-control" name="fechaVenta" id="fechaVenta" >
                                                </div>




                                                <div class="form-group">
                                                    <hr>
                                                    <p class="mt-5 font-weight-bold">Seleccionar Empleado : </p>
                                                    <hr>
                                                    <input type="hidden" id="cod_Empleado" name="cod_Empleado">

                                                    <label  for="nombreEmpleado">Nombre y Apellido  </label>
                                                    <input disabled class="form-control" type="type" id="nombreEmpleado" name="nombreEmpleado">
                                                    <label for="dniEmpleado">Dni  </label>
                                                    <input disabled class="form-control" type="type" id="dniEmpleado" name="dniEmpleado">

                                                    <input  data-toggle="modal" data-target=".bd-example-modal-lg2" type="button" class =" btn btn-primary m-4" value="Seleccionar Empleado">

                                                </div>


                                                <div class="form-group">

                                                    <hr>
                                                    <p class="mt-5 font-weight-bold">Seleccionar Cliente : </p>
                                                    <hr>

                                                    <input type="hidden" id="cod_Cliente" name="cod_Cliente">

                                                    <label for="nombreCliente">Nombre y Apellido  </label>
                                                    <input class="form-control" disabled type="type" id="nombreCliente" name="nombreCliente">



                                                    <label for="dniCliente">Dni  </label>
                                                    <input  class="form-control" disabled  type="type" id="dniCliente" name="dniCliente">

                                                    <input  data-toggle="modal" data-target=".bd-example-modal-lg" type="button" class =" btn btn-primary m-4" value="Seleccionar cliente">

                                                </div>




                                                <hr>

                                                <div  class="form-group mb-5 mt-5">   

                                                    <label for="servicioOPaquete">Seleccionar Servicio</label>

                                                    <input checked  type="radio" class="servicioOPaquete ml-2" name="servicioOPaquete" value="servicio"  />





                                                    <div id="div1" style="display">

                                                        <table class="table">
                                                            <thead>
                                                                <tr>

                                                                    <th scope="col">Nombre</th>
                                                                    <th scope="col">Costo</th>
                                                                    <th scope="col">Seleccionar</th>
                                                                </tr>
                                                            </thead>
                                                            <tbody>


                                                                <%       for (Servicio s : listaServicios) {


                                                                %>

                                                                <tr>

                                                                    <td><%= s.getNombre()%></td>
                                                                    <td><%= s.getCosto_servicio()%></td>

                                                                    <td><input   type="radio" class="radioNameS" name="radioServicio" value="<%= s.getCodigo_servicio()%>"/>
                                                                    </td>
                                                                </tr>




                                                                <% } %> </tbody>
                                                        </table>

                                                    </div>
                                                </div>

                                                <div  class="form-group mt-5">
                                                    <hr>
                                                    <label for="servicioOPaquete">Seleccionar Paquete</label>
                                                    <input type="radio"  class="servicioOPaquete ml-2" name="servicioOPaquete" value="paquete"/>



                                                    <div id="div2" style="display:none;" >

                                                        
                                
                                                        

                                                        
                                                        
                                                        
                                                         <%       for (Paquete p : listaPaquetes) {


                                                           %>

                                                         <p> C??digo Paquete :  <%= p.getCodigo_paquete()%></p>
                                                           <p> Costo Paquete :  $<%= p.getCosto_paquete() %></p>
                                                          
                                                           <input    type="radio" class="radioNameP" name="radioPaquete" value="<%= p.getCodigo_paquete() %>"/>

                                                           <hr>  <hr>
                                                       

                                                        <%  
                                                            }
                                                        %>
                                                    </div>


                                                    
                                                    
                                                </div>


                                            </div>


                                        </div>
                                        <!-- /.card-body -->

                                        <div class="card-footer">
                                            <button type="submit" class="btn btn-success">Guardar </button>
                                        </div>
                                    </form>
                                </div>


                            </div>
                        </div>
                        <!-- /.row -->





                        <div class="modal fade bd-example-modal-lg" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true">
                            <div class="modal-dialog modal-lg">
                                <div class="modal-content">

                                    <table class="table" id="tbCliente">
                                        <thead>
                                            <tr>
                                                <th scope="col">Dni</th>
                                                <th scope="col">Nombre</th>
                                                <th scope="col">Apellido</th>
                                                <th scope="col">Celular</th>
                                                <th scope="col">Direcci??n</th>
                                                <th scope="col">Seleccionar</th>

                                            </tr>
                                        </thead>
                                        <tbody>
                                            <%

                                                for (Cliente c : listaClientes) {

                                            %>
                                            <tr >


                                                <td  class="dniCliente"><%= c.getDni()%></td>

                                                <td class="nombreCliente"><%= c.getNombre()%></td>
                                                <td class="apellidoCliente"><%= c.getApellido()%></td>
                                                <td><%= c.getCelular()%></td>
                                                <td><%= c.getDireccion()%></td>
                                                <td>
                                                    <input type="button" class ="btn-primary btn-sm" name="btnSelect" data-nombre="<%= c.getNombre()%>" data-apellido="<%= c.getApellido()%>" data-dni="<%= c.getDni()%>" data-id="<%= c.getCodigo_persona()%>"  data-dismiss="modal"  value="Seleccionar">
                                                </td>

                                            </tr>

                                            <%
                                                }
                                            %>
                                        </tbody>
                                    </table>


                                </div>
                            </div>
                        </div>





                        <div class="modal fade bd-example-modal-lg2" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel2" aria-hidden="true">
                            <div class="modal-dialog modal-lg">
                                <div class="modal-content">

                                    <table class="table" id="tbEmpleado">
                                        <thead>
                                            <tr>
                                                <th scope="col">Dni</th>
                                                <th scope="col">Nombre</th>
                                                <th scope="col">Apellido</th>
                                                <th scope="col">Celular</th>
                                                <th scope="col">Direcci??n</th>
                                                <th scope="col">Seleccionar</th>

                                            </tr>
                                        </thead>
                                        <tbody>
                                            <%
                                                for (Empleado e : listaEmpleados) {

                                            %>
                                            <tr >


                                                <td  class="dniEmpleado"><%= e.getDni()%></td>

                                                <td class="nombreEmpleado"><%= e.getNombre()%></td>
                                                <td class="apellidoEmpleado"><%= e.getApellido()%></td>
                                                <td><%= e.getCelular()%></td>
                                                <td><%= e.getDireccion()%></td>
                                                <td>
                                                    <input type="button" class ="btn-primary btn-sm" name="btnSelect" data-nombre="<%= e.getNombre()%>" data-apellido="<%= e.getApellido()%>" data-dni="<%= e.getDni()%>" data-id="<%= e.getCodigo_persona()%>"  data-dismiss="modal"  value="Seleccionar">
                                                </td>

                                            </tr>

                                            <%
                                                }
                                            %>
                                        </tbody>
                                    </table>


                                </div>
                            </div>
                        </div>
                                        
                                        
                                        
                                        
                        
                        



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
