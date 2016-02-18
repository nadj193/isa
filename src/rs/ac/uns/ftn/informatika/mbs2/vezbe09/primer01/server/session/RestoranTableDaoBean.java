package rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.session;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.persistence.Query;

import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.RestoranTable;

@Stateless
@Local(RestoranTableDaoLocal.class)
public class RestoranTableDaoBean extends GenericDaoBean<RestoranTable, Integer> implements RestoranTableDaoLocal{

	@Override
	public List<RestoranTable> findRestoranTableConfiguration(Integer id) {
		Query query = em.createNamedQuery("findRestoranTableConfiguration");
		query.setParameter("restoran_id", id);
		@SuppressWarnings("unchecked")
		List<RestoranTable> result = (List<RestoranTable>) query.getResultList();
		return result;
	}
}
