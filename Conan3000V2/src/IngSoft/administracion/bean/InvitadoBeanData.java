package IngSoft.administracion.bean;

import java.io.Serializable;

public class InvitadoBeanData implements Serializable {
	int codigo;
	String nombre;
	public int getCodigo() {
		
		
		System.out.print("--- InvitadoBeanData ");
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
