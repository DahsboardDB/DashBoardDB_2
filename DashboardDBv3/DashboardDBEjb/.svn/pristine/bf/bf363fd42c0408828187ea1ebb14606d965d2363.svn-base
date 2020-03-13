package co.sistemcobro.dashboarddb.dao;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.apache.log4j.Logger;

import co.sistemcobro.dashboarddb.bean.Obligacion;

public class ObligacionDAO extends BaseDAO {

	public ObligacionDAO(DataSource ds) {
		super(ds);
	}

	private static Logger logger = Logger.getLogger(ObligacionDAO.class);
	
	private String SQL_BUSCAR_OBLIGACION_CLIENTE_COD = " SELECT DISTINCT d.COD_CLI,"
			+ " ob.o_id, ob.o_iddeudor, ob.o_idcargue, ob.TIP_DOC, ob.NRO_DOC, ob.COD_PRE, ob.DIA_MOR, ob.MAX_MOR_CLI, ob.TIP_DOC_CON, "
			+ " ob.NRO_DOC_CON, ob.CONYUGE, ob.COD_AGE_CLI, ob.NOM_AGE_CLI, ob.COD_AGE_ORI, NOM_AGE_ORI, ob.FOGAPI, ob.ESTADO, ob.TIPO, "
			+ " ob.TIPO_DOC_AVAL, ob.NRO_DOC_AVAL, ob.AVAL, ob.TIP_DOC_RLE, ob.NRO_DOC_RLE, ob.NOM_RLE, ob.DIR_DOM, ob.DES_DIR_COM, ob.DOM_ADICIONAL, "
			+ " ob.DPTO_DOM, ob.PROV_DOM, ob.DIST_DOM, ob.DIR_DOM_BT, ob.DPTO_DOM_BT, ob.PROV_DOM_BT, ob.DIST_DOM_BT, ob.DIR_NEG, ob.DES_DIR_NEG, "
			+ " ob.ADICIONAL, ob.DPTO_NEG, ob.PROV_NEG, ob.DIST_NEG, ob.DIR_NEG_BT, ob.DPTO_NEG_BT, ob.PROV_NEG_BT, ob.DIST_NEG_BT, "
			+ " ob.FEC_ULT_PAG, ob.IMP_ULT_PAG, ob.FEC_CTA_INT, IMP_CTA_INT, ob.MONEDA, SAL_SOL, ob.SAL_PRE, ob.CAP_VEN, ob.INT_TOT, ob.MOR_TOT, "
			+ " ob.INT_COM_MOR_TOT, ob.CAR_TOT, ob.IMP_ITF, ob.TOT_DEU, ob.IMP_TOT_DEU, ob.RANGO_UIT, ob.CUO_PAG, ob.CUO_VEN, ob.MONTO_APROB, ob.PLAZO,"
			+ " ob.FECHA_DESEMB, ob.RIESGO, ob.COD_FUN, ob.NOM_FUN, ob.CONVENIO, ob.USU_MES_ANT, ob.NUM_ENTIDADES_ADEU, ob.TERRITORIAL, ob.SUPERVISOR, "
			+ " ob.ZONA, ob.FAMILIA, ob.PRODUCTO, ob.EGP_ULT_PAG, ob.ANOCAS, ob.RIESGO_CASTIGO, ob.RangoMora, "
			+ " ob.CAMPANA, ob.EDAD "
			+ " FROM mibanco.obligacion ob "
			+ " JOIN mibanco.deudor d on d.d_id = ob.o_iddeudor "
			+ "	JOIN mibanco.cargue c on c.c_id = d.d_idcargue "
			+ " JOIN mibanco.base bas on bas.b_id = c.c_idbase"
			+ "	JOIN mibanco.producto p on p.p_id = bas.b_idproducto"
			+ "	where bas.b_estado = 2 AND c.c_estado = 2 AND p.p_estado = 2 "
			+ " AND ob.TIP_DOC = ? AND ob.NRO_DOC = ? ";
	
	
	private String SQL_BUSCAR_OBLIGACION_CLIENTE_COD_1 = " SELECT DISTINCT d.COD_CLI,"
			+ " ob.o_id, ob.o_iddeudor, ob.o_idcargue, ob.TIP_DOC, ob.NRO_DOC, ob.COD_PRE, ob.DIA_MOR, ob.MAX_MOR_CLI, ob.TIP_DOC_CON, "
			+ " ob.NRO_DOC_CON, ob.CONYUGE, ob.COD_AGE_CLI, ob.NOM_AGE_CLI, ob.COD_AGE_ORI, NOM_AGE_ORI, ob.FOGAPI, ob.ESTADO, ob.TIPO, "
			+ " ob.TIPO_DOC_AVAL, ob.NRO_DOC_AVAL, ob.AVAL, ob.TIP_DOC_RLE, ob.NRO_DOC_RLE, ob.NOM_RLE, ob.DIR_DOM, ob.DES_DIR_COM, ob.DOM_ADICIONAL, "
			+ " ob.DPTO_DOM, ob.PROV_DOM, ob.DIST_DOM, ob.DIR_DOM_BT, ob.DPTO_DOM_BT, ob.PROV_DOM_BT, ob.DIST_DOM_BT, ob.DIR_NEG, ob.DES_DIR_NEG, "
			+ " ob.ADICIONAL, ob.DPTO_NEG, ob.PROV_NEG, ob.DIST_NEG, ob.DIR_NEG_BT, ob.DPTO_NEG_BT, ob.PROV_NEG_BT, ob.DIST_NEG_BT, "
			+ " ob.FEC_ULT_PAG, ob.IMP_ULT_PAG, ob.FEC_CTA_INT, IMP_CTA_INT, ob.MONEDA, SAL_SOL, ob.SAL_PRE, ob.CAP_VEN, ob.INT_TOT, ob.MOR_TOT, "
			+ " ob.INT_COM_MOR_TOT, ob.CAR_TOT, ob.IMP_ITF, ob.TOT_DEU, ob.IMP_TOT_DEU, ob.RANGO_UIT, ob.CUO_PAG, ob.CUO_VEN, ob.MONTO_APROB, ob.PLAZO,"
			+ " ob.FECHA_DESEMB, ob.RIESGO, ob.COD_FUN, ob.NOM_FUN, ob.CONVENIO, ob.USU_MES_ANT, ob.NUM_ENTIDADES_ADEU, ob.TERRITORIAL, ob.SUPERVISOR, "
			+ " ob.ZONA, ob.FAMILIA, ob.PRODUCTO, ob.EGP_ULT_PAG, ob.ANOCAS, ob.RIESGO_CASTIGO, ob.RangoMora, "
			+ " ob.CAMPANA, ob.EDAD "
			+ " FROM mibanco.obligacion ob "
			+ " JOIN mibanco.deudor d on d.d_id = ob.o_iddeudor "
			+ "	JOIN mibanco.cargue c on c.c_id = d.d_idcargue "
			+ " JOIN mibanco.base bas on bas.b_id = c.c_idbase"
			+ "	JOIN mibanco.producto p on p.p_id = bas.b_idproducto"
			+ "	where bas.b_estado = 2 AND c.c_estado = 2 AND p.p_estado = 2 "
			+ " AND ob.NRO_DOC = ? ";
			
