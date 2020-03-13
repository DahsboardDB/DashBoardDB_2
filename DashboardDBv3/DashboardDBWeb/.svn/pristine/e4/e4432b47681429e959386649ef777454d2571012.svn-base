package co.sistemcobro.dashboarddb.bean;

import java.io.Serializable;
import java.util.ArrayList;

import javax.faces.bean.ManagedBean;
import javax.ejb.EJB;
import javax.faces.bean.ViewScoped;

import org.apache.log4j.Logger;

import co.sistemcobro.dashboarddb.ejb.IInstanciasEJBLocal;
import co.sistemcobro.dashboarddb.session.LoginBean;


@ManagedBean(name = "instanciasBean")
@ViewScoped
public class InstanciasBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static Logger logger= Logger.getLogger(InstanciasBean.class);
	private LoginBean loginBean;
	ArrayList <Instancias> ConsultarListadoInstancias;
	
	@EJB 
	private IInstanciasEJBLocal instanciasEJB; 
	
    public void consultarInstancias (String criterio) {
    	
    	try {
    		
    		ConsultarListadoInstancias = instanciasEJB.ConsultarListadoInstancia(criterio);

    	} catch (Exception e) {
    		
    		logger.error(e.getMessage(), e);
    		
    	}
    	
    }
    
    public ArrayList <Instancias> getConsultarListadoInstancias () {
    	return  ConsultarListadoInstancias; 
    	
    }
    
    public void setConsultarListadoInstancias (ArrayList<Instancias> consultarListadoInstancias) {
    	this.ConsultarListadoInstancias = consultarListadoInstancias; 
    }
    
    
    public IInstanciasEJBLocal getInstanciasEJB () {
    	return instanciasEJB;
    	
    }
    
    public void setInstanciasEJB (IInstanciasEJBLocal instanciasEJB) {
    	this.instanciasEJB = instanciasEJB;
    	
    }
	
}



