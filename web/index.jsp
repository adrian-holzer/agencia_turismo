<%-- 
    Document   : index
    Created on : 20 dic. 2021, 15:25:21
    Author     : usuario
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    
    
    <%

HttpSession misession  = request.getSession();
String usu = (String) misession.getAttribute("usuario");

if (usu!=null) {
        response.sendRedirect("principal.jsp");
   
    }
%>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Agencia de Turismo</title>
        
        
            <%@include file="head.jsp" %>
  <!-- Custom styles for this template -->
  <link href="./dist/signin.css" rel="stylesheet">

    </head>
    <body  class="text-center">
        
        <div class="login-box">
  <div class="login-logo">
    <a href="../../index2.html">Login</a>
  </div>
  <!-- /.login-logo -->
  <div class="card">
    <div class="card-body login-card-body">
     
      <form action="SvLogin" method="post">
        <div class="input-group mb-3">
            <input type="text" class="form-control" name="usuario" placeholder="Usuario">
          <div class="input-group-append">
            <div class="input-group-text">
              <span class="fas fa-envelope"></span>
            </div>
          </div>
        </div>
        <div class="input-group mb-3">
            <input type="password" name="password" class="form-control" placeholder="Password">
          <div class="input-group-append">
            <div class="input-group-text">
              <span class="fas fa-lock"></span>
            </div>
          </div>
        </div>
        <div class="row">
         
          <div class="col-6">
            <button type="submit" class="btn btn-primary btn-block">Iniciar Sesión</button>
          </div>
          <!-- /.col -->
        </div>
      </form>

   
    </div>
    <!-- /.login-card-body -->
  </div>
</div>
        
        
         <%@include file="linkscript.jsp" %>

    </body>
</html>