	/**
	 * consultarObligacionPorCliente. método para consultar obligación por cliente. 2019-04-29
	 * @author Camilo Ochoa
	 * @param String tipoDocumento, String numeroDocumento
	 * @throws SQLException si existe error de sintaxis en la sentencia SQL.
	 *         Exception si hay valores en null
	 * @return Obligacion (devuelve objeto)
	 * @see N/A
	 */
	
	public Obligacion consultarObligacionPorCliente(String tipoDocumento, String numeroDocumento) throws Exception {

		Obligacion obligacion = null;
		try {
			
			con = ds.getConnection();
			ps = con.prepareStatement(SQL_BUSCAR_OBLIGACION_CLIENTE_COD, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, tipoDocumento);
			ps.setString(2, numeroDocumento);
			
			rs = ps.executeQuery();
			while (rs.next()) {
				int t = 1;

				obligacion = new Obligacion();

				obligacion.setCodigoUnicoCliente(rs.getString(t++));
				obligacion.setIdObligacion(rs.getInt(t++));
				obligacion.setIdDeudor(rs.getInt(t++));
				obligacion.setIdCargue(rs.getInt(t++));
				obligacion.setTipoDocumento(rs.getString(t++));				
				obligacion.setNumeroDocumento(rs.getString(t++));
				obligacion.setNumeroObligacion(rs.getString(t++));
				obligacion.setDiasMora(rs.getInt(t++));
				obligacion.setMaxDiasMora(rs.getInt(t++));
				obligacion.setTipoDocumentoConyuge(rs.getString(t++));
				obligacion.setNumeroDocumentoConyuge(rs.getString(t++));
				obligacion.setNombreConyuge(rs.getString(t++));
				obligacion.setCodigoAgencia(rs.getInt(t++));
				obligacion.setNombreAgencia(rs.getString(t++));
				obligacion.setCodigoAgenciaOrigen(rs.getInt(t++));
				obligacion.setNombreAgenciaOrigen(rs.getString(t++));
				obligacion.setFogapi(rs.getString(t++));
				obligacion.setEstado(rs.getString(t++));
				obligacion.setTipoCredito(rs.getString(t++));
				obligacion.setTipoDocumentoAvalista(rs.getString(t++));
				obligacion.setNumeroDocumentoAvalista(rs.getString(t++));
				obligacion.setNombreAvalista(rs.getString(t++));
				obligacion.setTipoDocumentoRepresentanteLegal(rs.getString(t++));
				obligacion.setNumeroDocumentoRepresentanteLegal(rs.getString(t++));
				obligacion.setNombreRepresentanteLegal(rs.getString(t++));
				obligacion.setDireccionDomicilio(rs.getString(t++));
				obligacion.setDescripcionDomicilio(rs.getString(t++));
				obligacion.setDireccionAdicionalDomicilio(rs.getString(t++));
				obligacion.setDepartamento(rs.getString(t++));
				obligacion.setProvincia(rs.getString(t++));
				obligacion.setDistrito(rs.getString(t++));
				obligacion.setDireccionBantotal(rs.getString(t++));
				obligacion.setDepartamentoBantotal(rs.getString(t++));
				obligacion.setProvinciaBantotal(rs.getString(t++));
				obligacion.setDistritoBantotal(rs.getString(t++));
				obligacion.setDireccionNegocio(rs.getString(t++));
				obligacion.setDescripcionDireccionNegocio(rs.getString(t++));
				obligacion.setReferenciaAdicional(rs.getString(t++));
				obligacion.setDepartamentoDireccionNegocio(rs.getString(t++));
				obligacion.setProvinciaDireccionNegocio(rs.getString(t++));
				obligacion.setDistritoDireccionNegocio(rs.getString(t++));
				obligacion.setDireccionNegocioBantotal(rs.getString(t++));
				obligacion.setDepartamentoNegocioBantotal(rs.getString(t++));
				obligacion.setProvinciaNegocioBantotal(rs.getString(t++));
				obligacion.setDistritoNegocioBantotal(rs.getString(t++));				
				obligacion.setFechaUltimoPago(rs.getString(t++));
				obligacion.setImporteUltimoPago(rs.getString(t++));
				obligacion.setFechaAbonoACuenta(rs.getString(t++));
				obligacion.setImporteCuentaInterna(rs.getString(t++));
				obligacion.setMoneda(rs.getString(t++));
				obligacion.setSaldoCapitalSoles(rs.getString(t++));
				obligacion.setSaldoCapital(rs.getString(t++));
				obligacion.setCapitalVencido(rs.getString(t++));
				obligacion.setTotalInteses(rs.getString(t++));
				obligacion.setTotalMora(rs.getString(t++));
				obligacion.setCompensatorioTotal(rs.getString(t++));
				obligacion.setTotalCargos(rs.getString(t++));
				obligacion.setImporteITF(rs.getString(t++));				
				obligacion.setDeudaVencida(rs.getString(t++));
				obligacion.setTotalDeuda(rs.getString(t++));
				obligacion.setRangoUIT(rs.getString(t++));		
				obligacion.setNumeroCuotasPagadas(rs.getInt(t++));
				obligacion.setNumeroCuotasVencidas(rs.getInt(t++));
				obligacion.setMontoDesembolsado(rs.getString(t++));
				obligacion.setPlazoCredito(rs.getInt(t++));
				obligacion.setFechaDesembolso(rs.getString(t++));
				obligacion.setTipoRiesgo(rs.getString(t++));
				obligacion.setCodigoFuncionario(rs.getString(t++));
				obligacion.setNombreFuncionario(rs.getString(t++));
				obligacion.setCuentaConConvenio(rs.getString(t++));
				obligacion.setUsuarioCreditoAnterior(rs.getString(t++));
				obligacion.setNumeroEntidadesAdeuda(rs.getInt(t++));
				obligacion.setTerritorialAsignado(rs.getString(t++));
				obligacion.setSupervisorCobranza(rs.getString(t++));
				obligacion.setZonal(rs.getString(t++));
				obligacion.setFamilia(rs.getString(t++));
				obligacion.setProducto(rs.getString(t++));
				obligacion.setFechaUltimoPago2(rs.getString(t++));
				obligacion.setAnocas(rs.getString(t++));
				obligacion.setRiesgo(rs.getString(t++));
				obligacion.setRangoMora(rs.getString(t++));
				obligacion.setCampana(rs.getString(t++));
				obligacion.setEdad(rs.getString(t++));

			}
		} catch (SQLException e) {
			logger.error("SQLException Error SQL al tratar de consultarObligacionPorCliente ObligacionDAO "
					+ " id del registro.... "+Statement.RETURN_GENERATED_KEYS
					+" tabla afectada.... obligacion "+"descripción de evento..."+e);			
			throw new SQLException("SQLException Error SQL al tratar de consultarObligacionPorCliente ");
		} catch (Exception e) {
			logger.error("Exception Error al tratar de consultarObligacionPorCliente Clase ObligacionDAO "
					+ "id del registro.... "+Statement.RETURN_GENERATED_KEYS
					+" tabla afectada.... obligacion "+"descripción de evento..."+e);			
			throw new Exception("Exception Error al tratar de consultarObligacionPorCliente ");
		} finally {
			closeConexion();
			logger.info("finalizo dao ObligacionDAO método consultarObligacionPorCliente!");
		}
		return obligacion;
	}
	
