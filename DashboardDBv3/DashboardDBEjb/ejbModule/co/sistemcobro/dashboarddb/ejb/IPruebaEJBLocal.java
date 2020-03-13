package co.sistemcobro.dashboarddb.ejb;

import java.util.ArrayList;

import javax.ejb.Local;


import co.sistemcobro.dashboarddb.bean.Prueba;

@Local
public interface IPruebaEJBLocal {

	public ArrayList <Prueba> ConsultarListadoprueba(String criterio) throws Exception;
	
}
