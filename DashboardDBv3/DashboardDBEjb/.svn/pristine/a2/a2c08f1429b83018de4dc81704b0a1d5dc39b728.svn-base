package co.sistemcobro.dashboarddb.ejb;

import java.util.List;

import javax.ejb.Local;

import co.sistemcobro.dashboarddb.bean.Comite;

@Local
public interface IComiteEJBLocal {
	
	public Integer insertarComite(Comite comite) throws Exception;
	
	public Integer idComite() throws Exception;
	
	public List<Comite> comites() throws Exception;
	
	public Comite consultarComitePorId(Integer idComite) throws Exception;
	
	public Integer actualizarEstadoComite(Integer idComite, Integer idUsuarioMod) throws Exception;

}
