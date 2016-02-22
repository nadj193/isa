package rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "reservation")
public class Reservation implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "reservation_id", unique = true, nullable = false)
	private Integer id;
	
	@Column(name = "reservation_date", unique = false, nullable = false)
	private Date date;
	
	@Column(name= "reservation_duration", unique = false, nullable = false)
	private Integer duration;
	
	@ManyToMany(fetch = FetchType.EAGER, mappedBy="reservations")
	private Set<Guest> guests = new HashSet<Guest>();
	
	@ManyToMany(cascade = {ALL}, fetch = FetchType.EAGER)
	@JoinTable(
		      name="tableReservation",
		      joinColumns=@JoinColumn(name="reservation", referencedColumnName="reservation_id"),
		      inverseJoinColumns=@JoinColumn(name="restoranTable", referencedColumnName="table_id"))
	private Set<RestoranTable> tables = new HashSet<RestoranTable>();
	
	public void addGuest(Guest g) {
		if (g.getReservations() != null) {
			g.getReservations().add(this);
		}
		guests.add(g);
	}
	
	public void removeGuest(Guest g) {
		Iterator<Guest> iter = guests.iterator();
		while(iter.hasNext()) {
			Guest guest = iter.next();
			if(guest.getId().intValue() == g.getId().intValue()) {
				iter.remove();
			}
		}
		
		Iterator<Reservation> iter1 = g.getReservations().iterator();
		while(iter1.hasNext()) {
			Reservation reservation = iter1.next();
			if(reservation.getId().intValue() == this.id.intValue()) {
				iter1.remove();
			}
		}
	}
	
	public void addTable(RestoranTable t) {
		if (t.getReservations() != null)
			t.getReservations().add(this);
		tables.add(t);
	}

	public void removeTable(RestoranTable t) {
		Iterator<RestoranTable> iter = tables.iterator();
		while(iter.hasNext()) {
			RestoranTable table = iter.next();
			if(table.getId().intValue() == t.getId().intValue()) {
				iter.remove();
			}
		}
		
		Iterator<Reservation> iter1 = t.getReservations().iterator();
		while(iter1.hasNext()) {
			Reservation reservation = iter1.next();
			if(reservation.getId().intValue() == this.id.intValue()) {
				iter1.remove();
			}
		}
		t.setReservation(null);
		tables.remove(t);
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Integer getDuration() {
		return duration;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	public Set<Guest> getGuests() {
		return guests;
	}

	public void setGuests(Set<Guest> guests) {
		this.guests = guests;
	}

	public Set<RestoranTable> getTables() {
		return tables;
	}

	public void setTables(Set<RestoranTable> tables) {
		this.tables = tables;
	}
	
	public Reservation(){}
	
	public Reservation(Date date, Integer duration, Set<Guest> guests, Set<RestoranTable> tables) {
		super();
		this.date = date;
		this.duration = duration;
		this.guests = guests;
		this.tables = tables;
	}

	@Override
	public String toString() {
		return "Reservation [id=" + id + ", date=" + date + ", duration=" + duration + ", guests=" + guests
				+ ", tables=" + tables + "]";
	}
	
	
}
