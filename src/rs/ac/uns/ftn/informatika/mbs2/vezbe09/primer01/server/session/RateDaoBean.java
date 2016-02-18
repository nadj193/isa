package rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.session;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.Query;

import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.Guest;
import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.Rate;

@Stateless
@Local(RateDaoLocal.class)
public class RateDaoBean extends GenericDaoBean<Rate, Integer> implements RateDaoLocal{

	@Override
	public float getRestoranRate(Integer restoranId) {
		List<Rate> rates = findAll();
		int counter = 0;
		int sum = 0;
		for(Rate r : rates) {
			if (r.getRestoran().getId().intValue() == restoranId.intValue()) {
				sum += r.getValue();
				counter++;
			}
		}
		return sum/counter;
	}

	@Override
	public float getAverageRateByFriends(Integer restoranId, Integer guestId) {
		List<Rate> rates = findAll();
		int counter = 0;
		int sum = 0;
		for(Rate r : rates) {
			if (r.getRestoran().getId().intValue() == restoranId.intValue() && r.getGuest().getId().intValue() == guestId.intValue()) {
				for (Guest g : r.getGuest().getFriends()) {
					for(Rate r1 : g.getRestoranRates()) {
						if (r1.getRestoran().getId().intValue() == restoranId.intValue()) {
							sum += r1.getValue();
							counter++;
						}
					}
				}
			}	
		}
		return sum/counter;
	}

	@Override
	public int getRateByGuest(Integer guestId) {
		Query q = em.createNamedQuery("findGuestRate");
		q.setParameter("guest_id", guestId);
		Rate result = (Rate)q.getSingleResult();
		return result.getValue();
	}
	

}
