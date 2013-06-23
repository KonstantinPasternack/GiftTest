package de.giftbox.dao;

import java.util.List;

import de.giftbox.domain.Geschenkliste;

public interface GeschenklisteDAO {
	
	public void saveGeschenkliste(Geschenkliste geschenkliste);

	public void deleteGeschenkliste(Geschenkliste geschenkliste);

	public List<Geschenkliste> listGeschenkliste();
}