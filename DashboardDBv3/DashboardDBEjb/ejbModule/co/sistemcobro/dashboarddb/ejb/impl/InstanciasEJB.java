package co.sistemcobro.dashboarddb.ejb.impl;

import java.util.ArrayList;

import javax.ejb.Stateless;

import co.sistemcobro.dashboarddb.bean.Instancias;
import co.sistemcobro.dashboarddb.dao.InstanciasDAO;
import co.sistemcobro.dashboarddb.ejb.IInstanciasEJBLocal;

@Stateless(name = "InstanciasEJB")
public class InstanciasEJB extends BaseEJB implements IInstanciasEJBLocal  {

	public 	ArrayList<Instancias> ConsultarListadoInstancia (String criterio) throws Exception {
		InstanciasDAO instanciasdao = new InstanciasDAO (dc_dashboard);
		return instanciasdao.ConsultarListadoInstancia(criterio);
	}


	
	
}
