package co.sistemcobro.dashboarddb.ejb;

import java.util.List;

import javax.ejb.Local;

import co.sistemcobro.dashboarddb.bean.Acuerdo;

@Local
public interface IAcuerdoEJBLocal {
	
	public Integer insertarAcuerdo(Acuerdo acuerdo) throws Exception;
	
	public Integer idAcuerdo() throws Exception;
	
	public Integer actualizarEstado(Integer idComite, Integer idUsuarioMod) throws Exception;
	
	public List<Acuerdo> cuotasAcuerdosPorGestion(Integer idGestion) throws Exception;

}
