package co.sistemcobro.dashboarddb.dao;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.apache.log4j.Logger;

import co.sistemcobro.dashboarddb.bean.Agenda;
import co.sistemcobro.dashboarddb.constante.EstadoEnum;

public class AgendaDAO extends BaseDAO {

	private static Logger logger = Logger.getLogger(AgendaDAO.class);

	public AgendaDAO(DataSource ds) {
		super(ds);
	}

	private String SQL_BUSCAR_ULTIMA_AGENDA = "SELECT TOP 1 idagenda "
			+ " FROM mibanco.agenda g WHERE estado =? ORDER BY 1 DESC ";

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

	public Integer idAgenda() throws Exception {
		Integer result = 0;
		try {
			con = ds.getConnection();
			ps = con.prepareStatement(SQL_BUSCAR_ULTIMA_AGENDA, Statement.RETURN_GENERATED_KEYS);

			ps.setInt(1, EstadoEnum.ACTIVO.getIndex());

			rs = ps.executeQuery();
			while (rs.next()) {
				int t = 1;

				result = rs.getInt(t++);
			}
		} catch (SQLException e) {
			logger.error("SQLException Error SQL al tratar de idagenda agendaDAO " + " id del registro.... "
					+ Statement.RETURN_GENERATED_KEYS + " tabla afectada.... tipificaciones "
					+ "descripción de evento..." + e);
			throw new SQLException("SQLException Error SQL al tratar de idagenda ");
		} catch (Exception e) {
			logger.error("Exception Error al tratar de idTipificacion Clase agendaDAO " + "id del registro.... "
					+ Statement.RETURN_GENERATED_KEYS + " tabla afectada.... tipificaciones "
					+ "descripción de evento..." + e);
			throw new Exception("Exception Error al tratar de idagenda ");
		} finally {
			closeConexion();
			logger.info("finalizo dao agendaDAO método idagenda!");
		}
		return result;
	}

	/**
	 * insertaragenda. método insertar la gestión del asesor. 2019-04-29
	 * 
	 * @author Camilo Ochoa
	 * @param N/A
	 * @throws SQLException
	 *             si existe error de sintaxis en la sentencia SQL. Exception si
	 *             hay valores en null
	 * @return Integer (Llave de la tabla)
	 * @see N/A
	 */

