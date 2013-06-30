<script>
function alt_Multas(){
	
		var form=document.getElementById("frmAlternativo");
		form.accion.value="AplicarMulta";
		form.submit();
	}
</script>
<form id="frmAlternativo" name="frmAlternativo" method="POST" action="SMVPago">
			  <input type="hidden" name="accion" value="AplicarMulta"></input>
			 <input type="hidden" name="tipo" value="1"></input>
			  </form>
			  <script>alt_Multas();</script>
		    