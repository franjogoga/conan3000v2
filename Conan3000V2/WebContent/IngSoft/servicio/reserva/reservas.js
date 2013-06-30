function cambiarClase(elemento){
	if (atipo == 1) cAgregar(elemento);
	else if(atipo == 2)cEliminar(elemento)
	else if(atipo == 4)cAdicionar(elemento);	
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

function cAdicionar(elemento){
	if (elemento.className == "btn btn-danger") {
		$('#bModal').trigger('click');
		$('.mod').css('display','none');
		$('.modAdicional').css('display','inline');
		$('#cmbServicios')[0].selectedIndex = 0;
		
		var temp=elemento.getAttribute("id");
		reserva=temp;
		$.ajax({
		  type: "POST",
		  url: "/Conan3000V2/IngSoft/servicio/reserva/SMSReserva",
		  data: "accion=Buscar"+"&tipo=9" + "&codigo="+temp,
		  dataType: "html",
		  beforeSend: function ( xhr ) {
   		  $("#resultadoAdicional").html("<div align='center'><img src='img/ajax-loaders/ajax-loader-7.gif'></img></div>");
  		  },
		  success: function(msg){
			$("#resultadoAdicional").html(msg);	
			
		  },
		  error: function(objeto, quepaso, otroobj){
			alert("ERROR!!");
		  }
	
		});
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
		  +"&fFechaIni="+$('#fFechaIni').val()+"&txtIdSocio="+$('#txtIdSocioAlt').val(),
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
	if(numero!=atipo){
		$('#txtDocSocio').val('');
		$('#txtNomSocio').val('');
		$('#txtIdSocioAlt').val('');
		$('#txtIdSocio').val('');
		$('#txtDNISocio').val('');
		$('#txtNombreSocio').val('');
	if(numero==2) {
		atipo=2;
		temp=$('#titulo').html();
		temp=temp.replace('AGREGAR','ELIMINAR');
		temp=temp.replace('BUSCAR','ELIMINAR');
		temp=temp.replace('ADICIONAR A','ELIMINAR');
		$('#txtDocSocio').prop('disabled', false);
		$('#txtNomSocio').prop('disabled', false);
		$('#titulo').html(temp);
		$('.elim').css('display','inline');
		$('.crear').css('display','none');
		$('.modEliminar').css('display','inline');
		$('.modAgregar').css('display','none');
		$('#servicios').show();
		}
	else if(numero==1){
		atipo=1;
		temp=$('#titulo').html();
		temp=temp.replace('ELIMINAR','AGREGAR');
		temp=temp.replace('BUSCAR','AGREGAR');
		temp=temp.replace('ADICIONAR A','AGREGAR');
		$('#txtDocSocio').prop('disabled', true);
		$('#txtNomSocio').prop('disabled', true);
		$('#titulo').html(temp);
		$('.crear').css('display','inline');
		$('.elim').css('display','none');
		$('.modAgregar').css('display','inline');
		$('.modEliminar').css('display','none');
		$('#servicios').show();
		}
	else if(numero==3){
		atipo=3;
		temp=$('#titulo').html();
		temp=temp.replace('ELIMINAR','BUSCAR');
		temp=temp.replace('AGREGAR','BUSCAR');
		temp=temp.replace('ADICIONAR A','BUSCAR');
		$('#txtDocSocio').prop('disabled', false);
		$('#txtNomSocio').prop('disabled', false);
		$('#titulo').html(temp);
		$('.crear').css('display','none');
		$('.elim').css('display','none');
		$('.modAgregar').css('display','none');
		$('.modEliminar').css('display','none');	
		$('#servicios').show();	
	}
	else if(numero==4){
		atipo=4;
		temp=$('#titulo').html();
		temp=temp.replace('ELIMINAR','ADICIONAR A');
		temp=temp.replace('AGREGAR','ADICIONAR A');
		temp=temp.replace('BUSCAR','ADICIONAR A');
		$('#txtDocSocio').prop('disabled', false);
		$('#txtNomSocio').prop('disabled', false);
		$('#titulo').html(temp);
		$('.crear').css('display','none');
		$('.elim').css('display','none');
		$('.modAgregar').css('display','none');
		$('.modEliminar').css('display','none');
		$('#servicios').hide();		
	}
	//$('#TipoCancha').slideUp('fast');
	//$('#cmbServicios').selectedIndex = 0;
	ajax_reset();
	$("#resultadoBusqueda").html('');
	}	
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

function ajax_confirmaSocio(origen,salida,img,idelem){
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
   		 	idelem.val("");
			salida.val("");
			img.css('display','inline');
  		  },	  
		  success: function(msg){
			var temp;
			temp=msg.split('/');
			idelem.val(temp[0]);
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
		salida.val('');
		idelem.val('');		
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
			$('.modAgregar').css('display','none');
		  	 $('.modExito').css('display','inline');       		 
		  	 setTimeout(function(){
       $(".close").trigger("click");
       $('.modExito').css('display','none');
       $('.modAgregar').css('display','inline');
       }, 2000);
       },
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
} else alert("Debe seleccionar un socio")
	}
}

function ajax_elim(){
	if(lock5==1){
		lock5=0;
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
			  data: "accion=Eliminar"+"&tipo="+ctipo +"&txtIdSocio="+$('#txtIdSocio').val(),
			  dataType: "text",		  
			  success: function(msg){
			  	lock5=1;
			  	$("#resultadoBusqueda").html("");
				alert("Operacion realizada sin problemas");},
			  error: function(objeto, quepaso, otroobj){
			  	lock5=1;
			  	alert("ERROR!! No se pudo completar la operacion intente de nuevo");
			  }
		
			});
			  },
			  error: function(objeto, quepaso, otroobj){
			  	lock5=1;
				alert("ERROR!! No se pudo completar la operacion intente de nuevo");
				
			  }
		
			});
		}
	
	
}
function ajax_reset(){
	$.ajax({
		  type: "POST",
		  url: "/Conan3000V2/IngSoft/servicio/reserva/SMSReserva",
		  data: "accion=Buscar"+"&tipo=8",
		  dataType: "text",
		  success: function(msg){			  
		  },
		  error: function(){
			  alert("No se pudo vaciar la memoria")
		  			  }
	
		});
	
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

function updatetable(){		
	docReady();
$('.datatable').dataTable({
	"sDom": "<'row-fluid'<'span6'l><'span6'f>r>t<'row-fluid'<'span12'i><'span12 center'p>>",
	"sPaginationType": "bootstrap",
	"oLanguage": {
	"sLengthMenu": "_MENU_ registros por pagina"
	},
	"bDestroy": true
} );
}

function CambiarEstadoAdicional(elem){
	elem.toggleClass('btn-success btn-warning');
	if (elem.hasClass('btn-success')) elem.val('Agregar');
	if (elem.hasClass('btn-warning')) elem.val('Agregando');
}
function registrarAdicion(){
	var selec=$('.btn-warning');
	var adicion='';
	for(i=0;i<selec.length;i++){
		adicion=adicion+selec[i].id+'@';	
	}
	if(adicion.length>0 && reserva.length>0){
	adicion=adicion.substring(0,adicion.length-2);
	$.ajax({
		  type: "POST",
		  url: "/Conan3000V2/IngSoft/servicio/reserva/SMSReserva",
		  data: "accion=Crear"+"&tipo=4"+"&codigo="+reserva+"&adicionales="+adicion,
		  dataType: "text",
		  success: function(msg){	
		   $('.close').trigger('click');		  
		  },
		  error: function(){
			  alert("No se pudo vaciar la memoria")
		  			  }
	
		});
}
}