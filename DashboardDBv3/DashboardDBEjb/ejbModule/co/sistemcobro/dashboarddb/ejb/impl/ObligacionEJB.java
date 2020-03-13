package co.sistemcobro.dashboarddb.ejb.impl;
import java.util.List;

import javax.ejb.Stateless;

import co.sistemcobro.dashboarddb.bean.Obligacion;
import co.sistemcobro.dashboarddb.dao.ObligacionDAO;
import co.sistemcobro.dashboarddb.ejb.IObligacionEJBLocal;

@Stateless(name = "ObligacionEJB")
public class ObligacionEJB extends BaseEJB implements IObligacionEJBLocal {

	@Override
	public Obligacion consultarObligacionPorCliente(String tipoDocumento, String numeroDocumento) throws Exception {
		ObligacionDAO obligacionDAO = new ObligacionDAO(dc_dashboard);
		return obligacionDAO.consultarObligacionPorCliente(tipoDocumento, numeroDocumento);
	}

	@Override
	public List<Obligacion> consultarObligacionesPorCliente(String tipoDocumento, String numeroDocumento)
			throws Exception {
		ObligacionDAO obligacionDAO = new ObligacionDAO(dc_dashboard);
		return obligacionDAO.consultarObligacionesPorCliente(tipoDocumento, numeroDocumento);
	}

	@Override
	public Obligacion consultarObligacionPorCliente(String numeroDocumento) throws Exception {
		ObligacionDAO obligacionDAO = new ObligacionDAO(dc_dashboard);
		return obligacionDAO.consultarObligacionPorCliente(numeroDocumento);
	}

	@Override
	public List<Obligacion> consultarObligacionesPorCliente(String numeroDocumento) throws Exception {
		ObligacionDAO obligacionDAO = new ObligacionDAO(dc_dashboard);
		return obligacionDAO.consultarObligacionesPorCliente(numeroDocumento);
	}

}
