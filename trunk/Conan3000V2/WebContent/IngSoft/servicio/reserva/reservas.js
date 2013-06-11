function cambiarClase(elemento){
	if(atipo==1) cAgregar(elemento);
	else if(atipo==2)cEliminar(elemento);

	
}

function cAgregar(elemento){
	if (elemento.className == "btn btn-success") {
		elemento.className = "btn btn-warning";
		elemento.innerHTML=elemento.innerHTML.replace("Reservar&nbsp;&nbsp;&nbsp;","Pendiente");
		var temp=elemento.getAttribute("id")+"@";
		if(cancelados.search(temp)<0)
		pendientes=pendientes.concat(temp);
		else cancelados=cancelados.replace(temp,"");

		}
		else 
		if(elemento.className == "btn btn-warning") {
		elemento.className = "btn btn-success";
		elemento.innerHTML=elemento.innerHTML.replace("Pendiente","Reservar&nbsp;&nbsp;&nbsp;");
		var temp=elemento.getAttribute("id")+"@";
		if(pendientes.search(temp)<0)
		cancelados=cancelados.concat(temp);
		else pendientes=pendientes.replace(temp,"");
		}	
}

function cEliminar(elemento){
	if (elemento.className == "btn btn-danger") {
		elemento.className = "btn btn-warning";
		elemento.innerHTML=elemento.innerHTML.replace("Reservado","Pendiente");
		var temp=elemento.getAttribute("id")+"@";
		if(cancelados.search(temp)<0)
		pendientes=pendientes.concat(temp);
		else cancelados=cancelados.replace(temp,"");

		}
		else 
		if(elemento.className == "btn btn-warning") {
		elemento.className = "btn btn-danger";
		elemento.innerHTML=elemento.innerHTML.replace("Pendiente","Reservado");
		var temp=elemento.getAttribute("id")+"@";
		if(pendientes.search(temp)<0)
		cancelados=cancelados.concat(temp);
		else pendientes=pendientes.replace(temp,"");
		}	
}
function actFecha(elem){
	var temp= elem.val();
	var now=$.datepicker.parseDate("dd/mm/yy",temp);
	a=now.getDay();
	if(a==0)a=6;
	else a=a-1;
	now.setDate(now.getDate()-a);
	$('#fFechaIni').val($.datepicker.formatDate("dd/mm/yy",now));
	now.setDate(now.getDate()+6);
	$('#fFechaFin').val($.datepicker.formatDate("dd/mm/yy",now));
}

function ajax_submit(tipo){
	//alert("accion=Buscar"+"&tipo=" + tipo + "&fecIni=" + $(fecIni).val()+"&cmbServicios"+$('#cmbServicios').val());
	if(lock1==1){
	lock1=0;
	$.ajax({
		  type: "POST",
		  url: "/Conan3000V2/IngSoft/servicio/reserva/SMSReserva",
		  data: "accion=Buscar"+"&tipo=" + tipo + "&fecIni=" + $(fecIni).val()+"&cmbServicios="+$('#cmbServicios').val()+"&cmbSedes="+$('#cmbSedes').val()
		  +"&cmbTipoCancha="+$('#cmbTipoCancha').val()+"&pendientes="+pendientes+"&cancelados="+cancelados,
		  dataType: "html",
		  beforeSend: function ( xhr ) {
   		  $("#resultadoBusqueda").html("<div align='center'><img src='img/ajax-loaders/ajax-loader-7.gif'></img></div>");
  		  },
		  success: function(msg){
			$("#resultadoBusqueda").html(msg);
			pendientes="";
			cancelados="";			
			actualizar_pendientes();			
			lock1=1;
		  },
		  error: function(objeto, quepaso, otroobj){
		  	lock1=1;
			alert("ERROR!! Pas� lo siguiente: "+quepaso);
		  }
	
		});
		}
}
function cambiar(elem){
	
	var tabid='#'+elem.data('tabs');
	$('.tabsSel').removeAttr("disabled");
	elem.attr("disabled", "disabled");
		
	$('.tabs').css('display','none');
	var estado=$(tabid).css('display');
	if(estado.indexOf('none')>=0) estado='inline';
	else estado='none';
	$(tabid).css('display',estado);
}

