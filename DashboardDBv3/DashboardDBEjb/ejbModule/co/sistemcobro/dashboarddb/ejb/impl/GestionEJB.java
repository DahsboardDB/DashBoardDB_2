package co.sistemcobro.dashboarddb.ejb.impl;

import javax.ejb.Stateless;

import co.sistemcobro.dashboarddb.bean.Gestion;
import co.sistemcobro.dashboarddb.dao.GestionDAO;
import co.sistemcobro.dashboarddb.ejb.IGestionEJBLocal;

@Stateless(name = "GestionEJB")
public class GestionEJB extends BaseEJB implements IGestionEJBLocal {

	@Override
	public Integer insertarGestion(Gestion gestion) throws Exception {
		GestionDAO gestionDAO = new GestionDAO(dg_dashboard);
		return gestionDAO.insertarGestion(gestion);
	}

	@Override
	public Integer idGestion() throws Exception {
		GestionDAO gestionDAO = new GestionDAO(dc_dashboard);
		return gestionDAO.idGestion();
	}
	
	@Override
	public Integer actualizarEstado(Integer idGestion, Integer idUsuarioMod) throws Exception {
		GestionDAO gestionDAO = new GestionDAO(dg_dashboard);
		return gestionDAO.actualizarEstado(idGestion, idUsuarioMod);
	}

}
