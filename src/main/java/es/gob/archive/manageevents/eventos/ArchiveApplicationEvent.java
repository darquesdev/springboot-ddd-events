package es.gob.archive.manageevents.eventos;

import java.io.Serializable;

import org.springframework.context.ApplicationEvent;

public class ArchiveApplicationEvent extends ApplicationEvent implements Serializable{

	private Long id;
	private String descripcion;

    public ArchiveApplicationEvent(Object source) {
        super(source);
    }

    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}
