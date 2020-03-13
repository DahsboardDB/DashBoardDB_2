package co.sistemcobro.dashboarddb.ejb;

import java.util.List;

import javax.ejb.Local;

import co.sistemcobro.dashboarddb.bean.Memo;

@Local
public interface IMemoEJBLocal {
	
	public List<Memo> consultarMemo(String numeroDocumento) throws Exception;

}
