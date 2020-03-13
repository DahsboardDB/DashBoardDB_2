package co.sistemcobro.dashboarddb.bean;

import java.sql.Timestamp;

public class DatoAdicional {
	
	private Integer iddatoadicional;
	private String documentoDeudor;
	private String nombrecompleto;
	private String direccion;
	private String email;
	private Integer idTelefono;
	private Integer idUsarioCrea;
	private Timestamp fechaCrea;
	private Integer idusUarioMod;
	private Timestamp fechaMod;
	private Integer estado;
	
	public Integer getIddatoadicional() {
		return iddatoadicional;
	}
	public void setIddatoadicional(Integer iddatoadicional) {
		this.iddatoadicional = iddatoadicional;
	}
	public String getNombrecompleto() {
		return nombrecompleto;
	}
	public void setNombrecompleto(String nombrecompleto) {
		this.nombrecompleto = nombrecompleto;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	public Integer getIdUsarioCrea() {
		return idUsarioCrea;
	}
	public void setIdUsarioCrea(Integer idUsarioCrea) {
		this.idUsarioCrea = idUsarioCrea;
	}
	public Timestamp getFechaCrea() {
		return fechaCrea;
	}
	public void setFechaCrea(Timestamp fechaCrea) {
		this.fechaCrea = fechaCrea;
	}
	public Integer getIdusUarioMod() {
		return idusUarioMod;
	}
	public void setIdusUarioMod(Integer idusUarioMod) {
		this.idusUarioMod = idusUarioMod;
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
	public Integer getIdTelefono() {
		return idTelefono;
	}
	public void setIdTelefono(Integer idTelefono) {
		this.idTelefono = idTelefono;
	}
	public String getDocumentoDeudor() {
		return documentoDeudor;
	}
	public void setDocumentoDeudor(String documentoDeudor) {
		this.documentoDeudor = documentoDeudor;
	}
	
	
	
	

}
