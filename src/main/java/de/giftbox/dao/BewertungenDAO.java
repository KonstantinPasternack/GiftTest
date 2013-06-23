package de.giftbox.dao;

import java.util.List;

import de.giftbox.domain.Bewertungen;

public interface BewertungenDAO {

	public void saveBewertung(Bewertungen bewertungen);

	public List<Bewertungen> listBewertungen();
}