	/**
	 * consultarObligacionPorCliente. método para consultar obligación por cliente. 2019-04-29
	 * @author Camilo Ochoa
	 * @param String tipoDocumento, String numeroDocumento
	 * @throws SQLException si existe error de sintaxis en la sentencia SQL.
	 *         Exception si hay valores en null
	 * @return Obligacion (devuelve objeto)
	 * @see N/A
	 */
	
	public Obligacion consultarObligacionPorCliente(String numeroDocumento) throws Exception {

		Obligacion obligacion = null;
		try {
			
			con = ds.getConnection();
			ps = con.prepareStatement(SQL_BUSCAR_OBLIGACION_CLIENTE_COD_1, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, numeroDocumento);

			rs = ps.executeQuery();
			while (rs.next()) {
				int t = 1;

				obligacion = new Obligacion();

				obligacion.setCodigoUnicoCliente(rs.getString(t++));
				obligacion.setIdObligacion(rs.getInt(t++));
				obligacion.setIdDeudor(rs.getInt(t++));
				obligacion.setIdCargue(rs.getInt(t++));
				obligacion.setTipoDocumento(rs.getString(t++));				
				obligacion.setNumeroDocumento(rs.getString(t++));
				obligacion.setNumeroObligacion(rs.getString(t++));
				obligacion.setDiasMora(rs.getInt(t++));
				obligacion.setMaxDiasMora(rs.getInt(t++));
				obligacion.setTipoDocumentoConyuge(rs.getString(t++));
				obligacion.setNumeroDocumentoConyuge(rs.getString(t++));
				obligacion.setNombreConyuge(rs.getString(t++));
				obligacion.setCodigoAgencia(rs.getInt(t++));
				obligacion.setNombreAgencia(rs.getString(t++));
				obligacion.setCodigoAgenciaOrigen(rs.getInt(t++));
				obligacion.setNombreAgenciaOrigen(rs.getString(t++));
				obligacion.setFogapi(rs.getString(t++));
				obligacion.setEstado(rs.getString(t++));
				obligacion.setTipoCredito(rs.getString(t++));
				obligacion.setTipoDocumentoAvalista(rs.getString(t++));
				obligacion.setNumeroDocumentoAvalista(rs.getString(t++));
				obligacion.setNombreAvalista(rs.getString(t++));
				obligacion.setTipoDocumentoRepresentanteLegal(rs.getString(t++));
				obligacion.setNumeroDocumentoRepresentanteLegal(rs.getString(t++));
				obligacion.setNombreRepresentanteLegal(rs.getString(t++));
				obligacion.setDireccionDomicilio(rs.getString(t++));
				obligacion.setDescripcionDomicilio(rs.getString(t++));
				obligacion.setDireccionAdicionalDomicilio(rs.getString(t++));
				obligacion.setDepartamento(rs.getString(t++));
				obligacion.setProvincia(rs.getString(t++));
				obligacion.setDistrito(rs.getString(t++));
				obligacion.setDireccionBantotal(rs.getString(t++));
				obligacion.setDepartamentoBantotal(rs.getString(t++));
				obligacion.setProvinciaBantotal(rs.getString(t++));
				obligacion.setDistritoBantotal(rs.getString(t++));
				obligacion.setDireccionNegocio(rs.getString(t++));
				obligacion.setDescripcionDireccionNegocio(rs.getString(t++));
				obligacion.setReferenciaAdicional(rs.getString(t++));
				obligacion.setDepartamentoDireccionNegocio(rs.getString(t++));
				obligacion.setProvinciaDireccionNegocio(rs.getString(t++));
				obligacion.setDistritoDireccionNegocio(rs.getString(t++));
				obligacion.setDireccionNegocioBantotal(rs.getString(t++));
				obligacion.setDepartamentoNegocioBantotal(rs.getString(t++));
				obligacion.setProvinciaNegocioBantotal(rs.getString(t++));
				obligacion.setDistritoNegocioBantotal(rs.getString(t++));
				obligacion.setFechaUltimoPago(rs.getString(t++));
				obligacion.setImporteUltimoPago(rs.getString(t++));
				obligacion.setFechaAbonoACuenta(rs.getString(t++));
				obligacion.setImporteCuentaInterna(rs.getString(t++));
				obligacion.setMoneda(rs.getString(t++));
				obligacion.setSaldoCapitalSoles(rs.getString(t++));
				obligacion.setSaldoCapital(rs.getString(t++));
				obligacion.setCapitalVencido(rs.getString(t++));
				obligacion.setTotalInteses(rs.getString(t++));
				obligacion.setTotalMora(rs.getString(t++));
				obligacion.setCompensatorioTotal(rs.getString(t++));
				obligacion.setTotalCargos(rs.getString(t++));
				obligacion.setImporteITF(rs.getString(t++));				
				obligacion.setDeudaVencida(rs.getString(t++));
				obligacion.setTotalDeuda(rs.getString(t++));
				obligacion.setRangoUIT(rs.getString(t++));		
				obligacion.setNumeroCuotasPagadas(rs.getInt(t++));
				obligacion.setNumeroCuotasVencidas(rs.getInt(t++));
				obligacion.setMontoDesembolsado(rs.getString(t++));
				obligacion.setPlazoCredito(rs.getInt(t++));
				obligacion.setFechaDesembolso(rs.getString(t++));
				obligacion.setTipoRiesgo(rs.getString(t++));
				obligacion.setCodigoFuncionario(rs.getString(t++));
				obligacion.setNombreFuncionario(rs.getString(t++));
				obligacion.setCuentaConConvenio(rs.getString(t++));
				obligacion.setUsuarioCreditoAnterior(rs.getString(t++));
				obligacion.setNumeroEntidadesAdeuda(rs.getInt(t++));
				obligacion.setTerritorialAsignado(rs.getString(t++));
				obligacion.setSupervisorCobranza(rs.getString(t++));
				obligacion.setZonal(rs.getString(t++));
				obligacion.setFamilia(rs.getString(t++));
				obligacion.setProducto(rs.getString(t++));
				obligacion.setFechaUltimoPago2(rs.getString(t++));
				obligacion.setAnocas(rs.getString(t++));
				obligacion.setRiesgo(rs.getString(t++));
				obligacion.setRangoMora(rs.getString(t++));
				obligacion.setCampana(rs.getString(t++));
				obligacion.setEdad(rs.getString(t++));

			}
		} catch (SQLException e) {
			logger.error("SQLException Error SQL al tratar de consultarObligacionPorCliente ObligacionDAO "
					+ " id del registro.... "+Statement.RETURN_GENERATED_KEYS
					+" tabla afectada.... obligacion "+"descripción de evento..."+e);			
			throw new SQLException("SQLException Error SQL al tratar de consultarObligacionPorCliente ");
		} catch (Exception e) {
			logger.error("Exception Error al tratar de consultarObligacionPorCliente Clase ObligacionDAO "
					+ "id del registro.... "+Statement.RETURN_GENERATED_KEYS
					+" tabla afectada.... obligacion "+"descripción de evento..."+e);			
			throw new Exception("Exception Error al tratar de consultarObligacionPorCliente ");
		} finally {
			closeConexion();
			logger.info("finalizo dao ObligacionDAO método consultarObligacionPorCliente!");
		}
		return obligacion;
	}
	
