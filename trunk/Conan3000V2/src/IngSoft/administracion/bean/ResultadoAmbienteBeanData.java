package IngSoft.administracion.bean;

import java.io.Serializable;

public class ResultadoAmbienteBeanData implements Serializable{
	private String codigo;
	private String nombre; 
	private String nombreSede;
	private String nombreTipoAmbiente;
	private String estado;
	
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
	public String getNombreSede() {
		return nombreSede;
	}
	public void setNombreSede(String nombreSede) {
		this.nombreSede = nombreSede;
	}
	public String getNombreTipoAmbiente() {
		return nombreTipoAmbiente;
	}
	public void setNombreTipoAmbiente(String nombreTipoAmbiente) {
		this.nombreTipoAmbiente = nombreTipoAmbiente;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
}
