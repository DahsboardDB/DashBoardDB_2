package co.sistemcobro.dashboarddb.ejb;

import javax.ejb.Local;

import co.sistemcobro.dashboarddb.bean.PoliticaDescuento;

@Local
public interface IPoliticaDescuentoEJBLocal {
	
	public PoliticaDescuento descuentoMinyMax(String rangoMora, String rangoUIT) throws Exception;

}
