package rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.session;

import java.util.Date;

import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.Admin;
import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.Dish;
import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.Guest;
import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.Manager;
import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.Rate;
import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.Reservation;
import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.Restoran;
import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.RestoranTable;

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
		restoran.setDistance(100 + (int)(Math.random() * ((2000 - 100) + 1)));
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
		
		Guest guest3 = new Guest();
		guest3.setName("Mika");
		guest3.setLastName("Mikic");
		guest3.setEmail("mika@gmail.com");
		guest3.setPassword("mika");
		guest3.setAdress("Stevana Gudurica 26, Irig");
		em.persist(guest3);
		
		Rate ocena = new Rate();
		ocena.setValue(4);
		ocena.setRestoran(restoran);
		ocena.setGuest(guest3);
		em.persist(ocena);
		
		Rate ocena2 = new Rate();
		ocena2.setValue(5);
		ocena2.setRestoran(restoran);
		ocena2.setGuest(guest2);
		em.persist(ocena2);
		
		RestoranTable table = new RestoranTable();
		table.setColumn(1);
		table.setRow(1);
		table.setIsReserved(false);
		table.setOrdinal(1);
		table.setRestoran(restoran);
		em.persist(table);
		
		RestoranTable table1 = new RestoranTable();
		table1.setColumn(4);
		table1.setRow(2);
		table1.setIsReserved(false);
		table1.setOrdinal(1);
		table1.setRestoran(restoran);;
		em.persist(table1);
		
		Reservation reservation = new Reservation();
		reservation.setDate(new Date());
		reservation.setDuration(1);
		reservation.addGuest(guest);
		reservation.addGuest(guest3);
		reservation.addGuest(guest2);
		reservation.addTable(table);
		em.persist(reservation);
		
		Reservation reservation1 = new Reservation();
		reservation1.setDate(new Date());
		reservation1.setDuration(2);
		reservation1.addGuest(guest2);
		reservation1.addGuest(guest3);
		reservation.addTable(table1);
		em.persist(reservation1);
	}
}
