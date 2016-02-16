package rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity;

import java.io.Serializable;

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
@Table(name = "dish")
@NamedQueries({
@NamedQuery(name = "findDishByName", query = "SELECT d FROM Dish d WHERE d.name = :name")
})
public class Dish implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "dish_id", unique = true, nullable = false)
	private Integer id;
	
	@Column(name = "dish_name", unique = false, nullable = false)
	private String name;
	
	@Column(name = "dish_description", unique = false, nullable = false)
	private String description;
	
	@Column(name = "dish_price", unique = false, nullable = false)
	private Float price;
	
	@ManyToOne
	@JoinColumn(name = "restoran_id", referencedColumnName = "restoran_id", nullable = false)
	private Restoran restoran;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

	public Restoran getRestoran() {
		return restoran;
	}

	public void setRestoran(Restoran restoran) {
		this.restoran = restoran;
	}
	
	public Dish() {}
	
	public Dish(String name, String description, Float price, Restoran restoran) {
		super();
		this.name = name;
		this.description = description;
		this.price = price;
		this.restoran = restoran;
	}

	@Override
	public String toString() {
		return "Dish [id=" + id + ", name=" + name + ", description=" + description + ", price=" + price + ", restoran="
				+ restoran + "]";
	}
	
	
}