	private String SQL_BUSCAR_OBLIGACION_CLIENTE = 	" SELECT DISTINCT"
			+ " ob.o_id, ob.o_iddeudor, ob.o_idcargue, ob.TIP_DOC, ob.NRO_DOC, ob.COD_PRE, ob.DIA_MOR, ob.MAX_MOR_CLI, ob.TIP_DOC_CON, "
			+ " ob.NRO_DOC_CON, ob.CONYUGE, ob.COD_AGE_CLI, ob.NOM_AGE_CLI, ob.COD_AGE_ORI, NOM_AGE_ORI, ob.FOGAPI, ob.ESTADO, ob.TIPO, "
			+ " ob.TIPO_DOC_AVAL, ob.NRO_DOC_AVAL, ob.AVAL, ob.TIP_DOC_RLE, ob.NRO_DOC_RLE, ob.NOM_RLE, ob.DIR_DOM, ob.DES_DIR_COM, ob.DOM_ADICIONAL, "
			+ " ob.DPTO_DOM, ob.PROV_DOM, ob.DIST_DOM, ob.DIR_DOM_BT, ob.DPTO_DOM_BT, ob.PROV_DOM_BT, ob.DIST_DOM_BT, ob.DIR_NEG, ob.DES_DIR_NEG, "
			+ " ob.ADICIONAL, ob.DPTO_NEG, ob.PROV_NEG, ob.DIST_NEG, ob.DIR_NEG_BT, ob.DPTO_NEG_BT, ob.PROV_NEG_BT, ob.DIST_NEG_BT, "
			+ " ob.FEC_ULT_PAG, ob.IMP_ULT_PAG, ob.FEC_CTA_INT, IMP_CTA_INT, ob.MONEDA, SAL_SOL, ob.SAL_PRE, ob.CAP_VEN, ob.INT_TOT, ob.MOR_TOT, "
			+ " ob.INT_COM_MOR_TOT, ob.CAR_TOT, ob.IMP_ITF, ob.TOT_DEU, ob.IMP_TOT_DEU, ob.RANGO_UIT, ob.CUO_PAG, ob.CUO_VEN, ob.MONTO_APROB, ob.PLAZO,"
			+ " ob.FECHA_DESEMB, ob.RIESGO, ob.COD_FUN, ob.NOM_FUN, ob.CONVENIO, ob.USU_MES_ANT, ob.NUM_ENTIDADES_ADEU, ob.TERRITORIAL, ob.SUPERVISOR, "
			+ " ob.ZONA, ob.FAMILIA, ob.PRODUCTO, ob.EGP_ULT_PAG, ob.ANOCAS, ob.RIESGO_CASTIGO, ob.RangoMora, "
			+ " ob.CAMPANA, ob.EDAD "
			+ " FROM mibanco.obligacion ob "
			+ " JOIN mibanco.deudor d on d.d_id = ob.o_iddeudor "
			+ "	JOIN mibanco.cargue c on c.c_id = d.d_idcargue "
			+ " JOIN mibanco.base bas on bas.b_id = c.c_idbase"
			+ "	JOIN mibanco.producto p on p.p_id = bas.b_idproducto"
			+ "	where bas.b_estado = 2 AND c.c_estado = 2 AND p.p_estado = 2 "
			+ " AND ob.TIP_DOC = ? AND ob.NRO_DOC = ? ";
	
