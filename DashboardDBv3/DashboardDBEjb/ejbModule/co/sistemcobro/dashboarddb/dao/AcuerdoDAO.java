package co.sistemcobro.dashboarddb.dao;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.apache.log4j.Logger;

import co.sistemcobro.dashboarddb.bean.Acuerdo;
import co.sistemcobro.dashboarddb.constante.EstadoEnum;

public class AcuerdoDAO extends BaseDAO {

	private static Logger logger = Logger.getLogger(AcuerdoDAO.class);

	public AcuerdoDAO(DataSource ds) {
		super(ds);
	}

	private String SQL_BUSCAR_ULTIMA_acuerdo = "SELECT TOP 1 idacuerdo "
			+ " FROM mibanco.acuerdo ORDER BY 1 DESC ";

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

	public Integer idAcuerdo() throws Exception {
		Integer result = 0;
		try {
			con = ds.getConnection();
			ps = con.prepareStatement(SQL_BUSCAR_ULTIMA_acuerdo, Statement.RETURN_GENERATED_KEYS);

			rs = ps.executeQuery();
			while (rs.next()) {
				int t = 1;

				result = rs.getInt(t++);
			}
		} catch (SQLException e) {
			logger.error("SQLException Error SQL al tratar de idacuerdo acuerdoDAO " + " id del registro.... "
					+ Statement.RETURN_GENERATED_KEYS + " tabla afectada.... tipificaciones "
					+ "descripción de evento..." + e);
			throw new SQLException("SQLException Error SQL al tratar de idacuerdo ");
		} catch (Exception e) {
			logger.error("Exception Error al tratar de idTipificacion Clase acuerdoDAO " + "id del registro.... "
					+ Statement.RETURN_GENERATED_KEYS + " tabla afectada.... tipificaciones "
					+ "descripción de evento..." + e);
			throw new Exception("Exception Error al tratar de idacuerdo ");
		} finally {
			closeConexion();
			logger.info("finalizo dao acuerdoDAO método idacuerdo!");
		}
		return result;
	}
	
	private String SQL_BUSCAR_CUOTAS_ACUERDOS = "SELECT a.idacuerdo, a.idtipificacion, "
			+ " a.nombretercero, a.telefonoagendamiento, a.documentodeudor, a.iddeudor, "
			+ " a.codigounicocliente, a.codigoobligacion, a.fechainiciollamada,"
			+ " a.telefonomarcado, a.asesor, a.valorpromesa, a.fechapromesa,"
			+ " a.fechaagendamiento, a.observacion, a.tipollamada, a.idcall, a.tipodiscado, "
			+ " a.idusuariocrea, a.fechacrea, a.idusuariomod,  a.fechamod, a.estado, a.idgestion, a.idcomite, "
			+ " ac.idacuerdocuota, ac.idacuerdo, ac.valortotal, ac.cantidadcuotas, ac.valoracuerdo, "
			+ " ac.fechaacuerdo,  ac.idusuariocrea, ac.fechacrea, ac.idusuariomod, ac.fechamod, ac.estado "
			+ " FROM mibanco.acuerdo a "
			+ " JOIN mibanco.acuerdo_cuota ac on ac.idacuerdo = a.idacuerdo  "
			+ " where a.idgestion = ? ";

	/**
	 * consulta cuotas por gestion. método para consultar las cuotas del acuerdo 2019-04-29
	 * 
	 * @author Camilo Ochoa
	 * @param idGestion
	 * @throws SQLException
	 *             si existe error de sintaxis en la sentencia SQL. Exception si
	 *             hay valores en null
	 * @return List<Acuerdo> lista de cuotas por acuerdo
	 * @see N/A
	 */

