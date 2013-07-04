package IngSoft.administracion.bean;

import java.io.Serializable;


public class ResultadoEmpleadoBeanData implements Serializable{
	
	
	private String codigo;
	private String nombre; 
	private String apaterno;
	private String puesto;
	private String estado;
	
	
	// ** Cambios David: Agrego campo area y campo numeroDocumento
	
	// Inicio cambios
	private int numeroDocumento;
    private String area;
	
   
    
    public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
    
	public int getNumeroDocumento() {
		return numeroDocumento;
	}
	public void setNumeroDocumento(int numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}
	
	 // fin cambios
	
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
	public String getApaterno() {
		return apaterno;
	}
	public void setApaterno(String apaterno) {
		this.apaterno = apaterno;
	}
	public String getPuesto() {
		return puesto;
	}
	public void setPuesto(String puesto) {
		this.puesto = puesto;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	
	
}