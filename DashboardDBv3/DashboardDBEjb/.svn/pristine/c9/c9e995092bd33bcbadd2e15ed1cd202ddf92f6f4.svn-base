package co.sistemcobro.dashboarddb.ejb.impl;

import javax.ejb.Stateless;

import co.sistemcobro.dashboarddb.bean.PoliticaDescuento;
import co.sistemcobro.dashboarddb.dao.PoliticaDescuentoDAO;
import co.sistemcobro.dashboarddb.ejb.IPoliticaDescuentoEJBLocal;

@Stateless(name = "PoliticaDescuentoEJB")
public class PoliticaDescuentoEJB extends BaseEJB implements IPoliticaDescuentoEJBLocal {

	@Override
	public PoliticaDescuento descuentoMinyMax(String rangoMora, String rangoUIT) throws Exception {
		PoliticaDescuentoDAO politicaDescuentoDAO = new PoliticaDescuentoDAO(dc_dashboard);
		return politicaDescuentoDAO.descuentoMinyMax(rangoMora, rangoUIT);
	}

}
