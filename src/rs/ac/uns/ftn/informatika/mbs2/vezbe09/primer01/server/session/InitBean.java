package rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.session;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.Admin;
import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.Dish;
import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.Gorivo;
import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.Guest;
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
		restoran.setDescription("kineski restoran");
		restoran.addManager(manager);
		em.persist(restoran);
		
		Dish dish = new Dish();
		dish.setName("supa");
		dish.setDescription("kokosija supa");
		dish.setPrice(499.99F); 
		dish.setRestoran(restoran);
		em.persist(dish);
		
		Guest guest = new Guest();
		guest.setName("Pera");
		guest.setLastName("Peric");
		guest.setEmail("pera@gmail.com");
		guest.setPassword("pera");
		guest.setAdress("Milenka Grcica 35/12, Novi Sad");
		em.persist(guest);
		
		Guest guest2 = new Guest();
		guest2.setName("Zika");
		guest2.setLastName("Zikic");
		guest2.setEmail("zika@gmail.com");
		guest2.setPassword("zika");
		guest2.setAdress("Stevana Gudurica 18, Irig");
		guest2.addFriend(guest);
		em.persist(guest2);
		
		guest.addFriend(guest2);
		em.merge(guest);
		
		
	}
}
