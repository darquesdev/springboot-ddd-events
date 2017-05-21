package es.gob.archive.manageevents.persistence.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
public class EventosApp {

    @Id
    @Column(name = "ID")
	@GeneratedValue(generator = "generator", strategy = GenerationType.SEQUENCE)
    private Long id;

    @Basic(optional = false)
    @Lob
    @Column(name = "OBJETO_EVENTO")
    private Serializable objetoEvento;

    public EventosApp() {
    }

    public EventosApp(Long id) {
        this.id = id;
    }

    public EventosApp(Long id, Serializable objetoEvento) {
        this.id = id;
        this.objetoEvento = objetoEvento;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Serializable getObjetoEvento() {
        return objetoEvento;
    }

    public void setObjetoEvento(Serializable objetoEvento) {
        this.objetoEvento = objetoEvento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EventosApp)) {
            return false;
        }
        EventosApp other = (EventosApp) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entidades.EventosApp[ id=" + id + " ]";
    }
    
}
