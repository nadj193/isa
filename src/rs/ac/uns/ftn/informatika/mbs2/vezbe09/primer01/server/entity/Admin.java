package rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="admin")
@NamedQueries({
@NamedQuery(name = "findAdmin", query = "SELECT a FROM Admin a WHERE a.email = :email and a.password = :password"),
@NamedQuery(name = "findAdminWithEmail", query = "SELECT a FROM Admin a WHERE a.email = :email")
})
public class Admin extends User implements Serializable{

	private static final long serialVersionUID = 1L;

	public Admin() {}
	
	public Admin(String name, String lastName, String email, String password) {
		super(name, lastName, email, password);
	}
}
