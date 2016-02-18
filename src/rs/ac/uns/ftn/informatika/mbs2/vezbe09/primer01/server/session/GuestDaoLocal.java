package rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.session;

import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.Guest;

public interface GuestDaoLocal extends GenericDaoLocal<Guest, Integer>{
	
	public Guest findGuest(String email, String password);
	
	public Guest findGuestByEmail(String email);

}
