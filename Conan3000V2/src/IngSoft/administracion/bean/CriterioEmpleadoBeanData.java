package IngSoft.administracion.bean;

import java.io.Serializable;
import java.sql.Date;

public class CriterioEmpleadoBeanData implements Serializable{
	

	private String nombre;
	private String apellidoPaterno;
	private int numeroDocumento;
    private String area;
	
 
    
    
    
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidoPaterno() {
		return apellidoPaterno;
	}
	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}
	public int getNumeroDocumento() {
		return numeroDocumento;
	}
	public void setNumeroDocumento(int numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}

	
	

}