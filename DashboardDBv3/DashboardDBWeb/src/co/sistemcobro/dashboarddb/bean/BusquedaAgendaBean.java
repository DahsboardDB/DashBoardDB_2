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
import co.sistemcobro.dashboarddb.ejb.IAgendaEJBLocal;

@ManagedBean(name = "busquedaAgendaBean")
@ViewScoped
public class BusquedaAgendaBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static Logger logger = Logger.getLogger(BusquedaAgendaBean.class);

	@EJB
	private IAgendaEJBLocal agendaEJB;
	private LoginBean loginBean;
	
	private String documento;
	private List<Agenda> agendas;
	private boolean gestionarAgenda;
	public static final String redireccionUrl = "../../pages/obligacion/obligacion.xhtml";
	
	private ClienteBean clienteBean;
	private Agenda selectedAgenda;

	
	@PostConstruct
	public void init() {
		if (FacesContext.getCurrentInstance() != null) {
			FacesContext context = FacesContext.getCurrentInstance();
			Application application = context.getApplication();
			loginBean = (application.evaluateExpressionGet(context, "#{loginBean}", LoginBean.class));
			clienteBean = (application.evaluateExpressionGet(context, "#{clienteBean}", ClienteBean.class));
			try {
				agendas = new ArrayList<>();
				gestionarAgenda = false;
			} catch (Exception e) {
				logger.error(e.getMessage(), e);
			}
		}
	}

	public void buscarAgendasPorDocumento() {
		try {
			agendas = agendaEJB.agendasPorDocumento();
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
	}

	public void redireccionarDatosClienteAgendamiento(String numeroDocumento, Integer idAgenda, String numero) throws Exception {
		try {
			gestionarAgenda = true;
			agendaEJB.actualizarEstadoAgenda(idAgenda, Integer.parseInt(loginBean.getUsuarioHermes().getCodusuario()));
			FacesContext.getCurrentInstance().getExternalContext()
					.redirect(redireccionUrl + "?idcliente=" + numeroDocumento+"&numeromarcado="+numero);
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}

	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public List<Agenda> getAgendas() {
		return agendas;
	}

	public void setAgendas(List<Agenda> agendas) {
		this.agendas = agendas;
	}

	public static Logger getLogger() {
		return logger;
	}

	public static void setLogger(Logger logger) {
		BusquedaAgendaBean.logger = logger;
	}

	public IAgendaEJBLocal getAgendaEJB() {
		return agendaEJB;
	}

	public void setAgendaEJB(IAgendaEJBLocal agendaEJB) {
		this.agendaEJB = agendaEJB;
	}

	public boolean isGestionarAgenda() {
		return gestionarAgenda;
	}

	public void setGestionarAgenda(boolean gestionarAgenda) {
		this.gestionarAgenda = gestionarAgenda;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public LoginBean getLoginBean() {
		return loginBean;
	}

	public void setLoginBean(LoginBean loginBean) {
		this.loginBean = loginBean;
	}

	public static String getRedireccionurl() {
		return redireccionUrl;
	}

	public ClienteBean getClienteBean() {
		return clienteBean;
	}

	public void setClienteBean(ClienteBean clienteBean) {
		this.clienteBean = clienteBean;
	}

	public Agenda getSelectedAgenda() {
		return selectedAgenda;
	}

	public void setSelectedAgenda(Agenda selectedAgenda) {
		this.selectedAgenda = selectedAgenda;
	}
	
	

}