	public Integer insertarAgenda(Agenda agenda) throws Exception {
		Integer llave = 0;
		StringBuilder varname1 = new StringBuilder();
		varname1.append(" INSERT INTO mibanco.agenda ");
		varname1.append(" ( ");
		varname1.append(" telefonoagendamiento, ");// 1
		varname1.append(" documentodeudor, ");// 2
		varname1.append(" iddeudor, ");// 3
		varname1.append(" codigounicocliente, ");// 4
		varname1.append(" codigoobligacion, ");// 5
		varname1.append(" fechainiciollamada,  ");// 6
		varname1.append(" telefonomarcado, ");// 7
		varname1.append(" asesor,  ");// 8
		varname1.append(" fechaagendamiento, ");// 9
		varname1.append(" observacion, ");// 10
		varname1.append(" tipollamada, ");// 11
		varname1.append(" idcall, ");// 12
		varname1.append(" tipodiscado, ");// 13
		varname1.append(" idusuariocrea, ");// 14
		varname1.append(" fechacrea, ");// 15
		varname1.append(" estado, ");// 16
		varname1.append(" idgestion ");// 17
		varname1.append(" ) ");
		varname1.append(" VALUES ( ");
		varname1.append(" ?, "); // 1
		varname1.append(" ?, "); // 2
		varname1.append(" ?, "); // 3
		varname1.append(" ?, "); // 4
		varname1.append(" ?, "); // 5
		varname1.append(" ?, "); // 6
		varname1.append(" ?, "); // 7
		varname1.append(" ?, "); // 8
		varname1.append(" ?, "); // 9
		varname1.append(" ?, "); // 10
		varname1.append(" ?, "); // 11
		varname1.append(" ?, "); // 12
		varname1.append(" ?, "); // 13
		varname1.append(" ?, ");// 14
		varname1.append(" GETDATE() , ");// 15
		varname1.append(" ?, "); // 16
		varname1.append(" ? "); // 17
		varname1.append(" ) ");
		try {
			con = ds.getConnection();
			ps = con.prepareStatement(varname1.toString(), Statement.RETURN_GENERATED_KEYS);

			int t = 1;

			// telefonoagendamiento//1
			if (agenda.getTelefonoAgendamiento() != null) {
				ps.setString(t++, agenda.getTelefonoAgendamiento());

			} else {
				ps.setNull(t++, java.sql.Types.VARCHAR);
			}

			// documentodeudor//2
			if (agenda.getDocumentoDeudor() != null) {
				ps.setString(t++, agenda.getDocumentoDeudor());

			} else {
				ps.setNull(t++, java.sql.Types.VARCHAR);
			}

			// iddeudor//3
			if (agenda.getIdDeudor() != null) {
				ps.setString(t++, agenda.getIdDeudor());

			} else {
				ps.setNull(t++, java.sql.Types.VARCHAR);
			}

			// codigounicocliente//4
			if (agenda.getCodigoUnicoCliente() != null) {
				ps.setString(t++, agenda.getCodigoUnicoCliente());

			} else {
				ps.setNull(t++, java.sql.Types.VARCHAR);
			}

			// codigoobligacion//5
			if (agenda.getCodigoObligacion() != null) {
				ps.setString(t++, agenda.getCodigoObligacion());

			} else {
				ps.setNull(t++, java.sql.Types.VARCHAR);
			}

			// fechainiciollamada//6
			if (agenda.getFechaIniciollamada() != null) {
				ps.setTimestamp(t++, agenda.getFechaIniciollamada());

			} else {
				ps.setNull(t++, java.sql.Types.TIMESTAMP);
			}

			// telefonomarcado//7
			if (agenda.getTelefonoMarcado() != null) {
				ps.setString(t++, agenda.getTelefonoMarcado());

			} else {
				ps.setNull(t++, java.sql.Types.VARCHAR);
			}

			// asesor//8
			if (agenda.getAsesor() != null) {
				ps.setString(t++, agenda.getAsesor());

			} else {
				ps.setNull(t++, java.sql.Types.VARCHAR);
			}

			// fechaagendamiento//9
			if (agenda.getFechaAgendamiento() != null) {
				ps.setTimestamp(t++, agenda.getFechaAgendamiento());

			} else {
				ps.setNull(t++, java.sql.Types.TIMESTAMP);
			}

			// observacion//10
			if (agenda.getObservacion() != null) {
				ps.setString(t++, agenda.getObservacion());

			} else {
				ps.setNull(t++, java.sql.Types.VARCHAR);
			}

			// tipollamada//11
			if (agenda.getTipoLlamada() != null) {
				ps.setString(t++, agenda.getTipoLlamada());

			} else {
				ps.setNull(t++, java.sql.Types.VARCHAR);
			}

			// idcall//12
			if (agenda.getIdCall() != null) {
				ps.setString(t++, agenda.getIdCall());

			} else {
				ps.setNull(t++, java.sql.Types.VARCHAR);
			}

			// tipo discado//13
			if (agenda.getTipoDiscado() != null) {
				ps.setString(t++, agenda.getTipoDiscado());

			} else {
				ps.setNull(t++, java.sql.Types.VARCHAR);
			}

			// idusuariocrea//14
			if (agenda.getIdUsuarioCrea() != null) {
				ps.setInt(t++, agenda.getIdUsuarioCrea());

			} else {
				ps.setNull(t++, java.sql.Types.INTEGER);
			}

			// fechacrea//15

			// estado//16
			if (agenda.getEstado() != null) {
				ps.setInt(t++, agenda.getEstado());

			} else {
				ps.setNull(t++, java.sql.Types.INTEGER);
			}

			// estado//17
			if (agenda.getIdGestion() != null) {
				ps.setInt(t++, agenda.getIdGestion());

			} else {
				ps.setNull(t++, java.sql.Types.INTEGER);
			}

			ps.executeUpdate();
			llave = Statement.RETURN_GENERATED_KEYS;

		} catch (SQLException e) {
			logger.error("SQLException Error SQL al tratar de insertaragenda agendaDAO " + " id del registro.... "
					+ Statement.RETURN_GENERATED_KEYS + " tabla afectada.... obligacion " + "descripción de evento..."
					+ e);
			throw new SQLException("SQLException Error SQL al tratar de insertaragenda ");
		} catch (Exception e) {
			logger.error("Exception Error al tratar de  insertaragenda Clase agendaDAO " + "id del registro.... "
					+ Statement.RETURN_GENERATED_KEYS + " tabla afectada.... obligacion " + "descripción de evento..."
					+ e);
			throw new Exception("Exception Error al tratar de insertaragenda ");
		} finally {
			closeConexion();
			logger.info("finalizo dao AgendaDAO método insertaragenda!");
		}
		return llave;
	}

