package rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
	
	@ManyToOne
	@JoinColumn(name = "guest_id", referencedColumnName = "user_id", nullable = false)
	private Guest guest;
	
	@ManyToOne
	@JoinColumn(name = "restoran_id", referencedColumnName = "restoran_id", nullable = false)
	private Restoran restoran;
	
	@OneToMany(cascade = {ALL}, fetch = FetchType.EAGER, mappedBy = "reservation")
	private Set<RestoranTable> tables = new HashSet<RestoranTable>();
	
	public void addTable(RestoranTable t) {
		if (t.getReservation() != null)
			t.getReservation().getTables().remove(t);
		t.setReservation(this);
		tables.add(t);
	}

	public void removeTable(RestoranTable t) {
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

	public Guest getGuest() {
		return guest;
	}

	public void setGuest(Guest guest) {
		this.guest = guest;
	}

	public Restoran getRestoran() {
		return restoran;
	}

	public void setRestoran(Restoran restoran) {
		this.restoran = restoran;
	}

	public Set<RestoranTable> getTables() {
		return tables;
	}

	public void setTables(Set<RestoranTable> tables) {
		this.tables = tables;
	}
	
	public Reservation(){}
	
	public Reservation(Date date, Integer duration, Guest guest, Restoran restoran, Set<RestoranTable> tables) {
		super();
		this.date = date;
		this.duration = duration;
		this.guest = guest;
		this.restoran = restoran;
		this.tables = tables;
	}

	@Override
	public String toString() {
		return "Reservation [id=" + id + ", date=" + date + ", duration=" + duration + ", guest=" + guest
				+ ", restoran=" + restoran + ", tables=" + tables + "]";
	}
	
	
}
