package de.giftbox.dao;

import java.util.List;

import de.giftbox.domain.Benutzer;
import de.giftbox.domain.Friend;

public interface FriendDAO {

	public void saveBenutzerFreund(Friend friend);

	public List<Friend> listBenutzerFreund();

	public Friend getBenutzerFreundById(Integer id);

	public Friend findBenutzerFreundByUsername(String name);

	public List<Benutzer> findFriendsByBenutzerId(Integer id);

}