package co.sistemcobro.dashboarddb.dao;

import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import org.apache.log4j.Logger;

import co.sistemcobro.dashboarddb.bean.DatoAdicional;
public class DatoAdicionalDAO extends BaseDAO {

	private static Logger logger = Logger.getLogger(DatoAdicionalDAO.class);

	public DatoAdicionalDAO(DataSource ds) {
		super(ds);
	}

	/**
	 * insertarDatoAdicional. método insertar dato adicional. 2019-04-29
	 * 
	 * @author Camilo Ochoa
	 * @param N/A
	 * @throws SQLException
	 *             si existe error de sintaxis en la sentencia SQL. Exception si
	 *             hay valores en null
	 * @return Integer (Llave de la tabla)
	 * @see N/A
	 */

	public Integer insertarDatoAdicional(DatoAdicional datoAdicional) throws Exception {
		Integer llave = 0;
		StringBuilder varname1 = new StringBuilder();
		varname1.append(" INSERT INTO mibanco.datos_adicionales ");
		varname1.append(" ( ");
		varname1.append(" documentodeudor,  ");// 1
		varname1.append(" nombrecompleto,  ");// 2
		varname1.append(" direccion,  ");// 3
		varname1.append(" email,  ");// 4
		varname1.append(" idtelefono,  ");// 5
		varname1.append(" idusuariocrea,  ");// 6
		varname1.append(" fechacrea,  ");// 7
		varname1.append(" estado ");// 8
		varname1.append(" ) ");
		varname1.append(" VALUES ( ");
		varname1.append(" ?, ");// 1
		varname1.append(" ?, ");// 2
		varname1.append(" ?, ");// 3
		varname1.append(" ?, ");// 4
		varname1.append(" ?, ");// 5		
		varname1.append(" ?, ");// 6
		varname1.append(" GETDATE(), ");// 7
		varname1.append(" ? ");// 8
		varname1.append(" ) ");

		try {
			con = ds.getConnection();
			ps = con.prepareStatement(varname1.toString(), Statement.RETURN_GENERATED_KEYS);
			
			int t = 1;
			
			ps.setString(t++, datoAdicional.getDocumentoDeudor());//1
			ps.setString(t++, datoAdicional.getNombrecompleto());//2
			ps.setString(t++, datoAdicional.getDireccion());//3
			ps.setString(t++, datoAdicional.getEmail());//4
			ps.setInt(t++, datoAdicional.getIdTelefono());//5
			ps.setInt(t++, datoAdicional.getIdUsarioCrea());//6
			ps.setInt(t++, datoAdicional.getEstado());//8
			
			ps.executeUpdate();
			llave = Statement.RETURN_GENERATED_KEYS;

		} catch (SQLException e) {
			logger.error("SQLException Error SQL al tratar de insertarDatoAdicional telefonos DatoAdicionalDAO "
					+ " id del registro.... " + Statement.RETURN_GENERATED_KEYS + " tabla afectada.... datos adicionales "
					+ "descripción de evento..." + e);
			throw new SQLException("SQLException Error SQL al tratar de insertarDatoAdicional  ");
		} catch (Exception e) {
			logger.error("Exception Error al tratar de consultar telefonos DatoAdicionalDAO " + "id del registro.... "
					+ Statement.RETURN_GENERATED_KEYS + " tabla afectada.... datos adicionales " + "descripción de evento..."
					+ e);
			throw new Exception("Exception Error al tratar de insertarDatoAdicional telefonos ");
		} finally {
			closeConexion();
			logger.info("finalizo dao DatoAdicionalDAO método insertarDatoAdicional!");
		}
		return llave;
	}

}
