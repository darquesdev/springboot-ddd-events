package es.gob.archive.manageevents.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import es.gob.archive.manageevents.GenericArchiveEventPublisher;

@RestController
public class ControladorPruebaEventos {

	@Autowired
	private GenericArchiveEventPublisher customEventPublisher;
	
	@RequestMapping(value = "/resources/publicarEvento", method = RequestMethod.GET)
    public String publicarEvento(){
		System.out.println("PEPE");
		customEventPublisher.publish();
		return "Hola_20170";
    }
	
}
