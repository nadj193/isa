package rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.session;

import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.Manager;

public interface ManagerDaoLocal extends GenericDaoLocal<Manager, Integer>{
	
	public Manager findManager(String email, String password);
	
	public Manager findManagerByEmail(String email);

}
