package de.giftbox.dao;

import java.util.List;

import de.giftbox.domain.Bewertungen;

public interface BewertungenDAO {

	public void saveBewertung(Bewertungen bewertungen);

	public List<Bewertungen> listBewertungen();
	
	public Bewertungen findBewertungenById(Integer id);
	
	public Double findAvgBewertungByGeschenkId(Integer id);
	
	public List<Bewertungen> findBewertungenByUserId(Integer id);
}