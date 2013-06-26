package de.giftbox.dao;

import java.util.List;

import de.giftbox.domain.Geschenk;
import de.giftbox.domain.GeschenkInListe;

public interface GeschenkDAO {
	
	public void saveGeschenk(Geschenk geschenk);

	public void deleteGeschenk(Geschenk geschenk);

	public List<Geschenk> listGeschenk();

	public Geschenk getGeschenkById(Integer id);
	
	public Integer getLastAddedGeschenk();

	public void saveGeschenkInListe(GeschenkInListe geschenk);

}