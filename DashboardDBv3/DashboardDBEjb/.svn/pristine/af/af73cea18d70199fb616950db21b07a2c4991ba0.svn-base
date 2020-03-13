package co.sistemcobro.dashboarddb.ejb.impl;

import java.util.List;

import javax.ejb.Stateless;

import co.sistemcobro.dashboarddb.bean.Tipificacion;
import co.sistemcobro.dashboarddb.dao.TipificacionDAO;
import co.sistemcobro.dashboarddb.ejb.ITipificacionEJBLocal;

@Stateless(name = "TipificacionEJB")
public class TipificacionEJB extends BaseEJB implements ITipificacionEJBLocal {

	@Override
	public List<Tipificacion> tipificaciones(Integer idNivel) throws Exception {
		TipificacionDAO tipificacionDAO = new TipificacionDAO(dc_dashboard);
		return tipificacionDAO.tipificaciones(idNivel);
	}

	@Override
	public Integer idTipificacion(String codigo) throws Exception {
		TipificacionDAO tipificacionDAO = new TipificacionDAO(dc_dashboard);
		return tipificacionDAO.idTipificacion(codigo);
	}

}