function ajax_search(){
	//alert("accion=Buscar"+"&tipo=" + tipo + "&fecIni=" + $(fecIni).val()+"&cmbServicios"+$('#cmbServicios').val());
	if(lock2==1){
	lock2=0;
	$.ajax({
		  type: "POST",
		  url: "/Conan3000V2/IngSoft/servicio/reserva/SMSReserva",
		  data: "accion=Buscar"+"&tipo=2" +"&cmbServicios="+$('#cmbServicios').val()+"&cmbSedes="+$('#cmbSedes').val()+"&cmbTipoCancha="+$('#cmbTipoCancha').val()
		  +"&fFechaIni="+$('#fFechaIni').val(),
		  dataType: "html",
		  beforeSend: function ( xhr ) {
   		  $("#resultadoBusqueda").html("<div align='center'><img src='img/ajax-loaders/ajax-loader-7.gif'></img></div>");
   		  pendientes='';
   		  cancelados='';
  		  },
		  success: function(msg){
			$("#resultadoBusqueda").html(msg);			
			lock2=1;					
		  },
		  error: function(objeto, quepaso, otroobj){
		  	lock2=1;
			alert("ERROR!! Pas� lo siguiente: "+quepaso);
		  }
	 
		});
	}
		return false
		
}

function cambiaModo(numero) {
	var temp='';
	if(numero==2) {
		atipo=2;
		temp=$('#titulo').html();
		temp=temp.replace('AGREGAR','ELIMINAR');
		temp=temp.replace('BUSCAR','ELIMINAR');
		$('#txtDocSocio').prop('disabled', false);
		$('#txtNomSocio').prop('disabled', false);
		$('#txtDocSocio').val('');
		$('#txtNomSocio').val('');
		$('#txtIdSocio').val('');
		$('#txtDNISocio').val('');
		$('#txtNombreSocio').val('');
		$('#titulo').html(temp);
		$('.elim').css('display','inline');
		$('.crear').css('display','none');
		$('.modEliminar').css('display','inline');
		$('.modAgregar').css('display','none');
		}
	else if(numero==1){
		atipo=1;
		temp=$('#titulo').html();
		temp=temp.replace('ELIMINAR','AGREGAR');
		temp=temp.replace('BUSCAR','AGREGAR');
		$('#txtDocSocio').prop('disabled', true);
		$('#txtNomSocio').prop('disabled', true);
		$('#txtDocSocio').val('');
		$('#txtNomSocio').val('');
		$('#txtIdSocio').val('');
		$('#txtDNISocio').val('');
		$('#txtNombreSocio').val('');
		$('#titulo').html(temp);
		$('.crear').css('display','inline');
		$('.elim').css('display','none');
		$('.modAgregar').css('display','inline');
		$('.modEliminar').css('display','none');
		}
	else if(numero==3){
		atipo=3;
		temp=$('#titulo').html();
		temp=temp.replace('ELIMINAR','BUSCAR');
		temp=temp.replace('AGREGAR','BUSCAR');
		$('#txtDocSocio').prop('disabled', false);
		$('#txtNomSocio').prop('disabled', false);
		$('#txtDocSocio').val('');
		$('#txtNomSocio').val('');
		$('#txtIdSocio').val('');
		$('#txtDNISocio').val('');
		$('#txtNombreSocio').val('');
		$('#titulo').html(temp);
		$('.crear').css('display','none');
		$('.elim').css('display','none');
		$('.modAgregar').css('display','none');
		$('.modEliminar').css('display','none');		
	}
	//$('#TipoCancha').slideUp('fast');
	//$('#cmbServicios').selectedIndex = 0;
	$("#resultadoBusqueda").html('');
	
	
}
function actualizar_pendientes(){
	var ant=($("#pendientes").attr('value').split(','));						  								  		
		var temp;
	if(atipo==1){
	  		for(i=0;i<ant.length ;i++){						  		
	  			temp=".btn-success[id='"+ant[i]+"']";						  			
	  			if(!$(temp).hasClass("btn-danger")){						  			
	  			$(temp).html("<i class='icon-ok icon-white'></i>Pendiente");						  			
	  			$(temp).toggleClass("btn-warning btn-success");}
	  			//else{
		  		//var temp=ant[i]+"@";
		  		//cancelados=cancelados.concat(temp);
		  		//}						  									  			
	  		}
	}
	else{
		for(i=0;i<ant.length ;i++){						  		
  			temp=".btn-danger[id='"+ant[i]+"']";						  			
  			if($(temp).hasClass("btn-danger")){						  			
  			$(temp).html("<i class='icon-ok icon-white'></i>Pendiente");						  			
  			$(temp).toggleClass("btn-warning btn-danger");}
  			//else{
	  		//var temp=ant[i]+"@";
	  		//cancelados=cancelados.concat(temp);
	  		//}						  									  			
  		}
	
	
	
}
						  		

}

