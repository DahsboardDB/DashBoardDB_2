package co.sistemcobro.dashboarddb.ejb;

import java.util.List;
import javax.ejb.Local;

import co.sistemcobro.dashboarddb.bean.Cliente;


@Local
public interface IClienteEJBLocal {
	
	public List<Cliente> buscarClientes(String tipoDocumento, String numeroDocumento) throws Exception;
	
	public Cliente detalleCliente(String tipoDocumento, String numeroDocumento) throws Exception;
	
	public Cliente detalleCliente(String numeroDocumento) throws Exception;
	
	public List<Cliente> buscarClientesSinTipoDoc(String numeroDocumento) throws Exception;
	
}
