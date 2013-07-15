<script>
function alt_Buscar(){
	
		var form=document.getElementById("frmAlternativo");
		form.accion.value="BuscarNuevo";
		form.submit();
	}
</script>
<form id="frmAlternativo" name="frmAlternativo" method="POST" action="SMVVentaProductos">
			 <input type="hidden" name="tipo" value="1"></input>
			 <input type="hidden" name="accion" value="BuscarNuevo"></input>
			  </form>
			  <script>alt_Buscar();</script>