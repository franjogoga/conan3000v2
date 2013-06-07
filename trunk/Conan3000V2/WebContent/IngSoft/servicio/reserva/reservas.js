function cambiarClase(elemento){
	if(aTipo==1) cAgregar(elemento);
	else cEliminar(elemento);

	
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
		elemento.innerHTML=elemento.innerHTML.replace("Pendiente","Reservado");
		var temp=elemento.getAttribute("id")+"@";
		if(cancelados.search(temp)<0)
		pendientes=pendientes.concat(temp);
		else cancelados=cancelados.replace(temp,"");

		}
		else 
		if(elemento.className == "btn btn-warning") {
		elemento.className = "btn btn-danger";
		elemento.innerHTML=elemento.innerHTML.replace("Reservado","Pendiente");
		var temp=elemento.getAttribute("id")+"@";
		if(pendientes.search(temp)<0)
		cancelados=cancelados.concat(temp);
		else pendientes=pendientes.replace(temp,"");
		}	
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
		  data: "accion=Buscar"+"&tipo=2" +"&cmbServicios="+$('#cmbServicios').val()+"&cmbSedes="+$('#cmbSedes').val()+"&cmbTipoCancha="+$('#cmbTipoCancha').val(),
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

function actualizar_pendientes(){

var ant=($("#pendientes").attr('value').split(','));						  								  		
						  		var temp;
						  		for(i=0;i<ant.length ;i++){						  		
						  			temp=".btn-success[id='"+ant[i]+"']";						  			
						  			if(!$(temp).hasClass("btn-danger")){						  			
						  			$(temp).html("<i class='icon-ok icon-white'></i>Pendiente");
						  			
						  			$(temp).toggleClass("btn-warning btn-success");}						  			
						  			
						  		}
						  		//else{
						  		//var temp=ant[i]+"@";
						  		//cancelados=cancelados.concat(temp);
						  		//}

}

function ajax_confirmaSocio(){
	//alert("accion=Buscar"+"&tipo=" + tipo + "&fecIni=" + $(fecIni).val()+"&cmbServicios"+$('#cmbServicios').val());
	if(lock3==1){
	lock3=0;
	if($('#txtDNISocio').val().length >0){
	$.ajax({
		  type: "POST",
		  url: "/Conan3000V2/IngSoft/servicio/reserva/SMSReserva",
		  data: "accion=Buscar"+"&tipo=5" +"&txtDNISocio="+$('#txtDNISocio').val(),
		  dataType: "text",	
		   beforeSend: function ( xhr ) {
   		  $('#txtIdSocio').val("");
			$('#txtNombreSocio').val("");
  		  },	  
		  success: function(msg){
			var temp;
			temp=msg.split('/');
			$('#txtIdSocio').val(temp[0]);
			$('#txtNombreSocio').val(temp[1]);
			lock3=1;						
		  },
		  error: function(objeto, quepaso, otroobj){
		  	lock3=1;
			alert("ERROR!! No se pudo completar la operacion intente de nuevo");
		  }
	
		});
		
	}
	}
}

function ajax_crearReserva(){
//alert("accion=Buscar"+"&tipo=" + tipo + "&fecIni=" + $(fecIni).val()+"&cmbServicios"+$('#cmbServicios').val());
if(lock4==1){
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
			alert("Operacion realizada sin problemas")},
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
		}
}
function activarTipoCancha(elem){
var temp=$('#TipoCancha')
if(elem.val().indexOf('cancha')>=0){
	temp.slideDown('fast');
	ctipo=3;
}
else{
	temp.slideUp('fast');
	ctipo=2;
}

}