	private String SQL_BUSCAR_OBLIGACION_CLIENTE_1= 	" SELECT DISTINCT"
			+ " ob.o_id, ob.o_iddeudor, ob.o_idcargue, ob.TIP_DOC, ob.NRO_DOC, ob.COD_PRE, ob.DIA_MOR, ob.MAX_MOR_CLI, ob.TIP_DOC_CON, "
			+ " ob.NRO_DOC_CON, ob.CONYUGE, ob.COD_AGE_CLI, ob.NOM_AGE_CLI, ob.COD_AGE_ORI, NOM_AGE_ORI, ob.FOGAPI, ob.ESTADO, ob.TIPO, "
			+ " ob.TIPO_DOC_AVAL, ob.NRO_DOC_AVAL, ob.AVAL, ob.TIP_DOC_RLE, ob.NRO_DOC_RLE, ob.NOM_RLE, ob.DIR_DOM, ob.DES_DIR_COM, ob.DOM_ADICIONAL, "
			+ " ob.DPTO_DOM, ob.PROV_DOM, ob.DIST_DOM, ob.DIR_DOM_BT, ob.DPTO_DOM_BT, ob.PROV_DOM_BT, ob.DIST_DOM_BT, ob.DIR_NEG, ob.DES_DIR_NEG, "
			+ " ob.ADICIONAL, ob.DPTO_NEG, ob.PROV_NEG, ob.DIST_NEG, ob.DIR_NEG_BT, ob.DPTO_NEG_BT, ob.PROV_NEG_BT, ob.DIST_NEG_BT, "
			+ " ob.FEC_ULT_PAG, ob.IMP_ULT_PAG, ob.FEC_CTA_INT, IMP_CTA_INT, ob.MONEDA, SAL_SOL, ob.SAL_PRE, ob.CAP_VEN, ob.INT_TOT, ob.MOR_TOT, "
			+ " ob.INT_COM_MOR_TOT, ob.CAR_TOT, ob.IMP_ITF, ob.TOT_DEU, ob.IMP_TOT_DEU, ob.RANGO_UIT, ob.CUO_PAG, ob.CUO_VEN, ob.MONTO_APROB, ob.PLAZO,"
			+ " ob.FECHA_DESEMB, ob.RIESGO, ob.COD_FUN, ob.NOM_FUN, ob.CONVENIO, ob.USU_MES_ANT, ob.NUM_ENTIDADES_ADEU, ob.TERRITORIAL, ob.SUPERVISOR, "
			+ " ob.ZONA, ob.FAMILIA, ob.PRODUCTO, ob.EGP_ULT_PAG, ob.ANOCAS, ob.RIESGO_CASTIGO, ob.RangoMora, "
			+ " ob.CAMPANA, ob.EDAD "
			+ " FROM mibanco.obligacion ob "
			+ " JOIN mibanco.deudor d on d.d_id = ob.o_iddeudor "
			+ "	JOIN mibanco.cargue c on c.c_id = d.d_idcargue "
			+ " JOIN mibanco.base bas on bas.b_id = c.c_idbase"
			+ "	JOIN mibanco.producto p on p.p_id = bas.b_idproducto"
			+ "	where bas.b_estado = 2 AND c.c_estado = 2 AND p.p_estado = 2 "
			+ " AND ob.NRO_DOC = ? ";
	
	
	/**
	 * consultarObligacionesPorCliente. método para consultar obligación por cliente. 2019-04-29
	 * @author Camilo Ochoa
	 * @param String tipoDocumento, String numeroDocumento
	 * @throws SQLException si existe error de sintaxis en la sentencia SQL.
	 *         Exception si hay valores en null
	 * @return  List<Obligacion> (devuelve lista)
	 * @see N/A
	 */
	
