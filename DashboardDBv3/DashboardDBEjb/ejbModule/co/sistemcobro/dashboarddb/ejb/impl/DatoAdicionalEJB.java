package co.sistemcobro.dashboarddb.ejb.impl;

import javax.ejb.Stateless;

import co.sistemcobro.dashboarddb.bean.DatoAdicional;
import co.sistemcobro.dashboarddb.dao.DatoAdicionalDAO;
import co.sistemcobro.dashboarddb.ejb.IDatoAdicionalEJBLocal;

@Stateless(name = "DatoAdicionalEJB")
public class DatoAdicionalEJB extends BaseEJB implements IDatoAdicionalEJBLocal {

	@Override
	public Integer insertarDatoAdicional(DatoAdicional datoAdicional) throws Exception {
		DatoAdicionalDAO datoAdicionalDAO = new DatoAdicionalDAO(dg_dashboard);
		return datoAdicionalDAO.insertarDatoAdicional(datoAdicional);
	}

}
