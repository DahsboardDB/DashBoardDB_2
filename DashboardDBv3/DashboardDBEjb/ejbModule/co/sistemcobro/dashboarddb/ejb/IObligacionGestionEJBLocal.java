package co.sistemcobro.dashboarddb.ejb;

import javax.ejb.Local;

import co.sistemcobro.dashboarddb.bean.ObligacionGestion;

@Local
public interface IObligacionGestionEJBLocal {
	
	public Integer insertarObligacionGestion(ObligacionGestion obligacionGestion) throws Exception;

}
