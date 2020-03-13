package co.sistemcobro.dashboarddb.bean;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.Application;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;

import co.sistemcobro.dashboarddb.session.LoginBean;
import co.sistemcobro.dashboarddb.constante.EstadoEnum;
import co.sistemcobro.dashboarddb.ejb.IDatoAdicionalEJBLocal;
import co.sistemcobro.dashboarddb.ejb.ITelefonoEJBLocal;

@ManagedBean(name = "datoAdicionalBean")
@ViewScoped
public class DatoAdicionalBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static Logger logger = Logger.getLogger(DatoAdicionalBean.class);
	private LoginBean loginBean;
	private ClienteBean clienteBean;
	private OpcionesBean opcionBean;

	private UsuarioAplicacion usuarioAplicacion;

	@EJB
	IDatoAdicionalEJBLocal datoAdicionalEJB;

	@EJB
	ITelefonoEJBLocal telefonoEJB;

	private List<Telefono> telefonos;

	private String direccion;
	private String email;

	private String nuevoTipoTelefono;
	private String nuevoTelefono;

	@PostConstruct
	public void init() {
		if (FacesContext.getCurrentInstance() != null) {
			FacesContext context = FacesContext.getCurrentInstance();
			Application application = context.getApplication();
			clienteBean = (application.evaluateExpressionGet(context, "#{clienteBean}", ClienteBean.class));
			loginBean = (application.evaluateExpressionGet(context, "#{loginBean}", LoginBean.class));
			opcionBean = (application.evaluateExpressionGet(context, "#{opcionesBean}", OpcionesBean.class));
			try {

			} catch (Exception e) {
				logger.error(e.getMessage(), e);
			}

		}
	}

	public void datosAdicionales() {
		try {
			telefonos = telefonoEJB.telefonos(clienteBean.getCliente().getTipoDocumentoDeudor(),
					clienteBean.getCliente().getNumeroDocumentoDeudor());
			opcionBean.setearValores();
			opcionBean.setOpcionDatoAdicional(1);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
	}

	public void guardarDatoAdicional() {
		try {
			DatoAdicional datoAdicional = new DatoAdicional();
			Telefono telefono = new Telefono();

			boolean datoGuardado = false;

			Integer idTelefono = 0;

			if (nuevoTelefono != "" || nuevoTelefono != null) {
				telefono.setIdDeudor(clienteBean.getCliente().getIdDeudor());
				telefono.setIdCargue(clienteBean.getCliente().getIdCargue());
				telefono.setTipoDocumentoDeudor(clienteBean.getCliente().getTipoDocumentoDeudor());
				telefono.setNumeroDocumentoDeudor(clienteBean.getCliente().getNumeroDocumentoDeudor());
				telefono.setCodigoTelefono("TELN");
				telefono.setNumeroTelefono(nuevoTelefono);

				if (telefonoEJB.insertarTelefono(telefono) > 0) {
					idTelefono = telefonoEJB.idTelefono();
					datoGuardado = true;
				} else {
					datoGuardado = false;
				}
			}

			if ((!direccion.equals("") || direccion != null) && (!email.equals("") || email != null)) {
				datoAdicional.setDireccion(direccion);
				datoAdicional.setEmail(email);
				datoAdicional.setIdTelefono(idTelefono);
				datoAdicional.setNombrecompleto(clienteBean.getCliente().getNombreDeudor());
				datoAdicional.setDocumentoDeudor(clienteBean.getCliente().getNumeroDocumentoDeudor());
				datoAdicional.setIdUsarioCrea(Integer.parseInt(loginBean.getUsuarioHermes().getCodusuario()));
				datoAdicional.setEstado(EstadoEnum.ACTIVO.getIndex());

				if (datoAdicionalEJB.insertarDatoAdicional(datoAdicional) > 0) {
					datoGuardado = true;
				} else {
					datoGuardado = false;
				}
			}

			if (datoGuardado) {
				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Dato guardado éxitosamente "));
			} else {
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
						"Error", "Gestion no guardada, se produjo un error "));
			}

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
	}

	public ClienteBean getClienteBean() {
		return clienteBean;
	}

	public void setClienteBean(ClienteBean clienteBean) {
		this.clienteBean = clienteBean;
	}

	public LoginBean getLoginBean() {
		return loginBean;
	}

	public void setLoginBean(LoginBean loginBean) {
		this.loginBean = loginBean;
	}

	public OpcionesBean getOpcionBean() {
		return opcionBean;
	}

	public void setOpcionBean(OpcionesBean opcionBean) {
		this.opcionBean = opcionBean;
	}

	public UsuarioAplicacion getUsuarioAplicacion() {
		return usuarioAplicacion;
	}

	public void setUsuarioAplicacion(UsuarioAplicacion usuarioAplicacion) {
		this.usuarioAplicacion = usuarioAplicacion;
	}

	public IDatoAdicionalEJBLocal getDatoAdicionalEJB() {
		return datoAdicionalEJB;
	}

	public void setDatoAdicionalEJB(IDatoAdicionalEJBLocal datoAdicionalEJB) {
		this.datoAdicionalEJB = datoAdicionalEJB;
	}

	public ITelefonoEJBLocal getTelefonoEJB() {
		return telefonoEJB;
	}

	public void setTelefonoEJB(ITelefonoEJBLocal telefonoEJB) {
		this.telefonoEJB = telefonoEJB;
	}

	public List<Telefono> getTelefonos() {
		return telefonos;
	}

	public void setTelefonos(List<Telefono> telefonos) {
		this.telefonos = telefonos;
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

	public String getNuevoTipoTelefono() {
		return nuevoTipoTelefono;
	}

	public void setNuevoTipoTelefono(String nuevoTipoTelefono) {
		this.nuevoTipoTelefono = nuevoTipoTelefono;
	}

	public String getNuevoTelefono() {
		return nuevoTelefono;
	}

	public void setNuevoTelefono(String nuevoTelefono) {
		this.nuevoTelefono = nuevoTelefono;
	}

}
