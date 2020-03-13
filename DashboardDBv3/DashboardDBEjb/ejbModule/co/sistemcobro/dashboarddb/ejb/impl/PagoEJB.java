package co.sistemcobro.dashboarddb.ejb.impl;

import java.util.List;

import javax.ejb.Stateless;

import co.sistemcobro.dashboarddb.bean.Pago;
import co.sistemcobro.dashboarddb.dao.PagoDAO;
import co.sistemcobro.dashboarddb.ejb.IPagoEJBLocal;

@Stateless(name = "PagoEJB")
public class PagoEJB extends BaseEJB implements IPagoEJBLocal {

	@Override
	public List<Pago> pagos(String codigoCliente) throws Exception {
		PagoDAO pagoDAO = new PagoDAO(dc_dashboard);
		return pagoDAO.pagos(codigoCliente);
	}

}
