package rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.session;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;

import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.Guest;
import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.Reservation;

@Stateless
@Local(ReservationDaoLocal.class)
public class ReservationDaoBean extends GenericDaoBean<Reservation, Integer> implements ReservationDaoLocal{

	@Override
	public List<Reservation> getMyReservations(Integer guestId) {
		List<Reservation> result = new ArrayList<Reservation>();
		List<Reservation> reservations = findAll();
		for(Reservation r : reservations) {
			for(Guest g : r.getGuests()) {
				if (g.getId().intValue() == guestId) {
					result.add(r);
					break;
				}
			}
		}
		return result;
	}

	@Override
	public List<Guest> getFriendByReservation(Integer reservationId, Integer guestId) {
		List<Guest> result = new ArrayList<Guest>();
		Reservation reservation = findById(reservationId);
		for(Guest g : reservation.getGuests()) {
			if (g.getId().intValue() != guestId) {
				result.add(g);
			}
		}
		return result;
	}
}
