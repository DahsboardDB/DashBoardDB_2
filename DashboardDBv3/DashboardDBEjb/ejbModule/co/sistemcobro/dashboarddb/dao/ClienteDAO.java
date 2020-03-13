package co.sistemcobro.dashboarddb.dao;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import org.apache.log4j.Logger;

import co.sistemcobro.dashboarddb.bean.Cliente;

public class ClienteDAO extends BaseDAO {

	public ClienteDAO(DataSource ds) {
		super(ds);

	}

	private static Logger logger = Logger.getLogger(ClienteDAO.class);

	/**
	 * buscarClientes. método para consultar clientes. 2019-04-29
	 * 
	 * @author Camilo Ochoa
	 * @param String
	 *            tipoDocumento, String numeroDocumento
	 * @throws SQLException
	 *             si existe error de sintaxis en la sentencia SQL. Exception si
	 *             hay valores en null
	 * @return List<Cliente> (devuelve lista)
	 * @see N/A
	 */

	public List<Cliente> buscarClientes(String tipoDocumento, String numeroDocumento) throws Exception {

		ArrayList<Cliente> clientes = new ArrayList<>();

		String query = " SELECT d.d_id, c.c_id, d.USU_FIN, d.TIP_DOC, d.NRO_DOC, d.COD_CLI, d.NOM_CLI  "
				+ " FROM mibanco.deudor d "
				+ "	JOIN mibanco.cargue c on c.c_id = d.d_idcargue "
				+ " JOIN mibanco.base bas on bas.b_id = c.c_idbase"
				+ "	JOIN mibanco.producto p on p.p_id = bas.b_idproducto"
				+ "	 where 	 bas.b_estado = 2 AND c.c_estado = 2 AND p.p_estado = 2 "
				+ "	 AND d.TIP_DOC = '"+tipoDocumento+"' AND d.NRO_DOC like '%"+numeroDocumento+"%'";
						
		try {
			con = ds.getConnection();
			ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

			rs = ps.executeQuery();
			int t = 1;
			while (rs.next()) {
				t = 1;
				Cliente cl = new Cliente();

				cl.setIdDeudor(rs.getInt(t++));
				cl.setIdCargue(rs.getInt(t++));
				cl.setEmpresaCobranza(rs.getString(t++));
				cl.setTipoDocumentoDeudor(rs.getString(t++));
				cl.setNumeroDocumentoDeudor(rs.getString(t++));
				cl.setCodigoUnicoDeudor(rs.getString(t++));
				cl.setNombreDeudor(rs.getString(t++));

				clientes.add(cl);
			}

		} catch (SQLException e) {
			logger.error("SQLException Error SQL al tratar de consultarObligacionPorCliente ClienteDAO "
					+ " id del registro.... "+Statement.RETURN_GENERATED_KEYS
					+" tabla afectada.... obligacion "+"descripción de evento..."+e);			
			throw new SQLException("SQLException Error SQL al tratar de buscarClientes ");
		} catch (Exception e) {
			logger.error("Exception Error al tratar de insertar pagos Clase ClienteDAO "
					+ "id del registro.... "+Statement.RETURN_GENERATED_KEYS
					+" tabla afectada.... obligacion "+"descripción de evento..."+e);			
			throw new Exception("Exception Error al tratar de buscarClientes ");
		} finally {
			closeConexion();
			logger.info("finalizo dao ClienteDAO método buscarClientes!");
		}
		return clientes;
	}
	
	/**
	 * buscarClientesSinTipoDoc. método para consultar clientes sin tipo documento. 2019-04-29
	 * 
	 * @author Camilo Ochoa
	 * @param String
	 *            tipoDocumento, String numeroDocumento
	 * @throws SQLException
	 *             si existe error de sintaxis en la sentencia SQL. Exception si
	 *             hay valores en null
	 * @return List<Cliente> (devuelve lista)
	 * @see N/A
	 */

