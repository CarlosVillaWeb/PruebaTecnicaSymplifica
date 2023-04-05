            function agregarProductos() {
			// Obtenemos todos los checkboxes que estén seleccionados
			var checkboxes = document.querySelectorAll('input[name="productoSeleccionado"]:checked');
			var productosSeleccionados = [];

			// Iteramos sobre los checkboxes seleccionados y agregamos los productos correspondientes a la lista
			for (var i = 0; i < checkboxes.length; i++) {
				var productoId = checkboxes[i].value;
				var producto = getProductobyId(productoId);
				productosSeleccionados.push(producto);
			}

			// Actualizamos la lista de productos seleccionados en la tabla de la derecha utilizando Thymeleaf
			var template = document.querySelector('#productosSeleccionadosTemplate');
			var templateContent = template.innerHTML;
			var rendered = Mustache.render(templateContent, { productosSeleccionados: productosSeleccionados });
			document.querySelector('#productosSeleccionados').innerHTML = rendered;
		}

		function getProductobyId(id) {
			// Simulamos una llamada a una API para obtener el producto correspondiente al ID
			// Aquí deberías reemplazar esta función con una llamada real a tu API para obtener los productos
			var productosDisponibles = ${productosDisponibles};
			for (var i = 0; i < productosDisponibles.length; i++) {
				if (productosDisponibles[i].id === id) {
					return productosDisponibles[i];
				}
			}
			return null;
		}