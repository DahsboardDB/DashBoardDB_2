package co.sistemcobro.dashboarddb.bean;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.application.Application;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;
import org.primefaces.model.ScheduleModel;

import co.sistemcobro.dashboarddb.session.LoginBean;

@ManagedBean(name = "opcionesBean")
@ViewScoped
public class OpcionesBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private Logger logger = Logger.getLogger(OpcionesBean.class);
	private LoginBean loginBean;
	private ClienteBean clienteBean;
	private CalendarioBean calendarioBean;
	private BusquedaAgendaBean agendaBean;
	private ComiteBean comiteBean;

	private Integer opcionTelefonos;
	private Integer opcionMemo;
	private Integer opcionPagos;
	private Integer opcionComboTipificacion;
	private Integer opcionDatoAdicional;

	private Integer opcionBusqueda;
	private Integer opcionCalendario;
	private Integer i;
	private Integer opcionAdminFestivos;
	private Integer opcionAgendamiento;
	private Integer opcionGestionPorAprobar;
	private Integer opcionPromesa;

	private ScheduleModel eventModel;

	@PostConstruct
	public void init() {
		if (FacesContext.getCurrentInstance() != null) {
			FacesContext context = FacesContext.getCurrentInstance();
			Application application = context.getApplication();
			clienteBean = (application.evaluateExpressionGet(context, "#{clienteBean}", ClienteBean.class));
			loginBean = (application.evaluateExpressionGet(context, "#{loginBean}", LoginBean.class));
			calendarioBean = (application.evaluateExpressionGet(context, "#{calendarioBean}", CalendarioBean.class));
			agendaBean = (application.evaluateExpressionGet(context, "#{busquedaAgendaBean}",
					BusquedaAgendaBean.class));
			comiteBean = (application.evaluateExpressionGet(context, "#{comiteBean}", ComiteBean.class));
			try {
				opcionBusqueda = 1;
			} catch (Exception e) {
				logger.error(e.getMessage(), e);
			}
		}
	}

	public void verGestionesPorAprobar() {
		this.setearValores();
		comiteBean.comites();
		opcionGestionPorAprobar = 1;
		i = 4;
	}

	public void verAgendamiento() {
		this.setearValores();
		agendaBean.buscarAgendasPorDocumento();
		opcionAgendamiento = 1;
		i = 3;
	}

	public void administrarFestivos() {
		this.setearValores();
		opcionAdminFestivos = 1;
		i = 2;
	}

	public void verCalendario() {
		this.setearValores();
		calendarioBean.cargar();
		opcionCalendario = 1;
		i = 1;
	}

	public void verBusqueda() {
		this.setearValores();
		opcionBusqueda = 1;
		i = 0;
	}

	public void setearValores() {
		opcionTelefonos = 0;
		opcionBusqueda = 0;
		opcionCalendario = 0;
		opcionAdminFestivos = 0;
		opcionAgendamiento = 0;
		opcionMemo = 0;
		opcionPagos = 0;
		opcionDatoAdicional = 0;
		opcionGestionPorAprobar = 0;
		opcionPromesa = 0;
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

	public Integer getOpcionComboTipificacion() {
		return opcionComboTipificacion;
	}

	public void setOpcionComboTipificacion(Integer opcionComboTipificacion) {
		this.opcionComboTipificacion = opcionComboTipificacion;
	}

	public Integer getOpcionTelefonos() {
		return opcionTelefonos;
	}

	public void setOpcionTelefonos(Integer opcionTelefonos) {
		this.opcionTelefonos = opcionTelefonos;
	}

	public Integer getOpcionBusqueda() {
		return opcionBusqueda;
	}

	public void setOpcionBusqueda(Integer opcionBusqueda) {
		this.opcionBusqueda = opcionBusqueda;
	}

	public Integer getOpcionCalendario() {
		return opcionCalendario;
	}

	public void setOpcionCalendario(Integer opcionCalendario) {
		this.opcionCalendario = opcionCalendario;
	}

	public Integer getI() {
		return i;
	}

	public void setI(Integer i) {
		this.i = i;
	}

	public ScheduleModel getEventModel() {
		return eventModel;
	}

	public void setEventModel(ScheduleModel eventModel) {
		this.eventModel = eventModel;
	}

	public Logger getLogger() {
		return logger;
	}

	public void setLogger(Logger logger) {
		this.logger = logger;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public CalendarioBean getCalendarioBean() {
		return calendarioBean;
	}

	public void setCalendarioBean(CalendarioBean calendarioBean) {
		this.calendarioBean = calendarioBean;
	}

	public Integer getOpcionAdminFestivos() {
		return opcionAdminFestivos;
	}

	public void setOpcionAdminFestivos(Integer opcionAdminFestivos) {
		this.opcionAdminFestivos = opcionAdminFestivos;
	}

	public Integer getOpcionAgendamiento() {
		return opcionAgendamiento;
	}

	public void setOpcionAgendamiento(Integer opcionAgendamiento) {
		this.opcionAgendamiento = opcionAgendamiento;
	}

	public Integer getOpcionMemo() {
		return opcionMemo;
	}

	public void setOpcionMemo(Integer opcionMemo) {
		this.opcionMemo = opcionMemo;
	}

	public Integer getOpcionPagos() {
		return opcionPagos;
	}

	public void setOpcionPagos(Integer opcionPagos) {
		this.opcionPagos = opcionPagos;
	}

	public Integer getOpcionDatoAdicional() {
		return opcionDatoAdicional;
	}

	public void setOpcionDatoAdicional(Integer opcionDatoAdicional) {
		this.opcionDatoAdicional = opcionDatoAdicional;
	}

	public BusquedaAgendaBean getAgendaBean() {
		return agendaBean;
	}

	public void setAgendaBean(BusquedaAgendaBean agendaBean) {
		this.agendaBean = agendaBean;
	}

	public Integer getOpcionGestionPorAprobar() {
		return opcionGestionPorAprobar;
	}

	public void setOpcionGestionPorAprobar(Integer opcionGestionPorAprobar) {
		this.opcionGestionPorAprobar = opcionGestionPorAprobar;
	}

	public ComiteBean getComiteBean() {
		return comiteBean;
	}

	public void setComiteBean(ComiteBean comiteBean) {
		this.comiteBean = comiteBean;
	}

	public Integer getOpcionPromesa() {
		return opcionPromesa;
	}

	public void setOpcionPromesa(Integer opcionPromesa) {
		this.opcionPromesa = opcionPromesa;
	}

}
