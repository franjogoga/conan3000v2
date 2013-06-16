package IngSoft.administracion.bean;

import java.io.Serializable;

public class CanchaBeanData implements Serializable{
	
	private String codigo;
	private String idAmbiente;
	private String nombre;
	private String estado;
	private String idTipoCancha;
	private String descripcion;
	private String idSede;
	
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getIdAmbiente() {
		return idAmbiente;
	}
	public void setIdAmbiente(String idAmbiente) {
		this.idAmbiente = idAmbiente;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public String getIdTipoCancha() {
		return idTipoCancha;
	}
	public void setIdTipoCancha(String idTipoCancha) {
		this.idTipoCancha = idTipoCancha;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getIdSede() {
		return idSede;
	}
	public void setIdSede(String idSede) {
		this.idSede = idSede;
	}
}
