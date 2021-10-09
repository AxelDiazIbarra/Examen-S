
agregarEmpleado()

    var data;
    var url = "http://localhost:8093/empleados/";
         
        data = JSON.stringify({           
          //id: $('#id_p').val(),
          empleadoId: $('#empleadoId').val(),
          nombre: $('#nombre').val(),
          telefono: $('#telefono').val(),
          correo: $('#corrreo').val()
        });

        console.log(data.fechaNacimiento);
        

        $.ajax({
          method: "POST",
          url: url,
          data: data,
          dataType: 'json',
          contentType: "application/json",
          success: function (data) {
            console.log('Rellenando la tabla');
            mostrarTodosEmpleados();
            $('.alert-success').html('Se añadio el empleado').fadeIn().delay(4000).fadeOut('snow');

          },
          error: function (errors) {
            $('.alert-success').html('No fue posible añadir el empleado').fadeIn().delay(4000).fadeOut('snow');
            console.log(errors);
          }
        });
 