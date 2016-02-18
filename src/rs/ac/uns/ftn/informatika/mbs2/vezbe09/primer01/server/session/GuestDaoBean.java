package rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.session;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.Query;

import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.Admin;
import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.Guest;

@Stateless
@Local(GuestDaoLocal.class)
public class GuestDaoBean extends GenericDaoBean<Guest, Integer> implements GuestDaoLocal{

	@Override
	public Guest findGuest(String email, String password) {
		// TODO Auto-generated method stub
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

}
