package co.sistemcobro.dashboarddb.bean;

import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.Application;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

import co.sistemcobro.dashboarddb.session.LoginBean;
import co.sistemcobro.dashboarddb.ejb.IAcuerdoEJBLocal;
import co.sistemcobro.dashboarddb.ejb.IClienteEJBLocal;
import co.sistemcobro.dashboarddb.ejb.IComiteEJBLocal;
import co.sistemcobro.dashboarddb.ejb.IDescuentoDiferenciadoEJBLocal;
import co.sistemcobro.dashboarddb.ejb.IObligacionEJBLocal;
import co.sistemcobro.dashboarddb.ejb.IPoliticaDescuentoEJBLocal;
import co.sistemcobro.dashboarddb.ejb.ITelefonoEJBLocal;

import org.apache.log4j.Logger;

@ManagedBean(name = "clienteBean")
@ViewScoped
public class ClienteBean implements Serializable {

	private static final long serialVersionUID = -1250355351622573445L;
	private static Logger logger = Logger.getLogger(ClienteBean.class);
	private LoginBean loginBean;
	private Cliente cliente;
	private String idCall;
	private String connected_call;
	private String telefonoMarcado;
	private PoliticaDescuento politica;
	private DescuentoDiferenciado descuentoDiferenciado;

	@EJB
	private IPoliticaDescuentoEJBLocal politicaDescuentoEJB;
	@EJB
	private IDescuentoDiferenciadoEJBLocal descuentoDiferenciadoEJB;
	@EJB
	private IClienteEJBLocal clienteEJB;
	@EJB
	private IObligacionEJBLocal obligacionEJB;
	@EJB
	private ITelefonoEJBLocal telefonoEJB;
	@EJB
	private IComiteEJBLocal comiteEJB;
	@EJB
	private IAcuerdoEJBLocal acuerdoEJB;

	private Obligacion obligacion;
	private boolean obligacionSelected;
	private List<Obligacion> obligaciones;

	private List<Integer> idObligaciones;
	private ExternalContext context;

	private NavegacionBean navegacionBean;
	private String idC;

	private double valorDescuentoMin;
	private double valorDescuentoMax;

	private double valorDescuentoCampana;

	private double deudaTotalizada;

	private double capitalDeuda;

	private double deudaTotalizada2;

	@PostConstruct
	public void init() {
		try {
			FacesContext context = FacesContext.getCurrentInstance();
			Application application = context.getApplication();
			navegacionBean = application.evaluateExpressionGet(context, "#{navegacionBean}", NavegacionBean.class);
			loginBean = (application.evaluateExpressionGet(context, "#{loginBean}", LoginBean.class));

			cliente = new Cliente();
			obligacion = new Obligacion();
			politica = new PoliticaDescuento();
			descuentoDiferenciado = new DescuentoDiferenciado();
			idObligaciones = new ArrayList<>();
			deudaTotalizada2 = 0;
			capitalDeuda = 0;
			this.datosCliente();

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}

	}

