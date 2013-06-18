package IngSoft.servicio.bean;

import java.io.Serializable;
import java.util.Date;

public class EventoBeanData implements Serializable{
	
	private String codigo;
	//private String nombre;
	//private String idTipo;
	private int entradasTotal;
	private int limiteEntradas;
	private int precioEntrada;
	private String idSede;
	private String idAmbientes;
	private String idPlantilla;
	private Date fecha;
	private double monto;
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public int getEntradasTotal() {
		return entradasTotal;
	}
	public void setEntradasTotal(int entradasTotal) {
		this.entradasTotal = entradasTotal;
	}
	public int getLimiteEntradas() {
		return limiteEntradas;
	}
	public void setLimiteEntradas(int limiteEntradas) {
		this.limiteEntradas = limiteEntradas;
	}
	public int getPrecioEntrada() {
		return precioEntrada;
	}
	public void setPrecioEntrada(int precioEntrada) {
		this.precioEntrada = precioEntrada;
	}
	public String getIdSede() {
		return idSede;
	}
	public void setIdSede(String idSede) {
		this.idSede = idSede;
	}
	public String getIdAmbientes() {
		return idAmbientes;
	}
	public void setIdAmbientes(String idAmbientes) {
		this.idAmbientes = idAmbientes;
	}
	public String getIdPlantilla() {
		return idPlantilla;
	}
	public void setIdPlantilla(String idPlantilla) {
		this.idPlantilla = idPlantilla;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public double getMonto() {
		return monto;
	}
	public void setMonto(double monto) {
		this.monto = monto;
	}
	
	
	
	
	
	
	
}
