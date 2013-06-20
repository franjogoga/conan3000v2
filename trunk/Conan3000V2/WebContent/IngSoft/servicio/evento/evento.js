
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
		elem.attr('disabled', 'disabled');
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
		$(idboton).removeAttr('disabled');
		temp.html(temp.html().replace('<br><br>','<br>'));
		
	}
