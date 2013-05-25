package IngSoft.administracion.bean;

import java.io.Serializable;

public class ResultadoAmbienteBeanData implements Serializable{
	private String codigo;
	private String nombre; 
	private String idSede;
	private String descripcion;
	private String caracteristicas;
	private String idTipoAmbiente;
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
	public String getIdSede() {
		return idSede;
	}
	public void setIdSede(String idSede) {
		this.idSede = idSede;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getCaraceristicas() {
		return caracteristicas;
	}
	public void setCaracteristicas(String caracteristicas) {
		this.caracteristicas = caracteristicas;
	}
	public String getIdTipoAmbiente() {
		return idTipoAmbiente;
	}
	public void setIdTipoAmbiente(String idTipoAmbiente) {
		this.idTipoAmbiente = idTipoAmbiente;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
}
