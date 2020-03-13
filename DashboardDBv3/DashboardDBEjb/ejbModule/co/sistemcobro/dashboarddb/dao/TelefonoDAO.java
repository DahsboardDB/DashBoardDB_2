package co.sistemcobro.dashboarddb.dao;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import org.apache.log4j.Logger;

import co.sistemcobro.dashboarddb.bean.Telefono;

public class TelefonoDAO extends BaseDAO {

	public TelefonoDAO(DataSource ds) {
		super(ds);
	}

	private static Logger logger = Logger.getLogger(TelefonoDAO.class);

	private String SQL_TELEFONOS_POR_CLIENTE = " SELECT DISTINCT t.t_id, t.t_iddeudor, t.t_idcargue, t.TIP_DOC, t.NRO_DOC, t.COD_TEL, TELEFONO,"
			+ " case when ln_bloqueo is not null then 3 else 1 end  IDORIGEN,"
			+ " case when ln_bloqueo is not null then 'Lista Negra' else 'Mi Banco' end  ORIGEN"
			+ " FROM mibanco.telefono t "
			+ "	JOIN mibanco.cargue c on c.c_id = t.t_idcargue "
			+ " JOIN mibanco.base bas on bas.b_id = c.c_idbase "
			+ "	JOIN mibanco.producto p on p.p_id = bas.b_idproducto "
			+ " LEFT OUTER JOIN mibanco.lista_negra ln WITH (NOLOCK) on ln.ln_telefono = t.TELEFONO"
			+ "	where  bas.b_estado = 2 AND c.c_estado = 2 AND p.p_estado = 2 "			
			+ " AND t.TIP_DOC = ? AND t.NRO_DOC = ? "
			+ " UNION  ALL"
			+ " Select distinct *"
			+ " FROM mibanco.consultarTelefonosAdicionales(?)"
			+ " order by cod_tel desc";

	/**
	 * telefonos. método para consultar los telefonos del cliente. 2019-04-29
	 * 
	 * @author Camilo Ochoa
	 * @param N/A
	 * @throws SQLException
	 *             si existe error de sintaxis en la sentencia SQL. Exception si
	 *             hay valores en null
	 * @return List<Telefono> (Lista de telefonos)
	 * @see N/A
	 */

	public List<Telefono> telefonos(String tipoDocumento, String numeroDocumento) throws Exception {
		List<Telefono> telefonos = new ArrayList<>();
		Telefono telefono = null;
		try {
			con = ds.getConnection();
			ps = con.prepareStatement(SQL_TELEFONOS_POR_CLIENTE, Statement.RETURN_GENERATED_KEYS);

			ps.setString(1, tipoDocumento);
			ps.setString(2, numeroDocumento);
			ps.setString(3, numeroDocumento);

			rs = ps.executeQuery();
			while (rs.next()) {
				int t = 1;
				telefono = new Telefono();

				telefono.setIdTelefono(rs.getInt(t++));
				telefono.setIdDeudor(rs.getInt(t++));
				telefono.setIdCargue(rs.getInt(t++));
				telefono.setTipoDocumentoDeudor(rs.getString(t++));
				telefono.setNumeroDocumentoDeudor(rs.getString(t++));
				telefono.setCodigoTelefono(rs.getString(t++));
				telefono.setNumeroTelefono(rs.getString(t++));
				telefono.setIdOrigen(rs.getInt(t++));
				telefono.setOrigen(rs.getString(t++));

				telefonos.add(telefono);
			}
		} catch (SQLException e) {
			logger.error("SQLException Error SQL al tratar de consultar telefonos TelefonoDAO "
					+ " id del registro.... " + Statement.RETURN_GENERATED_KEYS + " tabla afectada.... telefono "
					+ "descripción de evento..." + e);
			throw new SQLException("SQLException Error SQL al tratar de consultar telefonos ");
		} catch (Exception e) {
			logger.error("Exception Error al tratar de consultar telefonos TelefonoDAO " + "id del registro.... "
					+ Statement.RETURN_GENERATED_KEYS + " tabla afectada.... telefono " + "descripción de evento..."
					+ e);
			throw new Exception("Exception Error al tratar de consultar telefonos ");
		} finally {
			closeConexion();
			logger.info("finalizo dao TelefonoDAO método telefonos!");
		}
		return telefonos;
	}

