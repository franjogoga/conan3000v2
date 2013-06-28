package IngSoft.administracion.bean;

import java.io.Serializable;
import java.util.Date;

public class MatriculaBeanData implements Serializable{


	private String codigoActividad;	
	private String nombreAtc;
	private String vacantes;
	private String inscritos;
	
	private String codigosocio;	
	private String nombreSoc;
	private String apaternoSoc;
	private String amaternoSoc;
	
	private String codigofamiliar;
	private String  nombreFam;
	private String  apaternoFam;
	private String  amaternoFam;
	
	private String horario;
	private Date fecha;
	private Double monto;
	public String getCodigoActividad() {
		return codigoActividad;
	}
	public void setCodigoActividad(String codigoActividad) {
		this.codigoActividad = codigoActividad;
	}
	public String getNombreAtc() {
		return nombreAtc;
	}
	public void setNombreAtc(String nombreAtc) {
		this.nombreAtc = nombreAtc;
	}
	public String getVacantes() {
		return vacantes;
	}
	public void setVacantes(String vacantes) {
		this.vacantes = vacantes;
	}
	public String getInscritos() {
		return inscritos;
	}
	public void setInscritos(String inscritos) {
		this.inscritos = inscritos;
	}
	public String getCodigosocio() {
		return codigosocio;
	}
	public void setCodigosocio(String codigosocio) {
		this.codigosocio = codigosocio;
	}
	public String getNombreSoc() {
		return nombreSoc;
	}
	public void setNombreSoc(String nombreSoc) {
		this.nombreSoc = nombreSoc;
	}
	public String getApaternoSoc() {
		return apaternoSoc;
	}
	public void setApaternoSoc(String apaternoSoc) {
		this.apaternoSoc = apaternoSoc;
	}
	public String getAmaternoSoc() {
		return amaternoSoc;
	}
	public void setAmaternoSoc(String amaternoSoc) {
		this.amaternoSoc = amaternoSoc;
	}
	public String getCodigofamiliar() {
		return codigofamiliar;
	}
	public void setCodigofamiliar(String codigofamiliar) {
		this.codigofamiliar = codigofamiliar;
	}
	public String getNombreFam() {
		return nombreFam;
	}
	public void setNombreFam(String nombreFam) {
		this.nombreFam = nombreFam;
	}
	public String getApaternoFam() {
		return apaternoFam;
	}
	public void setApaternoFam(String apaternoFam) {
		this.apaternoFam = apaternoFam;
	}
	public String getAmaternoFam() {
		return amaternoFam;
	}
	public void setAmaternoFam(String amaternoFam) {
		this.amaternoFam = amaternoFam;
	}
	public String getHorario() {
		return horario;
	}
	public void setHorario(String horario) {
		this.horario = horario;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public Double getMonto() {
		return monto;
	}
	public void setMonto(Double monto) {
		this.monto = monto;
	}
	
	
	
	

	
	
	
	
}
