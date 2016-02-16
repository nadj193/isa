package rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
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
	
	//TODO add jelo, ocena, konfiguracija stolova 
	
	public void add(Manager m) {
		if (m.getRestoran() != null)
			m.getRestoran().getManagers().remove(m);
		m.setRestoran(this);
		managers.add(m);
	}

	public void remove(Manager m) {
		m.setRestoran(null);
		managers.remove(m);
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
	
	public Restoran() {}
	
	public Restoran(String name, String description, Set<Manager> managers) {
		super();
		this.name = name;
		this.description = description;
		this.managers = managers;
	}

	@Override
	public String toString() {
		return "Restoran [id=" + id + ", name=" + name + ", description=" + description + ", managers=" + managers
				+ "]";
	}
	
}
