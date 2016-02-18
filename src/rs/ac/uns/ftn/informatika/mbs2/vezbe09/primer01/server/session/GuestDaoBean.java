package rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.session;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.Query;

import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.Guest;

@Stateless
@Local(GuestDaoLocal.class)
public class GuestDaoBean extends GenericDaoBean<Guest, Integer> implements GuestDaoLocal{

	@Override
	public Guest findGuest(String email, String password) {
		Query q = em.createNamedQuery("findGuest");
		q.setParameter("email", email);
		q.setParameter("password", password);
		Guest result = (Guest) q.getSingleResult();
		return result;
	}

	@Override
	public Guest findGuestByEmail(String email) {
		Query q = em.createNamedQuery("findGuestWithEmail");
		q.setParameter("email", email);
		Guest result = (Guest) q.getSingleResult();
		return result;
	}

	@Override
	public List<Guest> findPotencialFriends(Integer id) {
		List<Guest> result = new ArrayList<Guest>();
		List<Guest> allGuests = findAll();
		Guest guest = findById(id);
		for(Guest g : allGuests) {
			if(!guest.getFriends().contains(g)){
				result.add(g);
			}
		}
		return result;
	}

	@Override
	public List<Guest> getFriendsList(Integer id) {
		List<Guest> result = new ArrayList<Guest>();
		List<Guest> allGuests = findAll();
		Guest guest = findById(id);
		for(Guest g : allGuests) {
			if(guest.getFriends().contains(g)){
				result.add(g);
			}
		}
		return result;
	}
}
