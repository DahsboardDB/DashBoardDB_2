package co.sistemcobro.dashboarddb.dao;

import java.sql.SQLException;
import java.sql.Statement;

import javax.sql.DataSource;

import org.apache.log4j.Logger;

import co.sistemcobro.dashboarddb.bean.Gestion;
import co.sistemcobro.dashboarddb.constante.EstadoEnum;

public class GestionDAO extends BaseDAO {

	private static Logger logger = Logger.getLogger(GestionDAO.class);

	public GestionDAO(DataSource ds) {
		super(ds);
	}

	private String SQL_BUSCAR_ULTIMA_GESTION = "SELECT TOP 1 idgestion " + " FROM mibanco.gestion g ORDER BY 1 DESC ";

	/**
	 * ID última gestión guardada. método para consultar el id de la última
	 * gestión guardada. 2019-04-29
	 * 
	 * @author Camilo Ochoa
	 * @param N/A
	 * @throws SQLException
	 *             si existe error de sintaxis en la sentencia SQL. Exception si
	 *             hay valores en null
	 * @return Integer (ID)
	 * @see N/A
	 */

	public Integer idGestion() throws Exception {
		Integer result = 0;
		try {
			con = ds.getConnection();
			ps = con.prepareStatement(SQL_BUSCAR_ULTIMA_GESTION, Statement.RETURN_GENERATED_KEYS);

			rs = ps.executeQuery();
			while (rs.next()) {
				int t = 1;

				result = rs.getInt(t++);
			}
		} catch (SQLException e) {
			logger.error("SQLException Error SQL al tratar de idGestion GestionDAO " + " id del registro.... "
					+ Statement.RETURN_GENERATED_KEYS + " tabla afectada.... tipificaciones "
					+ "descripción de evento..." + e);
			throw new SQLException("SQLException Error SQL al tratar de idGestion ");
		} catch (Exception e) {
			logger.error("Exception Error al tratar de idTipificacion Clase GestionDAO " + "id del registro.... "
					+ Statement.RETURN_GENERATED_KEYS + " tabla afectada.... tipificaciones "
					+ "descripción de evento..." + e);
			throw new Exception("Exception Error al tratar de idGestion ");
		} finally {
			closeConexion();
			logger.info("finalizo dao GestionDAO método idGestion!");
		}
		return result;
	}

	/**
	 * insertarGestion. método insertar la gestión del asesor. 2019-04-29
	 * 
	 * @author Camilo Ochoa
	 * @param N/A
	 * @throws SQLException
	 *             si existe error de sintaxis en la sentencia SQL. Exception si
	 *             hay valores en null
	 * @return Integer (Llave de la tabla)
	 * @see N/A
	 */