function ajax_confirmaSocio(origen,salida,img){
	//alert("accion=Buscar"+"&tipo=" + tipo + "&fecIni=" + $(fecIni).val()+"&cmbServicios"+$('#cmbServicios').val());
	if(lock3==1){
	lock3=0;
	if(origen.val().length >0){
	$.ajax({
		  type: "POST",
		  url: "/Conan3000V2/IngSoft/servicio/reserva/SMSReserva",
		  data: "accion=Buscar"+"&tipo=5" +"&txtDNISocio="+origen.val(),
		  dataType: "text",	
		   beforeSend: function ( xhr ) {
   		  $('#txtIdSocio').val("");
			salida.val("");
			img.css('display','inline');
  		  },	  
		  success: function(msg){
			var temp;
			temp=msg.split('/');
			$('#txtIdSocio').val(temp[0]);
			salida.val(temp[1]);
			img.css('display','none');
			lock3=1;						
		  },
		  error: function(objeto, quepaso, otroobj){
			img.css('display','none');
		  	lock3=1;
			alert("ERROR!! No se pudo completar la operacion intente de nuevo");
		  }
	
		});
		
	}else{
		$('#txtNomSocio').val('');
		$('#txtIdSocio').val('');
		$('#txtNombreSocio').val('');
		lock3=1;}
	}
}

function ajax_crearReserva(){
//alert("accion=Buscar"+"&tipo=" + tipo + "&fecIni=" + $(fecIni).val()+"&cmbServicios"+$('#cmbServicios').val());
if(lock4==1){
	if($('#txtIdSocio').val().length >0){
	lock4=0;
	$.ajax({
		  type: "POST",
		  url: "/Conan3000V2/IngSoft/servicio/reserva/SMSReserva",
		  data: "accion=Buscar"+"&tipo=6" +"&cmbServicios="+$('#cmbServicios').val()+"&cmbSedes="+$('#cmbSedes').val()+"&cmbTipoCancha="+$('#cmbTipoCancha').val()
		  +"&pendientes="+pendientes+"&cancelados="+cancelados,
		  dataType: "text",
		  success: function(msg){
			$.ajax({
		  type: "POST",
		  url: "/Conan3000V2/IngSoft/servicio/reserva/SMSReserva",
		  data: "accion=Crear"+"&tipo="+ctipo +"&txtIdSocio="+$('#txtIdSocio').val(),
		  dataType: "text",		  
		  success: function(msg){
		  	lock4=1;
		  	$("#resultadoBusqueda").html("");
			alert("Operacion realizada sin problemas");},
		  error: function(objeto, quepaso, otroobj){
		  	lock4=1;
		  	alert("ERROR!! No se pudo completar la operacion intente de nuevo");
		  }
	
		});
		  },
		  error: function(objeto, quepaso, otroobj){
		  	lock4=1;
			alert("ERROR!! No se pudo completar la operacion intente de nuevo");
			
		  }
	
		});
} alert("Debe seleccionar un socio")
	}
}

function ajax_elim(){
	//if(lock4==1){
		//lock4=0;
		$.ajax({
			  type: "POST",
			  url: "/Conan3000V2/IngSoft/servicio/reserva/SMSReserva",
			  data: "accion=Eliminar"+"&tipo=2" +"&cmbServicios="+$('#cmbServicios').val()+"&cmbSedes="+$('#cmbSedes').val()+"&cmbTipoCancha="+$('#cmbTipoCancha').val()
			  +"&pendientes="+pendientes+"&cancelados="+cancelados,
			  dataType: "text",
			  success: function(msg){
				$.ajax({
			  type: "POST",
			  url: "/Conan3000V2/IngSoft/servicio/reserva/SMSReserva",
			  data: "accion=Crear"+"&tipo="+ctipo +"&txtIdSocio="+$('#txtIdSocio').val(),
			  dataType: "text",		  
			  success: function(msg){
			  	lock4=1;
			  	$("#resultadoBusqueda").html("");
				alert("Operacion realizada sin problemas");},
			  error: function(objeto, quepaso, otroobj){
			  	lock4=1;
			  	alert("ERROR!! No se pudo completar la operacion intente de nuevo");
			  }
		
			});
			  },
			  error: function(objeto, quepaso, otroobj){
			  	lock4=1;
				alert("ERROR!! No se pudo completar la operacion intente de nuevo");
				
			  }
		
			});
		//	}
	
	
}

function activarTipoCancha(elem){
var temp=$('#TipoCancha');
if(elem.val().indexOf('cancha')>=0){
	temp.slideDown('fast');
	ctipo=3;
}
else{
	temp.slideUp('fast');
	ctipo=2;
}

}