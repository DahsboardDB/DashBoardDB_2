package co.sistemcobro.dashboarddb.bean;

import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.Application;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;

import co.sistemcobro.dashboarddb.session.LoginBean;
import co.sistemcobro.dashboarddb.ejb.ITelefonoEJBLocal;

@ManagedBean(name = "telefonosBean")
@ViewScoped
public class TelefonosBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static Logger logger = Logger.getLogger(TelefonosBean.class);
	private LoginBean loginBean;
	private List<Telefono> telefonos;

	@EJB
	private ITelefonoEJBLocal telefonoEJB;

	private ClienteBean clienteBean;
	private OpcionesBean opcionBean;
	private UsuarioAplicacion usuarioAplicacion;

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

	public void telefonos() {
		try {
			telefonos = telefonoEJB.telefonos(clienteBean.getCliente().getTipoDocumentoDeudor(),
					clienteBean.getCliente().getNumeroDocumentoDeudor());
			opcionBean.setearValores();
			opcionBean.setOpcionTelefonos(1);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}

	}

	public ITelefonoEJBLocal getTelefonoEJB() {
		return telefonoEJB;
	}

	public void setTelefonoEJB(ITelefonoEJBLocal telefonoEJB) {
		this.telefonoEJB = telefonoEJB;
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

	public UsuarioAplicacion getUsuarioAplicacion() {
		return usuarioAplicacion;
	}

	public void setUsuarioAplicacion(UsuarioAplicacion usuarioAplicacion) {
		this.usuarioAplicacion = usuarioAplicacion;
	}

	public List<Telefono> getTelefonos() {
		return telefonos;
	}

	public void setTelefonos(List<Telefono> telefonos) {
		this.telefonos = telefonos;
	}

	public OpcionesBean getOpcionBean() {
		return opcionBean;
	}

	public void setOpcionBean(OpcionesBean opcionBean) {
		this.opcionBean = opcionBean;
	}

}
