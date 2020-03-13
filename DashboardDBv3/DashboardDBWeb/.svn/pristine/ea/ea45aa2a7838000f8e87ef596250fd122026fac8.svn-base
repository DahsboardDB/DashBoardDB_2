package co.sistemcobro.dashboarddb.bean;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.Application;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;

import co.sistemcobro.dashboarddb.ejb.IAgendaEJBLocal;

@ManagedBean(name = "navegacionBean")
@SessionScoped
public class NavegacionBean implements Serializable {
	private static final long serialVersionUID = 4545919119678482516L;
	private static Logger logger = Logger.getLogger(NavegacionBean.class);
	private String ruta;
	private Integer pagina;
	private Integer tipificacion;
	private boolean render;

	@EJB
	private IAgendaEJBLocal agendaEJB;

	public static final String redireccionInicio = "pages/inicio/inicio.xhmtl?faces-redirect=true";
	public static final String redireccionLogin = "login.xhmtl?faces-redirect=true";
	public static final String redireccionUrl = "../../pages/obligacion/obligacion.xhtml";

	private ClienteBean clienteBean;

	@PostConstruct
	public void init() {
		pagina = 2;
		render = false;
		try {
			FacesContext context = FacesContext.getCurrentInstance();
			Application application = context.getApplication();
			// clienteBean = application.evaluateExpressionGet(context,
			// "#{clienteBean}", ClienteBean.class);

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
	}

	public void redireccionarDatosCliente(String tipoDocumento, String numeroDocumento) throws Exception {
		FacesContext.getCurrentInstance().getExternalContext()
				.redirect(redireccionUrl + "?tipodocumento=" + tipoDocumento + "&idcliente=" + numeroDocumento);
	}

	public String getRuta() {
		return ruta;
	}

	public void setRuta(String ruta) {
		this.ruta = ruta;
	}

	public Integer getPagina() {
		return pagina;
	}

	public void setPagina(Integer pagina) {
		this.pagina = pagina;
	}

	public Integer getTipificacion() {
		return tipificacion;
	}

	public void setTipificacion(Integer tipificacion) {
		this.tipificacion = tipificacion;
	}

	public boolean isRender() {
		return render;
	}

	public void setRender(boolean render) {
		this.render = render;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public static String getRedireccioninicio() {
		return redireccionInicio;
	}

	public ClienteBean getClienteBean() {
		return clienteBean;
	}

	public void setClienteBean(ClienteBean clienteBean) {
		this.clienteBean = clienteBean;
	}

	public static String getRedireccionlogin() {
		return redireccionLogin;
	}

	public static String getRedireccionurl() {
		return redireccionUrl;
	}

	public IAgendaEJBLocal getAgendaEJB() {
		return agendaEJB;
	}

	public void setAgendaEJB(IAgendaEJBLocal agendaEJB) {
		this.agendaEJB = agendaEJB;
	}

}
