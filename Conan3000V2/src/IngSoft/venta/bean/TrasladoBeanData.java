package IngSoft.venta.bean;
import java.io.Serializable;
import java.sql.Date;

public class TrasladoBeanData implements Serializable{
	
	private String codigo;
	private String idmembresianuevo;
	private String idmembresiantiguo;
	private Date fecha;
	private Date fechafin;
	private String parentesco;
	private double monto;




	public Date getFechafin() {
		return fechafin;
	}

	public void setFechafin(Date fechafin) {
		this.fechafin = fechafin;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getIdmembresianuevo() {
		return idmembresianuevo;
	}
	
	public void setIdmembresianuevo(String idmembresianuevo) {
		this.idmembresianuevo = idmembresianuevo;
	}
	
	public String getIdmembresiantiguo() {
		return idmembresiantiguo;
	}
	
	public void setIdmembresiantiguo(String idmembresiantiguo) {
		this.idmembresiantiguo = idmembresiantiguo;
	}
	
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public String getParentesco() {
		return parentesco;
	}
	public void setParentesco(String parentesco) {
		this.parentesco = parentesco;
	}
	public double getMonto() {
		return monto;
	}
	public void setMonto(double monto) {
		this.monto = monto;
	}
		
}