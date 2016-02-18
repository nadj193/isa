package rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.session;

import java.util.List;

import rs.ac.uns.ftn.informatika.mbs2.vezbe09.primer01.server.entity.RestoranTable;

public interface RestoranTableDaoLocal extends GenericDaoLocal<RestoranTable, Integer>{

	public List<RestoranTable> findRestoranTableConfiguration(Integer id);
}
