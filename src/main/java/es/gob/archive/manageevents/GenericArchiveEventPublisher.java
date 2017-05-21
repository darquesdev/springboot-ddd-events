package es.gob.archive.manageevents;

import es.gob.archive.manageevents.persistence.entities.EventosApp;
import es.gob.archive.manageevents.persistence.repositories.EventosAppRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Component;

import es.gob.archive.manageevents.eventos.ArchiveApplicationEvent;

@Component
public class GenericArchiveEventPublisher implements ApplicationEventPublisherAware {

    private static Logger logger = Logger.getLogger(GenericArchiveEventPublisher.class);

    private ApplicationEventPublisher publisher;

	@Autowired 
	private EventosAppRepository repository;
	
	private int evento = 0;
	
	public void setApplicationEventPublisher(ApplicationEventPublisher publisher) {
		this.publisher = publisher;
	}

	public void publish() {
		for(int i=0; i<100; ++i){
			ArchiveApplicationEvent ce = new ArchiveApplicationEvent(this);
			++evento;
			int numeroDeEvento = evento;
			ce.setDescripcion(Integer.toString(numeroDeEvento));
            logger.debug("Antes de enviar "+ce);
			publishEvent(ce);
		}
	}

	public void publishEvent(ArchiveApplicationEvent evento){
		EventosApp eventoBD = new EventosApp();
		eventoBD.setObjetoEvento(evento);

		//TODO por que se guarda 2 veces???
		eventoBD = (EventosApp) repository.save(eventoBD);
		evento.setId(eventoBD.getId());
		publisher.publishEvent(evento);
	}
	
}