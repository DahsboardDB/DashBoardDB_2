package co.sistemcobro.dashboarddb.bean;

import java.sql.Timestamp;

public class Tipificacion {
	
	private Integer idTipificacion; 
	private String codigo;
	private String nombre; 
	private String detalle; 
	private Integer idUsuarioCrea; 
	private Timestamp fechaCrea; 
	private Integer idUsuarioMod; 
	private Timestamp fechaMod; 
	private Timestamp fechaFin; 
	private String estado; 
	private Integer idNiveltipificacion; 
	private Integer peso;
	
	public Integer getIdTipificacion() {
		return idTipificacion;
	}
	public void setIdTipificacion(Integer idTipificacion) {
		this.idTipificacion = idTipificacion;
	}
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
	public String getDetalle() {
		return detalle;
	}
	public void setDetalle(String detalle) {
		this.detalle = detalle;
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
	public Timestamp getFechaFin() {
		return fechaFin;
	}
	public void setFechaFin(Timestamp fechaFin) {
		this.fechaFin = fechaFin;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}
	public Integer getIdNiveltipificacion() {
		return idNiveltipificacion;
	}
	public void setIdNiveltipificacion(Integer idNiveltipificacion) {
		this.idNiveltipificacion = idNiveltipificacion;
	}
	public Integer getPeso() {
		return peso;
	}
	public void setPeso(Integer peso) {
		this.peso = peso;
	}
	
	
}
