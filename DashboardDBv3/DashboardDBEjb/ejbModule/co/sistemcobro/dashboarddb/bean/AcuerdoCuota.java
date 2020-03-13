package co.sistemcobro.dashboarddb.bean;

import java.sql.Timestamp;

public class AcuerdoCuota {
	
	
	private Integer numeroCuota;
	private Integer idAcuerdoCuota;
	private Integer idAcuerdo;	
	private Double valorTotalDeuda;
	private Integer cantidadCuotas;
	private Double valorAcuerdo;
	private Timestamp fechaAcuerdo;
	private Integer idUsuarioCrea; 
	private Timestamp fechaCrea; 
	private Integer idUsuarioMod; 
	private Timestamp fechaMod; 
	private Integer estado;
	
	public Integer getIdAcuerdoCuota() {
		return idAcuerdoCuota;
	}
	public void setIdAcuerdoCuota(Integer idAcuerdoCuota) {
		this.idAcuerdoCuota = idAcuerdoCuota;
	}
	public Integer getIdAcuerdo() {
		return idAcuerdo;
	}
	public void setIdAcuerdo(Integer idAcuerdo) {
		this.idAcuerdo = idAcuerdo;
	}
	public Double getValorTotalDeuda() {
		return valorTotalDeuda;
	}
	public void setValorTotalDeuda(Double valorTotalDeuda) {
		this.valorTotalDeuda = valorTotalDeuda;
	}
	public Integer getCantidadCuotas() {
		return cantidadCuotas;
	}
	public void setCantidadCuotas(Integer cantidadCuotas) {
		this.cantidadCuotas = cantidadCuotas;
	}
	public Double getValorAcuerdo() {
		return valorAcuerdo;
	}
	public void setValorAcuerdo(Double valorAcuerdo) {
		this.valorAcuerdo = valorAcuerdo;
	}
	public Timestamp getFechaAcuerdo() {
		return fechaAcuerdo;
	}
	public void setFechaAcuerdo(Timestamp fechaAcuerdo) {
		this.fechaAcuerdo = fechaAcuerdo;
	}
	public Integer getIdUsuarioCrea() {
		return idUsuarioCrea;
	}
	public void setIdUsuarioCrea(Integer idUsuarioCrea) {
		this.idUsuarioCrea = idUsuarioCrea;
	}
	public Timestamp getFechaCrea() {
		return fechaCrea;
	}
	public void setFechaCrea(Timestamp fechaCrea) {
		this.fechaCrea = fechaCrea;
	}
	public Integer getIdUsuarioMod() {
		return idUsuarioMod;
	}
	public void setIdUsuarioMod(Integer idUsuarioMod) {
		this.idUsuarioMod = idUsuarioMod;
	}
	public Timestamp getFechaMod() {
		return fechaMod;
	}
	public void setFechaMod(Timestamp fechaMod) {
		this.fechaMod = fechaMod;
	}
	public Integer getEstado() {
		return estado;
	}
	public void setEstado(Integer estado) {
		this.estado = estado;
	}
	public Integer getNumeroCuota() {
		return numeroCuota;
	}
	public void setNumeroCuota(Integer numeroCuota) {
		this.numeroCuota = numeroCuota;
	} 
	
	
	
	

}
