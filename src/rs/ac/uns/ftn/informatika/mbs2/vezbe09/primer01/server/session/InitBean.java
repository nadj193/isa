package rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.session;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.Admin;
import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.Dish;
import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.Gorivo;
import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.Korisnik;
import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.Manager;
import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.Menjac;
import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.Restoran;

@Stateless
@Remote(Init.class)
public class InitBean implements Init {

	@PersistenceContext(unitName = "Vezbe09")
	EntityManager em;
	
	public void init() {
		
		Admin admin = new Admin();
		admin.setName("Admin");
		admin.setLastName("Admin");
		admin.setEmail("admin@gmail.com");
		admin.setPassword("admin");
		em.persist(admin);
		
		Manager manager = new Manager();
		manager.setName("Manager");
		manager.setLastName("Manager");
		manager.setEmail("manager@gmail.com");
		manager.setPassword("manager");
		em.persist(manager);
		
		Restoran restoran = new Restoran();
		restoran.setName("Dva stapica");
		restoran.setDescription("kineski");
		restoran.addManager(manager);
		em.persist(restoran);
		
		Dish dish = new Dish("supa", "kokosija supa", 499.99F, restoran);
		em.persist(dish);
		
		Korisnik korisnik = new Korisnik("Admin", "Admin", "admin", "admin");
		em.persist(korisnik);
		
		Gorivo dizel = new Gorivo();
		dizel.setTipGoriva("Dizel");
		em.persist(dizel);
		
		Gorivo benzin = new Gorivo();
		benzin.setTipGoriva("Benzin");
		em.persist(benzin);
		
		Menjac automatski = new Menjac();
		automatski.setTipMenjaca("Automatski");
		em.persist(automatski);
		
		Menjac rucni = new Menjac();
		rucni.setTipMenjaca("Manuelni");
		em.persist(rucni);
	}
}
