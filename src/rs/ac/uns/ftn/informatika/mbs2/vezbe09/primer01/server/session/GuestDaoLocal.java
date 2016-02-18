package rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.session;

import java.util.List;

import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.Guest;

public interface GuestDaoLocal extends GenericDaoLocal<Guest, Integer>{
	
	public Guest findGuest(String email, String password);
	
	public Guest findGuestByEmail(String email);
	
	public List<Guest> findPotencialFriends(Integer id);

}