	public List<Acuerdo> cuotasAcuerdosPorGestion(Integer idGestion) throws Exception {
		List<Acuerdo> cuotasAcuerdos = new ArrayList<>();
		Acuerdo acuerdo = null;
		try {
			con = ds.getConnection();
			ps = con.prepareStatement(SQL_BUSCAR_CUOTAS_ACUERDOS, Statement.RETURN_GENERATED_KEYS);

			ps.setInt(1, idGestion);

			rs = ps.executeQuery();
			while (rs.next()) {
				int t = 1;
				
				acuerdo = new Acuerdo();
				
				acuerdo.setIdAcuerdo(rs.getInt(t++)); 
				acuerdo.setIdTipificacion(rs.getInt(t++)); 
				acuerdo.setNombreTercero(rs.getString(t++)); 
				acuerdo.setTelefonoAgendamiento(rs.getString(t++)); 
				acuerdo.setDocumentoDeudor(rs.getString(t++)); 
				acuerdo.setIdDeudor(rs.getString(t++)); 
				acuerdo.setCodigoUnicoCliente(rs.getString(t++));
				acuerdo.setCodigoObligacion(rs.getString(t++));
				acuerdo.setFechaIniciollamada(rs.getTimestamp(t++));
				acuerdo.setTelefonoMarcado(rs.getString(t++));
				acuerdo.setAsesor(rs.getString(t++));
				acuerdo.setValorPromesa(rs.getDouble(t++)); 
				acuerdo.setFechaPromesa(rs.getTimestamp(t++)); 
				acuerdo.setFechaAgendamiento(rs.getTimestamp(t++)); 
				acuerdo.setObservacion(rs.getString(t++)); 
				acuerdo.setTipoLlamada(rs.getString(t++)); 
				acuerdo.setIdCall(rs.getString(t++)); 
				acuerdo.setTipoDiscado(rs.getString(t++)); 
				acuerdo.setIdUsuarioCrea(rs.getInt(t++)); 
				acuerdo.setFechaCrea(rs.getTimestamp(t++)); 
				acuerdo.setIdUsuarioMod(rs.getInt(t++)); 
				acuerdo.setFechaMod(rs.getTimestamp(t++)); 
				acuerdo.setEstado(rs.getInt(t++));
				acuerdo.setIdGestion(rs.getInt(t++));
				acuerdo.setIdComite(rs.getInt(t++));
				
				acuerdo.getAcuerdoCuota().setIdAcuerdoCuota(rs.getInt(t++)); 
				acuerdo.getAcuerdoCuota().setIdAcuerdo(rs.getInt(t++));
				acuerdo.getAcuerdoCuota().setValorTotalDeuda(rs.getDouble(t++)); 
				acuerdo.getAcuerdoCuota().setNumeroCuota(rs.getInt(t++)); 
				acuerdo.getAcuerdoCuota().setValorAcuerdo(rs.getDouble(t++)); 
				acuerdo.getAcuerdoCuota().setFechaAcuerdo(rs.getTimestamp(t++)); 
				acuerdo.getAcuerdoCuota().setIdUsuarioCrea(rs.getInt(t++)); 
				acuerdo.getAcuerdoCuota().setFechaCrea(rs.getTimestamp(t++)); 
				acuerdo.getAcuerdoCuota().setIdUsuarioMod(rs.getInt(t++)); 
				acuerdo.getAcuerdoCuota().setFechaMod(rs.getTimestamp(t++)); 
				acuerdo.getAcuerdoCuota().setEstado(rs.getInt(t++));
				
				cuotasAcuerdos.add(acuerdo);
			}
		} catch (SQLException e) {
			logger.error("SQLException Error SQL al tratar de cuotas acuerdo acuerdoDAO " + " id del registro.... "
					+ Statement.RETURN_GENERATED_KEYS + " tabla afectada.... cuotas acuerdo "
					+ "descripción de evento..." + e);
			throw new SQLException("SQLException Error SQL al tratar de cuotas acuerdo ");
		} catch (Exception e) {
			logger.error("Exception Error al tratar de cuotas acuerdo Clase acuerdoDAO " + "id del registro.... "
					+ Statement.RETURN_GENERATED_KEYS + " tabla afectada.... cuotas acuerdo "
					+ "descripción de evento..." + e);
			throw new Exception("Exception Error al tratar de cuotas acuerdo ");
		} finally {
			closeConexion();
			logger.info("finalizo dao acuerdoDAO método cuotasAcuerdosPorGestion!");
		}
		return cuotasAcuerdos;
	}
	
	

	/**
	 * insertaracuerdo. método insertar la gestión del asesor. 2019-04-29
	 * 
	 * @author Camilo Ochoa
	 * @param N/A
	 * @throws SQLException
	 *             si existe error de sintaxis en la sentencia SQL. Exception si
	 *             hay valores en null
	 * @return Integer (Llave de la tabla)
	 * @see N/A
	 */

