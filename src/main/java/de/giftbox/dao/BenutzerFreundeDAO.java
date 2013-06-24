package de.giftbox.dao;

import java.util.List;

import de.giftbox.domain.BenutzerFreunde;

public interface BenutzerFreundeDAO {

	public void saveBenutzerFreund(BenutzerFreunde benutzerFreunde);

	public List<BenutzerFreunde> listBenutzerFreund();

	public BenutzerFreunde getBenutzerFreundById(Integer id);

	public BenutzerFreunde findBenutzerFreundByUsername(String name);

}