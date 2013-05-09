package IngSoft.administracion.bean;

import java.io.Serializable;

public class SedeBeanData implements Serializable{
	
	String codigo;
	String nombre;
	String direccion;
	long telefono;
	double areaterreno;
	
	String departamento;
	String provincia;
	String distrito;
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
	public String getProvincia() {
		return provincia;
	}
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	public String getDistrito() {
		return distrito;
	}
	public void setDistrito(String distrito) {
		this.distrito = distrito;
		
	}
	

	
	

}
