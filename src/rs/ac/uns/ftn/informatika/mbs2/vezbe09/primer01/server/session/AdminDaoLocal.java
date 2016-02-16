package rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.session;

import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.Admin;

public interface AdminDaoLocal extends GenericDaoLocal<Admin, Integer>{
	
	public Admin findAdmin(String email, String password);
	
	public Admin findAdminByEmail(String email);

}
