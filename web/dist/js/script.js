

    
window.onload = function() {
    
$(".servicioOPaquete").click(function(){
          
            var valor = $(this).val();
          
         
            if(valor == 'servicio'){
                $("#div1").css("display", "block");
                $("#div2").css("display", "none");
                
            }
            else{
                
                $("#div2").css("display", "block");
                $("#div1").css("display", "none");
               

            }
 });


 // Seleccionar Cliente 
 
 $('#tbCliente tr input').on('click', function(){
  

  
 var id = $(this).attr("data-id");
 var dniCliente = $(this).attr("data-dni");
 var nombreApellido = $(this).attr("data-nombre") + " " + $(this).attr("data-apellido");

 
 $('#cod_Cliente').val(id);
 $('#dniCliente').val(dniCliente);
 $('#nombreCliente').val(nombreApellido);
 
});
 
 
 
 
 // Seleccionar Empleado
 
  $('#tbEmpleado tr input').on('click', function(){
  

  
 var id = $(this).attr("data-id");
 var dniEmpleado = $(this).attr("data-dni");
 var nombreEmpleado = $(this).attr("data-nombre") + " " + $(this).attr("data-apellido");


 
 $('#cod_Empleado').val(id);
 $('#dniEmpleado').val(dniEmpleado);
 $('#nombreEmpleado').val(nombreEmpleado);
 
});
 
 
 
 
 
 
 
};

