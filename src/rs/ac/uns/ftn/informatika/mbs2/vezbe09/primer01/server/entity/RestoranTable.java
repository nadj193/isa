package rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="restoranTable")
@NamedQueries({
@NamedQuery(name = "findRestoranTableConfiguration", query = "SELECT t FROM RestoranTable t WHERE t.restoran.id = :restoran_id")
})
public class RestoranTable implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "table_id", unique = true, nullable = false)
	private Integer id;
	
	@Column(name = "table_row", unique = false, nullable = false)
	private Integer row;
	
	@Column(name = "table_column", unique = false, nullable = false)
	private Integer column;
	
	@Column(name = "table_ordinal", unique = false, nullable = false)
	private Integer ordinal;
	
	@ManyToOne
	@JoinColumn(name = "restoran_id", referencedColumnName = "restoran_id", nullable = false)
	private Restoran restoran;
	
	@ManyToMany(fetch = FetchType.EAGER, mappedBy="tables")
	private Set<Reservation> reservations = new HashSet<Reservation>();
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getRow() {
		return row;
	}

	public void setRow(Integer row) {
		this.row = row;
	}

	public Integer getColumn() {
		return column;
	}

	public void setColumn(Integer column) {
		this.column = column;
	}

	public Integer getOrdinal() {
		return ordinal;
	}

	public void setOrdinal(Integer ordinal) {
		this.ordinal = ordinal;
	}
	
	public Restoran getRestoran() {
		return restoran;
	}

	public void setRestoran(Restoran restoran) {
		this.restoran = restoran;
	}
	
	public Set<Reservation> getReservations() {
		return reservations;
	}

	public void setReservation(Set<Reservation> reservations) {
		this.reservations = reservations;
	}

	public RestoranTable(){}
	
	public RestoranTable(Integer row, Integer column, Integer ordinal, Restoran restoran,
			Set<Reservation> reservations) {
		super();
		this.row = row;
		this.column = column;
		this.ordinal = ordinal;
		this.restoran = restoran;
		this.reservations = reservations;
	}

	@Override
	public String toString() {
		return "RestoranTable [id=" + id + ", row=" + row + ", column=" + column
				+ ", ordinal=" + ordinal + "]";
	}
	
	
}
