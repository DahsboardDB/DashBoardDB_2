package co.sistemcobro.dashboarddb.ejb;

import java.util.List;

import javax.ejb.Local;

import co.sistemcobro.dashboarddb.bean.Agenda;

@Local
public interface IAgendaEJBLocal {
	
	public Integer idAgenda() throws Exception;
	
	public Integer insertarAgenda(Agenda agenda) throws Exception;

	public List<Agenda> agendasPorDocumento() throws Exception;
	
	public Integer actualizarEstadoAgenda(Integer idAgenda, Integer idUsuarioMod) throws Exception;

}
