package IngSoft.administracion.bean;
import java.io.Serializable;
import java.util.Date;

public class CriterioReservaBeanData implements Serializable{
	
	
	private String codigo;
	private String codigosocio;
	private String codigoinvitado;
	private String nombresocio;
	private String apaternosocio;
	private String amaternosocio;
	private String dnisocio;	
	private String nombreinvi;
	private String apaternoinvi;
	private String amaternoinvi;
	private Date fechaingreso;
	private String estado;
	
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getCodigosocio() {
		return codigosocio;
	}
	public void setCodigosocio(String codigosocio) {
		this.codigosocio = codigosocio;
	}
	public String getCodigoinvitado() {
		return codigoinvitado;
	}
	public void setCodigoinvitado(String codigoinvitado) {
		this.codigoinvitado = codigoinvitado;
	}
	public String getNombresocio() {
		return nombresocio;
	}
	public void setNombresocio(String nombresocio) {
		this.nombresocio = nombresocio;
	}
	public String getApaternosocio() {
		return apaternosocio;
	}
	public void setApaternosocio(String apaternosocio) {
		this.apaternosocio = apaternosocio;
	}
	public String getAmaternosocio() {
		return amaternosocio;
	}
	public void setAmaternosocio(String amaternosocio) {
		this.amaternosocio = amaternosocio;
	}
	public String getDnisocio() {
		return dnisocio;
	}
	public void setDnisocio(String dnisocio) {
		this.dnisocio = dnisocio;
	}
	public String getNombreinvi() {
		return nombreinvi;
	}
	public void setNombreinvi(String nombreinvi) {
		this.nombreinvi = nombreinvi;
	}
	public String getApaternoinvi() {
		return apaternoinvi;
	}
	public void setApaternoinvi(String apaternoinvi) {
		this.apaternoinvi = apaternoinvi;
	}
	public String getAmaternoinvi() {
		return amaternoinvi;
	}
	public void setAmaternoinvi(String amaternoinvi) {
		this.amaternoinvi = amaternoinvi;
	}
	public Date getFechaingreso() {
		return fechaingreso;
	}
	public void setFechaingreso(Date fechaingreso) {
		this.fechaingreso = fechaingreso;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	
	

}