	private String SQL_ULTIMO_TELEFONO = " SELECT TOP 1 t_id FROM mibanco.telefono ORDER BY 1 DESC ";

	/**
	 * telefono. método para consultar los telefonos del cliente. 2019-04-29
	 * 
	 * @author Camilo Ochoa
	 * @param N/A
	 * @throws SQLException
	 *             si existe error de sintaxis en la sentencia SQL. Exception si
	 *             hay valores en null
	 * @return Integer (id del telefono)
	 * @see N/A
	 */

	public Integer idTelefono() throws Exception {
		Integer result = 0;
		try {
			con = ds.getConnection();
			ps = con.prepareStatement(SQL_ULTIMO_TELEFONO, Statement.RETURN_GENERATED_KEYS);

			rs = ps.executeQuery();
			while (rs.next()) {
				int t = 1;

				result = rs.getInt(t++);
			}
		} catch (SQLException e) {
			logger.error("SQLException Error SQL al tratar de consultar idTelefono TelefonoDAO "
					+ " id del registro.... " + Statement.RETURN_GENERATED_KEYS + " tabla afectada.... telefono "
					+ "descripción de evento..." + e);
			throw new SQLException("SQLException Error SQL al tratar de consultar idTelefono ");
		} catch (Exception e) {
			logger.error("Exception Error al tratar de consultar telefonos TelefonoDAO " + "id del registro.... "
					+ Statement.RETURN_GENERATED_KEYS + " tabla afectada.... telefono " + "descripción de evento..."
					+ e);
			throw new Exception("Exception Error al tratar de consultar idTelefono ");
		} finally {
			closeConexion();
			logger.info("finalizo dao TelefonoDAO método idTelefono!");
		}
		return result;
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

	public Integer insertarTelefono(Telefono telefono) throws Exception {
		Integer llave = 0;
		StringBuilder varname1 = new StringBuilder();
		varname1.append(" INSERT INTO mibanco.telefono ");
		varname1.append(" ( ");
		varname1.append(" t_iddeudor,");// 1
		varname1.append(" t_idcargue,");// 2
		varname1.append(" TIP_DOC, ");// 3
		varname1.append(" NRO_DOC, ");// 4
		varname1.append(" COD_TEL, ");// 5
		varname1.append(" TELEFONO ");// 6
		varname1.append(" ) ");
		varname1.append(" VALUES ( ");
		varname1.append(" ?, ");// 1
		varname1.append(" ?, ");// 2
		varname1.append(" ?, ");// 3
		varname1.append(" ?, ");// 4
		varname1.append(" ?, ");// 5
		varname1.append(" ? ");// 6
		varname1.append(" ) ");

		try {
			con = ds.getConnection();
			ps = con.prepareStatement(varname1.toString(), Statement.RETURN_GENERATED_KEYS);

			int t = 1;

			ps.setInt(t++, telefono.getIdDeudor());
			ps.setInt(t++, telefono.getIdCargue());
			ps.setString(t++, telefono.getTipoDocumentoDeudor());
			ps.setString(t++, telefono.getNumeroDocumentoDeudor());
			ps.setString(t++, telefono.getCodigoTelefono());
			ps.setString(t++, telefono.getNumeroTelefono());

			ps.executeUpdate();
			llave = Statement.RETURN_GENERATED_KEYS;

		} catch (SQLException e) {
			logger.error("SQLException Error SQL al tratar de insertarTelefono telefonos TelefonoDAO "
					+ " id del registro.... " + Statement.RETURN_GENERATED_KEYS + " tabla afectada.... telefono "
					+ "descripción de evento..." + e);
			throw new SQLException("SQLException Error SQL al tratar de insertarTelefono  ");
		} catch (Exception e) {
			logger.error("Exception Error al tratar de consultar telefonos TelefonoDAO " + "id del registro.... "
					+ Statement.RETURN_GENERATED_KEYS + " tabla afectada.... telefono " + "descripción de evento..."
					+ e);
			throw new Exception("Exception Error al tratar de insertarTelefono telefonos ");
		} finally {
			closeConexion();
			logger.info("finalizo dao TelefonoDAO método insertarTelefono!");
		}
		return llave;
	}

}