	public List<Cliente> buscarClientesSinTipoDoc(String numeroDocumento) throws Exception {

		ArrayList<Cliente> clientes = new ArrayList<>();

		String query = " SELECT d.d_id, c.c_id, d.USU_FIN, d.TIP_DOC, d.NRO_DOC, d.COD_CLI, d.NOM_CLI  "
				+ " FROM mibanco.deudor d "
				+ "	JOIN mibanco.cargue c on c.c_id = d.d_idcargue "
				+ " JOIN mibanco.base bas on bas.b_id = c.c_idbase"
				+ "	JOIN mibanco.producto p on p.p_id = bas.b_idproducto"
				+ "	where bas.b_estado = 2 AND c.c_estado = 2 AND p.p_estado = 2 "
				+ " AND	d.NRO_DOC like '%"+numeroDocumento+"%'";

		try {
			con = ds.getConnection();
			ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

			rs = ps.executeQuery();
			int t = 1;
			while (rs.next()) {
				t = 1;
				Cliente cl = new Cliente();

				cl.setIdDeudor(rs.getInt(t++));
				cl.setIdCargue(rs.getInt(t++));
				cl.setEmpresaCobranza(rs.getString(t++));
				cl.setTipoDocumentoDeudor(rs.getString(t++));
				cl.setNumeroDocumentoDeudor(rs.getString(t++));
				cl.setCodigoUnicoDeudor(rs.getString(t++));
				cl.setNombreDeudor(rs.getString(t++));

				clientes.add(cl);
			}

		} catch (SQLException e) {
			logger.error("SQLException Error SQL al tratar de consultarObligacionPorCliente ClienteDAO "
					+ " id del registro.... "+Statement.RETURN_GENERATED_KEYS
					+" tabla afectada.... obligacion "+"descripción de evento..."+e);			
			throw new SQLException("SQLException Error SQL al tratar de buscarClientes ");
		} catch (Exception e) {
			logger.error("Exception Error al tratar de insertar pagos Clase ClienteDAO "
					+ "id del registro.... "+Statement.RETURN_GENERATED_KEYS
					+" tabla afectada.... obligacion "+"descripción de evento..."+e);			
			throw new Exception("Exception Error al tratar de buscarClientes ");
		} finally {
			closeConexion();
			logger.info("finalizo dao ClienteDAO método buscarClientes!");
		}
		return clientes;
	}
	
	
	/**
	 * detalleCliente. método para consultar detalle de clientes. 2019-04-29
	 * 
	 * @author Camilo Ochoa
	 * @param String
	 *            tipoDocumento, String numeroDocumento
	 * @throws SQLException
	 *             si existe error de sintaxis en la sentencia SQL. Exception si
	 *             hay valores en null
	 * @return Cliente (devuelve objeto)
	 * @see N/A
	 */

