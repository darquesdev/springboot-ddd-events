package es.gob.archive.manageevents;

import org.springframework.context.ApplicationListener;
import org.springframework.scheduling.annotation.Async;

import es.gob.archive.manageevents.eventos.ArchiveApplicationEvent;

public abstract class IListenerEventsBean<T extends ArchiveApplicationEvent> implements ApplicationListener<T> {

	public abstract void proccessEvent(T event);
	
	@Async
	public void onApplicationEvent(T event) {
		
		proccessEvent(event);
		
	}

	
}
