package co.sistemcobro.dashboarddb.dao;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.apache.log4j.Logger;

import co.sistemcobro.dashboarddb.bean.Pago;

public class PagoDAO extends BaseDAO {

	public PagoDAO(DataSource ds) {
		super(ds);
	}

	private static Logger logger = Logger.getLogger(PagoDAO.class);
	
	private String SQL_PAGOS_POR_CLIENTE = "SELECT DISTINCT p.p_id, p.p_idcargue, p.USU_FIN, p.RAN_ANO_CAS, p.TIP_CAR, p.COD_CLI, "
			+ " p.NOM_CLI, p.COD_PRE, p.NOM_AGE, p.CARTERA_EDR_INH,  p.COD_MON, p.PAG_REA, p.PAG_REA_SOL, p.FEC_ULT_PAG "
			+ " FROM mibanco.pago p "
			+ " JOIN mibanco.cargue c on c.c_id = p.p_idcargue  "
			+ " JOIN mibanco.base bas on bas.b_id = c.c_idbase 	"
			+ " JOIN mibanco.producto pr on pr.p_id = bas.b_idproducto 	"
			+ " where c.c_estado = 2 AND pr.p_estado = 2 "
			+ " AND p.COD_CLI = ? ";
	
	/**
	 * pagos. método para consultar los pagos del cliente. 2019-04-29
	 * 
	 * @author Camilo Ochoa
	 * @param N/A
	 * @throws SQLException
	 *             si existe error de sintaxis en la sentencia SQL. Exception si
	 *             hay valores en null
	 * @return List<Pago> (Lista de pagos)
	 * @see N/A
	 */
	
	public List<Pago> pagos(String codigoCliente) throws Exception {
		List<Pago> pagos = new ArrayList<>();
		Pago pago = null;
		try {
			con = ds.getConnection();
			ps = con.prepareStatement(SQL_PAGOS_POR_CLIENTE, Statement.RETURN_GENERATED_KEYS);
			
			ps.setString(1, codigoCliente);
			
			rs = ps.executeQuery();
			while (rs.next()) {
				int t = 1;
				pago = new Pago();
				
				pago.setIdPago(rs.getInt(t++));
				pago.setIdCargue(rs.getInt(t++));
				pago.setUsuarioFin(rs.getString(t++));
				pago.setRango(rs.getString(t++));
				pago.setTipoCartera(rs.getString(t++));
				pago.setCodigoDeudor(rs.getString(t++));
				pago.setNombreDeudor(rs.getString(t++));
				pago.setCodigoObligacion(rs.getString(t++));
				pago.setNombreAgencia(rs.getString(t++));
				pago.setCarteraINH(rs.getString(t++));
				pago.setCodigoMoneda(rs.getString(t++));
				pago.setPagoReal(rs.getFloat(t++));
				pago.setPagoRealSoles(rs.getFloat(t++));
				pago.setFechaUltimoPago(rs.getTimestamp(t++));

				
				pagos.add(pago);				
			}
		} catch (SQLException e) {
			logger.error("SQLException Error SQL al tratar de consultar pagos PagoDAO "
					+ " id del registro.... " + Statement.RETURN_GENERATED_KEYS + " tabla afectada.... pagos "
					+ "descripción de evento..." + e);
			throw new SQLException("SQLException Error SQL al tratar de consultar pagos ");
		} catch (Exception e) {
			logger.error("Exception Error al tratar de consultar pagos PagoDAO " + "id del registro.... "
					+ Statement.RETURN_GENERATED_KEYS + " tabla afectada.... pagos " + "descripción de evento..."
					+ e);
			throw new Exception("Exception Error al tratar de consultar pagos ");
		} finally {
			closeConexion();
			logger.info("finalizo dao PagoDAO método pagos!");
		}
		return pagos;
	}

}
