package co.sistemcobro.dashboarddb.dao;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.apache.log4j.Logger;

import co.sistemcobro.dashboarddb.bean.TipoDocumento;
import co.sistemcobro.dashboarddb.constante.EstadoEnum;

public class TipoDocumentoDAO extends BaseDAO {

	public TipoDocumentoDAO(DataSource ds) {
		super(ds);
	}

	private static Logger logger = Logger.getLogger(TipoDocumentoDAO.class);

	private String SQL_TIPOS_DE_DOCUMENTO = " SELECT td.idtipodocumento, td.codigo, td.descripcion, "
			+ " td.idusuariocrea, td.fechacrea, td.idusuariomod, td.fechamod, td.estado "
			+ " FROM mibanco.tipo_documento td WHERE td.estado = ? ";

	/**
	 * tiposDocumento. método para consultar los tipos de documento. 2019-04-29
	 * 
	 * @author Camilo Ochoa
	 * @param N/A
	 * @throws SQLException
	 *             si existe error de sintaxis en la sentencia SQL. Exception si
	 *             hay valores en null
	 * @return OList<TipoDocumento> (Lista de documentos)
	 * @see N/A
	 */

	public List<TipoDocumento> tiposDocumento() throws Exception {
		ArrayList<TipoDocumento> tiposDocumento = new ArrayList<>();
		TipoDocumento tipoDocumento = null;
		try {
			con = ds.getConnection();
			ps = con.prepareStatement(SQL_TIPOS_DE_DOCUMENTO, Statement.RETURN_GENERATED_KEYS);
			
			ps.setInt(1, EstadoEnum.ACTIVO.getIndex());
			
			rs = ps.executeQuery();
			while (rs.next()) {
				int t = 1;
				tipoDocumento = new TipoDocumento();
				
				tipoDocumento.setIdTipoDocumento(rs.getInt(t++));
				tipoDocumento.setCodigoTipoDocumento(rs.getString(t++));
				tipoDocumento.setDescripcion(rs.getString(t++));
				tipoDocumento.setIdUsuarioCrea(rs.getInt(t++));
				tipoDocumento.setFechaCrea(rs.getTimestamp(t++));
				tipoDocumento.setIdUsuarioMod(rs.getInt(t++));
				tipoDocumento.setFechaMod(rs.getTimestamp(t++));
				tipoDocumento.setEstado(rs.getInt(t++));
				
				tiposDocumento.add(tipoDocumento);				
			}
		} catch (SQLException e) {
			logger.error("SQLException Error SQL al tratar de tiposDocumento TipoDocumentoDAO "
					+ " id del registro.... " + Statement.RETURN_GENERATED_KEYS + " tabla afectada.... tiposDocumento "
					+ "descripción de evento..." + e);
			throw new SQLException("SQLException Error SQL al tratar de tiposDocumento ");
		} catch (Exception e) {
			logger.error("Exception Error al tratar de tiposDocumento Clase TipoDocumentoDAO " + "id del registro.... "
					+ Statement.RETURN_GENERATED_KEYS + " tabla afectada.... tiposDocumento " + "descripción de evento..."
					+ e);
			throw new Exception("Exception Error al tratar de tiposDocumento ");
		} finally {
			closeConexion();
			logger.info("finalizo dao TipoDocumentoDAO método tiposDocumento!");
		}
		return tiposDocumento;
	}

}
