package co.sistemcobro.dashboarddb.ejb;

import javax.ejb.Local;

import co.sistemcobro.dashboarddb.bean.DescuentoDiferenciado;

@Local
public interface IDescuentoDiferenciadoEJBLocal {
	
	public DescuentoDiferenciado descuentoDiferenciado(String numeroObligacion, String numeroDocumentoDeudor, String codigoUnicoDeudor ) throws Exception;

}
