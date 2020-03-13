package co.sistemcobro.dashboarddb.ejb.impl;

import java.util.List;

import javax.ejb.Stateless;

import co.sistemcobro.dashboarddb.bean.Agenda;
import co.sistemcobro.dashboarddb.dao.AgendaDAO;
import co.sistemcobro.dashboarddb.ejb.IAgendaEJBLocal;

@Stateless(name = "AgendaEJB")
public class AgendaEJB extends BaseEJB implements IAgendaEJBLocal{

	@Override
	public Integer idAgenda() throws Exception {
		AgendaDAO agendaDAO = new AgendaDAO(dc_dashboard);
		return agendaDAO.idAgenda();
	}

	@Override
	public Integer insertarAgenda(Agenda agenda) throws Exception {
		AgendaDAO agendaDAO = new AgendaDAO(dg_dashboard);
		return agendaDAO.insertarAgenda(agenda);
	}
	
	@Override
	public List<Agenda> agendasPorDocumento() throws Exception {
		AgendaDAO agendaDAO = new AgendaDAO(dc_dashboard);
		return agendaDAO.agendasPorDocumento();
	}

	@Override
	public Integer actualizarEstadoAgenda(Integer idAgenda, Integer idUsuarioMod) throws Exception {
		AgendaDAO agendaDAO = new AgendaDAO(dg_dashboard);
		return agendaDAO.actualizarEstadoAgenda(idAgenda, idUsuarioMod);
	}

}