	public Integer insertarGestion(Gestion gestion) throws Exception {
		Integer llave = 0;
		StringBuilder varname1 = new StringBuilder();
		varname1.append(" INSERT INTO mibanco.gestion ");
		varname1.append(" ( ");
		varname1.append(" idtipificacion, ");// 1
		varname1.append(" nombretercero, ");// 2
		varname1.append(" telefonoagendamiento, ");// 3
		varname1.append(" documentodeudor,  ");// 4
		varname1.append(" iddeudor,  ");// 5
		varname1.append(" codigounicocliente, ");// 6
		varname1.append(" codigoobligacion, ");// 7
		varname1.append(" fechainiciollamada, ");// 8
		varname1.append(" fechafinllamada, ");// 9
		varname1.append(" telefonomarcado, ");// 10
		varname1.append(" asesor, ");// 11
		varname1.append(" valorpromesa, ");// 12
		varname1.append(" fechapromesa, ");// 13
		varname1.append(" fechaagendamiento, ");// 14
		varname1.append(" observacion, ");// 15
		varname1.append(" tipollamada, ");// 16
		varname1.append(" idcall,  ");// 17
		varname1.append(" idusuariocrea, ");// 18
		varname1.append(" fechacrea,  ");// 19
		varname1.append(" estado ");// 20
		varname1.append(" ) ");
		varname1.append(" VALUES ( ");
		varname1.append(" ?, "); // 1//idtipificacion -1
		varname1.append(" ?, "); // 2//nombretercero -2
		varname1.append(" ?, "); // 3//telefonoagendamiento -3
		varname1.append(" ?, "); // 4//documentodeudor -4
		varname1.append(" ?, "); // 5//iddeudor -5
		varname1.append(" ?, "); // 6//codigounicocliente -6
		varname1.append(" ?, "); // 7//codigoobligacion -7
		varname1.append(" ?, "); // 8//fechainiciollamada -8
		varname1.append(" ?, "); // 9//fechafinllamada -9
		varname1.append(" ?, "); // 10//telefonomarcado -10
		varname1.append(" ?, "); // 11//asesor -11
		varname1.append(" ?, "); // 12//valorpromesa -12
		varname1.append(" ?, "); // 13//fechapromesa -13
		varname1.append(" ?, "); // 14//fechaagendamiento -14
		varname1.append(" ?, "); // 15//observacion -15
		varname1.append(" ?, "); // 16//tipollamada -16
		varname1.append(" ?, "); // 17//idcall -17
		varname1.append(" ?, "); // 18//idusuariocrea -18
		varname1.append(" GETDATE() , "); // 19//fechacrea -19
		varname1.append(" ? "); // 20//estado -20
		varname1.append(" ) ");
		try {
			con = ds.getConnection();
			ps = con.prepareStatement(varname1.toString(), Statement.RETURN_GENERATED_KEYS);

			int t = 1;

			// idtipificacion// 1
			if (gestion.getIdTipificacion() != null) {
				ps.setInt(t++, gestion.getIdTipificacion());

			} else {
				ps.setNull(t++, java.sql.Types.INTEGER);
			}

			// nombretercero// 2
			if (gestion.getNombreTercero() != null) {
				ps.setString(t++, gestion.getNombreTercero());

			} else {
				ps.setNull(t++, java.sql.Types.VARCHAR);
			}

			// telefonoagendamiento//3
			if (gestion.getTelefonoAgendamiento() != null) {
				ps.setString(t++, gestion.getTelefonoAgendamiento());

			} else {
				ps.setNull(t++, java.sql.Types.VARCHAR);
			}

			// documentodeudor//4
			if (gestion.getDocumentoDeudor() != null) {
				ps.setString(t++, gestion.getDocumentoDeudor());

			} else {
				ps.setNull(t++, java.sql.Types.VARCHAR);
			}

			// iddeudor//5
			if (gestion.getIdDeudor() != null) {
				ps.setString(t++, gestion.getIdDeudor());

			} else {
				ps.setNull(t++, java.sql.Types.VARCHAR);
			}

			// codigounicocliente//6
			if (gestion.getCodigoUnicoCliente() != null) {
				ps.setString(t++, gestion.getCodigoUnicoCliente());

			} else {
				ps.setNull(t++, java.sql.Types.VARCHAR);
			}

			// codigoobligacion//7
			if (gestion.getCodigoObligacion() != null) {
				ps.setString(t++, gestion.getCodigoObligacion());

			} else {
				ps.setNull(t++, java.sql.Types.VARCHAR);
			}

			// fechainiciollamada//8
			if (gestion.getFechaIniciollamada() != null) {
				ps.setTimestamp(t++, gestion.getFechaIniciollamada());

			} else {
				ps.setNull(t++, java.sql.Types.TIMESTAMP);
			}

			// fechafinllamada//9
			if (gestion.getFechaFinllamada() != null) {
				ps.setTimestamp(t++, gestion.getFechaFinllamada());

			} else {
				ps.setNull(t++, java.sql.Types.TIMESTAMP);
			}

			// telefonomarcado//10
			if (gestion.getTelefonoMarcado() != null) {
				ps.setString(t++, gestion.getTelefonoMarcado());

			} else {
				ps.setNull(t++, java.sql.Types.VARCHAR);
			}

			// asesor//11
			if (gestion.getAsesor() != null) {
				ps.setString(t++, gestion.getAsesor());

			} else {
				ps.setNull(t++, java.sql.Types.VARCHAR);
			}

			// valorpromesa//12
			if (gestion.getValorPromesa() != null) {
				ps.setDouble(t++, gestion.getValorPromesa());

			} else {
				ps.setNull(t++, java.sql.Types.BIGINT);
			}

			// fechapromesa//13
			if (gestion.getFechaPromesa() != null) {
				ps.setTimestamp(t++, gestion.getFechaPromesa());

			} else {
				ps.setNull(t++, java.sql.Types.TIMESTAMP);
			}

			// fechaagendamiento//14
			if (gestion.getFechaAgendamiento() != null) {
				ps.setTimestamp(t++, gestion.getFechaAgendamiento());

			} else {
				ps.setNull(t++, java.sql.Types.TIMESTAMP);
			}

			// observacion//15
			if (gestion.getObservacion() != null) {
				ps.setString(t++, gestion.getObservacion());

			} else {
				ps.setNull(t++, java.sql.Types.VARCHAR);
			}

			// tipollamada//16
			if (gestion.getTipoLlamada() != null) {
				ps.setString(t++, gestion.getTipoLlamada());

			} else {
				ps.setNull(t++, java.sql.Types.VARCHAR);
			}

			// idcall//17
			if (gestion.getIdCall() != null) {
				ps.setString(t++, gestion.getIdCall());

			} else {
				ps.setNull(t++, java.sql.Types.VARCHAR);
			}

			// idusuariocrea//18
			if (gestion.getIdUsuarioCrea() != null) {
				ps.setInt(t++, gestion.getIdUsuarioCrea());

			} else {
				ps.setNull(t++, java.sql.Types.INTEGER);
			}

			// fechacrea//19

			// estado//20
			if (gestion.getEstado() != null) {
				ps.setInt(t++, gestion.getEstado());

			} else {
				ps.setNull(t++, java.sql.Types.INTEGER);
			}

			ps.executeUpdate();
			llave = Statement.RETURN_GENERATED_KEYS;

		} catch (SQLException e) {
			logger.error("SQLException Error SQL al tratar de insertarGestion GestionDAO " + " id del registro.... "
					+ Statement.RETURN_GENERATED_KEYS + " tabla afectada.... obligacion " + "descripción de evento..."
					+ e);
			throw new SQLException("SQLException Error SQL al tratar de insertarGestion ");
		} catch (Exception e) {
			logger.error("Exception Error al tratar de  insertarGestion Clase GestionDAO " + "id del registro.... "
					+ Statement.RETURN_GENERATED_KEYS + " tabla afectada.... obligacion " + "descripción de evento..."
					+ e);
			throw new Exception("Exception Error al tratar de insertarGestion ");
		} finally {
			closeConexion();
			logger.info("finalizo dao GestionDAO método insertarGestion!");
		}
		return llave;
	}