	String consultarAgenda = "" + "SELECT  [idagenda], [telefonoagendamiento] " + "      ,[documentodeudor] "
			+ "      ,[telefonomarcado] " + "      ,[asesor] " + "      ,[fechaagendamiento] " + "      ,[observacion] "
			+ "  FROM [mibanco].[agenda] WHERE estado = ?  " + " ORDER BY fechaagendamiento DESC ";

	public List<Agenda> agendasPorDocumento() throws Exception {

		List<Agenda> agendas = new ArrayList<>();
		Agenda agenda = null;

		try {
			con = ds.getConnection();
			ps = con.prepareStatement(consultarAgenda.toString());
			
			ps.setInt(1, EstadoEnum.ACTIVO.getIndex());

			rs = ps.executeQuery();

			while (rs.next()) {
				int t = 1;
				agenda = new Agenda();
				
				agenda.setIdAgenda(rs.getInt(t++));
				agenda.setTelefonoAgendamiento(rs.getString(t++));
				agenda.setDocumentoDeudor(rs.getString(t++));
				agenda.setTelefonoMarcado(rs.getString(t++));
				agenda.setAsesor(rs.getString(t++));
				agenda.setFechaAgendamiento(rs.getTimestamp(t++));
				agenda.setObservacion(rs.getString(t++));

				agendas.add(agenda);
			}

		} catch (SQLException e) {
			logger.error(e.getMessage());
			throw new Exception(e.getMessage());
		} catch (Exception e) {
			logger.error(e.getMessage());
			throw new Exception(e.getMessage());
		} finally {
			closeConexion();
		}

		return agendas;
	}
	
	private String SQL_ACTUALIZAR_ESTADO_AGENDA = " UPDATE mibanco.agenda SET estado = ?, idusuariomod = ?, fechamod =  GETDATE() WHERE idAgenda = ? ";
	
	/**
	 * actualizar estado de agenda. método actualizar esl estado de la agenda cuando se quiere volver a gestionar. 2019-04-29
	 * 
	 * @author Camilo Ochoa
	 * @param Integer (Llave de la tabla)
	 * @return Integer (Llave de la tabla)
	 * @throws Exception 
	 * @see N/A
	 */
	
	public Integer actualizarEstadoAgenda(Integer idAgenda, Integer idUsuarioMod) throws Exception{
		Integer llave = 0;		
		try {
			
			con = ds.getConnection();
			ps = con.prepareStatement(SQL_ACTUALIZAR_ESTADO_AGENDA, Statement.RETURN_GENERATED_KEYS);

			ps.setInt(1, EstadoEnum.ELIMINADO.getIndex());
			ps.setInt(2, idUsuarioMod);
			ps.setInt(3, idAgenda);
			
			ps.executeUpdate();
			llave = Statement.RETURN_GENERATED_KEYS;
			
		} catch (SQLException e) {
			logger.error("SQLException Error SQL al tratar de actualizarEstadoAgenda agenda AgendaDAO "
					+ " id del registro.... " + Statement.RETURN_GENERATED_KEYS + " tabla afectada.... agenda "
					+ "descripción de evento..." + e);
			throw new SQLException("SQLException Error SQL al tratar de actualizarEstadoAgenda  ");
		} catch (Exception e) {
			logger.error("Exception Error al tratar de consultar agenda AgendaDAO " + "id del registro.... "
					+ Statement.RETURN_GENERATED_KEYS + " tabla afectada.... agenda " + "descripción de evento..."
					+ e);
			throw new Exception("Exception Error al tratar de actualizarEstadoAgenda agenda ");
		} finally {
			closeConexion();
			logger.info("finalizo dao AgendaDAO método actualizarEstadoAgenda!");
		}
		
		return llave;
	}
	

}