	public void guardarTelefono(String numero) {
		try {
			Date ahora = new Date();
			cliente.setTelefonoMarcado(numero);
			cliente.setFechaInicioLlamada(new Timestamp(ahora.getTime()));
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
	}

	public void escucharObligacion(Integer idObligacion, String deuda) {
		try {
			String summary = obligacionSelected ? "Checked" : "Unchecked";
			String valorDeudaStr = deuda.replace(",", ".");
			double totalDeuda = Double.parseDouble(valorDeudaStr);
			if (summary.equals("Checked")) {
				idObligaciones.add(idObligacion);
				deudaTotalizada2 += totalDeuda;
			} else {
				deudaTotalizada2 -= totalDeuda;
			}

			deudaTotalizada = formatearDecimales(deudaTotalizada2, 2);

			this.calcularDescuentos();
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}

	}

	public void datosCliente() {
		HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext()
				.getRequest();
		String idCliente = (String) request.getParameter("idcliente");
		String tipoDocumento = (String) request.getParameter("tipodocumento");

		String numeroMarcado = (String) request.getParameter("numeromarcado");

		idCall = (String) request.getParameter("id_call");
		connected_call = (String) request.getParameter("connected_call");

		try {
			if (idCliente != null) {
				if (tipoDocumento == null || tipoDocumento.equals("")) {
					cliente = clienteEJB.detalleCliente(idCliente);
					obligacion = obligacionEJB.consultarObligacionPorCliente(idCliente);
					obligaciones = obligacionEJB.consultarObligacionesPorCliente(idCliente);
					cliente.setIdCall(idCall);
					cliente.setTelefonoMarcado(telefonoMarcado);

					for (Obligacion ob : obligaciones) {
						String valorDeudaStr = ob.getDeudaVencida().replace(",", ".");
						double totalDeuda = Double.parseDouble(valorDeudaStr);

						deudaTotalizada += totalDeuda;
					}
					deudaTotalizada = formatearDecimales(deudaTotalizada, 2);
					this.calcularDescuentos();
				} else {
					cliente = clienteEJB.detalleCliente(tipoDocumento, idCliente);
					obligacion = obligacionEJB.consultarObligacionPorCliente(tipoDocumento, idCliente);
					obligaciones = obligacionEJB.consultarObligacionesPorCliente(tipoDocumento, idCliente);
					cliente.setIdCall(idCall);
					cliente.setTelefonoMarcado(telefonoMarcado);

					for (Obligacion ob : obligaciones) {
						String valorDeudaStr = ob.getDeudaVencida().replace(",", ".");
						double totalDeuda = Double.parseDouble(valorDeudaStr);

						deudaTotalizada += totalDeuda;
					}

					deudaTotalizada = formatearDecimales(deudaTotalizada, 2);
					this.calcularDescuentos();
				}

				if (connected_call != null) {
					if (!connected_call.isEmpty()) {
						cliente.setTelefonoMarcado(connected_call);
						Date fecha = new Date();
						cliente.setFechaInicioLlamada(new Timestamp(fecha.getTime()));
					}
				} else {
					Date fecha = new Date();
					cliente.setFechaInicioLlamada(new Timestamp(fecha.getTime()));
				}

				if (numeroMarcado != null && !numeroMarcado.equals("")) {
					cliente.setTelefonoMarcado(numeroMarcado);
					Date fecha = new Date();
					cliente.setFechaInicioLlamada(new Timestamp(fecha.getTime()));
				} else {
					Date fecha = new Date();
					cliente.setFechaInicioLlamada(new Timestamp(fecha.getTime()));
				}

			}

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
	}

	public void calcularDescuentos() {
		try {

			politica = new PoliticaDescuento();
			descuentoDiferenciado = new DescuentoDiferenciado();

			if (obligacion.getRangoMora() != null || obligacion.getRangoUIT() != null) {

				politica = politicaDescuentoEJB.descuentoMinyMax(obligacion.getRangoMora(), obligacion.getRangoUIT());
				if (politica != null) {
					double valorDescuentoMin1 = (deudaTotalizada * politica.getDescMin());
					double valorDescuentoMax1 = (deudaTotalizada * politica.getDescMax());

					valorDescuentoMin = formatearDecimales(valorDescuentoMin1, 2);
					valorDescuentoMax = formatearDecimales(valorDescuentoMax1, 2);

					descuentoDiferenciado = descuentoDiferenciadoEJB.descuentoDiferenciado(
							obligacion.getNumeroObligacion(), obligacion.getNumeroDocumento(),
							obligacion.getCodigoUnicoCliente());

					capitalDeuda = descuentoDiferenciado.getCapital();
					double valorPorcentaje = formatearDecimales((capitalDeuda * descuentoDiferenciado.getDescuento()),
							2);
					valorDescuentoCampana = formatearDecimales((capitalDeuda - valorPorcentaje), 2);
				}
			}

		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}

	}

	public Double formatearDecimales(Double numero, Integer numeroDecimales) {
		return Math.round(numero * Math.pow(10, numeroDecimales)) / Math.pow(10, numeroDecimales);
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public LoginBean getLoginBean() {
		return loginBean;
	}

	public void setLoginBean(LoginBean loginBean) {
		this.loginBean = loginBean;
	}

	public String getIdCall() {
		return idCall;
	}

	public void setIdCall(String idCall) {
		this.idCall = idCall;
	}

	public String getConnected_call() {
		return connected_call;
	}

	public void setConnected_call(String connected_call) {
		this.connected_call = connected_call;
	}

	public IClienteEJBLocal getClienteEJB() {
		return clienteEJB;
	}

	public void setClienteEJB(IClienteEJBLocal clienteEJB) {
		this.clienteEJB = clienteEJB;
	}

	public ITelefonoEJBLocal getTelefonoEJB() {
		return telefonoEJB;
	}

	public void setTelefonoEJB(ITelefonoEJBLocal telefonoEJB) {
		this.telefonoEJB = telefonoEJB;
	}

	public ExternalContext getContext() {
		return context;
	}

	public void setContext(ExternalContext context) {
		this.context = context;
	}

	public NavegacionBean getNavegacionBean() {
		return navegacionBean;
	}

	public void setNavegacionBean(NavegacionBean navegacionBean) {
		this.navegacionBean = navegacionBean;
	}

	public String getIdC() {
		return idC;
	}

	public void setIdC(String idC) {
		this.idC = idC;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public IObligacionEJBLocal getObligacionEJB() {
		return obligacionEJB;
	}

	public void setObligacionEJB(IObligacionEJBLocal obligacionEJB) {
		this.obligacionEJB = obligacionEJB;
	}

	public Obligacion getObligacion() {
		return obligacion;
	}

	public void setObligacion(Obligacion obligacion) {
		this.obligacion = obligacion;
	}

	public List<Obligacion> getObligaciones() {
		return obligaciones;
	}

	public void setObligaciones(List<Obligacion> obligaciones) {
		this.obligaciones = obligaciones;
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

	public String getTelefonoMarcado() {
		return telefonoMarcado;
	}

	public void setTelefonoMarcado(String telefonoMarcado) {
		this.telefonoMarcado = telefonoMarcado;
	}

	public IPoliticaDescuentoEJBLocal getPoliticaDescuentoEJB() {
		return politicaDescuentoEJB;
	}

	public void setPoliticaDescuentoEJB(IPoliticaDescuentoEJBLocal politicaDescuentoEJB) {
		this.politicaDescuentoEJB = politicaDescuentoEJB;
	}

	public IDescuentoDiferenciadoEJBLocal getDescuentoDiferenciadoEJB() {
		return descuentoDiferenciadoEJB;
	}

	public void setDescuentoDiferenciadoEJB(IDescuentoDiferenciadoEJBLocal descuentoDiferenciadoEJB) {
		this.descuentoDiferenciadoEJB = descuentoDiferenciadoEJB;
	}

	public double getValorDescuentoMin() {
		return valorDescuentoMin;
	}

	public void setValorDescuentoMin(double valorDescuentoMin) {
		this.valorDescuentoMin = valorDescuentoMin;
	}

	public double getValorDescuentoMax() {
		return valorDescuentoMax;
	}

	public void setValorDescuentoMax(double valorDescuentoMax) {
		this.valorDescuentoMax = valorDescuentoMax;
	}

	public PoliticaDescuento getPolitica() {
		return politica;
	}

	public void setPolitica(PoliticaDescuento politica) {
		this.politica = politica;
	}

	public DescuentoDiferenciado getDescuentoDiferenciado() {
		return descuentoDiferenciado;
	}

	public void setDescuentoDiferenciado(DescuentoDiferenciado descuentoDiferenciado) {
		this.descuentoDiferenciado = descuentoDiferenciado;
	}

	public double getValorDescuentoCampana() {
		return valorDescuentoCampana;
	}

	public void setValorDescuentoCampana(double valorDescuentoCampana) {
		this.valorDescuentoCampana = valorDescuentoCampana;
	}

	public double getDeudaTotalizada() {
		return deudaTotalizada;
	}

	public void setDeudaTotalizada(double deudaTotalizada) {
		this.deudaTotalizada = deudaTotalizada;
	}

	public boolean isObligacionSelected() {
		return obligacionSelected;
	}

	public void setObligacionSelected(boolean obligacionSelected) {
		this.obligacionSelected = obligacionSelected;
	}

	public double getDeudaTotalizada2() {
		return deudaTotalizada2;
	}

	public void setDeudaTotalizada2(double deudaTotalizada2) {
		this.deudaTotalizada2 = deudaTotalizada2;
	}

	public List<Integer> getIdObligaciones() {
		return idObligaciones;
	}

	public void setIdObligaciones(List<Integer> idObligaciones) {
		this.idObligaciones = idObligaciones;
	}

	public double getCapitalDeuda() {
		return capitalDeuda;
	}

	public void setCapitalDeuda(double capitalDeuda) {
		this.capitalDeuda = capitalDeuda;
	}

}