package co.sistemcobro.dashboarddb.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.faces.model.SelectItem;
import javax.sql.DataSource;

import org.apache.log4j.Logger;

public class BancoDAO extends BaseDAO {

	public BancoDAO(DataSource ds) {
		super(ds);

	}

	private static Logger logger = Logger.getLogger(BancoDAO.class);

	private String SQL_BUSCAR_BANCOS = "select t.identidad,t.nombreentidad from publicar.entidad t "
			+ " inner join publicar.entidad_pais ep on ep.identidad=t.identidad "
			+ " where idpais=2"
			+ " and t.estado=2 order by t.identidad";

	public List<SelectItem> buscarTipificacionesPorGrupo() throws Exception {

		ArrayList<SelectItem> bancos = new ArrayList<>();
		SelectItem banco = new SelectItem();

		try {
			con = ds.getConnection();
			ps = con.prepareStatement(SQL_BUSCAR_BANCOS);

			rs = ps.executeQuery();
			int t = 1;
			while (rs.next()) {
				t = 1;
				banco = new SelectItem();
				banco.setValue(rs.getInt(t++));
				banco.setLabel(rs.getString(t));
				
				bancos.add(banco);

			}
		} catch (SQLException e) {
			logger.error("Error SQL al tratar de leer  los bancos", e);
			throw new Exception("Error SQL al tratar de leer  los bancos", e);
		} catch (Exception e) {
			logger.error("Error al tratar de leer  los bancos", e);
			throw new Exception("Error al tratar de leer  los bancos: ", e);
		} finally {
			closeConexion();
			logger.info("finalizo dao!");
		}
		return bancos;
	}

}
