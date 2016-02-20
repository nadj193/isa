package rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.session;

import javax.ejb.Local;
import javax.ejb.Stateless;

import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.Reservation;

@Stateless
@Local(ReservationDaoLocal.class)
public class ReservationDaoBean extends GenericDaoBean<Reservation, Integer> implements ReservationDaoLocal{

}
