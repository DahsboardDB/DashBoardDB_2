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

import co.sistemcobro.dashboarddb.ejb.IClienteEJBLocal;
import co.sistemcobro.dashboarddb.ejb.ITipoDocumentoEJBLocal;

@ManagedBean(name = "busquedaBean")
@ViewScoped
public class BusquedaBean  implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static Logger logger = Logger.getLogger(BusquedaBean.class);
	private NavegacionBean navegacionBean;

	@EJB
	private IClienteEJBLocal ClienteEJB;

	@EJB
	private ITipoDocumentoEJBLocal tipoDocumentoEJB;
	
	private List<TipoDocumento> tiposDocumento;
	private String selectedTipoDocumento;

	private String numeroDocumento;
	private List<Cliente> clientes;
	private boolean tabla;
	private boolean sinResultados;

	@PostConstruct
	public void init() {
		try {
			FacesContext context = FacesContext.getCurrentInstance();
			Application application = context.getApplication();
			navegacionBean = application.evaluateExpressionGet(context, "#{navegacionBean}", NavegacionBean.class);
			
			tiposDocumento = tipoDocumentoEJB.tiposDocumento();
			
			
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
	}

	public void buscar() {

		try {
			if(selectedTipoDocumento == "" || selectedTipoDocumento == null){
				this.clientes = ClienteEJB.buscarClientesSinTipoDoc(numeroDocumento);
			}else{
				this.clientes = ClienteEJB.buscarClientes(selectedTipoDocumento, numeroDocumento);
			}

			if (clientes.isEmpty()) {
				sinResultados = true;
				tabla = false;
			} else {
				tabla = true;
				sinResultados = false;
			}

		} catch (Exception e) {

			logger.error(e.getMessage(), e);
		}
	}

	public String getNumeroDocumento() {
		return numeroDocumento;
	}

	public void setNumeroDocumento(String numeroDocumento) {
		this.numeroDocumento = numeroDocumento;
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	public boolean isSinResultados() {
		return sinResultados;
	}

	public void setSinResultados(boolean sinResultados) {
		this.sinResultados = sinResultados;
	}

	public boolean isTabla() {
		return tabla;
	}

	public void setTabla(boolean tabla) {
		this.tabla = tabla;
	}

	public NavegacionBean getNavegacionBean() {
		return navegacionBean;
	}

	public void setNavegacionBean(NavegacionBean navegacionBean) {
		this.navegacionBean = navegacionBean;
	}

	public IClienteEJBLocal getClienteEJB() {
		return ClienteEJB;
	}

	public void setClienteEJB(IClienteEJBLocal clienteEJB) {
		ClienteEJB = clienteEJB;
	}

	public ITipoDocumentoEJBLocal getTipoDocumentoEJB() {
		return tipoDocumentoEJB;
	}

	public void setTipoDocumentoEJB(ITipoDocumentoEJBLocal tipoDocumentoEJB) {
		this.tipoDocumentoEJB = tipoDocumentoEJB;
	}

	public List<TipoDocumento> getTiposDocumento() {
		return tiposDocumento;
	}

	public void setTiposDocumento(List<TipoDocumento> tiposDocumento) {
		this.tiposDocumento = tiposDocumento;
	}

	public String getSelectedTipoDocumento() {
		return selectedTipoDocumento;
	}

	public void setSelectedTipoDocumento(String selectedTipoDocumento) {
		this.selectedTipoDocumento = selectedTipoDocumento;
	}
	
	
	
	

}
