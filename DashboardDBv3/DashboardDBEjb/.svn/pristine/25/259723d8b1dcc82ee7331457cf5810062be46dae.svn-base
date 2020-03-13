package co.sistemcobro.dashboarddb.dao;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.apache.log4j.Logger;

import co.sistemcobro.dashboarddb.bean.Comite;
import co.sistemcobro.dashboarddb.constante.EstadoEnum;

public class ComiteDAO extends BaseDAO {

	private static Logger logger = Logger.getLogger(ComiteDAO.class);

	public ComiteDAO(DataSource ds) {
		super(ds);
	}
	
	private String SQL_COMITES = "SELECT c.idcomite, c.idtipificacion, c.nombretercero, "
			+ " c.telefonoagendamiento, c.documentodeudor,c.iddeudor, c.codigounicocliente, "
			+ " c.codigoobligacion, c.fechainiciollamada,  c.telefonomarcado, c.asesor, c.valorpromesa, "
			+ " c.fechapromesa, c.fechaagendamiento, c.observacion, c.tipollamada, c.idcall, "
			+ "  c.tipodiscado, c.idusuariocrea, c.fechacrea, c.idusuariomod, c.fechamod, c.estado, "
			+ "  t.nombre as tipificacion FROM mibanco.comite c "
			+ " JOIN mibanco.tipificacion t on t.idtipificacion = c.idtipificacion"
			+ " WHERE c.estado = ? ORDER BY c.fechacrea DESC ";
	
	public List<Comite> comites() throws Exception {
		List<Comite> comites = new ArrayList<>();
		Comite comite = null;
		
		try {
			con = ds.getConnection();
			ps = con.prepareStatement(SQL_COMITES, Statement.RETURN_GENERATED_KEYS);
			
			
			ps.setInt(1, EstadoEnum.ACTIVO.getIndex());

			rs = ps.executeQuery();
			while (rs.next()) {
				int t = 1;
				comite = new Comite();
				
				comite.setIdComite(rs.getInt(t++)); 
				comite.setIdTipificacion(rs.getInt(t++)); 
				comite.setNombreTercero(rs.getString(t++)); 
				comite.setTelefonoAgendamiento(rs.getString(t++)); 
				comite.setDocumentoDeudor(rs.getString(t++)); 
				comite.setIdDeudor(rs.getString(t++)); 
				comite.setCodigoUnicoCliente(rs.getString(t++));
				comite.setCodigoObligacion(rs.getString(t++));
				comite.setFechaIniciollamada(rs.getTimestamp(t++));
				comite.setTelefonoMarcado(rs.getString(t++));
				comite.setAsesor(rs.getString(t++));
				comite.setValorPromesa(rs.getDouble(t++)); 
				comite.setFechaPromesa(rs.getTimestamp(t++)); 
				comite.setFechaAgendamiento(rs.getTimestamp(t++)); 
				comite.setObservacion(rs.getString(t++)); 
				comite.setTipoLlamada(rs.getString(t++)); 
				comite.setIdCall(rs.getString(t++)); 
				comite.setTipoDiscado(rs.getString(t++)); 
				comite.setIdUsuarioCrea(rs.getInt(t++)); 
				comite.setFechaCrea(rs.getTimestamp(t++)); 
				comite.setIdUsuarioMod(rs.getInt(t++)); 
				comite.setFechaMod(rs.getTimestamp(t++)); 
				comite.setEstado(rs.getInt(t++));
				comite.setTipificacion(rs.getString(t++));
				
				comites.add(comite);
			}
		} catch (SQLException e) {
			logger.error("SQLException Error SQL al tratar de consultar comites ComiteDAO "
					+ " id del registro.... " + Statement.RETURN_GENERATED_KEYS + " tabla afectada.... telefono "
					+ "descripción de evento..." + e);
			throw new SQLException("SQLException Error SQL al tratar de consultar comites ");
		} catch (Exception e) {
			logger.error("Exception Error al tratar de consultar comites ComiteDAO " + "id del registro.... "
					+ Statement.RETURN_GENERATED_KEYS + " tabla afectada.... telefono " + "descripción de evento..."
					+ e);
			throw new Exception("Exception Error al tratar de consultar comites ");
		} finally {
			closeConexion();
			logger.info("finalizo dao ComiteDAO método comites!");
		}
		return comites;
	}
	
	private String SQL_BUSCAR_ULTIMA= "SELECT TOP 1 idcomite "
			+ " FROM mibanco.comite g WHERE estado =? ORDER BY 1 DESC ";
	
