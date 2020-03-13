package co.sistemcobro.dashboarddb.ejb.impl;

import java.util.List;
import javax.ejb.Stateless;

import co.sistemcobro.dashboarddb.bean.Cliente;
import co.sistemcobro.dashboarddb.dao.ClienteDAO;
import co.sistemcobro.dashboarddb.ejb.IClienteEJBLocal;

@Stateless(name = "ClienteEJB")
public class ClienteEJB extends BaseEJB implements IClienteEJBLocal {

	@Override
	public List<Cliente> buscarClientes(String tipoDocumento, String numeroDocumento) throws Exception {
		ClienteDAO cliente = new ClienteDAO(dc_dashboard);
		return cliente.buscarClientes(tipoDocumento, numeroDocumento);
	}

	@Override
	public Cliente detalleCliente(String tipoDocumento, String numeroDocumento) throws Exception {
		ClienteDAO cliente = new ClienteDAO(dc_dashboard);
		return cliente.detalleCliente(tipoDocumento, numeroDocumento);
	}

	@Override
	public List<Cliente> buscarClientesSinTipoDoc(String numeroDocumento) throws Exception {
		ClienteDAO cliente = new ClienteDAO(dc_dashboard);
		return cliente.buscarClientesSinTipoDoc(numeroDocumento);
	}

	@Override
	public Cliente detalleCliente(String numeroDocumento) throws Exception {
		ClienteDAO cliente = new ClienteDAO(dc_dashboard);
		return cliente.detalleCliente(numeroDocumento);
	}

}
