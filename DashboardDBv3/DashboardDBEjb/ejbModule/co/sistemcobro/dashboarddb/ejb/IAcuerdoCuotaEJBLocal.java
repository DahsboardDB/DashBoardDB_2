package co.sistemcobro.dashboarddb.ejb;

import java.util.List;

import javax.ejb.Local;

import co.sistemcobro.dashboarddb.bean.AcuerdoCuota;

@Local
public interface IAcuerdoCuotaEJBLocal {
	
	public Integer insertarCuotaAcuerdo(List<AcuerdoCuota> acuerdosCuota, Integer idAcuerdo) throws Exception;
	
	public Integer insertarCuotaAcuerdo(AcuerdoCuota acuerdoCuota, Integer idAcuerdo) throws Exception;
	
	

}
