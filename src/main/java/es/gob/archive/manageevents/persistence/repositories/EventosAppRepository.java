package es.gob.archive.manageevents.persistence.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import es.gob.archive.manageevents.persistence.entities.EventosApp;

public interface EventosAppRepository extends JpaRepository<EventosApp, Long> {

}
