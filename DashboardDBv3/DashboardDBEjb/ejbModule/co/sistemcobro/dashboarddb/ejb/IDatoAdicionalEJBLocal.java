package co.sistemcobro.dashboarddb.ejb;

import javax.ejb.Local;

import co.sistemcobro.dashboarddb.bean.DatoAdicional;

@Local
public interface IDatoAdicionalEJBLocal {

	public Integer insertarDatoAdicional(DatoAdicional datoAdicional) throws Exception;
}
