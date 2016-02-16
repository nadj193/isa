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
		restoran.setDescription("Dobro dosli u kucu tradicionalne kineske kuhinje.Restoran brze hrane 2 stapica se nalazi u Novom Sadu, na novoj adresi u ulici Vase Stajica 27. Autenticnost nase kuhinje cine kineski kuvari N'Jang Hantian i Yu Hongbo koji su pristigli iz Liaoninga na preporuku proslavljenog kineskog kuvara, popularnog u beogradskim restoranima, maestra Manga. On ih je poducio kako da kineska jela prilagode nasem ukusu i da pritom ne izgube sustinska svojstva. Na meniju su piletina, svinjetina, teletina, riba u raznim kombinacijama, sa kikirikijem, bambusom i kineskim pecurkama, u sosu od ostriga, kariju, ljutom secuan sosu i mnogim drugim. Sluze se i plodovi mora, salate, supe, rolnice i pohovane banane, ananas i jabuke s cokoladom ili medom.");
		restoran.addManager(manager);
		em.persist(restoran);
		
		Dish dish = new Dish();
		dish.setName("supa");
		dish.setDescription("kokosija supa");
		dish.setPrice(499.99F); 
		dish.setRestoran(restoran);
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