	/**
	 * ID última gestión guardada. método para consultar el id de la última gestión guardada. 2019-04-29
	 * 
	 * @author Camilo Ochoa
	 * @param N/A
	 * @throws SQLException
	 *             si existe error de sintaxis en la sentencia SQL. Exception si
	 *             hay valores en null
	 * @return Integer (ID)
	 * @see N/A
	 */

	public Integer idComite() throws Exception {
		Integer result = 0;
		try {
			con = ds.getConnection();
			ps = con.prepareStatement(SQL_BUSCAR_ULTIMA, Statement.RETURN_GENERATED_KEYS);
			
			ps.setInt(1, EstadoEnum.ACTIVO.getIndex());
			
			rs = ps.executeQuery();
			while (rs.next()) {
				int t = 1;
				
				result = rs.getInt(t++);
			}
		} catch (SQLException e) {
			logger.error("SQLException Error SQL al tratar de idComite ComiteDAO "
					+ " id del registro.... " + Statement.RETURN_GENERATED_KEYS + " tabla afectada.... tipificaciones "
					+ "descripción de evento..." + e);
			throw new SQLException("SQLException Error SQL al tratar de idComite ");
		} catch (Exception e) {
			logger.error("Exception Error al tratar de idTipificacion Clase ComiteDAO " + "id del registro.... "
					+ Statement.RETURN_GENERATED_KEYS + " tabla afectada.... tipificaciones " + "descripción de evento..."
					+ e);
			throw new Exception("Exception Error al tratar de idComite ");
		} finally {
			closeConexion();
			logger.info("finalizo dao ComiteDAO método idComite!");
		}
		return result;
	}
	
	private String SQL_BUSCAR_POR_ID_COMITE = " SELECT c.idcomite, c.idtipificacion, c.nombretercero, "
			+ " c.telefonoagendamiento, c.documentodeudor, c.iddeudor, c.codigounicocliente, c.codigoobligacion,"
			+ " c.fechainiciollamada, c.telefonomarcado, c.asesor, c.valorpromesa, c.fechapromesa,"
			+ " c.fechaagendamiento, c.observacion, c.tipollamada, c.idcall, c.tipodiscado,"
			+ " c.idusuariocrea, c.fechacrea, c.idusuariomod, c.fechamod, c.estado, "
			+ " (SELECT MAX(ac.idacuerdo) FROM  mibanco.acuerdo ac WHERE ac.estado = 3 AND ac.idcomite = c.idcomite) as idacuerdo,"
			+ " (SELECT MAX(g.idgestion) FROM  mibanco.gestion g WHERE g.estado = 3 AND g.idgestion  "
			+ " = (SELECT max(ac.idgestion) FROM  mibanco.acuerdo ac WHERE ac.idcomite = c.idcomite and ac.estado = 3)) "
			+ " as idgestion  FROM mibanco.comite c  WHERE c.idcomite = ? ";
	
	/**
	 * ID última gestión guardada. método para consultar el id de la última gestión guardada. 2019-04-29
	 * 
	 * @author Camilo Ochoa
	 * @param N/A
	 * @throws SQLException
	 *             si existe error de sintaxis en la sentencia SQL. Exception si
	 *             hay valores en null
	 * @return Integer (ID)
	 * @see N/A
	 */

	public Comite consultarComitePorId(Integer idComite) throws Exception {
		Comite comite = null;
		try {
			con = ds.getConnection();
			ps = con.prepareStatement(SQL_BUSCAR_POR_ID_COMITE, Statement.RETURN_GENERATED_KEYS);
			
			ps.setInt(1, idComite);
			
			rs = ps.executeQuery();
			while (rs.next()) {				
				int t = 1;
				
				comite = new Comite();
				
				comite.setIdComite(rs.getInt(t++)); 
				comite.setIdTipificacion(rs.getInt(t++)); 
				comite.setNombreTercero(rs.getString(t++)); 
				comite.setTelefonoAgendamiento(rs.getString(t++)); 
				comite.setDocumentoDeudor(rs.getString(t++)); 
				comite.setIdDeudor(rs.getString(t++)); 
				comite.setCodigoUnicoCliente(rs.getString(t++));
				comite.setCodigoObligacion(rs.getString(t++));
				comite.setFechaIniciollamada(rs.getTimestamp(t++));
				comite.setTelefonoMarcado(rs.getString(t++));
				comite.setAsesor(rs.getString(t++));
				comite.setValorPromesa(rs.getDouble(t++)); 
				comite.setFechaPromesa(rs.getTimestamp(t++)); 
				comite.setFechaAgendamiento(rs.getTimestamp(t++)); 
				comite.setObservacion(rs.getString(t++)); 
				comite.setTipoLlamada(rs.getString(t++)); 
				comite.setIdCall(rs.getString(t++)); 
				comite.setTipoDiscado(rs.getString(t++)); 
				comite.setIdUsuarioCrea(rs.getInt(t++)); 
				comite.setFechaCrea(rs.getTimestamp(t++)); 
				comite.setIdUsuarioMod(rs.getInt(t++)); 
				comite.setFechaMod(rs.getTimestamp(t++)); 
				comite.setEstado(rs.getInt(t++));
				comite.setIdAcuerdo(rs.getInt(t++));
				comite.setIdGestion(rs.getInt(t++));
				
			}
		} catch (SQLException e) {
			logger.error("SQLException Error SQL al tratar de idComite ComiteDAO "
					+ " id del registro.... " + Statement.RETURN_GENERATED_KEYS + " tabla afectada.... tipificaciones "
					+ "descripción de evento..." + e);
			throw new SQLException("SQLException Error SQL al tratar de idComite ");
		} catch (Exception e) {
			logger.error("Exception Error al tratar de idTipificacion Clase ComiteDAO " + "id del registro.... "
					+ Statement.RETURN_GENERATED_KEYS + " tabla afectada.... tipificaciones " + "descripción de evento..."
					+ e);
			throw new Exception("Exception Error al tratar de idComite ");
		} finally {
			closeConexion();
			logger.info("finalizo dao ComiteDAO método consultarComitePorId!");
		}
		return comite;
	}
	
