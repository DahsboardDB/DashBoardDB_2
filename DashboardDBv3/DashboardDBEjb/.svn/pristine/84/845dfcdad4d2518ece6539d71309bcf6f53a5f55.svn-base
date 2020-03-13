package co.sistemcobro.dashboarddb.ejb.impl;

import java.util.List;

import javax.ejb.Stateless;

import co.sistemcobro.dashboarddb.bean.AcuerdoCuota;
import co.sistemcobro.dashboarddb.dao.AcuerdoCuotaDAO;
import co.sistemcobro.dashboarddb.ejb.IAcuerdoCuotaEJBLocal;

@Stateless(name = "AcuerdoCuotaEJB")
public class AcuerdoCuotaEJB extends BaseEJB implements IAcuerdoCuotaEJBLocal{

	@Override
	public Integer insertarCuotaAcuerdo(List<AcuerdoCuota>  acuerdoCuota, Integer idAcuerdo) throws Exception {
		AcuerdoCuotaDAO acuerdoCuotaDAO = new AcuerdoCuotaDAO(dg_dashboard);
		return acuerdoCuotaDAO.insertarCuotaAcuerdo(acuerdoCuota, idAcuerdo);
	}

	@Override
	public Integer insertarCuotaAcuerdo(AcuerdoCuota acuerdoCuota, Integer idAcuerdo) throws Exception {
		AcuerdoCuotaDAO acuerdoCuotaDAO = new AcuerdoCuotaDAO(dg_dashboard);
		return acuerdoCuotaDAO.insertarCuotaAcuerdo(acuerdoCuota, idAcuerdo);
	}

}
