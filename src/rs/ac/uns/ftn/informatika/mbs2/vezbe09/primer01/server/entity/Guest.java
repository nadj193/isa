package rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.FetchType.LAZY;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="guest")
@NamedQueries({
@NamedQuery(name = "findGuest", query = "SELECT g FROM Guest g WHERE g.email = :email and g.password = :password"),
@NamedQuery(name = "findGuestWithEmail", query = "SELECT g FROM Guest g WHERE g.email = :email")
})
public class Guest extends User implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Column(name = "guest_adress", unique = false, nullable = true)
	private String adress;
	
	@OneToMany(cascade = {ALL}, fetch = LAZY, mappedBy = "guest")
	private Set<Rate> restoranRates = new HashSet<Rate>();
	
	@ManyToMany(cascade = {ALL}, fetch = LAZY)
	@JoinTable(
		      name="friends",
		      joinColumns=@JoinColumn(name="guest1", referencedColumnName="user_id"),
		      inverseJoinColumns=@JoinColumn(name="guest2", referencedColumnName="user_id"))
	private Set<Guest> friends = new HashSet<Guest>();
	
	public void addFriend(Guest g) {
		if (this.friends != null)
			this.friends.remove(g);
		this.friends.add(g);
	}

	public void removeFriend(Guest g) {
		this.friends.remove(g);
	}
	
	public void addRate(Rate r) {
		if (r.getGuest() != null)
			r.getGuest().getRestoranRates().remove(r);
		r.setGuest(this);
		restoranRates.add(r);
	}

	public void removeRate(Rate r) {
		r.setGuest(null);
		restoranRates.remove(r);
	}
	
	public Set<Guest> getFriends() {
		return friends;
	}

	public void setFriends(Set<Guest> friends) {
		this.friends = friends;
	}
	
	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public Set<Rate> getRestoranRates() {
		return restoranRates;
	}

	public void setRestoranRates(Set<Rate> restoranRates) {
		this.restoranRates = restoranRates;
	}

	public Guest() {}

	public Guest(String name, String lastName, String email, String password) {
		super(name, lastName, email, password);
	}

	public Guest(String adress, Set<Guest> friends) {
		super();
		this.adress = adress;
		this.friends = friends;
	}
	
	
	
	
	

}
