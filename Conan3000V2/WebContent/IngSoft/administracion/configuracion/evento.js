
function alt_fecha(obj){
	obj.value=obj.value.slice(0,5);
	
	}

function verificar_fecha(comparacion,fecha1,fecha2){
	var fec1=fecha1.value.split("/");
	var fec2=document.getElementById(fecha2).value.split("/");
	var test=true;
	if(fec1.length==fec2.length) {
		var size=fec1.length;
		var a='';
		var b='';	
		for(i=size-1;i>=0;i--){
			a=a.concat(fec1[i]);
			b=b.concat(fec2[i]);
			}
		if(comparacion==0){
			if(parseInt(a)==parseInt(b))  test=false;
			}
		if(comparacion==1){
			if(parseInt(a)<=parseInt(b))   test=false;
			}
		if(comparacion==-1){
			if(parseInt(a)>=parseInt(b) )  test=false;
			}
		if(test){			
				fecha1.value=document.getElementById(fecha2).value;			
			}
			
		} 
	else{
		alert("Error al comparar fechas");
	}			
}

function alfanumerico(e) 
{ 
var key = window.event.keyCode || event.keyCode;
return ((key >= 48 && key <= 57) ||(key >= 97 && key <= 122) ||(key >= 65 && key <=90) ||(key >= 192 && key <=246)||(key <=13) ||(key ==32));
}
 
function numerico(e) 
{ 
var key = window.event.keyCode || event.keyCode;
return ((key >= 48 && key <= 57) || (key <=13));
} 


function dinero(e) 
{ 
var key = window.event.keyCode || event.keyCode;
return ((key >= 48 && key <= 57) ||(key >= 97 && key <= 122) ||(key >= 65 && key <=90) ||(key >= 192 && key <=246)||(key <=13) ||(key ==32)||(key ==46));
}

function vDinero(elem){
filtrar('1234567890.',elem,50);
if(elem.val().length==0){
 elem.val("0.0");
 }
 var temp= elem.val();
 var pos=temp.indexOf('.');
 
 if(pos>=0){
 	elem.val(elem.val().substring(0,pos+3));
 }
 else{
 	elem.val(elem.val()+".0");
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

	function agregarConcesionario(elem){
		var nombre=elem.parent().parent().children()[0].innerText;
		var id=elem.prop("id");
		concesionario=id;
		$('.btn-success').attr('disabled', 'disabled');
		var temp="&lt;div class='input-append'&gt;&lt;input id='appendedInputButton' size='16' type='text' readonly='true' value='Salon Principal'&gt;&lt;button class='btn' disabled='disabled' type='button'&gt;X&lt;/button&gt;&lt;/div&gt;";
		var temp2="<div class='input-append'><input id='appendedInputButton' size='16' type='text' readonly='true' value='"+nombre+"'><button class='btn' type='button' onclick='retirarConcesionario($(this),&#39;"+id+"&#39;)'>X</button></div><br/>";
		$("#listaServicios").html($("#listaServicios").html()+temp2);
		updatetable();
		$('#mytable_length').css("display","none");  
	}	
	
	function retirarConcesionario(elem,idboton){
		var temp=elem.parent().parent();
		var idboton='#'+idboton;
		elem.parent().remove();
		$('.btn-success').removeAttr('disabled');
		temp.html(temp.html().replace('<br><br>','<br>'));
		concesionario='';
		
	}
	
	function filtrar(mod,obj,num){
	var temp=obj.val();
	var a=temp.length;					
	var b="";
	for(i=0;i<a;i++){
		if(mod.indexOf(temp.charAt(i))>=0 ) b=b.concat(temp.charAt(i));									
	}
	if(b.length>num) b= b.substring(0,num);
	obj.val(b);
	
}
	
		function agregarfilar(){
		var num=parseInt($('#txtAgregarFilas').val());
		for(i=0;i<num;i++){
			$('#listainvitados').html($('#listainvitados').html()+"<input id='appendedInputButton' size='16' type='text' id='txtDNIinvitado' value='DNI'/><input id='appendedInputButton' size='16' type='text' value='Nombre'/><input id='appendedInputButton' size='16' type='text' value='Apellido Paterno'/><input id='appendedInputButton' size='16' type='text' value='Apellido Materno'/><br/>");		
		}
		}
				
		
