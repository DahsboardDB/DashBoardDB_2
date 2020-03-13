package co.sistemcobro.dashboarddb.ejb.impl;

import javax.ejb.Stateless;

import co.sistemcobro.dashboarddb.bean.DescuentoDiferenciado;
import co.sistemcobro.dashboarddb.dao.DescuentoDiferenciadoDAO;
import co.sistemcobro.dashboarddb.ejb.IDescuentoDiferenciadoEJBLocal;

@Stateless(name = "DescuentoDiferenciadoEJB")
public class DescuentoDiferenciadoEJB extends BaseEJB implements IDescuentoDiferenciadoEJBLocal {

	@Override
	public DescuentoDiferenciado descuentoDiferenciado(String numeroObligacion, String numeroDocumentoDeudor,
			String codigoUnicoDeudor) throws Exception {
		
		DescuentoDiferenciadoDAO descuentoDAO = new DescuentoDiferenciadoDAO(dc_dashboard);
		return descuentoDAO.descuentoDiferenciado(numeroObligacion, numeroDocumentoDeudor, codigoUnicoDeudor);
	}

}
