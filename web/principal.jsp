

<%@page contentType="text/html" pageEncoding="UTF-8"%>



<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Agencia de Turismo</title>

        <%@include file="head.jsp" %>


    </head>

    <body class="hold-transition sidebar-mini">
        <div class="wrapper">

            <%@include file="navbar.jsp" %>

            <%@include file="aside.jsp" %>


            <!-- Content Wrapper. Contains page content -->
            <div class="content-wrapper">
                

                <!-- Main content -->
                <section class="content">
                    <div class="container-fluid">
                        <div class="row">
                            <div class="col-md-12">
                                  <div class="jumbotron">
                                            <h1 class="display-4 text-center">Administración Agencia de Turismo</h1>
                                            <hr class="my-4">
                                            
                                        </div>


                                <!-- /.card -->
                            </div>
                            <!-- /.col -->
                        </div>

                    </div><!-- /.container-fluid -->
                </section>
                <!-- /.content -->
            </div>



            <!-- /.content-wrapper -->
            <%@include file="footer.jsp" %>



        </div>

        <!-- ./wrapper -->

        <%@include file="linkscript.jsp" %>


    </body>
 <% }%>
</html>
