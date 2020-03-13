package co.sistemcobro.dashboarddb.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.sql.DataSource;

import org.apache.log4j.Logger;

import com.mysql.jdbc.Statement;

import co.sistemcobro.dashboarddb.bean.Instancias;

public class InstanciasDAO  extends BaseDAO{
	 
	
	
	
	public InstanciasDAO(DataSource ds2) {
		super(ds2);
		// TODO Auto-generated constructor stub
	}
	
	private static Logger logger = Logger.getLogger(InstanciasDAO.class);

	
	public ArrayList<Instancias> ConsultarListadoInstancia(String criterio) throws SQLException {
	        ArrayList<Instancias> miListadoInstnacia = new ArrayList<Instancias>();
	        Instancias instancia;
	        

	        con = ds.getConnection();
			ps = con.prepareStatement(criterio);
			rs = ps.executeQuery();
	        try {
	        Statement sentencia = (Statement) con.createStatement();

	        String querySQL = 
	        		"SELECT * "
	        		+ "FROM dbaproceso.dbo.InstanciasSQL "
	        		+ "where idsql= " + criterio;
	        ResultSet rs = sentencia.executeQuery(querySQL);
	        while (rs.next()) {
	            // Asignamos los resultados de la busqueda al objeto que se va a retornar.
	        instancia = new Instancias ();
	        instancia.setIdsql(rs.getInt(1));
	        instancia.setInstancia(rs.getString(2));
	        instancia.setDnsname(rs.getString(3));
	        instancia.setObservacion(rs.getString(4));
	        instancia.setFechaCrea(rs.getTimestamp(5));
	        instancia.setFechamodificacion(rs.getTimestamp(6));
	        
	        
	        miListadoInstnacia.add(instancia);
	        }
	        return miListadoInstnacia;
	        } catch (Exception ex) {
	        System.out.println("Error en consulta de listado usuarios: " + ex.getMessage());
	        return miListadoInstnacia;
	        }
	    }
}
