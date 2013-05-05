package IngSoft.administracion.bean;

import java.io.Serializable;

public class SedeBeanData implements Serializable{
	
	int codigo;
	String nombre;
	
	

	
	
	public int getCodido() {
		
		System.out.print("--> SedeBeanData ---> getCodido");
		
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
	

}