	public List<Obligacion> consultarObligacionesPorCliente(String tipoDocumento, String numeroDocumento) throws Exception {
		List<Obligacion> obligaciones =  new ArrayList<>();
		Obligacion obligacion = null;
		try {
			
			con = ds.getConnection();
			ps = con.prepareStatement(SQL_BUSCAR_OBLIGACION_CLIENTE, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, tipoDocumento);
			ps.setString(2, numeroDocumento);

			rs = ps.executeQuery();
			while (rs.next()) {
				int t = 1;

				obligacion = new Obligacion();
								
				obligacion.setIdObligacion(rs.getInt(t++));
				obligacion.setIdDeudor(rs.getInt(t++));
				obligacion.setIdCargue(rs.getInt(t++));
				obligacion.setTipoDocumento(rs.getString(t++));				
				obligacion.setNumeroDocumento(rs.getString(t++));
				obligacion.setNumeroObligacion(rs.getString(t++));
				obligacion.setDiasMora(rs.getInt(t++));
				obligacion.setMaxDiasMora(rs.getInt(t++));
				obligacion.setTipoDocumentoConyuge(rs.getString(t++));
				obligacion.setNumeroDocumentoConyuge(rs.getString(t++));
				obligacion.setNombreConyuge(rs.getString(t++));
				obligacion.setCodigoAgencia(rs.getInt(t++));
				obligacion.setNombreAgencia(rs.getString(t++));
				obligacion.setCodigoAgenciaOrigen(rs.getInt(t++));
				obligacion.setNombreAgenciaOrigen(rs.getString(t++));
				obligacion.setFogapi(rs.getString(t++));
				obligacion.setEstado(rs.getString(t++));
				obligacion.setTipoCredito(rs.getString(t++));
				obligacion.setTipoDocumentoAvalista(rs.getString(t++));
				obligacion.setNumeroDocumentoAvalista(rs.getString(t++));
				obligacion.setNombreAvalista(rs.getString(t++));
				obligacion.setTipoDocumentoRepresentanteLegal(rs.getString(t++));
				obligacion.setNumeroDocumentoRepresentanteLegal(rs.getString(t++));
				obligacion.setNombreRepresentanteLegal(rs.getString(t++));
				obligacion.setDireccionDomicilio(rs.getString(t++));
				obligacion.setDescripcionDomicilio(rs.getString(t++));
				obligacion.setDireccionAdicionalDomicilio(rs.getString(t++));
				obligacion.setDepartamento(rs.getString(t++));
				obligacion.setProvincia(rs.getString(t++));
				obligacion.setDistrito(rs.getString(t++));
				obligacion.setDireccionBantotal(rs.getString(t++));
				obligacion.setDepartamentoBantotal(rs.getString(t++));
				obligacion.setProvinciaBantotal(rs.getString(t++));
				obligacion.setDistritoBantotal(rs.getString(t++));
				obligacion.setDireccionNegocio(rs.getString(t++));
				obligacion.setDescripcionDireccionNegocio(rs.getString(t++));
				obligacion.setReferenciaAdicional(rs.getString(t++));
				obligacion.setDepartamentoDireccionNegocio(rs.getString(t++));
				obligacion.setProvinciaDireccionNegocio(rs.getString(t++));
				obligacion.setDistritoDireccionNegocio(rs.getString(t++));
				obligacion.setDireccionNegocioBantotal(rs.getString(t++));
				obligacion.setDepartamentoNegocioBantotal(rs.getString(t++));
				obligacion.setProvinciaNegocioBantotal(rs.getString(t++));
				obligacion.setDistritoNegocioBantotal(rs.getString(t++));
				obligacion.setFechaUltimoPago(rs.getString(t++));
				obligacion.setImporteUltimoPago(rs.getString(t++));
				obligacion.setFechaAbonoACuenta(rs.getString(t++));
				obligacion.setImporteCuentaInterna(rs.getString(t++));
				obligacion.setMoneda(rs.getString(t++));
				obligacion.setSaldoCapitalSoles(rs.getString(t++));
				obligacion.setSaldoCapital(rs.getString(t++));
				obligacion.setCapitalVencido(rs.getString(t++));
				obligacion.setTotalInteses(rs.getString(t++));
				obligacion.setTotalMora(rs.getString(t++));
				obligacion.setCompensatorioTotal(rs.getString(t++));
				obligacion.setTotalCargos(rs.getString(t++));
				obligacion.setImporteITF(rs.getString(t++));				
				obligacion.setDeudaVencida(rs.getString(t++));
				obligacion.setTotalDeuda(rs.getString(t++));
				obligacion.setRangoUIT(rs.getString(t++));		
				obligacion.setNumeroCuotasPagadas(rs.getInt(t++));
				obligacion.setNumeroCuotasVencidas(rs.getInt(t++));
				obligacion.setMontoDesembolsado(rs.getString(t++));
				obligacion.setPlazoCredito(rs.getInt(t++));
				obligacion.setFechaDesembolso(rs.getString(t++));
				obligacion.setTipoRiesgo(rs.getString(t++));
				obligacion.setCodigoFuncionario(rs.getString(t++));
				obligacion.setNombreFuncionario(rs.getString(t++));
				obligacion.setCuentaConConvenio(rs.getString(t++));
				obligacion.setUsuarioCreditoAnterior(rs.getString(t++));
				obligacion.setNumeroEntidadesAdeuda(rs.getInt(t++));
				obligacion.setTerritorialAsignado(rs.getString(t++));
				obligacion.setSupervisorCobranza(rs.getString(t++));
				obligacion.setZonal(rs.getString(t++));
				obligacion.setFamilia(rs.getString(t++));
				obligacion.setProducto(rs.getString(t++));
				obligacion.setFechaUltimoPago2(rs.getString(t++));
				obligacion.setAnocas(rs.getString(t++));
				obligacion.setRiesgo(rs.getString(t++));
				obligacion.setRangoMora(rs.getString(t++));
				obligacion.setCampana(rs.getString(t++));
				obligacion.setEdad(rs.getString(t++));
				
				obligaciones.add(obligacion);

			}
		} catch (SQLException e) {
			logger.error("SQLException Error SQL al tratar de consultarObligacionesPorCliente ObligacionDAO "
					+ " id del registro.... "+Statement.RETURN_GENERATED_KEYS
					+" tabla afectada.... obligacion "+"descripción de evento..."+e);			
			throw new SQLException("SQLException Error SQL al tratar de consultarObligacionesPorCliente ");
		} catch (Exception e) {
			logger.error("Exception Error al tratar de consultarObligacionesPorCliente Clase ObligacionDAO "
					+ "id del registro.... "+Statement.RETURN_GENERATED_KEYS
					+" tabla afectada.... obligacion "+"descripción de evento..."+e);			
			throw new Exception("Exception Error al tratar de consultarObligacionesPorCliente ");
		} finally {
			closeConexion();
			logger.info("finalizo dao ObligacionDAO método consultarObligacionesPorCliente!");
		}
		return obligaciones;
	}
	
