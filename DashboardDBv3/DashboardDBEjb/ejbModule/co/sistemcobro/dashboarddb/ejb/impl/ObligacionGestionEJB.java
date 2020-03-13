package co.sistemcobro.dashboarddb.ejb.impl;

import javax.ejb.Stateless;

import co.sistemcobro.dashboarddb.bean.ObligacionGestion;
import co.sistemcobro.dashboarddb.dao.ObligacionGestionDAO;
import co.sistemcobro.dashboarddb.ejb.IObligacionGestionEJBLocal;

@Stateless(name = "ObligacionGestionEJB")
public class ObligacionGestionEJB extends BaseEJB implements IObligacionGestionEJBLocal{

	@Override
	public Integer insertarObligacionGestion(ObligacionGestion obligacionGestion) throws Exception {
		ObligacionGestionDAO obligacionGestionDAO = new ObligacionGestionDAO(dg_dashboard);
		return obligacionGestionDAO.insertarObligacionGestion(obligacionGestion);
	}

}
