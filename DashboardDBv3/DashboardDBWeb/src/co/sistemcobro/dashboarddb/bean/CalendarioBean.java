package co.sistemcobro.dashboarddb.bean;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import org.apache.log4j.Logger;
import org.primefaces.event.ScheduleEntryMoveEvent;
import org.primefaces.event.ScheduleEntryResizeEvent;
import org.primefaces.event.SelectEvent;
import org.primefaces.model.DefaultScheduleEvent;
import org.primefaces.model.DefaultScheduleModel;
import org.primefaces.model.ScheduleEvent;
import org.primefaces.model.ScheduleModel;

import co.sistemcobro.dashboarddb.ws.CalendarioWS;
import co.sistemcobro.dashboarddb.constante.Constante;

@ManagedBean(name = "calendarioBean")
@ViewScoped
public class CalendarioBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private ScheduleModel eventModel;

	private ScheduleModel lazyEventModel;
	
	List<FechaCalendarioDTO> festividades;

	private ScheduleEvent event = new DefaultScheduleEvent();
	
	private Logger logger = Logger.getLogger(CalendarioBean.class);

	@PostConstruct
	public void init() {
		festividades = new ArrayList<>();
	}

	public void cargar() {
		CalendarioWS calendarioWS = new CalendarioWS();
		eventModel = new DefaultScheduleModel();

		try {
			festividades = calendarioWS.consultaFestivos(Constante.PAIS);
			
			SimpleDateFormat parseador = new SimpleDateFormat("yyyy-MM-dd HH:mm");
			SimpleDateFormat formateador = new SimpleDateFormat("dd/MM/yyyy HH:mm");

			for (FechaCalendarioDTO e : festividades) {
				String fechaI = e.getFechaFestivo()+" 05:00";
				String fechaF = e.getFechaFestivo()+" 23:59";
				
				Date date1 = parseador.parse(fechaI);
				Date date2 = parseador.parse(fechaF);
				
				String fechaI2 = formateador.format(date1);
				String fechaF2 = formateador.format(date2);
				
				eventModel.addEvent(new DefaultScheduleEvent(e.getObservacion(), formateador.parse(fechaI2), formateador.parse(fechaF2),true));
			}
		} catch (Exception e) {
			logger.error("se presento un error en la consulta de días festivos" + e.getMessage(), e);
		} 
	}

	public ScheduleModel getEventModel() {
		return eventModel;
	}

	public ScheduleModel getLazyEventModel() {
		return lazyEventModel;
	}
	
	public ScheduleEvent getEvent() {
		return event;
	}

	public void setEvent(ScheduleEvent event) {
		this.event = event;
	}

	public void addEvent() {
		if (event.getId() == null)
			eventModel.addEvent(event);
		else
			eventModel.updateEvent(event);
		

		event = new DefaultScheduleEvent();
	}

	public void onEventSelect(SelectEvent selectEvent) {
		event = (ScheduleEvent) selectEvent.getObject();
	}

	public void onDateSelect(SelectEvent selectEvent) {
		event = new DefaultScheduleEvent("", (Date) selectEvent.getObject(), (Date) selectEvent.getObject());
	}

	public void onEventMove(ScheduleEntryMoveEvent event) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Event moved",
				"Day delta:" + event.getDayDelta() + ", Minute delta:" + event.getMinuteDelta());

		addMessage(message);
	}

	public void onEventResize(ScheduleEntryResizeEvent event) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Event resized",
				"Day delta:" + event.getDayDelta() + ", Minute delta:" + event.getMinuteDelta());

		addMessage(message);
	}

	private void addMessage(FacesMessage message) {
		FacesContext.getCurrentInstance().addMessage(null, message);
	}

	public Logger getLogger() {
		return logger;
	}

	public void setLogger(Logger logger) {
		this.logger = logger;
	}

	public void setEventModel(ScheduleModel eventModel) {
		this.eventModel = eventModel;
	}

	public void setLazyEventModel(ScheduleModel lazyEventModel) {
		this.lazyEventModel = lazyEventModel;
	}

	public List<FechaCalendarioDTO> getFestividades() {
		return festividades;
	}

	public void setFestividades(List<FechaCalendarioDTO> festividades) {
		this.festividades = festividades;
	}
	
	
	
	
}
