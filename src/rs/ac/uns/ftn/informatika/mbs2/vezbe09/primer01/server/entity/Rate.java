package rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "rate")
@NamedQueries({
@NamedQuery(name = "findGuestRate", query = "SELECT r FROM Rate r WHERE r.guest.id = :guest_id")
})
public class Rate {
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "rate_id", unique = true, nullable = false)
	private Integer id;
	
	@Column(name = "value", unique = false, nullable = false)
	private Integer value;
	
	@ManyToOne
	@JoinColumn(name = "restoran_id", referencedColumnName = "restoran_id", nullable = false)
	private Restoran restoran;
	
	@ManyToOne
	@JoinColumn(name = "guest_id", referencedColumnName = "user_id", nullable = false)
	private Guest guest;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getValue() {
		return value;
	}

	public void setValue(Integer value) {
		this.value = value;
	}

	public Restoran getRestoran() {
		return restoran;
	}

	public void setRestoran(Restoran restoran) {
		this.restoran = restoran;
	}

	public Guest getGuest() {
		return guest;
	}

	public void setGuest(Guest guest) {
		this.guest = guest;
	}
	
	public Rate(){}
	
	public Rate(Integer value, Restoran restoran, Guest guest) {
		super();
		this.value = value;
		this.restoran = restoran;
		this.guest = guest;
	}
}
