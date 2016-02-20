package rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.session;

import java.util.List;

import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.Guest;
import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.Reservation;

public interface ReservationDaoLocal extends GenericDaoLocal<Reservation, Integer>{
	
	public List<Reservation> getMyReservations(Integer guestId);

	public List<Guest> getFriendByReservation(Integer reservationId, Integer guestId);
}
