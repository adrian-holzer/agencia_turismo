




<%@page import="logica.modelos.Empleado"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
    <%

HttpSession misession  = request.getSession();
String usu = (String) misession.getAttribute("usuario");

if (usu==null) {
        response.sendRedirect("index.jsp");
    }else{
    

%>

  <!-- Main Sidebar Container -->
  <aside class="main-sidebar sidebar-dark-primary elevation-4">
    <!-- Brand Logo -->
    <a href="/" class="brand-link">
      <img src="../../dist/img/AdminLTELogo.png" alt="AdminLTE Logo" class="brand-image img-circle elevation-3" style="opacity: .8">
      <span class="brand-text font-weight-light">Agencia de Turismo</span>
    </a>

    <!-- Sidebar -->
    <div class="sidebar">
      <!-- Sidebar user (optional) -->
      <div class="user-panel mt-3 pb-3 mb-3 d-flex">
        <div class="image">
          
        </div>
        <div class="info">
          <a href="#" class="d-block"><%= usu  %></a>
        </div>
      </div>

      

      <!-- Sidebar Menu -->
      <nav class="mt-2">
        <ul class="nav nav-pills nav-sidebar flex-column" data-widget="treeview" role="menu" data-accordion="false">
          <!-- Add icons to the links using the .nav-icon class
               with font-awesome or any other icon font library -->
          <li class="nav-item">
            <a href="#" class="nav-link">
              <i class="nav-icon fas fa-user-alt"></i>
              <p>
                Empleados
                <i class="right fas fa-angle-left"></i>
              </p>
            </a>
            <ul class="nav nav-treeview">
              <li class="nav-item">
                  <a href="SvConsultaEmpleados" class="nav-link">
                  <i class="far fa-circle nav-icon"></i>
                  <p>Listado</p>
                </a>
              </li>
              <li class="nav-item">
                <a href="altaEmpleado.jsp" class="nav-link">
                  <i class="far fa-circle nav-icon"></i>
                  <p>Alta</p>
                </a>
              </li>
              
              
            </ul>
          </li>
          
         <li class="nav-item">
            <a href="#" class="nav-link">
              <i class="nav-icon fas fa-user-alt"></i>
              <p>
                Clientes
                <i class="right fas fa-angle-left"></i>
              </p>
            </a>
            <ul class="nav nav-treeview">
              <li class="nav-item">
                  <a href="SvListClientes" class="nav-link">
                  <i class="far fa-circle nav-icon"></i>
                  <p>Listado</p>
                </a>
              </li>
              <li class="nav-item">
                <a href="AltaCliente.jsp" class="nav-link">
                  <i class="far fa-circle nav-icon"></i>
                  <p>Alta</p>
                </a>
              </li>
              
            </ul>
          </li>
          
           <li class="nav-item">
            <a href="#" class="nav-link">
              <i class="nav-icon fas fa-edit"></i>
              <p>
                Ventas
                <i class="right fas fa-angle-left"></i>
              </p>
            </a>
            <ul class="nav nav-treeview">
              <li class="nav-item">
                  <a href="SvlistaVentas" class="nav-link">
                  <i class="far fa-circle nav-icon"></i>
                  <p>Listado</p>
                </a>
              </li>
              <li class="nav-item">
                <a href="SvCrearVenta" class="nav-link">
                  <i class="far fa-circle nav-icon"></i>
                  <p>Alta</p>
                </a>
              </li>
              
            </ul>
          </li>
     
          
          
          
           <li class="nav-item">
            <a href="#" class="nav-link">
              <i class="nav-icon fas fa-suitcase-rolling"></i>
              <p>
                Paquetes
                <i class="right fas fa-angle-left"></i>
              </p>
            </a>
            <ul class="nav nav-treeview">
              <li class="nav-item">
                  <a href="SvListaPaquetes" class="nav-link">
                  <i class="far fa-circle nav-icon"></i>
                  <p>Listado</p>
                </a>
              </li>
              <li class="nav-item">
                <a href="SvCrearPaquete" class="nav-link">
                  <i class="far fa-circle nav-icon"></i>
                  <p>Alta</p>
                </a>
              </li>
              
            </ul>
          </li>
          
          
          
          
          
          
           <li class="nav-item">
            <a href="#" class="nav-link">
              <i class="nav-icon fas fa-suitcase-rolling"></i>
              <p>
                Servicios
                <i class="right fas fa-angle-left"></i>
              </p>
            </a>
            <ul class="nav nav-treeview">
              <li class="nav-item">
                  <a href="SvlistarServicios" class="nav-link">
                  <i class="far fa-circle nav-icon"></i>
                  <p>Listado</p>
                </a>
              </li>
              <li class="nav-item">
                <a href="altaServicio.jsp" class="nav-link">
                  <i class="far fa-circle nav-icon"></i>
                  <p>Alta</p>
                </a>
              </li>
              
            </ul>
          </li>
          
          
       
          
          <li class="nav-item mt-5">
               
              <form action="SvLogin" method="GET">
                  
                  
             
              <p class="nav-link">
                  <i class="fas fa-power-off mx-2 "></i>   <input type="submit" class="btn btn-danger btn-sm" value="Cerrar Sesion"> 
              </p>
      </i>
            
              </form>
                  
                 
          </li>
       
        </ul>
      </nav>
      <!-- /.sidebar-menu -->
    </div>
    <!-- /.sidebar -->
  </aside>
