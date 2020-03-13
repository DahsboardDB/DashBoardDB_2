package co.sistemcobro.dashboarddb.ejb;

import java.util.ArrayList;

import javax.ejb.Local;

import co.sistemcobro.dashboarddb.bean.Instancias;

@Local
public interface IInstanciasEJBLocal {

	public ArrayList <Instancias> ConsultarListadoInstancia(String criterio) throws Exception;
	
}
