package rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.session;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.Query;

import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.Dish;

@Stateless
@Local(DishDaoLocal.class)
public class DishDaoBean extends GenericDaoBean<Dish, Integer> implements DishDaoLocal{

	@Override
	public Dish findDishByName(String name) {
		Query query = em.createNamedQuery("findDishByName");
		query.setParameter("name", name);
		Dish result = (Dish) query.getSingleResult();
		return result;
	}
}