	private String SQL_ACTUALIZAR_ESTADO = " UPDATE mibanco.gestion SET estado = ?, idusuariomod = ?, fechamod = GETDATE() WHERE idgestion = ? ";

	/**
	 * actualizar estado de gestion. método actualizar esl estado de la gestion.
	 * 2019-04-29
	 * 
	 * @author Camilo Ochoa
	 * @param Integer
	 *            (Llave de la tabla)
	 * @return Integer (Llave de la tabla)
	 * @throws Exception
	 * @see N/A
	 */

	public Integer actualizarEstado(Integer idGestion, Integer idUsuarioMod) throws Exception {
		Integer llave = 0;
		try {

			con = ds.getConnection();
			ps = con.prepareStatement(SQL_ACTUALIZAR_ESTADO, Statement.RETURN_GENERATED_KEYS);

			ps.setInt(1, EstadoEnum.ACTIVO.getIndex());
			ps.setInt(2, idUsuarioMod);
			ps.setInt(3, idGestion);

			ps.executeUpdate();
			llave = Statement.RETURN_GENERATED_KEYS;

		} catch (SQLException e) {
			logger.error("SQLException Error SQL al tratar de actualizarEstado comite GestionDAO "
					+ " id del registro.... " + Statement.RETURN_GENERATED_KEYS + " tabla afectada.... GESTION "
					+ "descripción de evento..." + e);
			throw new SQLException("SQLException Error SQL al tratar de actualizarEstado ");
		} catch (Exception e) {
			logger.error("Exception Error al tratar de actualizar estado GestionDAO " + "id del registro.... "
					+ Statement.RETURN_GENERATED_KEYS + " tabla afectada.... gestion " + "descripción de evento..."
					+ e);
			throw new Exception("Exception Error al tratar de actualizarEstado gestion ");
		} finally {
			closeConexion();
			logger.info("finalizo dao GestionDAO método actualizarEstado!");
		}

		return llave;
	}

}