	public Cliente detalleCliente(String tipoDocumento, String numeroDocumento) throws Exception {

		Cliente cl = null;
		String query = " SELECT d.d_id, c.c_id, d.USU_FIN, d.TIP_DOC, d.NRO_DOC, d.COD_CLI, d.NOM_CLI  "
				+ " FROM mibanco.deudor d "
				+ "	JOIN mibanco.cargue c on c.c_id = d.d_idcargue "
				+ " JOIN mibanco.base bas on bas.b_id = c.c_idbase"
				+ "	JOIN mibanco.producto p on p.p_id = bas.b_idproducto"
				+ "	where bas.b_estado = 2 AND c.c_estado = 2 AND p.p_estado = 2 "
				+ "	AND d.TIP_DOC = '"+tipoDocumento+"' AND d.NRO_DOC like '%" + numeroDocumento + "%' ";

		try {
			con = ds.getConnection();
			ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

			rs = ps.executeQuery();
			int t = 1;
			while (rs.next()) {
				t = 1;
				cl = new Cliente();

				cl.setIdDeudor(rs.getInt(t++));
				cl.setIdCargue(rs.getInt(t++));
				cl.setEmpresaCobranza(rs.getString(t++));
				cl.setTipoDocumentoDeudor(rs.getString(t++));
				cl.setNumeroDocumentoDeudor(rs.getString(t++));
				cl.setCodigoUnicoDeudor(rs.getString(t++));
				cl.setNombreDeudor(rs.getString(t++));

			}

		} catch (SQLException e) {
			logger.error("SQLException Error SQL al tratar de consultarObligacionPorCliente ClienteDAO "
					+ " id del registro.... "+Statement.RETURN_GENERATED_KEYS
					+" tabla afectada.... obligacion "+"descripción de evento..."+e);			
			throw new SQLException("SQLException Error SQL al tratar de buscarClientes ");
		} catch (Exception e) {
			logger.error("Exception Error al tratar de insertar pagos Clase ClienteDAO "
					+ "id del registro.... "+Statement.RETURN_GENERATED_KEYS
					+" tabla afectada.... obligacion "+"descripción de evento..."+e);			
			throw new Exception("Exception Error al tratar de buscarClientes ");
		} finally {
			closeConexion();
			logger.info("finalizo dao ClienteDAO método buscarClientes!");
		}
		return cl;
	}
	
	/**
	 * detalleCliente. método para consultar detalle de clientes. 2019-04-29
	 * 
	 * @author Camilo Ochoa
	 * @param String
	 *            tipoDocumento, String numeroDocumento
	 * @throws SQLException
	 *             si existe error de sintaxis en la sentencia SQL. Exception si
	 *             hay valores en null
	 * @return Cliente (devuelve objeto)
	 * @see N/A
	 */

	public Cliente detalleCliente(String numeroDocumento) throws Exception {

		Cliente cl = null;
		String query = " SELECT d.d_id, c.c_id, d.USU_FIN, d.TIP_DOC, d.NRO_DOC, d.COD_CLI, d.NOM_CLI  "
				+ " FROM mibanco.deudor d "
				+ "	JOIN mibanco.cargue c on c.c_id = d.d_idcargue "
				+ " JOIN mibanco.base bas on bas.b_id = c.c_idbase"
				+ "	JOIN mibanco.producto p on p.p_id = bas.b_idproducto"
				+ "	where bas.b_estado = 2 AND c.c_estado = 2 AND p.p_estado = 2 "
				+ "	AND d.NRO_DOC like '%" + numeroDocumento + "%' ";				

		try {
			con = ds.getConnection();
			ps = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

			rs = ps.executeQuery();
			int t = 1;
			while (rs.next()) {
				t = 1;
				cl = new Cliente();

				cl.setIdDeudor(rs.getInt(t++));
				cl.setIdCargue(rs.getInt(t++));
				cl.setEmpresaCobranza(rs.getString(t++));
				cl.setTipoDocumentoDeudor(rs.getString(t++));
				cl.setNumeroDocumentoDeudor(rs.getString(t++));
				cl.setCodigoUnicoDeudor(rs.getString(t++));
				cl.setNombreDeudor(rs.getString(t++));

			}

		} catch (SQLException e) {
			logger.error("SQLException Error SQL al tratar de consultarObligacionPorCliente ClienteDAO "
					+ " id del registro.... "+Statement.RETURN_GENERATED_KEYS
					+" tabla afectada.... obligacion "+"descripción de evento..."+e);			
			throw new SQLException("SQLException Error SQL al tratar de buscarClientes ");
		} catch (Exception e) {
			logger.error("Exception Error al tratar de insertar pagos Clase ClienteDAO "
					+ "id del registro.... "+Statement.RETURN_GENERATED_KEYS
					+" tabla afectada.... obligacion "+"descripción de evento..."+e);			
			throw new Exception("Exception Error al tratar de buscarClientes ");
		} finally {
			closeConexion();
			logger.info("finalizo dao ClienteDAO método buscarClientes!");
		}
		return cl;
	}

}
