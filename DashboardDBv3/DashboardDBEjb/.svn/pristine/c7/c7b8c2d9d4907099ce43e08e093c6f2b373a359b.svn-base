package co.sistemcobro.dashboarddb.ejb;

import java.util.List;

import javax.ejb.Local;

import co.sistemcobro.dashboarddb.bean.Obligacion;


@Local
public interface IObligacionEJBLocal {

	public Obligacion consultarObligacionPorCliente(String tipoDocumento, String numeroDocumento) throws Exception;
	
	public List<Obligacion> consultarObligacionesPorCliente(String tipoDocumento, String numeroDocumento) throws Exception;
	
	public Obligacion consultarObligacionPorCliente(String numeroDocumento) throws Exception;
	
	public List<Obligacion> consultarObligacionesPorCliente(String numeroDocumento) throws Exception;
	
}
