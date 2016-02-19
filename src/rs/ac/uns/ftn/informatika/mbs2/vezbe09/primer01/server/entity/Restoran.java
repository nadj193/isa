package rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "restoran")
public class Restoran implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "restoran_id", unique = true, nullable = false)
	private Integer id;
	
	@Column(name = "restoran_name", unique = false, nullable = false)
	private String name;
	
	@Column(name = "restoran_description", unique = false, nullable = false)
	private String description;
	
	@OneToMany(cascade = { ALL }, fetch = LAZY, mappedBy = "restoran")
	private Set<Manager> managers = new HashSet<Manager>();
	
	@OneToMany(cascade = { ALL }, fetch = LAZY, mappedBy = "restoran")
	private Set<Dish> menu = new HashSet<Dish>();
	
	@OneToMany(cascade = {ALL}, fetch = LAZY, mappedBy = "restoran")
	private Set<RestoranTable> tableConfiguration = new HashSet<RestoranTable>();
	
	@OneToMany(cascade = {ALL}, fetch = FetchType.EAGER, mappedBy = "restoran")
	private Set<Rate> rating = new HashSet<Rate>(); 
	
	@Column(name = "restoran_distance", unique = false, nullable = true)
	private int distance;
	
	public void addManager(Manager m) {
		if (m.getRestoran() != null)
			m.getRestoran().getManagers().remove(m);
		m.setRestoran(this);
		managers.add(m);
	}

	public void removeManager(Manager m) {
		m.setRestoran(null);
		managers.remove(m);
	}
	
	public void addDish(Dish d) {
		if (d.getRestoran() != null)
			d.getRestoran().getMenu().remove(d);
		d.setRestoran(this);
		menu.add(d);
	}

	public void removeDish(Dish d) {
		d.setRestoran(null);
		menu.remove(d);
	}
	
	public void addTable(RestoranTable t) {
		if (t.getRestoran() != null)
			t.getRestoran().getTableConfiguration().remove(t);
		t.setRestoran(this);
		tableConfiguration.add(t);
	}

	public void removeTable(RestoranTable t) {
		t.setRestoran(null);
		tableConfiguration.remove(t);
	}
	
	public void addRate(Rate r) {
		if (r.getRestoran() != null)
			r.getRestoran().getRating().remove(r);
		r.setRestoran(this);
		rating.add(r);
	}

	public void removeRate(Rate r) {
		r.setRestoran(null);
		rating.remove(r);
	}
	
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

	public Set<Manager> getManagers() {
		return managers;
	}

	public void setManagers(Set<Manager> managers) {
		this.managers = managers;
	}
	
	public Set<Dish> getMenu() {
		return menu;
	}

	public void setMenu(Set<Dish> menu) {
		this.menu = menu;
	}
	
	
	public Set<RestoranTable> getTableConfiguration() {
		return tableConfiguration;
	}

	public void setTableConfiguration(Set<RestoranTable> tableConfiguration) {
		this.tableConfiguration = tableConfiguration;
	}
	
	public Set<Rate> getRating() {
		return rating;
	}

	public void setRating(Set<Rate> rating) {
		this.rating = rating;
	}
	
	public int getDistance() {
		return distance;
	}
	
	public void setDistance(int distance) {
		this.distance = distance;
	}
	
	public float getAverageRate() {
		int counter = 0;
		int sum = 0;
		for(Rate r : rating) {
			sum += r.getValue();
			counter++;
		}
		if (counter == 0) {
			return 0;
		}
		return (float)sum/counter;
	}
	
	public float getAverageRateByGuestAndFriends(Integer guestId, Set<Guest> friends) {
		int counter = 0;
		int sum = 0;
		for(Rate r : rating) {
			if(r.getGuest().getId().intValue() == guestId.intValue()){
				sum += r.getValue();
				counter++;
				break;
			}
		}
		
		if (friends != null) {
			for(Rate r : rating) {
				for (Guest g : friends){
					if(r.getGuest().getId().intValue() == g.getId().intValue()) {
						sum+=r.getValue();
						counter++;
					}
				}
			}
		}
		if(counter == 0) {
			return 0;
		}
		return (float)sum/counter;
	}
	
	public Restoran() {}
	
	public Restoran(String name, String description, Set<Manager> managers, Set<Dish> menu) {
		super();
		this.name = name;
		this.description = description;
		this.managers = managers;
		this.menu = menu;
	}

	@Override
	public String toString() {
		return "Restoran [id=" + id + ", name=" + name + ", description=" + description + ", managers=" + managers
				+ "]";
	}
	
}
