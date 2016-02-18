package rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name="restoranTable")
@NamedQueries({
@NamedQuery(name = "findRestoranTableConfiguration", query = "SELECT t FROM RestoranTable t WHERE t.restoran.id = :restoran_id")
})
public class RestoranTable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "table_id", unique = true, nullable = false)
	private Integer id;
	
	@Column(name = "table_row", unique = false, nullable = false)
	private Integer row;
	
	@Column(name = "table_column", unique = false, nullable = false)
	private Integer column;
	
	@Column(name = "table_reserved", unique = false, nullable = false)
	private Boolean isReserved;
	
	@Column(name = "table_ordinal", unique = false, nullable = false)
	private Integer ordinal;
	
	@ManyToOne
	@JoinColumn(name = "restoran_id", referencedColumnName = "restoran_id", nullable = false)
	private Restoran restoran;
	
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

	public Boolean getIsReserved() {
		return isReserved;
	}

	public void setIsReserved(Boolean isReserved) {
		this.isReserved = isReserved;
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

	public RestoranTable(){}
	
	public RestoranTable(Integer row, Integer column, Boolean isReserved, Integer ordinal) {
		super();
		this.row = row;
		this.column = column;
		this.isReserved = isReserved;
		this.ordinal = ordinal;
	}

	@Override
	public String toString() {
		return "RestoranTable [id=" + id + ", row=" + row + ", column=" + column + ", isReserved=" + isReserved
				+ ", ordinal=" + ordinal + "]";
	}
	
	
}
