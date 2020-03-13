package co.sistemcobro.dashboarddb.ejb.impl;

import java.util.ArrayList;

import javax.ejb.Stateless;

import co.sistemcobro.dashboarddb.bean.Prueba;
import co.sistemcobro.dashboarddb.dao.PruebaDAO;
import co.sistemcobro.dashboarddb.ejb.IInstanciasEJBLocal;
import co.sistemcobro.dashboarddb.ejb.IPruebaEJBLocal;

@Stateless(name = "PruebaEJB")
public class PruebaEJB extends BaseEJB implements IPruebaEJBLocal {
	
	
public 	ArrayList<Prueba> ConsultarListadoprueba (String criterio) throws Exception {
			PruebaDAO pruebadao = new PruebaDAO (dc_dashboard);
			return pruebadao.ConsultarListadoprueba(criterio);
		}

}
