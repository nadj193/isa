package rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="manager")
@NamedQueries({
@NamedQuery(name = "findManager", query = "SELECT m FROM Manager m WHERE m.email = :email and m.password = :password"),
@NamedQuery(name = "findManagerWithEmail", query = "SELECT m FROM Manager m WHERE m.email = :email")
})
public class Manager extends User implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@ManyToOne
	@JoinColumn(name = "restoran_id", referencedColumnName = "restoran_id", nullable = false)
	private Restoran restoran;

	public Restoran getRestoran() {
		return restoran;
	}

	public void setRestoran(Restoran restoran) {
		this.restoran = restoran;
	}

	public Manager() {}
	
	public Manager(String name, String lastName, String email, String password) {
		super(name, lastName, email, password);
	}
	
	public Manager(Restoran restoran) {
		super();
		this.restoran = restoran;
	}

	@Override
	public String toString() {
		return "Manager [restoran=" + restoran + "]";
	}
	
}
