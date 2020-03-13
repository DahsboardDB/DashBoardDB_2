package co.sistemcobro.dashboarddb.ejb.impl;

import java.util.List;

import javax.ejb.Stateless;

import co.sistemcobro.dashboarddb.bean.Telefono;
import co.sistemcobro.dashboarddb.dao.TelefonoDAO;
import co.sistemcobro.dashboarddb.ejb.ITelefonoEJBLocal;

@Stateless(name = "TelefonoEJB")
public class TelefonoEJB extends BaseEJB implements ITelefonoEJBLocal {

	@Override
	public List<Telefono> telefonos(String tipoDocumento, String numeroDocumento) throws Exception {
		TelefonoDAO telefonoDAO = new TelefonoDAO(dc_dashboard);
		return telefonoDAO.telefonos(tipoDocumento, numeroDocumento);
	}

	@Override
	public Integer idTelefono() throws Exception {
		TelefonoDAO telefonoDAO = new TelefonoDAO(dc_dashboard);
		return telefonoDAO.idTelefono();
	}

	@Override
	public Integer insertarTelefono(Telefono telefono) throws Exception {
		TelefonoDAO telefonoDAO = new TelefonoDAO(dg_dashboard);
		return telefonoDAO.insertarTelefono(telefono);
	}

}
