package es.gob.archive.manageevents.beans;

import java.util.List;

import javax.annotation.PostConstruct;

import es.gob.archive.manageevents.persistence.entities.EventosApp;
import es.gob.archive.manageevents.persistence.repositories.EventosAppRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Component;


@Component
public class RelaunchEventsWhenStartBean implements ApplicationEventPublisherAware {

	private ApplicationEventPublisher publisher;
	
	@Autowired 
	private EventosAppRepository repository;
	
	@PostConstruct
	private void relaunchEvents(){
		List eventosPendientes = repository.findAll();
		for(Object evento : eventosPendientes){
			EventosApp eventoAplicacion = (EventosApp)evento;
			ApplicationEvent eventoEnviar = (ApplicationEvent) eventoAplicacion.getObjetoEvento();
			publisher.publishEvent(eventoEnviar);
		}
	}

	@Override
	public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
		this.publisher = applicationEventPublisher;
	}
	
}
