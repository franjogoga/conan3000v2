package IngSoft.administracion.bean;

import java.io.Serializable;

public class CriterioServicioBeanData implements Serializable{
	private String nombre;
	private String idAmbiente;
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getIdAmbiente() {
		return idAmbiente;
	}
	public void setIdAmbiente(String idAmbiente) {
		this.idAmbiente = idAmbiente;
	}
}
