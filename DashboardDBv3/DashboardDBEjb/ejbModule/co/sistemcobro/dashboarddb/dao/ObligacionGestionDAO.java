package co.sistemcobro.dashboarddb.dao;

import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import org.apache.log4j.Logger;

import co.sistemcobro.dashboarddb.bean.ObligacionGestion;
import co.sistemcobro.dashboarddb.constante.EstadoEnum;

public class ObligacionGestionDAO extends BaseDAO {

	public ObligacionGestionDAO(DataSource ds) {
		super(ds);
	}

	private static Logger logger = Logger.getLogger(ObligacionGestionDAO.class);
	
	
	/**
	 * insertarObligacionGestion. método insertar la relacion de obligación gestión. 2019-04-29
	 * 
	 * @author Camilo Ochoa
	 * @param N/A
	 * @throws SQLException
	 *             si existe error de sintaxis en la sentencia SQL. Exception si
	 *             hay valores en null
	 * @return Integer (Llave de la tabla)
	 * @see N/A
	 */
	public Integer insertarObligacionGestion(ObligacionGestion obligacionGestion) throws Exception {
		Integer llave = 0;

		StringBuilder varname1 = new StringBuilder();
		varname1.append(" INSERT INTO mibanco.obligacion_gestion ");
		varname1.append(" ( ");
		varname1.append(" idgestion, idobligacion, idusuariocrea, fechacrea, estado ");
		varname1.append(" ) ");
		varname1.append("VALUES ( ");
		varname1.append(" ?,"); // 1
		varname1.append(" ?,"); // 2
		varname1.append(" ?,"); // 3
		varname1.append(" GETDATE(),"); // 4
		varname1.append(" ? "); // 5
		varname1.append(" )");
		try {
			con = ds.getConnection();
			ps = con.prepareStatement(varname1.toString(), Statement.RETURN_GENERATED_KEYS);
			int t = 1;
			
			ps.setInt(t++, obligacionGestion.getIdGestion());
			ps.setInt(t++, obligacionGestion.getIdObligacion());
			ps.setInt(t++, obligacionGestion.getIdUsuarioCrea());
			ps.setInt(t++, EstadoEnum.ACTIVO.getIndex());

			ps.executeUpdate();
			llave = Statement.RETURN_GENERATED_KEYS;

		} catch (SQLException e) {
			logger.error("SQLException Error SQL al tratar de insertarGestion ObligacionGestionDAO " + " id del registro.... "
					+ Statement.RETURN_GENERATED_KEYS + " tabla afectada.... ObligacionGestion " + "descripción de evento..."
					+ e);
			throw new SQLException("SQLException Error SQL al tratar de insertarObligacionGestion ");
		} catch (Exception e) {
			logger.error("Exception Error al tratar de  insertarGestion Clase ObligacionGestionDAO " + "id del registro.... "
					+ Statement.RETURN_GENERATED_KEYS + " tabla afectada.... obligacion " + "descripción de evento..."
					+ e);
			throw new Exception("Exception Error al tratar de insertarObligacionGestion ");
		} finally {
			closeConexion();
			logger.info("finalizo dao ObligacionGestionDAO método insertarObligacionGestion!");
		}
		return llave;
	}

}
