package de.giftbox.daoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import de.giftbox.dao.FriendDAO;
import de.giftbox.domain.Benutzer;
import de.giftbox.domain.Friend;

public class FriendDAOImpl implements FriendDAO {

	private static final Logger log = LoggerFactory
			.getLogger(BenutzerDAOImpl.class);

	@Autowired
	SessionFactory sessionFactory;

	@Transactional
	public void saveBenutzerFreund(Friend friend) {
		sessionFactory.getCurrentSession().saveOrUpdate(friend);
	}

	@Transactional
	public List<Friend> listBenutzerFreund() {
		// TODO Auto-generated method stub
		return null;
	}

	@Transactional
	public Friend getBenutzerFreundById(Integer id) {
		log.debug("Getting BenutzerFreund with ID: " + id);

		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<Friend> bf = session.createCriteria(Friend.class)
				.add(Restrictions.eq("id_BenutzerFreund", id)).list();

		return bf.get(0);
	}

	@Transactional
	public Friend findBenutzerFreundByUsername(String name) {
		return null;
	}

	@Transactional
	public List<Benutzer> findFriendsByBenutzerId(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		String sql = "SELECT b.* FROM benutzer b JOIN friend f ON b.id_Benutzer = f.benutzerFreund_fk WHERE f.benutzer_fk = "
				+ id;
		Query query = session.createSQLQuery(sql).addEntity(Benutzer.class);

		@SuppressWarnings("unchecked")
		List<Benutzer> listb = query.list();
		return listb;

	}
}
