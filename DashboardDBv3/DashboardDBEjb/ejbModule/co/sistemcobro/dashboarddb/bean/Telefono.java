package co.sistemcobro.dashboarddb.bean;

public class Telefono {

	private Integer idTelefono;
	private Integer idDeudor;
	private Integer idCargue;
	private String tipoDocumentoDeudor;
	private String numeroDocumentoDeudor;
	private String codigoTelefono;
	private String numeroTelefono;
	private Integer idOrigen;
	private String origen;

	public Integer getIdTelefono() {
		return idTelefono;
	}

	public void setIdTelefono(Integer idTelefono) {
		this.idTelefono = idTelefono;
	}

	public Integer getIdDeudor() {
		return idDeudor;
	}

	public void setIdDeudor(Integer idDeudor) {
		this.idDeudor = idDeudor;
	}

	public Integer getIdCargue() {
		return idCargue;
	}

	public void setIdCargue(Integer idCargue) {
		this.idCargue = idCargue;
	}

	public String getTipoDocumentoDeudor() {
		return tipoDocumentoDeudor;
	}

	public void setTipoDocumentoDeudor(String tipoDocumentoDeudor) {
		this.tipoDocumentoDeudor = tipoDocumentoDeudor;
	}

	public String getNumeroDocumentoDeudor() {
		return numeroDocumentoDeudor;
	}

	public void setNumeroDocumentoDeudor(String numeroDocumentoDeudor) {
		this.numeroDocumentoDeudor = numeroDocumentoDeudor;
	}

	public String getCodigoTelefono() {
		return codigoTelefono;
	}

	public void setCodigoTelefono(String codigoTelefono) {
		this.codigoTelefono = codigoTelefono;
	}

	public String getNumeroTelefono() {
		return numeroTelefono;
	}

	public void setNumeroTelefono(String numeroTelefono) {
		this.numeroTelefono = numeroTelefono;
	}

	public Integer getIdOrigen() {
		return idOrigen;
	}

	public void setIdOrigen(Integer idOrigen) {
		this.idOrigen = idOrigen;
	}

	public String getOrigen() {
		return origen;
	}

	public void setOrigen(String origen) {
		this.origen = origen;
	}

}
