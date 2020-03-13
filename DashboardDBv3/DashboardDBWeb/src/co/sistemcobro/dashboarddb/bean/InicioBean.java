package co.sistemcobro.dashboarddb.bean;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.apache.log4j.Logger;

import co.sistemcobro.dashboarddb.session.LoginBean;

@ManagedBean(name = "inicioBean")
@ViewScoped
public class InicioBean  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static Logger logger = Logger.getLogger(InicioBean.class);
	
	private LoginBean loginBean;
	private ClienteBean clienteBean;
	private OpcionesBean opcionBean;

	private UsuarioAplicacion usuarioAplicacion;
	

	@PostConstruct
	public void init() {
			try {
				
				
			} catch (Exception e) {
				logger.error(e.getMessage(), e);
			}
	}
	
	public String regresarInicio() {
		return "/pages/inicio/inicio.xhmtl?faces-redirect=true";
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
	
	public OpcionesBean getOpcionBean() {
		return opcionBean;
	}

	public void setOpcionBean(OpcionesBean opcionBean) {
		this.opcionBean = opcionBean;
	}
	
	

}
