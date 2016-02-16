package rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.session;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.Query;

import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.Admin;

@Stateless
@Local(AdminDaoLocal.class)
public class AdminDaoBean extends GenericDaoBean<Admin, Integer> implements AdminDaoLocal {

	@Override
	public Admin findAdmin(String email, String password) {
		Query q = em.createNamedQuery("findAdmin");
		q.setParameter("email", email);
		q.setParameter("password", password);
		Admin result = (Admin) q.getSingleResult();
		return result;
	}

	@Override
	public Admin findAdminByEmail(String email) {
		Query q = em.createNamedQuery("findAdminWithEmail");
		q.setParameter("email", email);
		Admin result = (Admin) q.getSingleResult();
		return result;
	}
}
