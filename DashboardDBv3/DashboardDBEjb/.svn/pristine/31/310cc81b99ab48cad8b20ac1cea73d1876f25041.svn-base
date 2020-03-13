package co.sistemcobro.dashboarddb.dao;

import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import org.apache.log4j.Logger;

import co.sistemcobro.dashboarddb.bean.PoliticaDescuento;

public class PoliticaDescuentoDAO  extends BaseDAO {

	public PoliticaDescuentoDAO(DataSource ds) {
		super(ds);
	}

	private static Logger logger = Logger.getLogger(PoliticaDescuentoDAO.class);
	
	private String SQL_POLITICA_DESCUENTO = " SELECT DISTINCT pd.Desc_Min, pd.Desc_Max "
			+ " FROM mibanco.politica_descuento pd "
			+ "	JOIN mibanco.cargue c on c.c_id = pd.idcargue "
			+ " JOIN mibanco.base bas on bas.b_id = c.c_idbase "
			+ "	JOIN mibanco.producto p on p.p_id = bas.b_idproducto "
			+ "	where 	 bas.b_estado = 2 AND c.c_estado = 2 AND p.p_estado = 2 "
			+ " AND pd.RangoMora = ? AND pd.RANGO_UIT = ? ";
	
	/**
	 * descuentoMinyMax. método para consultar los porcentajes de descuento. 2019-04-29
	 * 
	 * @author Camilo Ochoa
	 * @param N/A
	 * @throws SQLException
	 *             si existe error de sintaxis en la sentencia SQL. Exception si
	 *             hay valores en null
	 * @return Objeto PoliticaDescuento ( politica)
	 * @see N/A
	 */

	public PoliticaDescuento descuentoMinyMax(String rangoMora, String rangoUIT) throws Exception {		
		PoliticaDescuento politica = null;
		try {
			con = ds.getConnection();
			ps = con.prepareStatement(SQL_POLITICA_DESCUENTO, Statement.RETURN_GENERATED_KEYS);
			
			ps.setString(1, rangoMora);
			ps.setString(2, rangoUIT);
			
			rs = ps.executeQuery();
			while (rs.next()) {
				int t = 1;
				politica = new PoliticaDescuento();
				
				politica.setDescMin(rs.getFloat(t++));	
				politica.setDescMax(rs.getFloat(t++));	
				
			}
		} catch (SQLException e) {
			logger.error("SQLException Error SQL al tratar de consultar politicas de descuento PoliticaDescuentoDAO "
					+ " id del registro.... " + Statement.RETURN_GENERATED_KEYS + " tabla afectada.... politica descuento "
					+ "descripción de evento..." + e);
			throw new SQLException("SQLException Error SQL al tratar de consultar descuentoMinyMax ");
		} catch (Exception e) {
			logger.error("Exception Error al tratar de consultar politicas de descuento PoliticaDescuentoDAO " + "id del registro.... "
					+ Statement.RETURN_GENERATED_KEYS + " tabla afectada.... politica descuento " + "descripción de evento..."
					+ e);
			throw new Exception("Exception Error al tratar de consultar descuentoMinyMax ");
		} finally {
			closeConexion();
			logger.info("finalizo dao PoliticaDescuentoDAO método descuentoMinyMax!");
		}
		return politica;
	}

}
