package rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.session;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.Query;

import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.Manager;

@Stateless
@Local(ManagerDaoLocal.class)
public class ManagerDaoBean extends GenericDaoBean<Manager, Integer> implements ManagerDaoLocal{

	@Override
	public Manager findManager(String email, String password) {
		Query q = em.createNamedQuery("findManager");
		q.setParameter("email", email);
		q.setParameter("password", password);
		Manager result = (Manager) q.getSingleResult();
		return result;
	}

	@Override
	public Manager findManagerByEmail(String email) {
		Query q = em.createNamedQuery("findManagerWithEmail");
		q.setParameter("email", email);
		Manager result = (Manager) q.getSingleResult();
		return result;
	}

}