	public Integer insertarAcuerdo(Acuerdo acuerdo) throws Exception {
		Integer llave = 0;
		StringBuilder varname1 = new StringBuilder();
		varname1.append(" INSERT INTO mibanco.acuerdo ");
		varname1.append(" ( ");
		varname1.append(" idtipificacion, ");// 1
		varname1.append(" nombretercero, ");// 2
		varname1.append(" telefonoagendamiento, ");// 3
		varname1.append(" documentodeudor,  ");// 4
		varname1.append(" iddeudor,  ");// 5
		varname1.append(" codigounicocliente, ");// 6
		varname1.append(" codigoobligacion, ");// 7
		varname1.append(" fechainiciollamada, ");// 8
		varname1.append(" telefonomarcado, ");// 9
		varname1.append(" asesor, ");// 10
		varname1.append(" valorpromesa, ");// 11
		varname1.append(" fechapromesa, ");// 12
		varname1.append(" fechaagendamiento, ");// 13
		varname1.append(" observacion, ");// 14
		varname1.append(" tipollamada, ");// 15
		varname1.append(" idcall,  ");// 16
		varname1.append(" idusuariocrea, ");// 17
		varname1.append(" fechacrea,  ");// 18
		varname1.append(" estado, ");// 19
		varname1.append(" idgestion, ");// 20
		varname1.append(" idcomite ");// 21
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
		varname1.append(" ?, "); // 9//telefonomarcado -9
		varname1.append(" ?, "); // 10//asesor -10
		varname1.append(" ?, "); // 11//valorpromesa -11
		varname1.append(" ?, "); // 12//fechapromesa -12
		varname1.append(" ?, "); // 13//fechaagendamiento -13
		varname1.append(" ?, "); // 14//observacion -14
		varname1.append(" ?, "); // 15//tipollamada -15
		varname1.append(" ?, "); // 16//idcall -16
		varname1.append(" ?, "); // 17//idusuariocrea -17
		varname1.append(" GETDATE() , "); // 18//fechacrea -18
		varname1.append(" ?, "); // 19//estado -19
		varname1.append(" ?, "); // 20//idgestion -20
		varname1.append(" ? "); // 21//idcomite -21
		varname1.append(" ) ");
		try {
			con = ds.getConnection();
			ps = con.prepareStatement(varname1.toString(), Statement.RETURN_GENERATED_KEYS);

			int t = 1;

			// idacuerdo// 1
			if (acuerdo.getIdTipificacion() != null) {
				ps.setInt(t++, acuerdo.getIdTipificacion());

			} else {
				ps.setNull(t++, java.sql.Types.INTEGER);
			}

			// nombretercero// 2
			if (acuerdo.getNombreTercero() != null) {
				ps.setString(t++, acuerdo.getNombreTercero());

			} else {
				ps.setNull(t++, java.sql.Types.VARCHAR);
			}

			// telefonoagendamiento//3
			if (acuerdo.getTelefonoAgendamiento() != null) {
				ps.setString(t++, acuerdo.getTelefonoAgendamiento());

			} else {
				ps.setNull(t++, java.sql.Types.VARCHAR);
			}

			// documentodeudor//4
			if (acuerdo.getDocumentoDeudor() != null) {
				ps.setString(t++, acuerdo.getDocumentoDeudor());

			} else {
				ps.setNull(t++, java.sql.Types.VARCHAR);
			}

			// iddeudor//5
			if (acuerdo.getIdDeudor() != null) {
				ps.setString(t++, acuerdo.getIdDeudor());

			} else {
				ps.setNull(t++, java.sql.Types.VARCHAR);
			}

			// codigounicocliente//6
			if (acuerdo.getCodigoUnicoCliente() != null) {
				ps.setString(t++, acuerdo.getCodigoUnicoCliente());

			} else {
				ps.setNull(t++, java.sql.Types.VARCHAR);
			}

			// codigoobligacion//7
			if (acuerdo.getCodigoObligacion() != null) {
				ps.setString(t++, acuerdo.getCodigoObligacion());

			} else {
				ps.setNull(t++, java.sql.Types.VARCHAR);
			}

			// fechainiciollamada//8
			if (acuerdo.getFechaIniciollamada() != null) {
				ps.setTimestamp(t++, acuerdo.getFechaIniciollamada());

			} else {
				ps.setNull(t++, java.sql.Types.TIMESTAMP);
			}

			// telefonomarcado//9
			if (acuerdo.getTelefonoMarcado() != null) {
				ps.setString(t++, acuerdo.getTelefonoMarcado());

			} else {
				ps.setNull(t++, java.sql.Types.VARCHAR);
			}

			// asesor//10
			if (acuerdo.getAsesor() != null) {
				ps.setString(t++, acuerdo.getAsesor());

			} else {
				ps.setNull(t++, java.sql.Types.VARCHAR);
			}

			// valorpromesa//11
			if (acuerdo.getValorPromesa() != null) {
				ps.setDouble(t++, acuerdo.getValorPromesa());

			} else {
				ps.setNull(t++, java.sql.Types.BIGINT);
			}

			// fechapromesa//12
			if (acuerdo.getFechaPromesa() != null) {
				ps.setTimestamp(t++, acuerdo.getFechaPromesa());

			} else {
				ps.setNull(t++, java.sql.Types.TIMESTAMP);
			}

			// fechaagendamiento//13
			if (acuerdo.getFechaAgendamiento() != null) {
				ps.setTimestamp(t++, acuerdo.getFechaAgendamiento());

			} else {
				ps.setNull(t++, java.sql.Types.TIMESTAMP);
			}

			// observacion//14
			if (acuerdo.getObservacion() != null) {
				ps.setString(t++, acuerdo.getObservacion());

			} else {
				ps.setNull(t++, java.sql.Types.VARCHAR);
			}

			// tipollamada//15
			if (acuerdo.getTipoLlamada() != null) {
				ps.setString(t++, acuerdo.getTipoLlamada());

			} else {
				ps.setNull(t++, java.sql.Types.VARCHAR);
			}

			// idcall//16
			if (acuerdo.getIdCall() != null) {
				ps.setString(t++, acuerdo.getIdCall());

			} else {
				ps.setNull(t++, java.sql.Types.VARCHAR);
			}

			// idusuariocrea//17
			if (acuerdo.getIdUsuarioCrea() != null) {
				ps.setInt(t++, acuerdo.getIdUsuarioCrea());

			} else {
				ps.setNull(t++, java.sql.Types.INTEGER);
			}

			// fechacrea//18

			// estado//19
			if (acuerdo.getEstado() != null) {
				ps.setInt(t++, acuerdo.getEstado());

			} else {
				ps.setNull(t++, java.sql.Types.INTEGER);
			}

			// idgestion //20
			if (acuerdo.getIdGestion() != null) {
				ps.setInt(t++, acuerdo.getIdGestion());

			} else {
				ps.setNull(t++, java.sql.Types.INTEGER);
			}

			// idcomite	 //21
			if (acuerdo.getIdComite() != null) {
				ps.setInt(t++, acuerdo.getIdComite());

			} else {
				ps.setNull(t++, java.sql.Types.INTEGER);
			}

			ps.executeUpdate();
			llave = Statement.RETURN_GENERATED_KEYS;

		} catch (SQLException e) {
			logger.error("SQLException Error SQL al tratar de insertaracuerdo acuerdoDAO " + " id del registro.... "
					+ Statement.RETURN_GENERATED_KEYS + " tabla afectada.... obligacion " + "descripción de evento..."
					+ e);
			throw new SQLException("SQLException Error SQL al tratar de insertaracuerdo ");
		} catch (Exception e) {
			logger.error("Exception Error al tratar de  insertaracuerdo Clase acuerdoDAO " + "id del registro.... "
					+ Statement.RETURN_GENERATED_KEYS + " tabla afectada.... obligacion " + "descripción de evento..."
					+ e);
			throw new Exception("Exception Error al tratar de insertaracuerdo ");
		} finally {
			closeConexion();
			logger.info("finalizo dao AcuerdoDAO método insertaracuerdo!");
		}
		return llave;
	}
	
