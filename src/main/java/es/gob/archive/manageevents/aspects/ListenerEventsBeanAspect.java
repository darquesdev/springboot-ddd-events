package es.gob.archive.manageevents.aspects;

import es.gob.archive.manageevents.persistence.repositories.EventosAppRepository;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import es.gob.archive.manageevents.eventos.ArchiveApplicationEvent;

@Component
@Aspect
public class ListenerEventsBeanAspect {
	
	@Autowired 
	private EventosAppRepository repository;
	
	@After("execution(* es.gob.archive.manageevents.IListenerEventsBean.onApplicationEvent(..))")
	public void afterProcessEvent(JoinPoint joinPoint){
		System.out.println("Se ejecuta el after "+joinPoint.getArgs()[0]);
		ArchiveApplicationEvent eventoArchive = (ArchiveApplicationEvent) joinPoint.getArgs()[0];
		Long id = eventoArchive.getId();
		repository.delete(id);
	}

}