	/**
	 * insertarComite. método insertar la gestión del asesor. 2019-04-29
	 * 
	 * @author Camilo Ochoa
	 * @param N/A
	 * @throws SQLException
	 *             si existe error de sintaxis en la sentencia SQL. Exception si
	 *             hay valores en null
	 * @return Integer (Llave de la tabla)
	 * @see N/A
	 */
	
	public Integer insertarComite(Comite comite) throws Exception {
		Integer llave = 0;
		StringBuilder varname1 = new StringBuilder();
		varname1.append(" INSERT INTO mibanco.comite ");
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
		varname1.append(" estado ");// 19
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
		varname1.append(" ? "); // 19//estado -19
		varname1.append(" ) ");
		try {
			con = ds.getConnection();
			ps = con.prepareStatement(varname1.toString(), Statement.RETURN_GENERATED_KEYS);

			int t = 1;

			// idcomite// 1
			if (comite.getIdTipificacion() != null) {
				ps.setInt(t++, comite.getIdTipificacion());

			} else {
				ps.setNull(t++, java.sql.Types.INTEGER);
			}

			// nombretercero// 2
			if (comite.getNombreTercero() != null) {
				ps.setString(t++, comite.getNombreTercero());

			} else {
				ps.setNull(t++, java.sql.Types.VARCHAR);
			}

			// telefonoagendamiento//3
			if (comite.getTelefonoAgendamiento() != null) {
				ps.setString(t++, comite.getTelefonoAgendamiento());

			} else {
				ps.setNull(t++, java.sql.Types.VARCHAR);
			}

			// documentodeudor//4
			if (comite.getDocumentoDeudor() != null) {
				ps.setString(t++, comite.getDocumentoDeudor());

			} else {
				ps.setNull(t++, java.sql.Types.VARCHAR);
			}

			// iddeudor//5
			if (comite.getIdDeudor() != null) {
				ps.setString(t++, comite.getIdDeudor());

			} else {
				ps.setNull(t++, java.sql.Types.VARCHAR);
			}

			// codigounicocliente//6
			if (comite.getCodigoUnicoCliente() != null) {
				ps.setString(t++, comite.getCodigoUnicoCliente());

			} else {
				ps.setNull(t++, java.sql.Types.VARCHAR);
			}

			// codigoobligacion//7
			if (comite.getCodigoObligacion() != null) {
				ps.setString(t++, comite.getCodigoObligacion());

			} else {
				ps.setNull(t++, java.sql.Types.VARCHAR);
			}

			// fechainiciollamada//8
			if (comite.getFechaIniciollamada() != null) {
				ps.setTimestamp(t++, comite.getFechaIniciollamada());

			} else {
				ps.setNull(t++, java.sql.Types.TIMESTAMP);
			}

			// telefonomarcado//9
			if (comite.getTelefonoMarcado() != null) {
				ps.setString(t++, comite.getTelefonoMarcado());

			} else {
				ps.setNull(t++, java.sql.Types.VARCHAR);
			}

			// asesor//10
			if (comite.getAsesor() != null) {
				ps.setString(t++, comite.getAsesor());

			} else {
				ps.setNull(t++, java.sql.Types.VARCHAR);
			}

			// valorpromesa//11
			if (comite.getValorPromesa() != null) {
				ps.setDouble(t++, comite.getValorPromesa());

			} else {
				ps.setNull(t++, java.sql.Types.BIGINT);
			}

			// fechapromesa//12
			if (comite.getFechaPromesa() != null) {
				ps.setTimestamp(t++, comite.getFechaPromesa());

			} else {
				ps.setNull(t++, java.sql.Types.TIMESTAMP);
			}

			// fechaagendamiento//13
			if (comite.getFechaAgendamiento() != null) {
				ps.setTimestamp(t++, comite.getFechaAgendamiento());

			} else {
				ps.setNull(t++, java.sql.Types.TIMESTAMP);
			}

			// observacion//14
			if (comite.getObservacion() != null) {
				ps.setString(t++, comite.getObservacion());

			} else {
				ps.setNull(t++, java.sql.Types.VARCHAR);
			}

			// tipollamada//15
			if (comite.getTipoLlamada() != null) {
				ps.setString(t++, comite.getTipoLlamada());

			} else {
				ps.setNull(t++, java.sql.Types.VARCHAR);
			}

			// idcall//16
			if (comite.getIdCall() != null) {
				ps.setString(t++, comite.getIdCall());

			} else {
				ps.setNull(t++, java.sql.Types.VARCHAR);
			}

			// idusuariocrea//17
			if (comite.getIdUsuarioCrea() != null) {
				ps.setInt(t++, comite.getIdUsuarioCrea());

			} else {
				ps.setNull(t++, java.sql.Types.INTEGER);
			}

			// fechacrea//18

			// estado//19
			if (comite.getEstado() != null) {
				ps.setInt(t++, comite.getEstado());

			} else {
				ps.setNull(t++, java.sql.Types.INTEGER);
			}

			ps.executeUpdate();
			llave = Statement.RETURN_GENERATED_KEYS;

		} catch (SQLException e) {
			logger.error("SQLException Error SQL al tratar de insertarComite ComiteDAO " + " id del registro.... "
					+ Statement.RETURN_GENERATED_KEYS + " tabla afectada.... obligacion " + "descripción de evento..."
					+ e);
			throw new SQLException("SQLException Error SQL al tratar de insertarComite ");
		} catch (Exception e) {
			logger.error("Exception Error al tratar de  insertarComite Clase ComiteDAO " + "id del registro.... "
					+ Statement.RETURN_GENERATED_KEYS + " tabla afectada.... obligacion " + "descripción de evento..."
					+ e);
			throw new Exception("Exception Error al tratar de insertarComite ");
		} finally {
			closeConexion();
			logger.info("finalizo dao ComiteDAO método insertarComite!");
		}
		return llave;
	}
	
