package co.sistemcobro.dashboarddb.dao;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.apache.log4j.Logger;

import co.sistemcobro.dashboarddb.bean.Memo;

public class MemoDAO extends BaseDAO {

	private static Logger logger = Logger.getLogger(MemoDAO.class);

	public MemoDAO(DataSource ds) {
		super(ds);
	}

	private String SQL_MEMO_POR_DEUDOR = "Select distinct * from consultarMemo(?) "
			+ " order by idgestion desc ";

	/**
	 * consultar memo. método para consultar las gestiones realizadas.
	 * 2019-04-29
	 * 
	 * @author Camilo Ochoa
	 * @param String
	 *            (identificación del cliente)
	 * @return List<Memo> (lista de gestiones)
	 * @throws Exception
	 * @see N/A
	 */

	public List<Memo> consultarMemo(String numeroDocumento) throws Exception {
		List<Memo> gestiones = new ArrayList<>();
		Memo memo = null;
		try {
			con = ds.getConnection();
			ps = con.prepareStatement(SQL_MEMO_POR_DEUDOR, Statement.RETURN_GENERATED_KEYS);

			ps.setString(1, numeroDocumento);

			rs = ps.executeQuery();
			while (rs.next()) {
				int t = 1;
				memo = new Memo();
				
				memo.setNumeroDocumentoDeudor(rs.getString(t++));
				memo.setIdGestion(rs.getInt(t++));
				memo.setTelefonoAgendamiento(rs.getString(t++));
				memo.setNombreTercero(rs.getString(t++));
				memo.setFechaLlamada(rs.getTimestamp(t++));
				memo.setNombreAsesor(rs.getString(t++));
				memo.setTelefonoMarcado(rs.getString(t++));
				memo.setObservacion(rs.getString(t++));
				memo.setFechaAgendamiento(rs.getTimestamp(t++));
				memo.setValorPromesa(rs.getBigDecimal(t++));
				memo.setFechaPromesa(rs.getTimestamp(t++));
				memo.setTipificacion(rs.getString(t++));
				memo.setIdCall(rs.getString(t++));
				memo.setAprobadoPor(rs.getString(t++));
				
				gestiones.add(memo);
			}

		} catch (SQLException e) {
			logger.error("SQLException Error SQL al tratar de consultarMemo MemoDAO " + " id del registro.... "
					+ Statement.RETURN_GENERATED_KEYS + " tabla afectada.... GESTIONES " + "descripción de evento..."
					+ e);
			throw new SQLException("SQLException Error SQL al tratar de consultarMemo ");
		} catch (Exception e) {
			logger.error("Exception Error al tratar de consultarMemo Clase MemoDAO " + "id del registro.... "
					+ Statement.RETURN_GENERATED_KEYS + " tabla afectada.... gestion " + "descripción de evento..."
					+ e);
			throw new Exception("Exception Error al tratar de consultarMemo ");
		} finally {
			closeConexion();
			logger.info("finalizo dao MemoDAO método consultarMemo!");
		}
		return gestiones;
	}

}
