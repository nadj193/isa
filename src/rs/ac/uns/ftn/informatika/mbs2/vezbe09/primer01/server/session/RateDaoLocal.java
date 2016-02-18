package rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.session;

import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.Rate;

public interface RateDaoLocal extends GenericDaoLocal<Rate, Integer>{

	public float getRestoranRate(Integer restoranId);
	
	public float getAverageRateByFriends(Integer restoranId, Integer guestId);
	
	public int getRateByGuest(Integer guestId);
}
