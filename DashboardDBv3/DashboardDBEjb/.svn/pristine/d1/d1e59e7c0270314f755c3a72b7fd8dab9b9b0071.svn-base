package co.sistemcobro.dashboarddb.ejb.impl;

import java.util.List;

import javax.ejb.Stateless;

import co.sistemcobro.dashboarddb.bean.Acuerdo;
import co.sistemcobro.dashboarddb.dao.AcuerdoDAO;
import co.sistemcobro.dashboarddb.ejb.IAcuerdoEJBLocal;

@Stateless(name = "AcuerdoEJB")
public class AcuerdoEJB extends BaseEJB implements IAcuerdoEJBLocal {

	@Override
	public Integer insertarAcuerdo(Acuerdo acuerdo) throws Exception {
		AcuerdoDAO acuerdoDAO = new AcuerdoDAO(dg_dashboard);
		return acuerdoDAO.insertarAcuerdo(acuerdo);
	}

	@Override
	public Integer idAcuerdo() throws Exception {
		AcuerdoDAO acuerdoDAO = new AcuerdoDAO(dc_dashboard);
		return acuerdoDAO.idAcuerdo();
	}

	@Override
	public Integer actualizarEstado(Integer idAcuerdo, Integer idUsuarioMod) throws Exception {
		AcuerdoDAO acuerdoDAO = new AcuerdoDAO(dg_dashboard);
		return acuerdoDAO.actualizarEstado(idAcuerdo, idUsuarioMod);
	}

	@Override
	public List<Acuerdo> cuotasAcuerdosPorGestion(Integer idGestion) throws Exception {
		AcuerdoDAO acuerdoDAO = new AcuerdoDAO(dc_dashboard);
		return acuerdoDAO.cuotasAcuerdosPorGestion(idGestion);
	}

}
