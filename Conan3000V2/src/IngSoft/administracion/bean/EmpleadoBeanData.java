package IngSoft.administracion.bean;

import java.io.Serializable;
import java.util.Date;

public class EmpleadoBeanData implements Serializable{


	private String codigo;	
	private String nombre;
	private String puesto;
	
	
	
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
	public String getPuesto() {
		return puesto;
	}
	public void setPuesto(String puesto) {
		this.puesto = puesto;
	}
	
	
	
	
}
