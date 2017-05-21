package es.gob.archive.manageevents;

import java.util.Calendar;
import java.util.Random;

import org.springframework.stereotype.Component;

import es.gob.archive.manageevents.eventos.ArchiveApplicationEvent;

@Component
public class ListenerEventsBean extends es.gob.archive.manageevents.IListenerEventsBean<ArchiveApplicationEvent> {

	@Override
	public void proccessEvent(ArchiveApplicationEvent event) {
		Calendar c = Calendar.getInstance();
		
		System.out.println(c.getTime()+event.toString());
		
		Random r = new Random();
		
		int espera = Math.abs(r.nextInt()) % 8000;
		
		System.out.println("se demora en procesar "+espera+" "+event);
		
		try {
			Thread.sleep(espera);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		c = Calendar.getInstance();
		
		System.out.println(c.getTime()+" termina el tiempo de espera "+event.toString());
	}
	
}
