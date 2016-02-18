package rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="guest")
@NamedQueries({
@NamedQuery(name = "findGuest", query = "SELECT g FROM Guest g WHERE g.email = :email and g.password = :password"),
@NamedQuery(name = "findGuestWithEmail", query = "SELECT g FROM Guest g WHERE g.email = :email")
})
public class Guest extends User implements Serializable{

	private static final long serialVersionUID = 1L;
	
	public Guest() {}

	public Guest(String name, String lastName, String email, String password) {
		super(name, lastName, email, password);
	}
	
	
	

}
