package co.sistemcobro.dashboarddb.bean;

import java.sql.Timestamp;

public class TipoDocumento {
	
	private Integer idTipoDocumento;
	private String codigoTipoDocumento;
	private String descripcion;
	private Integer idUsuarioCrea;
	private Timestamp fechaCrea;
	private Integer idUsuarioMod;
	private Timestamp fechaMod;
	private Integer estado;
	
	public Integer getIdTipoDocumento() {
		return idTipoDocumento;
	}
	public void setIdTipoDocumento(Integer idTipoDocumento) {
		this.idTipoDocumento = idTipoDocumento;
	}	

	public String getCodigoTipoDocumento() {
		return codigoTipoDocumento;
	}
	public void setCodigoTipoDocumento(String codigoTipoDocumento) {
		this.codigoTipoDocumento = codigoTipoDocumento;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
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
	
	
}
