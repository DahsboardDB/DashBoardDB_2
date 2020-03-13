package co.sistemcobro.dashboarddb.dao;
import java.sql.SQLException;
import java.sql.Statement;
import javax.sql.DataSource;
import org.apache.log4j.Logger;

import co.sistemcobro.dashboarddb.bean.DescuentoDiferenciado;

public class DescuentoDiferenciadoDAO extends BaseDAO {

	public DescuentoDiferenciadoDAO(DataSource ds) {
		super(ds);
	}

	private static Logger logger = Logger.getLogger(DescuentoDiferenciadoDAO.class);
	
	private String SQL_DESCUENTO_DIFERENCIADO = " SELECT DISTINCT df_id, df_idcargue, df_COD_CLI, "
			+ " df_DNI, df_COD_PRE, df_RIESGO, df_DIASMORA, df_CAPITAL, df_DSCTO, df_CAMPANA, "
			+ " df_FECHACASTIGO, idusuariocrea, fechacrea, idusuariomod, fechamod, estado "
			+ " FROM mibanco.descuento_diferenciado ddf "
			+ " JOIN mibanco.cargue c on c.c_id = ddf.df_idcargue  "
			+ " JOIN mibanco.base bas on bas.b_id = c.c_idbase "
			+ " JOIN mibanco.producto p on p.p_id = bas.b_idproducto "
			+ " where 	 bas.b_estado = 2 AND c.c_estado = 2 AND p.p_estado = 2 "
			+ " AND ddf.df_COD_PRE = ? AND (ddf.df_DNI = ? OR  ddf.df_COD_CLI = ?) ";
	
	/**
	 * descuento Diferenciado. método para consultar los porcentajes de descuento diferenciados. 2019-05-28
	 * 
	 * @author Camilo Ochoa
	 * @param String numeroObligacion, String numeroDocumentoDeudor, String codigoUnicoDeudor
	 * @throws SQLException
	 *             si existe error de sintaxis en la sentencia SQL. Exception si
	 *             hay valores en null
	 * @return Objeto PoliticaDescuento ( politica)
	 * @throws Exception 
	 * @see N/A
	 */
	
	public DescuentoDiferenciado descuentoDiferenciado(String numeroObligacion, String numeroDocumentoDeudor, String codigoUnicoDeudor ) throws Exception{
		DescuentoDiferenciado descuento = null;
		try {
			con = ds.getConnection();
			ps = con.prepareStatement(SQL_DESCUENTO_DIFERENCIADO, Statement.RETURN_GENERATED_KEYS);
			
			ps.setString(1, numeroObligacion);
			ps.setString(2, numeroDocumentoDeudor);
			ps.setString(3, codigoUnicoDeudor);
			
			rs = ps.executeQuery();
			while (rs.next()) {
				int t = 1;
				descuento = new DescuentoDiferenciado();
				
				descuento.setIdDescuentoDiferenciado(rs.getInt(t++));
				descuento.setIdCargue(rs.getInt(t++));
				descuento.setCodigoUnicoCliente(rs.getString(t++));
				descuento.setNumeroDocumentoDeudor(rs.getString(t++));
				descuento.setNumeroObligacion(rs.getString(t++));
				descuento.setRiesgo(rs.getString(t++));
				descuento.setDiasMora(rs.getInt(t++));
				descuento.setCapital(rs.getDouble(t++));
				descuento.setDescuento(rs.getFloat(t++));
				descuento.setCampana(rs.getInt(t++));
				descuento.setFechaCastigo(rs.getDate(t++));
				descuento.setIdusuariocrea(rs.getInt(t++));
				descuento.setFechacrea(rs.getTimestamp(t++));
				descuento.setIdusuariomod(rs.getInt(t++));
				descuento.setFechamod(rs.getTimestamp(t++));
				descuento.setEstado(rs.getInt(t++));
				
			}
			
		} catch (SQLException e) {
			logger.error("SQLException Error SQL al tratar de consultar  DescuentoDiferenciadoDAO "
					+ " id del registro.... " + Statement.RETURN_GENERATED_KEYS + " tabla afectada.... descuentoDiferenciado "
					+ "descripción de evento..." + e);
			throw new SQLException("SQLException Error SQL al tratar de consultar descuentoMinyMax ");
		} catch (Exception e) {
			logger.error("Exception Error al tratar de consultar descuentoDiferenciado DescuentoDiferenciadoDAO " + "id del registro.... "
					+ Statement.RETURN_GENERATED_KEYS + " tabla afectada.... descuentoDiferenciado " + "descripción de evento..."
					+ e);
			throw new Exception("Exception Error al tratar de consultar descuentoDiferenciado ");
		} finally {
			closeConexion();
			logger.info("finalizo dao DescuentoDiferenciadoDAO método descuentoDiferenciado!");
		}
		
		return descuento;
	}

}
