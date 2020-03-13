package co.sistemcobro.dashboarddb.bean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.Application;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;

import co.sistemcobro.dashboarddb.session.LoginBean;
import co.sistemcobro.dashboarddb.ejb.IMemoEJBLocal;

@ManagedBean(name = "memoBean")
@ViewScoped
public class MemoBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static Logger logger = Logger.getLogger(MemoBean.class);
	private LoginBean loginBean;
	private ClienteBean clienteBean;
	private OpcionesBean opcionBean;

	private UsuarioAplicacion usuarioAplicacion;

	@EJB
	private IMemoEJBLocal memoEJB;

	private List<Memo> gestiones;

	@PostConstruct
	public void init() {
		if (FacesContext.getCurrentInstance() != null) {
			FacesContext context = FacesContext.getCurrentInstance();
			Application application = context.getApplication();
			clienteBean = (application.evaluateExpressionGet(context, "#{clienteBean}", ClienteBean.class));
			loginBean = (application.evaluateExpressionGet(context, "#{loginBean}", LoginBean.class));
			opcionBean = (application.evaluateExpressionGet(context, "#{opcionesBean}", OpcionesBean.class));
			try {
				gestiones = new ArrayList<>();
			} catch (Exception e) {
				logger.error(e.getMessage(), e);
			}

		}
	}

	public void gestiones() {
		try {
			gestiones = memoEJB.consultarMemo(clienteBean.getCliente().getNumeroDocumentoDeudor());
			opcionBean.setearValores();
			opcionBean.setOpcionMemo(1);

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

	public IMemoEJBLocal getMemoEJB() {
		return memoEJB;
	}

	public void setMemoEJB(IMemoEJBLocal memoEJB) {
		this.memoEJB = memoEJB;
	}

	public List<Memo> getGestiones() {
		return gestiones;
	}

	public void setGestiones(List<Memo> gestiones) {
		this.gestiones = gestiones;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
