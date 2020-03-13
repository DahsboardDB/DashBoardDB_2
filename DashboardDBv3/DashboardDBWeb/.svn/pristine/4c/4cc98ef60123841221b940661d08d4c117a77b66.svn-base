package co.sistemcobro.dashboarddb.bean;

import java.io.Serializable;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
import co.sistemcobro.dashboarddb.ws.CalendarioWS;
import co.sistemcobro.dashboarddb.constante.Constante;
import co.sistemcobro.dashboarddb.constante.EstadoEnum;
import co.sistemcobro.dashboarddb.ejb.IAcuerdoCuotaEJBLocal;
import co.sistemcobro.dashboarddb.ejb.IAcuerdoEJBLocal;
import co.sistemcobro.dashboarddb.ejb.IAgendaEJBLocal;
import co.sistemcobro.dashboarddb.ejb.IComiteEJBLocal;
import co.sistemcobro.dashboarddb.ejb.IGestionEJBLocal;
import co.sistemcobro.dashboarddb.ejb.IObligacionGestionEJBLocal;
import co.sistemcobro.dashboarddb.ejb.ITipificacionEJBLocal;

@ManagedBean(name = "gestionBean")
@ViewScoped
public class GestionBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static Logger logger = Logger.getLogger(GestionBean.class);
	private LoginBean loginBean;
	private ClienteBean clienteBean;
	private OpcionesBean opcionBean;
	private TipificarBean tipificarBean;

	List<FechaCalendarioDTO> listaFestivosWS;

	private boolean diaFestivo;
	private boolean guardoExitosamente;

	@EJB
	private ITipificacionEJBLocal tipificacionEJB;

	@EJB
	private IGestionEJBLocal gestionEJB;

	@EJB
	private IObligacionGestionEJBLocal obligacionGestionEJB;

	@EJB
	private IComiteEJBLocal comiteEJB;

	@EJB
	private IAcuerdoEJBLocal acuerdoEJB;

	@EJB
	private IAgendaEJBLocal agendaEJB;

	@EJB
	private IAcuerdoCuotaEJBLocal acuerdoCuotaEJB;

	private UsuarioAplicacion usuarioAplicacion;

	private Date ahora;
	private Gestion gestion;
	private Comite comite;
	private Agenda agenda;
	private Acuerdo acuerdo;
	private ObligacionGestion obligacionGestion;
	private Integer idGestion;
	private Integer idTipificacion;

	private Double valorPromesa = new Double(0);

	private List<AcuerdoCuota> cuotasAcuerdo;
	private boolean acuerdoCumple;
	private Integer idComite;

	@PostConstruct
	public void init() {
		if (FacesContext.getCurrentInstance() != null) {
			FacesContext context = FacesContext.getCurrentInstance();
			Application application = context.getApplication();
			clienteBean = (application.evaluateExpressionGet(context, "#{clienteBean}", ClienteBean.class));
			loginBean = (application.evaluateExpressionGet(context, "#{loginBean}", LoginBean.class));
			opcionBean = (application.evaluateExpressionGet(context, "#{opcionesBean}", OpcionesBean.class));
			tipificarBean = (application.evaluateExpressionGet(context, "#{tipificarBean}", TipificarBean.class));
			try {
				diaFestivo = false;
				guardoExitosamente = false;

				// fecha actual
				ahora = new Date();
				gestion = new Gestion();
				obligacionGestion = new ObligacionGestion();
				comite = new Comite();
				acuerdo = new Acuerdo();
				agenda = new Agenda();

				// this.setearValores();
			} catch (Exception e) {
				logger.error(e.getMessage(), e);
			}

		}
	}

	public Double formatearDecimales(Double numero, Integer numeroDecimales) {
		return Math.round(numero * Math.pow(10, numeroDecimales)) / Math.pow(10, numeroDecimales);
	}

	public void handleKeyEvent() {
		double valorPromesa1 = valorPromesa;

	}

	public void guardarGestion() {
		try {

			idTipificacion = tipificacionEJB.idTipificacion(tipificarBean.getSelectedCodigoTipificacion());

			this.validarFestivo();

			if (!diaFestivo && !tipificarBean.isAcuerdo() && !tipificarBean.isAgendaLlamada()) {
				this.guardarGestionNormal();
			}

			if (!diaFestivo && tipificarBean.isAgendaLlamada()) {
				this.guardarGestionNormal();
				this.guardarAgenda();
			}

			if (diaFestivo) {
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Error",
						"Gestion no guardada, la fecha de la promesa es un día festivo "));
			}

			if (guardoExitosamente) {
				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Gestion guardada éxitosamente "));
				this.setearValores();
			} else {
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
						"Error", "Gestion no guardada, ocurrio un error "));
			}

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		} finally {
			diaFestivo = false;
			guardoExitosamente = false;
			this.tipificarBean.setAgendaLlamada(false);
			this.tipificarBean.setearValores();
			tipificarBean.setAcuerdo(false);
			this.setearValores();
		}
	}

	public void setearValores() {
		valorPromesa = new Double(0);
		tipificarBean.setFechaPromesa(null);
		tipificarBean.setObservacion("");
		tipificarBean.setFechaAgendamiento(null);
		tipificarBean.setMontoCuota(valorPromesa);
		tipificarBean.setValorAcuerdo(null);
		tipificarBean.setSelectedCodigoTipificacion("");
		tipificarBean.setNombreTercero(null);
		tipificarBean.setValorAcuerdo(new Double(0));
		tipificarBean.setFechaAcuerdo(null);
		tipificarBean.setValueDeseaFraccionar(false);
		tipificarBean.setNegociarCuotas(0);
		tipificarBean.setTelefonoAgendado(null);
		cuotasAcuerdo = new ArrayList<>();
		tipificarBean.setCuotasAcuerdo(cuotasAcuerdo);
		tipificarBean.setAcuerdo(false);
		tipificarBean.setAgendaLlamada(false);
		diaFestivo = false;
		idComite = 0;
	}

	public void guardarGestionComite() {
		try {
			acuerdoCumple = false;

			tipificarBean.setAcuerdo(true);
			idTipificacion = tipificacionEJB.idTipificacion(tipificarBean.getSelectedCodigoTipificacion());

			this.validarFestivo();

			if (!diaFestivo && tipificarBean.isAcuerdo()) {

				cuotasAcuerdo = tipificarBean.getCuotasAcuerdo();
				tipificarBean.setFechaPromesa(tipificarBean.getFechaAcuerdo());

				if (tipificarBean.getNegociarCuotas() == 1 && tipificarBean.isValueDeseaFraccionar()) {
					for (AcuerdoCuota ac : cuotasAcuerdo) {
						tipificarBean.setMontoPromesa(new Double(0));
						acuerdoCumple = true;
					}
				} else {
					double valorPromesa1 = formatearDecimales(tipificarBean.getValorAcuerdo(), 2);
					tipificarBean.setMontoPromesa(valorPromesa1);

					double valorDescuentoCampana = formatearDecimales(clienteBean.getValorDescuentoCampana(), 1);

					if (valorPromesa1 < valorDescuentoCampana) {
						acuerdoCumple = true;
					} else {
						acuerdoCumple = false;
					}
				}

				if (acuerdoCumple) {
					this.guardarGestionNormal();
					this.guardarAcuerdo();
				} else {
					this.guardarGestionNormal();
					this.guardarComite();
					this.guardarAcuerdo();
				}
			}

			if (diaFestivo) {
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Error",
						"Gestion no guardada, la fecha de la promesa es un día festivo "));
			}

			if (guardoExitosamente) {
				FacesContext.getCurrentInstance().addMessage(null,
						new FacesMessage(FacesMessage.SEVERITY_INFO, "Info", "Gestion guardada éxitosamente "));
			} else {
				if (diaFestivo) {

				} else {
					FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR,
							"Error", "Gestion no guardada, ocurrio un error "));
				}
			}

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		} finally {
			if (guardoExitosamente) {
				tipificarBean.setObservacion("");
				tipificarBean.setFechaPromesa(null);
				tipificarBean.setSelectedCodigoTipificacion("");
			}
			diaFestivo = false;
			guardoExitosamente = false;
			this.tipificarBean.setAgendaLlamada(false);
			this.tipificarBean.setearValores();
			valorPromesa = new Double(0);
			this.setearValores();
		}
	}

	public boolean guardarAgenda() {
		try {

			if (tipificarBean.getTelefonoAgendado() != null) {
				agenda.setTelefonoAgendamiento(tipificarBean.getTelefonoAgendado());
			}

			if (clienteBean.getCliente().getNumeroDocumentoDeudor() != null) {
				agenda.setDocumentoDeudor(clienteBean.getCliente().getNumeroDocumentoDeudor());
			}

			if (clienteBean.getCliente().getIdDeudor() != null) {
				agenda.setIdDeudor(String.valueOf(clienteBean.getCliente().getIdDeudor()));
			}

			if (clienteBean.getCliente().getCodigoUnicoDeudor() != null) {
				agenda.setCodigoUnicoCliente(clienteBean.getCliente().getCodigoUnicoDeudor());
			}

			if (clienteBean.getObligacion().getNumeroObligacion() != null) {
				agenda.setCodigoObligacion(clienteBean.getObligacion().getNumeroObligacion());
			}

			if (ahora != null) {
				agenda.setFechaIniciollamada(new Timestamp(ahora.getTime()));
			}

			if (tipificarBean.getTelefonoMarcado() != null) {
				agenda.setTelefonoMarcado(tipificarBean.getTelefonoMarcado());
			}

			if (loginBean.getUsuarioHermes() != null) {
				agenda.setAsesor(loginBean.getUsuarioHermes().getNombre());
			}

			if (tipificarBean.getFechaAgendamiento() != null) {
				agenda.setFechaAgendamiento(new Timestamp(tipificarBean.getFechaAgendamiento().getTime()));
			}

			if (tipificarBean.getObservacion() != null) {
				agenda.setObservacion(tipificarBean.getObservacion());
			}

			agenda.setTipoLlamada("");
			agenda.setIdCall(clienteBean.getCliente().getIdCall());
			agenda.setTipoDiscado("");

			if (clienteBean.getCliente().getTelefonoMarcado() != null) {
				agenda.setTelefonoMarcado(clienteBean.getCliente().getTelefonoMarcado());
			}

			if (loginBean.getUsuarioHermes() != null) {
				agenda.setIdUsuarioCrea(Integer.parseInt(loginBean.getUsuarioHermes().getCodusuario()));
			}

			agenda.setEstado(EstadoEnum.ACTIVO.getIndex());

			agenda.setIdGestion(idGestion);

			if (agendaEJB.insertarAgenda(agenda) > 0) {
				guardoExitosamente = true;
			} else {
				guardoExitosamente = false;
			}

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return guardoExitosamente;
	}

	public boolean guardarComite() {
		try {
			if (idTipificacion != null) {
				comite.setIdTipificacion(idTipificacion);
			}

			if (tipificarBean.getNombreTercero() != null) {
				comite.setNombreTercero(tipificarBean.getNombreTercero());
			}

			if (tipificarBean.getTelefonoAgendado() != null) {
				comite.setTelefonoAgendamiento(tipificarBean.getTelefonoAgendado());
			}

			if (clienteBean.getCliente().getNumeroDocumentoDeudor() != null) {
				comite.setDocumentoDeudor(clienteBean.getCliente().getNumeroDocumentoDeudor());
			}

			if (clienteBean.getCliente().getIdDeudor() != null) {
				comite.setIdDeudor(String.valueOf(clienteBean.getCliente().getIdDeudor()));
			}

			if (clienteBean.getCliente().getCodigoUnicoDeudor() != null) {
				comite.setCodigoUnicoCliente(clienteBean.getCliente().getCodigoUnicoDeudor());
			}

			if (clienteBean.getObligacion().getNumeroObligacion() != null) {
				comite.setCodigoObligacion(clienteBean.getObligacion().getNumeroObligacion());
			}

			if (ahora != null) {
				comite.setFechaIniciollamada(new Timestamp(ahora.getTime()));
			}

			if (tipificarBean.getTelefonoMarcado() != null) {
				comite.setTelefonoMarcado(tipificarBean.getTelefonoMarcado());
			}

			if (loginBean.getUsuarioHermes() != null) {
				comite.setAsesor(loginBean.getUsuarioHermes().getNombre());
			}

			if (tipificarBean.getMontoPromesa() != 0.0) {
				comite.setValorPromesa(tipificarBean.getMontoPromesa());
			}

			if (tipificarBean.getFechaPromesa() != null) {
				comite.setFechaPromesa(new Timestamp(tipificarBean.getFechaPromesa().getTime()));
			}

			if (tipificarBean.getFechaAgendamiento() != null) {
				comite.setFechaAgendamiento(new Timestamp(tipificarBean.getFechaAgendamiento().getTime()));
			}

			if (tipificarBean.getObservacion() != null) {
				comite.setObservacion(tipificarBean.getObservacion());
			}

			comite.setTipoLlamada("");
			comite.setIdCall(clienteBean.getCliente().getIdCall());
			comite.setTipoDiscado("");

			if (clienteBean.getCliente().getTelefonoMarcado() != null) {
				comite.setTelefonoMarcado(clienteBean.getCliente().getTelefonoMarcado());
			}

			if (loginBean.getUsuarioHermes() != null) {
				comite.setIdUsuarioCrea(Integer.parseInt(loginBean.getUsuarioHermes().getCodusuario()));
			}

			comite.setEstado(EstadoEnum.ACTIVO.getIndex());

			if (comiteEJB.insertarComite(comite) > 0) {
				idComite = comiteEJB.idComite();

				// se vuelve una gestion cuando es aprobado
				FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Info",
						"Se guarda pero debe esperarse aprobación de coordinador "));

				guardoExitosamente = true;
			} else {
				guardoExitosamente = false;
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return guardoExitosamente;
	}

	public boolean guardarAcuerdo() {
		try {
			if (idTipificacion != null) {
				acuerdo.setIdTipificacion(
						tipificacionEJB.idTipificacion(tipificarBean.getSelectedCodigoTipificacion()));
			}

			if (tipificarBean.getNombreTercero() != null) {
				acuerdo.setNombreTercero(tipificarBean.getNombreTercero());
			}

			if (tipificarBean.getTelefonoAgendado() != null) {
				acuerdo.setTelefonoAgendamiento(tipificarBean.getTelefonoAgendado());
			}

			if (clienteBean.getCliente().getNumeroDocumentoDeudor() != null) {
				acuerdo.setDocumentoDeudor(clienteBean.getCliente().getNumeroDocumentoDeudor());
			}

			if (clienteBean.getCliente().getIdDeudor() != null) {
				acuerdo.setIdDeudor(String.valueOf(clienteBean.getCliente().getIdDeudor()));
			}

			if (clienteBean.getCliente().getCodigoUnicoDeudor() != null) {
				acuerdo.setCodigoUnicoCliente(clienteBean.getCliente().getCodigoUnicoDeudor());
			}

			if (clienteBean.getObligacion().getNumeroObligacion() != null) {
				acuerdo.setCodigoObligacion(clienteBean.getObligacion().getNumeroObligacion());
			}

			if (ahora != null) {
				acuerdo.setFechaIniciollamada(new Timestamp(ahora.getTime()));
			}

			if (tipificarBean.getTelefonoMarcado() != null) {
				acuerdo.setTelefonoMarcado(tipificarBean.getTelefonoMarcado());
			}

			if (loginBean.getUsuarioHermes() != null) {
				acuerdo.setAsesor(loginBean.getUsuarioHermes().getNombre());
			}

			if (tipificarBean.getMontoPromesa() != 0.0) {
				acuerdo.setValorPromesa(tipificarBean.getMontoPromesa());
			}

			if (tipificarBean.getFechaPromesa() != null) {
				acuerdo.setFechaPromesa(new Timestamp(tipificarBean.getFechaPromesa().getTime()));
			}

			if (tipificarBean.getFechaAgendamiento() != null) {
				acuerdo.setFechaAgendamiento(new Timestamp(tipificarBean.getFechaAgendamiento().getTime()));
			}

			if (tipificarBean.getObservacion() != null) {
				acuerdo.setObservacion(tipificarBean.getObservacion());
			}

			acuerdo.setTipoLlamada("");
			acuerdo.setIdCall(clienteBean.getCliente().getIdCall());
			acuerdo.setTipoDiscado("");

			if (clienteBean.getCliente().getTelefonoMarcado() != null) {
				acuerdo.setTelefonoMarcado(clienteBean.getCliente().getTelefonoMarcado());
			}

			if (loginBean.getUsuarioHermes() != null) {
				acuerdo.setIdUsuarioCrea(Integer.parseInt(loginBean.getUsuarioHermes().getCodusuario()));
			}

			if (acuerdoCumple) {
				acuerdo.setEstado(EstadoEnum.ACTIVO.getIndex());
			} else {
				acuerdo.setEstado(EstadoEnum.DESHABILITADO.getIndex());
			}

			acuerdo.setIdGestion(idGestion);

			if (idComite != null) {
				acuerdo.setIdComite(idComite);
			}

			if (acuerdoEJB.insertarAcuerdo(acuerdo) > 0) {
				Integer id = acuerdoEJB.idAcuerdo();

				if (!tipificarBean.getCuotasAcuerdo().isEmpty()) {
					if (acuerdoCuotaEJB.insertarCuotaAcuerdo(tipificarBean.getCuotasAcuerdo(), id) > 0) {
						guardoExitosamente = true;
					}
				} else {
					AcuerdoCuota cuotaAcuerdo = new AcuerdoCuota();

					cuotaAcuerdo.setNumeroCuota(1);
					cuotaAcuerdo.setValorTotalDeuda(tipificarBean.getValorTotal());
					cuotaAcuerdo.setValorAcuerdo(tipificarBean.getMontoPromesa());
					cuotaAcuerdo.setFechaAcuerdo(new Timestamp(tipificarBean.getFechaPromesa().getTime()));
					cuotaAcuerdo.setIdUsuarioCrea(Integer.parseInt(loginBean.getUsuarioHermes().getCodusuario()));
					cuotaAcuerdo.setEstado(EstadoEnum.ACTIVO.getIndex());

					if (acuerdoCuotaEJB.insertarCuotaAcuerdo(cuotaAcuerdo, id) > 0) {
						guardoExitosamente = true;
					}
				}
			} else {
				guardoExitosamente = false;
			}

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return guardoExitosamente;
	}

	public boolean guardarGestionNormal() {
		try {
			if (idTipificacion != null) {
				gestion.setIdTipificacion(idTipificacion);
			}

			if (tipificarBean.getNombreTercero() != null) {
				gestion.setNombreTercero(tipificarBean.getNombreTercero());
			}

			if (tipificarBean.getTelefonoAgendado() != null) {
				gestion.setTelefonoAgendamiento(tipificarBean.getTelefonoAgendado());
			}

			if (clienteBean.getCliente().getNumeroDocumentoDeudor() != null) {
				gestion.setDocumentoDeudor(clienteBean.getCliente().getNumeroDocumentoDeudor());
			}

			if (clienteBean.getCliente().getIdDeudor() != null) {
				gestion.setIdDeudor(String.valueOf(clienteBean.getCliente().getIdDeudor()));
			}

			if (clienteBean.getCliente().getCodigoUnicoDeudor() != null) {
				gestion.setCodigoUnicoCliente(clienteBean.getCliente().getCodigoUnicoDeudor());
			}

			if (clienteBean.getObligacion().getNumeroObligacion() != null) {
				gestion.setCodigoObligacion(clienteBean.getObligacion().getNumeroObligacion());
			}

			if (ahora != null) {
				gestion.setFechaFinllamada(new Timestamp(ahora.getTime()));
			}

			if (tipificarBean.getTelefonoMarcado() != null) {
				gestion.setTelefonoMarcado(tipificarBean.getTelefonoMarcado());
			}

			if (loginBean.getUsuarioHermes() != null) {
				gestion.setAsesor(loginBean.getUsuarioHermes().getNombre());
			}

			if (tipificarBean.getMontoPromesa() != 0.0) {
				gestion.setValorPromesa(tipificarBean.getMontoPromesa());
			}

			if (tipificarBean.getFechaPromesa() != null) {
				gestion.setFechaPromesa(new Timestamp(tipificarBean.getFechaPromesa().getTime()));
			}

			if (tipificarBean.getFechaAgendamiento() != null) {
				gestion.setFechaAgendamiento(new Timestamp(tipificarBean.getFechaAgendamiento().getTime()));
			}

			if (tipificarBean.getObservacion() != null) {
				gestion.setObservacion(tipificarBean.getObservacion());
			}

			gestion.setTipoLlamada("");
			gestion.setIdCall(clienteBean.getCliente().getIdCall());
			gestion.setTipoDiscado("");

			if (clienteBean.getCliente().getFechaInicioLlamada() != null) {
				gestion.setFechaIniciollamada(clienteBean.getCliente().getFechaInicioLlamada());
			}

			if (clienteBean.getCliente().getTelefonoMarcado() != null) {
				gestion.setTelefonoMarcado(clienteBean.getCliente().getTelefonoMarcado());
			}

			if (loginBean.getUsuarioHermes() != null) {
				gestion.setIdUsuarioCrea(Integer.parseInt(loginBean.getUsuarioHermes().getCodusuario()));
			}

			if (acuerdoCumple) {
				if (tipificarBean.isAcuerdo()) {
					gestion.setEstado(EstadoEnum.ACTIVO.getIndex());
				} else {
					gestion.setEstado(EstadoEnum.DESHABILITADO.getIndex());
				}
			} else {
				if (!tipificarBean.isAcuerdo() && !tipificarBean.isAgendaLlamada()) {
					gestion.setEstado(EstadoEnum.ACTIVO.getIndex());
				} else if (!tipificarBean.isAcuerdo() && tipificarBean.isAgendaLlamada()) {
					gestion.setEstado(EstadoEnum.ACTIVO.getIndex());
				} else {
					gestion.setEstado(EstadoEnum.DESHABILITADO.getIndex());
				}
			}

			if (gestionEJB.insertarGestion(gestion) > 0) {
				idGestion = gestionEJB.idGestion();

				if (!clienteBean.getIdObligaciones().isEmpty()) {
					for (Integer c : clienteBean.getIdObligaciones()) {

						obligacionGestion.setIdGestion(idGestion);
						obligacionGestion.setIdObligacion(c);
						obligacionGestion
								.setIdUsuarioCrea(Integer.parseInt(loginBean.getUsuarioHermes().getCodusuario()));

						if (obligacionGestionEJB.insertarObligacionGestion(obligacionGestion) > 0) {
							guardoExitosamente = true;
						} else {
							guardoExitosamente = false;
						}
					}
				} else {
					obligacionGestion.setIdGestion(idGestion);
					obligacionGestion.setIdObligacion(clienteBean.getObligacion().getIdObligacion());
					obligacionGestion.setIdUsuarioCrea(Integer.parseInt(loginBean.getUsuarioHermes().getCodusuario()));

					if (obligacionGestionEJB.insertarObligacionGestion(obligacionGestion) > 0) {
						guardoExitosamente = true;
					} else {
						guardoExitosamente = false;
					}
				}

			} else {
				guardoExitosamente = false;
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return guardoExitosamente;
	}

	public boolean validarFestivo() {
		try {
			CalendarioWS calendarioWS = new CalendarioWS();
			diaFestivo = false;
			listaFestivosWS = calendarioWS.consultaFestivos(Constante.PAIS);

			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

			if (tipificarBean.getFechaAgendamiento() != null) {
				String fechaComoCadena = sdf.format(tipificarBean.getFechaAgendamiento());
				for (FechaCalendarioDTO festivosWS : listaFestivosWS) {
					if (festivosWS.getFechaFestivo().equals(fechaComoCadena)) {
						diaFestivo = true;
						break;
					}
				}
			}

			if (tipificarBean.getFechaAcuerdo() != null) {
				String fechaComoCadena2 = sdf.format(tipificarBean.getFechaAcuerdo());

				for (FechaCalendarioDTO festivosWS : listaFestivosWS) {
					if (festivosWS.getFechaFestivo().equals(fechaComoCadena2)) {
						diaFestivo = true;
						break;
					}
				}
			}

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return diaFestivo;
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

	public TipificarBean getTipificarBean() {
		return tipificarBean;
	}

	public void setTipificarBean(TipificarBean tipificarBean) {
		this.tipificarBean = tipificarBean;
	}

	public ITipificacionEJBLocal getTipificacionEJB() {
		return tipificacionEJB;
	}

	public void setTipificacionEJB(ITipificacionEJBLocal tipificacionEJB) {
		this.tipificacionEJB = tipificacionEJB;
	}

	public IGestionEJBLocal getGestionEJB() {
		return gestionEJB;
	}

	public void setGestionEJB(IGestionEJBLocal gestionEJB) {
		this.gestionEJB = gestionEJB;
	}

	public IObligacionGestionEJBLocal getObligacionGestionEJB() {
		return obligacionGestionEJB;
	}

	public void setObligacionGestionEJB(IObligacionGestionEJBLocal obligacionGestionEJB) {
		this.obligacionGestionEJB = obligacionGestionEJB;
	}

	public List<FechaCalendarioDTO> getListaFestivosWS() {
		return listaFestivosWS;
	}

	public void setListaFestivosWS(List<FechaCalendarioDTO> listaFestivosWS) {
		this.listaFestivosWS = listaFestivosWS;
	}

	public boolean isDiaFestivo() {
		return diaFestivo;
	}

	public void setDiaFestivo(boolean diaFestivo) {
		this.diaFestivo = diaFestivo;
	}

	public boolean isGuardoExitosamente() {
		return guardoExitosamente;
	}

	public void setGuardoExitosamente(boolean guardoExitosamente) {
		this.guardoExitosamente = guardoExitosamente;
	}

	public IComiteEJBLocal getComiteEJB() {
		return comiteEJB;
	}

	public void setComiteEJB(IComiteEJBLocal comiteEJB) {
		this.comiteEJB = comiteEJB;
	}

	public IAcuerdoEJBLocal getAcuerdoEJB() {
		return acuerdoEJB;
	}

	public void setAcuerdoEJB(IAcuerdoEJBLocal acuerdoEJB) {
		this.acuerdoEJB = acuerdoEJB;
	}

	public Date getAhora() {
		return ahora;
	}

	public void setAhora(Date ahora) {
		this.ahora = ahora;
	}

	public Gestion getGestion() {
		return gestion;
	}

	public void setGestion(Gestion gestion) {
		this.gestion = gestion;
	}

	public ObligacionGestion getObligacionGestion() {
		return obligacionGestion;
	}

	public void setObligacionGestion(ObligacionGestion obligacionGestion) {
		this.obligacionGestion = obligacionGestion;
	}

	public Comite getComite() {
		return comite;
	}

	public void setComite(Comite comite) {
		this.comite = comite;
	}

	public Acuerdo getAcuerdo() {
		return acuerdo;
	}

	public void setAcuerdo(Acuerdo acuerdo) {
		this.acuerdo = acuerdo;
	}

	public Agenda getAgenda() {
		return agenda;
	}

	public void setAgenda(Agenda agenda) {
		this.agenda = agenda;
	}

	public IAgendaEJBLocal getAgendaEJB() {
		return agendaEJB;
	}

	public void setAgendaEJB(IAgendaEJBLocal agendaEJB) {
		this.agendaEJB = agendaEJB;
	}

	public Integer getIdGestion() {
		return idGestion;
	}

	public void setIdGestion(Integer idGestion) {
		this.idGestion = idGestion;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Double getValorPromesa() {
		return valorPromesa;
	}

	public void setValorPromesa(Double valorPromesa) {
		this.valorPromesa = valorPromesa;
	}

	public Integer getIdTipificacion() {
		return idTipificacion;
	}

	public void setIdTipificacion(Integer idTipificacion) {
		this.idTipificacion = idTipificacion;
	}

	public List<AcuerdoCuota> getCuotasAcuerdo() {
		return cuotasAcuerdo;
	}

	public void setCuotasAcuerdo(List<AcuerdoCuota> cuotasAcuerdo) {
		this.cuotasAcuerdo = cuotasAcuerdo;
	}

	public IAcuerdoCuotaEJBLocal getAcuerdoCuotaEJB() {
		return acuerdoCuotaEJB;
	}

	public void setAcuerdoCuotaEJB(IAcuerdoCuotaEJBLocal acuerdoCuotaEJB) {
		this.acuerdoCuotaEJB = acuerdoCuotaEJB;
	}

	public boolean isAcuerdoCumple() {
		return acuerdoCumple;
	}

	public void setAcuerdoCumple(boolean acuerdoCumple) {
		this.acuerdoCumple = acuerdoCumple;
	}

	public Integer getIdComite() {
		return idComite;
	}

	public void setIdComite(Integer idComite) {
		this.idComite = idComite;
	}

}
