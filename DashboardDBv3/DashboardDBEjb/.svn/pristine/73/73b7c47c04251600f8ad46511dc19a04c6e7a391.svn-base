package co.sistemcobro.dashboarddb.dao;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import javax.sql.DataSource;

import org.apache.log4j.Logger;

import co.sistemcobro.dashboarddb.bean.AcuerdoCuota;

public class AcuerdoCuotaDAO extends BaseDAO {

	public AcuerdoCuotaDAO(DataSource ds) {
		super(ds);
	}

	private static Logger logger = Logger.getLogger(AcuerdoCuotaDAO.class);

	/**
	 * insertarAcuerdoCuota. método insertar acuerdo cuota. 2019-04-29
	 * 
	 * @author Camilo Ochoa
	 * @param Objeto
	 *            AcuerdoCuota
	 * @throws SQLException
	 *             si existe error de sintaxis en la sentencia SQL. Exception si
	 *             hay valores en null
	 * @return Integer (Llave de la tabla)
	 * @see N/A
	 */

	public Integer insertarCuotaAcuerdo(List<AcuerdoCuota> acuerdosCuota, Integer idAcuerdo) throws Exception {
		Integer llave = 0;
		StringBuilder varname1 = new StringBuilder();
		varname1.append(" INSERT INTO mibanco.acuerdo_cuota ");
		varname1.append(" ( ");
		varname1.append(" idacuerdo, ");// 1
		varname1.append(" valortotal, ");// 2
		varname1.append(" cantidadcuotas, ");// 3
		varname1.append(" valoracuerdo, ");// 4
		varname1.append(" fechaacuerdo, ");// 5
		varname1.append(" idusuariocrea, ");// 6
		varname1.append(" fechacrea, ");// 7
		varname1.append(" estado ");// 8
		varname1.append(" ) ");
		varname1.append(" VALUES ( ");
		varname1.append(" ?, ");// 1
		varname1.append(" ?, ");// 2
		varname1.append(" ?, ");// 3
		varname1.append(" ?, ");// 4
		varname1.append(" ?, ");// 5
		varname1.append(" ?, ");// 6
		varname1.append(" GETDATE(), ");// 7
		varname1.append(" ? ");// 8
		varname1.append(" ) ");

		try {
			con = ds.getConnection();
			ps = con.prepareStatement(varname1.toString(), Statement.RETURN_GENERATED_KEYS);

			for (AcuerdoCuota ac : acuerdosCuota) {
				int t = 1;

				ps.setInt(t++, idAcuerdo);// 1
				ps.setDouble(t++, ac.getValorTotalDeuda());// 2
				ps.setInt(t++, ac.getNumeroCuota());// 3
				ps.setDouble(t++, ac.getValorAcuerdo());// 4
				ps.setTimestamp(t++, ac.getFechaAcuerdo());// 5
				ps.setInt(t++, ac.getIdUsuarioCrea());// 6
				ps.setInt(t++, ac.getEstado());// 8

				ps.executeUpdate();
				llave = Statement.RETURN_GENERATED_KEYS;
			}

		} catch (SQLException e) {
			logger.error("SQLException Error SQL al tratar de insertarCuotaAcuerdo telefonos AcuerdoCuotaDAO "
					+ " id del registro.... " + Statement.RETURN_GENERATED_KEYS + " tabla afectada.... telefono "
					+ "descripción de evento..." + e);
			throw new SQLException("SQLException Error SQL al tratar de insertarCuotaAcuerdo  ");
		} catch (Exception e) {
			logger.error("Exception Error al tratar de consultar telefonos AcuerdoCuotaDAO " + "id del registro.... "
					+ Statement.RETURN_GENERATED_KEYS + " tabla afectada.... telefono " + "descripción de evento..."
					+ e);
			throw new Exception("Exception Error al tratar de insertarCuotaAcuerdo telefonos ");
		} finally {
			closeConexion();
			logger.info("finalizo dao AcuerdoCuotaDAO método insertarCuotaAcuerdo!");
		}
		return llave;
	}

	/**
	 * insertarAcuerdoCuota. método insertar acuerdo cuota. 2019-04-29
	 * 
	 * @author Camilo Ochoa
	 * @param Objeto
	 *            AcuerdoCuota
	 * @throws SQLException
	 *             si existe error de sintaxis en la sentencia SQL. Exception si
	 *             hay valores en null
	 * @return Integer (Llave de la tabla)
	 * @see N/A
	 */

	public Integer insertarCuotaAcuerdo(AcuerdoCuota acuerdoCuota, Integer idAcuerdo) throws Exception {
		Integer llave = 0;
		StringBuilder varname1 = new StringBuilder();
		varname1.append(" INSERT INTO mibanco.acuerdo_cuota ");
		varname1.append(" ( ");
		varname1.append(" idacuerdo, ");// 1
		varname1.append(" valortotal, ");// 2
		varname1.append(" cantidadcuotas, ");// 3
		varname1.append(" valoracuerdo, ");// 4
		varname1.append(" fechaacuerdo, ");// 5
		varname1.append(" idusuariocrea, ");// 6
		varname1.append(" fechacrea, ");// 7
		varname1.append(" estado ");// 8
		varname1.append(" ) ");
		varname1.append(" VALUES ( ");
		varname1.append(" ?, ");// 1
		varname1.append(" ?, ");// 2
		varname1.append(" ?, ");// 3
		varname1.append(" ?, ");// 4
		varname1.append(" ?, ");// 5
		varname1.append(" ?, ");// 6
		varname1.append(" GETDATE(), ");// 7
		varname1.append(" ? ");// 8
		varname1.append(" ) ");

		try {
			con = ds.getConnection();
			ps = con.prepareStatement(varname1.toString(), Statement.RETURN_GENERATED_KEYS);

			int t = 1;

			ps.setInt(t++, idAcuerdo);// 1
			ps.setDouble(t++, acuerdoCuota.getValorTotalDeuda());// 2
			ps.setInt(t++, acuerdoCuota.getNumeroCuota());// 3
			ps.setDouble(t++, acuerdoCuota.getValorAcuerdo());// 4
			ps.setTimestamp(t++, acuerdoCuota.getFechaAcuerdo());// 5
			ps.setInt(t++, acuerdoCuota.getIdUsuarioCrea());// 6
			ps.setInt(t++, acuerdoCuota.getEstado());// 8

			ps.executeUpdate();
			llave = Statement.RETURN_GENERATED_KEYS;

		} catch (SQLException e) {
			logger.error("SQLException Error SQL al tratar de insertarCuotaAcuerdo telefonos AcuerdoCuotaDAO "
					+ " id del registro.... " + Statement.RETURN_GENERATED_KEYS + " tabla afectada.... telefono "
					+ "descripción de evento..." + e);
			throw new SQLException("SQLException Error SQL al tratar de insertarCuotaAcuerdo  ");
		} catch (Exception e) {
			logger.error("Exception Error al tratar de consultar telefonos AcuerdoCuotaDAO " + "id del registro.... "
					+ Statement.RETURN_GENERATED_KEYS + " tabla afectada.... telefono " + "descripción de evento..."
					+ e);
			throw new Exception("Exception Error al tratar de insertarCuotaAcuerdo telefonos ");
		} finally {
			closeConexion();
			logger.info("finalizo dao AcuerdoCuotaDAO método insertarCuotaAcuerdo!");
		}
		return llave;
	}

}
