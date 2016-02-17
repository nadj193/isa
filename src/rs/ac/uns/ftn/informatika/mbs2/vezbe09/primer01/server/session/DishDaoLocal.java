package rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.session;

import java.util.List;

import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.Dish;

public interface DishDaoLocal extends GenericDaoLocal<Dish, Integer>{
	
	public Dish findDishByName(String name);
	
	public List<Dish> findRestoranMenu(Integer id);

}
