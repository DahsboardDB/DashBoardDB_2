package co.sistemcobro.dashboarddb.bean;

import java.io.Serializable;
import java.util.ArrayList;
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
import co.sistemcobro.dashboarddb.ejb.IAcuerdoEJBLocal;
import co.sistemcobro.dashboarddb.ejb.IComiteEJBLocal;
import co.sistemcobro.dashboarddb.ejb.IGestionEJBLocal;
import co.sistemcobro.dashboarddb.ejb.IObligacionGestionEJBLocal;

@ManagedBean(name = "comiteBean")
@ViewScoped
public class ComiteBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static Logger logger = Logger.getLogger(ComiteBean.class);
	private LoginBean loginBean;
	private List<Comite> comites;
	private Comite selectedComite;

	@EJB
	private IGestionEJBLocal gestionEJB;

	@EJB
	private IComiteEJBLocal comiteEJB;

	@EJB
	private IAcuerdoEJBLocal acuerdoEJB;

	@EJB
	private IObligacionGestionEJBLocal obligacionGestionEJB;

	private ClienteBean clienteBean;
	private OpcionesBean opcionBean;

	private UsuarioAplicacion usuarioAplicacion;

	private ObligacionGestion obligacionGestion;

	@PostConstruct
	public void init() {
		if (FacesContext.getCurrentInstance() != null) {
			FacesContext context = FacesContext.getCurrentInstance();
			Application application = context.getApplication();
			loginBean = (application.evaluateExpressionGet(context, "#{loginBean}", LoginBean.class));
			try {
				comites = new ArrayList<>();
			} catch (Exception e) {
				logger.error(e.getMessage(), e);
			}

		}
	}

	public void destroyWorld() {

	}

	public void comites() {
		try {
			comites = comiteEJB.comites();
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
	}

	public void aprobarGestion(Integer idComite) {
		try {
			Comite comite = new Comite();
			comite = comiteEJB.consultarComitePorId(idComite);

			Integer idAcuerdo = comite.getIdAcuerdo();
			Integer idGestion = comite.getIdGestion();

			if (acuerdoEJB.actualizarEstado(idAcuerdo,
					Integer.parseInt(loginBean.getUsuarioHermes().getCodusuario())) > 0) {
				if (gestionEJB.actualizarEstado(idGestion,
						Integer.parseInt(loginBean.getUsuarioHermes().getCodusuario())) > 0) {
					if (comiteEJB.actualizarEstadoComite(idComite,
							Integer.parseInt(loginBean.getUsuarioHermes().getCodusuario())) > 0) {
						FacesContext.getCurrentInstance().addMessage(null,
								new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Gestion aprobada éxitosamente "));
					} else {
						FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
								"Error", "Gestion no guardada, ocurrio un error "));

					}
				}
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

	public List<Comite> getComites() {
		return comites;
	}

	public void setComites(List<Comite> comites) {
		this.comites = comites;
	}

	public IComiteEJBLocal getComiteEJB() {
		return comiteEJB;
	}

	public void setComiteEJB(IComiteEJBLocal comiteEJB) {
		this.comiteEJB = comiteEJB;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public IGestionEJBLocal getGestionEJB() {
		return gestionEJB;
	}

	public void setGestionEJB(IGestionEJBLocal gestionEJB) {
		this.gestionEJB = gestionEJB;
	}

	public Comite getSelectedComite() {
		return selectedComite;
	}

	public void setSelectedComite(Comite selectedComite) {
		this.selectedComite = selectedComite;
	}

	public ObligacionGestion getObligacionGestion() {
		return obligacionGestion;
	}

	public void setObligacionGestion(ObligacionGestion obligacionGestion) {
		this.obligacionGestion = obligacionGestion;
	}

	public IObligacionGestionEJBLocal getObligacionGestionEJB() {
		return obligacionGestionEJB;
	}

	public void setObligacionGestionEJB(IObligacionGestionEJBLocal obligacionGestionEJB) {
		this.obligacionGestionEJB = obligacionGestionEJB;
	}

	public IAcuerdoEJBLocal getAcuerdoEJB() {
		return acuerdoEJB;
	}

	public void setAcuerdoEJB(IAcuerdoEJBLocal acuerdoEJB) {
		this.acuerdoEJB = acuerdoEJB;
	}

}
