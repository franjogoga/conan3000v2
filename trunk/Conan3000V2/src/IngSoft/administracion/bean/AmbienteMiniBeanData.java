package IngSoft.administracion.bean;

import java.io.Serializable;

public class AmbienteMiniBeanData implements Serializable{
	private String codigo; 
	private String nombre;
	private String codigoSede;
	
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
	public String getCodigoSede() {
		return codigoSede;
	}
	public void setCodigoSede(String codigoSede) {
		this.codigoSede = codigoSede;
	}
}
