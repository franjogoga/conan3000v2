
function alt_fecha(obj){
	obj.value=obj.value.slice(0,5);
	
	}

function verificar_fecha(comparacion,fecha1,fecha2){
	var fec1=fecha1.value.split("/");
	var fec2=document.getElementById(fecha2).value.split("/");
	var resultado=true;
	if(fec1.length==fec2.length) {
		var size=fec1.length;
		for(i=size-1;i>=0;i--){
			if(comparacion==0){
				if(fec1[i].indexOf(fec2[i])<0)  resultado= false;
				}
			if(comparacion==1){
				if(parseInt(fec1[i])<parseInt(fec2[i]))  resultado= false;
				}
			if(comparacion==-1){
				if(parseInt(fec1[i])>parseInt(fec2[i]))  resultado= false;
				}
			}
		if(resultado==false){			
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