	/**
	 * consultarObligacionesPorCliente. método para consultar obligación por cliente. 2019-04-29
	 * @author Camilo Ochoa
	 * @param String tipoDocumento, String numeroDocumento
	 * @throws SQLException si existe error de sintaxis en la sentencia SQL.
	 *         Exception si hay valores en null
	 * @return  List<Obligacion> (devuelve lista)
	 * @see N/A
	 */
	
	public List<Obligacion> consultarObligacionesPorCliente(String numeroDocumento) throws Exception {
		List<Obligacion> obligaciones =  new ArrayList<>();
		Obligacion obligacion = null;
		try {
			
			con = ds.getConnection();
			ps = con.prepareStatement(SQL_BUSCAR_OBLIGACION_CLIENTE_1, Statement.RETURN_GENERATED_KEYS);
			ps.setString(1, numeroDocumento);

			rs = ps.executeQuery();
			while (rs.next()) {
				int t = 1;

				obligacion = new Obligacion();
								
				obligacion.setIdObligacion(rs.getInt(t++));
				obligacion.setIdDeudor(rs.getInt(t++));
				obligacion.setIdCargue(rs.getInt(t++));
				obligacion.setTipoDocumento(rs.getString(t++));				
				obligacion.setNumeroDocumento(rs.getString(t++));
				obligacion.setNumeroObligacion(rs.getString(t++));
				obligacion.setDiasMora(rs.getInt(t++));
				obligacion.setMaxDiasMora(rs.getInt(t++));
				obligacion.setTipoDocumentoConyuge(rs.getString(t++));
				obligacion.setNumeroDocumentoConyuge(rs.getString(t++));
				obligacion.setNombreConyuge(rs.getString(t++));
				obligacion.setCodigoAgencia(rs.getInt(t++));
				obligacion.setNombreAgencia(rs.getString(t++));
				obligacion.setCodigoAgenciaOrigen(rs.getInt(t++));
				obligacion.setNombreAgenciaOrigen(rs.getString(t++));
				obligacion.setFogapi(rs.getString(t++));
				obligacion.setEstado(rs.getString(t++));
				obligacion.setTipoCredito(rs.getString(t++));
				obligacion.setTipoDocumentoAvalista(rs.getString(t++));
				obligacion.setNumeroDocumentoAvalista(rs.getString(t++));
				obligacion.setNombreAvalista(rs.getString(t++));
				obligacion.setTipoDocumentoRepresentanteLegal(rs.getString(t++));
				obligacion.setNumeroDocumentoRepresentanteLegal(rs.getString(t++));
				obligacion.setNombreRepresentanteLegal(rs.getString(t++));
				obligacion.setDireccionDomicilio(rs.getString(t++));
				obligacion.setDescripcionDomicilio(rs.getString(t++));
				obligacion.setDireccionAdicionalDomicilio(rs.getString(t++));
				obligacion.setDepartamento(rs.getString(t++));
				obligacion.setProvincia(rs.getString(t++));
				obligacion.setDistrito(rs.getString(t++));
				obligacion.setDireccionBantotal(rs.getString(t++));
				obligacion.setDepartamentoBantotal(rs.getString(t++));
				obligacion.setProvinciaBantotal(rs.getString(t++));
				obligacion.setDistritoBantotal(rs.getString(t++));
				obligacion.setDireccionNegocio(rs.getString(t++));
				obligacion.setDescripcionDireccionNegocio(rs.getString(t++));
				obligacion.setReferenciaAdicional(rs.getString(t++));
				obligacion.setDepartamentoDireccionNegocio(rs.getString(t++));
				obligacion.setProvinciaDireccionNegocio(rs.getString(t++));
				obligacion.setDistritoDireccionNegocio(rs.getString(t++));
				obligacion.setDireccionNegocioBantotal(rs.getString(t++));
				obligacion.setDepartamentoNegocioBantotal(rs.getString(t++));
				obligacion.setProvinciaNegocioBantotal(rs.getString(t++));
				obligacion.setDistritoNegocioBantotal(rs.getString(t++));
				obligacion.setFechaUltimoPago(rs.getString(t++));
				obligacion.setImporteUltimoPago(rs.getString(t++));
				obligacion.setFechaAbonoACuenta(rs.getString(t++));
				obligacion.setImporteCuentaInterna(rs.getString(t++));
				obligacion.setMoneda(rs.getString(t++));
				obligacion.setSaldoCapitalSoles(rs.getString(t++));
				obligacion.setSaldoCapital(rs.getString(t++));
				obligacion.setCapitalVencido(rs.getString(t++));
				obligacion.setTotalInteses(rs.getString(t++));
				obligacion.setTotalMora(rs.getString(t++));
				obligacion.setCompensatorioTotal(rs.getString(t++));
				obligacion.setTotalCargos(rs.getString(t++));
				obligacion.setImporteITF(rs.getString(t++));				
				obligacion.setDeudaVencida(rs.getString(t++));
				obligacion.setTotalDeuda(rs.getString(t++));
				obligacion.setRangoUIT(rs.getString(t++));		
				obligacion.setNumeroCuotasPagadas(rs.getInt(t++));
				obligacion.setNumeroCuotasVencidas(rs.getInt(t++));
				obligacion.setMontoDesembolsado(rs.getString(t++));
				obligacion.setPlazoCredito(rs.getInt(t++));
				obligacion.setFechaDesembolso(rs.getString(t++));
				obligacion.setTipoRiesgo(rs.getString(t++));
				obligacion.setCodigoFuncionario(rs.getString(t++));
				obligacion.setNombreFuncionario(rs.getString(t++));
				obligacion.setCuentaConConvenio(rs.getString(t++));
				obligacion.setUsuarioCreditoAnterior(rs.getString(t++));
				obligacion.setNumeroEntidadesAdeuda(rs.getInt(t++));
				obligacion.setTerritorialAsignado(rs.getString(t++));
				obligacion.setSupervisorCobranza(rs.getString(t++));
				obligacion.setZonal(rs.getString(t++));
				obligacion.setFamilia(rs.getString(t++));
				obligacion.setProducto(rs.getString(t++));
				obligacion.setFechaUltimoPago2(rs.getString(t++));
				obligacion.setAnocas(rs.getString(t++));
				obligacion.setRiesgo(rs.getString(t++));
				obligacion.setRangoMora(rs.getString(t++));
				obligacion.setCampana(rs.getString(t++));
				obligacion.setEdad(rs.getString(t++));
				
				obligaciones.add(obligacion);

			}
		} catch (SQLException e) {
			logger.error("SQLException Error SQL al tratar de consultarObligacionesPorCliente ObligacionDAO "
					+ " id del registro.... "+Statement.RETURN_GENERATED_KEYS
					+" tabla afectada.... obligacion "+"descripción de evento..."+e);			
			throw new SQLException("SQLException Error SQL al tratar de consultarObligacionesPorCliente ");
		} catch (Exception e) {
			logger.error("Exception Error al tratar de consultarObligacionesPorCliente Clase ObligacionDAO "
					+ "id del registro.... "+Statement.RETURN_GENERATED_KEYS
					+" tabla afectada.... obligacion "+"descripción de evento..."+e);			
			throw new Exception("Exception Error al tratar de consultarObligacionesPorCliente ");
		} finally {
			closeConexion();
			logger.info("finalizo dao ObligacionDAO método consultarObligacionesPorCliente!");
		}
		return obligaciones;
	}

}
