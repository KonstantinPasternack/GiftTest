package de.giftbox.dao;

import java.util.List;

import de.giftbox.domain.Geschenk;

public interface GeschenkDAO {
	
	public void saveGeschenk(Geschenk geschenk);

	public void deleteGeschenk(Geschenk geschenk);

	public List<Geschenk> listGeschenk();

	public Geschenk getGeschenkById(Integer id);
	
	public Integer getLastAddedGeschenk();

}