	private String SQL_ACTUALIZAR_ESTADO = " UPDATE mibanco.acuerdo SET estado = ?, idusuariomod = ?, fechamod = GETDATE() WHERE idacuerdo = ? ";

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

	public Integer actualizarEstado(Integer idAcuerdo, Integer idUsuarioMod) throws Exception {
		Integer llave = 0;
		try {

			con = ds.getConnection();
			ps = con.prepareStatement(SQL_ACTUALIZAR_ESTADO, Statement.RETURN_GENERATED_KEYS);

			ps.setInt(1, EstadoEnum.ACTIVO.getIndex());
			ps.setInt(2, idUsuarioMod);
			ps.setInt(3, idAcuerdo);

			ps.executeUpdate();
			llave = Statement.RETURN_GENERATED_KEYS;

		} catch (SQLException e) {
			logger.error("SQLException Error SQL al tratar de actualizarEstado acuerdo AcuerdoDAO "
					+ " id del registro.... " + Statement.RETURN_GENERATED_KEYS + " tabla afectada.... GESTION "
					+ "descripción de evento..." + e);
			throw new SQLException("SQLException Error SQL al tratar de actualizarEstado ");
		} catch (Exception e) {
			logger.error("Exception Error al tratar de actualizar estado AcuerdoDAO " + "id del registro.... "
					+ Statement.RETURN_GENERATED_KEYS + " tabla afectada.... acuerdo " + "descripción de evento..."
					+ e);
			throw new Exception("Exception Error al tratar de actualizarEstado acuerdo ");
		} finally {
			closeConexion();
			logger.info("finalizo dao AcuerdoDAO método actualizarEstado!");
		}

		return llave;
	}

}