	private String SQL_ACTUALIZAR_ESTADO_COMITE = " UPDATE mibanco.comite SET estado = ?, idusuariomod = ?, fechamod = GETDATE() WHERE idComite = ? ";
	
	/**
	 * actualizar estado de comite. método actualizar esl estado del comite cuando se quiere volver a gestionar. 2019-04-29
	 * 
	 * @author Camilo Ochoa
	 * @param Integer (Llave de la tabla)
	 * @return Integer (Llave de la tabla)
	 * @throws Exception 
	 * @see N/A
	 */
	
	public Integer actualizarEstadoComite(Integer idComite, Integer idUsuarioMod) throws Exception{
		Integer llave = 0;		
		try {
			
			con = ds.getConnection();
			ps = con.prepareStatement(SQL_ACTUALIZAR_ESTADO_COMITE, Statement.RETURN_GENERATED_KEYS);

			ps.setInt(1, EstadoEnum.ELIMINADO.getIndex());
			ps.setInt(2, idUsuarioMod);			
			ps.setInt(3, idComite);
			
			ps.executeUpdate();
			llave = Statement.RETURN_GENERATED_KEYS;
			
		} catch (SQLException e) {
			logger.error("SQLException Error SQL al tratar de actualizarEstadoComite comite ComiteDAO "
					+ " id del registro.... " + Statement.RETURN_GENERATED_KEYS + " tabla afectada.... comite "
					+ "descripción de evento..." + e);
			throw new SQLException("SQLException Error SQL al tratar de actualizarEstadoComite  ");
		} catch (Exception e) {
			logger.error("Exception Error al tratar de consultar comite ComiteDAO " + "id del registro.... "
					+ Statement.RETURN_GENERATED_KEYS + " tabla afectada.... comite " + "descripción de evento..."
					+ e);
			throw new Exception("Exception Error al tratar de actualizarEstadoComite comite ");
		} finally {
			closeConexion();
			logger.info("finalizo dao ComiteDAO método actualizarEstadoComite!");
		}
		
		return llave;
	}

}
