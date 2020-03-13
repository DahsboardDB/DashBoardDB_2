package co.sistemcobro.dashboarddb.ejb;

import java.util.List;
import javax.ejb.Local;

import co.sistemcobro.dashboarddb.bean.Telefono;

@Local
public interface ITelefonoEJBLocal {
	
	public List<Telefono> telefonos(String tipoDocumento, String numeroDocumento) throws Exception;
	
	public Integer idTelefono() throws Exception;
	
	public Integer insertarTelefono(Telefono telefono) throws Exception;

}
