package IngSoft.servicio.bean;

import java.io.Serializable;
import java.util.Date;
import java.util.Vector;

public class CriterioBungalowSorteoBeanData implements Serializable{
	private Date fInicioSorteo;
	private Date fFinSorteo;
	private Date fSorteo;
	public Date getfInicioSorteo() {
		return fInicioSorteo;
	}
	public void setfInicioSorteo(Date fInicioSorteo) {
		this.fInicioSorteo = fInicioSorteo;
	}
	public Date getfFinSorteo() {
		return fFinSorteo;
	}
	public void setfFinSorteo(Date fFinSorteo) {
		this.fFinSorteo = fFinSorteo;
	}
	public Date getfSorteo() {
		return fSorteo;
	}
	public void setfSorteo(Date fSorteo) {
		this.fSorteo = fSorteo;
	}

	
	
}
