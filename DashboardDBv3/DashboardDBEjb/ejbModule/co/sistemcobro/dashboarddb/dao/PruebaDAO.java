package co.sistemcobro.dashboarddb.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import javax.resource.cci.ResultSet;
import javax.sql.DataSource;

import com.mysql.jdbc.Statement;
import com.sun.istack.internal.logging.Logger;

import co.sistemcobro.dashboarddb.bean.Prueba;

public class PruebaDAO extends BaseDAO{

	
public PruebaDAO(DataSource ds2) {
		super(ds2);
		// TODO Auto-generated constructor stub
	}


private static Logger logger = Logger.getLogger(PruebaDAO.class);

	
	public ArrayList<Prueba> ConsultarListadoprueba(String criterio) throws SQLException {
	        ArrayList<Prueba> miListadoprueba = new ArrayList<Prueba>();
	        Prueba prueba;
	        

	        con = ds.getConnection();
			ps = con.prepareStatement(criterio);
			rs = ps.executeQuery();
	        try {
	        Statement sentencia = (Statement) con.createStatement();

	        String querySQL = 
	        		"SELECT * "
	        		+ "FROM dbaproceso.dbo.InstanciasSQL "
	        		+ "where idsql= " + criterio;
	        ResultSet rs = (ResultSet) sentencia.executeQuery(querySQL);
	        while (rs.next()) {
	            // Asignamos los resultados de la busqueda al objeto que se va a retornar.
	        	prueba = new Prueba ();
	        	prueba.setIdtabla(rs.getInt(1));
	        	prueba.setNombre(rs.getString(2));
	        	prueba.setApellido(rs.getString(3));
	        
	        
	        miListadoprueba.add(prueba);
	        }
	        return miListadoprueba;
	        } catch (Exception ex) {
	        System.out.println("Error en consulta de listado usuarios: " + ex.getMessage());
	        return miListadoprueba;
	        }
	    }
	
	
	
}
