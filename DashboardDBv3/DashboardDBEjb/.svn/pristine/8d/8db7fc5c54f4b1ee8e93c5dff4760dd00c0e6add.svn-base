package co.sistemcobro.dashboarddb.dao;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.apache.log4j.Logger;

import co.sistemcobro.dashboarddb.bean.Tipificacion;
import co.sistemcobro.dashboarddb.constante.EstadoEnum;

public class TipificacionDAO extends BaseDAO {

	public TipificacionDAO(DataSource ds) {
		super(ds); 
	}

	private static Logger logger = Logger.getLogger(TipificacionDAO.class);

	private String SQL_TIPIFICACIONES = "SELECT idtipificacion, codigo, nombre, detalle, idusuariocrea,"
			+ " fechacrea, idusuariomod, fechamod, fechafin, estado, idniveltipificacion, peso"
			+ " FROM mibanco.tipificacion tp WHERE tp.estado =? and tp.idniveltipificacion = ? ";

	/**
	 * tipificaciones. método para consultar las tipificaciones. 2019-04-29
	 * 
	 * @author Camilo Ochoa
	 * @param N/A
	 * @throws SQLException
	 *             si existe error de sintaxis en la sentencia SQL. Exception si
	 *             hay valores en null
	 * @return List<Tipificacion> (Lista de tipificaciones)
	 * @see N/A
	 */

	public List<Tipificacion> tipificaciones(Integer idNivel) throws Exception {
		ArrayList<Tipificacion> tipificaciones = new ArrayList<>();
		Tipificacion tipificacion = null;
		try {
			con = ds.getConnection();
			ps = con.prepareStatement(SQL_TIPIFICACIONES, Statement.RETURN_GENERATED_KEYS);
			
			ps.setInt(1, EstadoEnum.ACTIVO.getIndex());
			ps.setInt(2, idNivel);
			
			rs = ps.executeQuery();
			while (rs.next()) {
				int t = 1;
				tipificacion = new Tipificacion();
				
				tipificacion.setIdTipificacion(rs.getInt(t++)); 
				tipificacion.setCodigo(rs.getString(t++));
				tipificacion.setNombre(rs.getString(t++)); 
				tipificacion.setDetalle(rs.getString(t++)); 
				tipificacion.setIdUsuarioCrea(rs.getInt(t++)); 
				tipificacion.setFechaCrea(rs.getTimestamp(t++)); 
				tipificacion.setIdUsuarioMod(rs.getInt(t++)); 
				tipificacion.setFechaMod(rs.getTimestamp(t++)); 
				tipificacion.setFechaFin(rs.getTimestamp(t++)); 
				tipificacion.setEstado(rs.getString(t++)); 
				tipificacion.setIdNiveltipificacion(rs.getInt(t++)); 
				tipificacion.setPeso(rs.getInt(t++));
				
				tipificaciones.add(tipificacion);				
			}
		} catch (SQLException e) {
			logger.error("SQLException Error SQL al tratar de tipificaciones TipificacionDAO "
					+ " id del registro.... " + Statement.RETURN_GENERATED_KEYS + " tabla afectada.... tipificaciones "
					+ "descripción de evento..." + e);
			throw new SQLException("SQLException Error SQL al tratar de tipificaciones ");
		} catch (Exception e) {
			logger.error("Exception Error al tratar de tipificaciones Clase TipificacionDAO " + "id del registro.... "
					+ Statement.RETURN_GENERATED_KEYS + " tabla afectada.... tipificaciones " + "descripción de evento..."
					+ e);
			throw new Exception("Exception Error al tratar de tipificaciones ");
		} finally {
			closeConexion();
			logger.info("finalizo dao TipificacionDAO método tipificaciones!");
		}
		return tipificaciones;
	}
	
	private String SQL_BUSCAR_ID_POR_COD = "SELECT TOP 1 idtipificacion "
			+ " FROM mibanco.tipificacion tp WHERE tp.estado =? and tp.codigo = ? "
			+ " ORDER BY idtipificacion DESC ";

	/**
	 * ID tipificacion. método para consultar las tipificaciones. 2019-04-29
	 * 
	 * @author Camilo Ochoa
	 * @param Código de tipificación
	 * @throws SQLException
	 *             si existe error de sintaxis en la sentencia SQL. Exception si
	 *             hay valores en null
	 * @return Integer (ID)
	 * @see N/A
	 */

	public Integer idTipificacion (String codigo) throws Exception {
		Integer result = 0;
		try {
			con = ds.getConnection();
			ps = con.prepareStatement(SQL_BUSCAR_ID_POR_COD, Statement.RETURN_GENERATED_KEYS);
			
			ps.setInt(1, EstadoEnum.ACTIVO.getIndex());
			ps.setString(2, codigo);
			
			rs = ps.executeQuery();
			while (rs.next()) {
				int t = 1;
				
				result = rs.getInt(t++);
			}
		} catch (SQLException e) {
			logger.error("SQLException Error SQL al tratar de idTipificacion TipificacionDAO "
					+ " id del registro.... " + Statement.RETURN_GENERATED_KEYS + " tabla afectada.... tipificaciones "
					+ "descripción de evento..." + e);
			throw new SQLException("SQLException Error SQL al tratar de tipificaciones ");
		} catch (Exception e) {
			logger.error("Exception Error al tratar de idTipificacion Clase TipificacionDAO " + "id del registro.... "
					+ Statement.RETURN_GENERATED_KEYS + " tabla afectada.... tipificaciones " + "descripción de evento..."
					+ e);
			throw new Exception("Exception Error al tratar de idTipificacion ");
		} finally {
			closeConexion();
			logger.info("finalizo dao TipificacionDAO método idTipificacion!");
		}
		return result;
	}

}
