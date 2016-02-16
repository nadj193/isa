package rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.session;

import javax.ejb.Local;
import javax.ejb.Stateless;

import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.Manager;

@Stateless
@Local(ManagerDaoLocal.class)
public class ManagerDaoBean extends GenericDaoBean<Manager, Integer> implements ManagerDaoLocal{

}
