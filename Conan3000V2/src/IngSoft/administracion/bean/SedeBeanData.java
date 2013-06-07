package IngSoft.administracion.bean;

import java.io.Serializable;

public class SedeBeanData implements Serializable{
	
	String codigo;
	String nombre;
	String direccion;
	long telefono;
	double areaterreno;
	
	String departamento;
	String coddepartamento;
	
	String provincia;
	String codprovincia;
	
	String distrito;
	String coddistrito;
	
	String estado;

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

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public long getTelefono() {
		return telefono;
	}

	public void setTelefono(long telefono) {
		this.telefono = telefono;
	}

	public double getAreaterreno() {
		return areaterreno;
	}

	public void setAreaterreno(double areaterreno) {
		this.areaterreno = areaterreno;
	}

	public String getDepartamento() {
		return departamento;
	}

	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}

	public String getCoddepartamento() {
		return coddepartamento;
	}

	public void setCoddepartamento(String coddepartamento) {
		this.coddepartamento = coddepartamento;
	}

	public String getProvincia() {
		return provincia;
	}

	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}

	public String getCodprovincia() {
		return codprovincia;
	}

	public void setCodprovincia(String codprovincia) {
		this.codprovincia = codprovincia;
	}

	public String getDistrito() {
		return distrito;
	}

	public void setDistrito(String distrito) {
		this.distrito = distrito;
	}

	public String getCoddistrito() {
		return coddistrito;
	}

	public void setCoddistrito(String coddistrito) {
		this.coddistrito = coddistrito;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	


	
	

}
