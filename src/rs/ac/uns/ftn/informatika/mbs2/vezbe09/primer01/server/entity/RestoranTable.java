package rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="restoranTable")
public class RestoranTable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "table_id", unique = true, nullable = false)
	private Integer id;
	
	@Column(name = "row", unique = false, nullable = false)
	private Integer row;
	
	@Column(name = "column", unique = false, nullable = false)
	private Integer column;
	
	@Column(name = "reserved", unique = false, nullable = false)
	private Boolean isReserved;
	
	@Column(name = "ordinal", unique = false, nullable = false)
	private Integer ordinal;

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