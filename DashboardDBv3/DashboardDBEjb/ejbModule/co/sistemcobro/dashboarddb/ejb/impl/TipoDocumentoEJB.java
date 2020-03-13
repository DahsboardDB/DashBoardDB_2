package co.sistemcobro.dashboarddb.ejb.impl;

import java.util.List;
import javax.ejb.Stateless;

import co.sistemcobro.dashboarddb.bean.TipoDocumento;
import co.sistemcobro.dashboarddb.dao.TipoDocumentoDAO;
import co.sistemcobro.dashboarddb.ejb.ITipoDocumentoEJBLocal;

@Stateless(name = "TipoDocumentoEJB")
public class TipoDocumentoEJB extends BaseEJB implements ITipoDocumentoEJBLocal {

	@Override
	public List<TipoDocumento> tiposDocumento() throws Exception {
		TipoDocumentoDAO tipoDocumento = new TipoDocumentoDAO(dc_dashboard);
		return tipoDocumento.tiposDocumento();
	}

}
