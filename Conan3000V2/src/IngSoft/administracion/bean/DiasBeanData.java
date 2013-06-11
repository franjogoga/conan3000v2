package IngSoft.administracion.bean;

import java.io.Serializable;
import java.util.Date;

public class DiasBeanData implements Serializable{

	private String codigo;	
	private String nombre;
	
	
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
	
}
