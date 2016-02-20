package rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.FetchType.LAZY;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
	
	@ManyToMany(cascade = {ALL}, fetch = FetchType.EAGER)
	@JoinTable(
		      name="friends",
		      joinColumns=@JoinColumn(name="guest1", referencedColumnName="user_id"),
		      inverseJoinColumns=@JoinColumn(name="guest2", referencedColumnName="user_id"))
	private Set<Guest> friends = new HashSet<Guest>();
	
	@ManyToMany(cascade = {ALL}, fetch = FetchType.EAGER)
	@JoinTable(
		      name="guestReservation",
		      joinColumns=@JoinColumn(name="guest", referencedColumnName="user_id"),
		      inverseJoinColumns=@JoinColumn(name="reservation", referencedColumnName="reservation_id"))
	private Set<Reservation> reservations = new HashSet<Reservation>();
		
	public void addFriend(Guest g) {
		if (g.getFriends() != null) {
			g.getFriends().add(this);
		}
		friends.add(g);
	}

	public void removeFriend(Guest g) {
		Iterator<Guest> iter = g.getFriends().iterator();
		while(iter.hasNext()) {
			Guest guest = iter.next();
			if(guest.getId().intValue() == super.getId().intValue()) {
				iter.remove();
			}
		}
		
		Iterator<Guest> iter1 = friends.iterator();
		while(iter1.hasNext()) {
			Guest guest = iter1.next();
			if(guest.getId().intValue() == g.getId().intValue()) {
				iter1.remove();
			}
		}
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

	public Set<Reservation> getReservations() {
		return reservations;
	}

	public void setReservations(Set<Reservation> reservations) {
		this.reservations = reservations;
	}

	public Guest() {}

	public Guest(String name, String lastName, String email, String password) {
		super(name, lastName, email, password);
	}

	public Guest(String adress, Set<Rate> restoranRates, Set<Guest> friends, Set<Reservation> reservations) {
		super();
		this.adress = adress;
		this.restoranRates = restoranRates;
		this.friends = friends;
		this.reservations = reservations;
	}	

}
