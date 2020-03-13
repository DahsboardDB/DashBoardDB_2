package co.sistemcobro.dashboarddb.ejb.impl;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

import co.sistemcobro.dashboarddb.bean.Comite;
import co.sistemcobro.dashboarddb.bean.DescuentoDiferenciado;
import co.sistemcobro.dashboarddb.bean.Obligacion;
import co.sistemcobro.dashboarddb.dao.ComiteDAO;
import co.sistemcobro.dashboarddb.dao.DescuentoDiferenciadoDAO;
import co.sistemcobro.dashboarddb.dao.ObligacionDAO;
import co.sistemcobro.dashboarddb.ejb.IComiteEJBLocal;

@Stateless(name = "ComiteEJB")
public class ComiteEJB extends BaseEJB implements IComiteEJBLocal {

	@Override
	public Integer insertarComite(Comite comite) throws Exception {
		ComiteDAO comiteDAO = new ComiteDAO(dg_dashboard);
		return comiteDAO.insertarComite(comite);
	}

	@Override
	public Integer idComite() throws Exception {
		ComiteDAO comiteDAO = new ComiteDAO(dc_dashboard);
		return comiteDAO.idComite();
	}

	@Override
	public List<Comite> comites() throws Exception {
		ComiteDAO comiteDAO = new ComiteDAO(dc_dashboard);
		Obligacion obligacion = new Obligacion();
		ObligacionDAO obligacionDAO = new ObligacionDAO(dc_dashboard);
		DescuentoDiferenciado descuentoDiferenciado = new DescuentoDiferenciado();
		DescuentoDiferenciadoDAO descuentoDAO = new DescuentoDiferenciadoDAO(dc_dashboard);
		List<Comite> comites = new ArrayList<>();
		List<Comite> comites2 = new ArrayList<>();
		comites = comiteDAO.comites();

		for (Comite c : comites) {
			obligacion = obligacionDAO.consultarObligacionPorCliente(c.getDocumentoDeudor());
			
			if(obligacion != null){
				descuentoDiferenciado = descuentoDAO.descuentoDiferenciado(obligacion.getNumeroObligacion(),
						obligacion.getNumeroDocumento(), obligacion.getCodigoUnicoCliente());
				
				if(descuentoDiferenciado != null ){
					 double capitalDeuda = descuentoDiferenciado.getCapital();
					    
					    double valorPorcentaje = formatearDecimales((capitalDeuda * descuentoDiferenciado.getDescuento()), 2);
					    double valorDescuentoCampana = formatearDecimales((capitalDeuda - valorPorcentaje),2);
					    
						c.setValorDescuentoDiferenciado(valorDescuentoCampana);
						
						c.setIdObligacion(obligacion.getIdObligacion());

						comites2.add(c);
				}		  
			}
		}

		return comites2;
	}

	public Double formatearDecimales(Double numero, Integer numeroDecimales) {
		return Math.round(numero * Math.pow(10, numeroDecimales)) / Math.pow(10, numeroDecimales);
	}

	@Override
	public Comite consultarComitePorId(Integer idComite) throws Exception {
		ComiteDAO comiteDAO = new ComiteDAO(dc_dashboard);
		return comiteDAO.consultarComitePorId(idComite);
	}

	@Override
	public Integer actualizarEstadoComite(Integer idComite, Integer idUsuarioMod) throws Exception {
		ComiteDAO comiteDAO = new ComiteDAO(dg_dashboard);
		return comiteDAO.actualizarEstadoComite(idComite, idUsuarioMod);
	}

}
