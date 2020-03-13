package co.sistemcobro.dashboarddb.ejb.impl;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

import co.sistemcobro.dashboarddb.bean.Acuerdo;
import co.sistemcobro.dashboarddb.bean.Memo;
import co.sistemcobro.dashboarddb.dao.AcuerdoDAO;
import co.sistemcobro.dashboarddb.dao.MemoDAO;
import co.sistemcobro.dashboarddb.ejb.IMemoEJBLocal;

@Stateless(name = "MemoEJB")
public class MemoEJB extends BaseEJB implements IMemoEJBLocal {

	@Override
	public List<Memo> consultarMemo(String numeroDocumento) throws Exception {
		MemoDAO memoDAO = new MemoDAO(dc_dashboard);
		AcuerdoDAO acuerdoDAO = new AcuerdoDAO(dc_dashboard);
		List<Memo> memos2 = new ArrayList<>();
		List<Memo> memos = memoDAO.consultarMemo(numeroDocumento);
		List<Acuerdo> cuotasAcuerdosPorGestion = new ArrayList<>();
		for (Memo g : memos) {
			cuotasAcuerdosPorGestion = acuerdoDAO.cuotasAcuerdosPorGestion(g.getIdGestion());
			g.setAcuerdos(cuotasAcuerdosPorGestion);
			memos2.add(g);
		}
		
		return memos2;
	}

}
