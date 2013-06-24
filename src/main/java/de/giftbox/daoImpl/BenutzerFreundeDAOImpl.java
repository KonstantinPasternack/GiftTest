package de.giftbox.daoImpl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import de.giftbox.dao.BenutzerFreundeDAO;
import de.giftbox.domain.Benutzer;
import de.giftbox.domain.BenutzerFreunde;

public class BenutzerFreundeDAOImpl implements BenutzerFreundeDAO {

	private static final Logger log = LoggerFactory
			.getLogger(BenutzerDAOImpl.class);

	@Autowired
	SessionFactory sessionFactory;

	
	@Transactional
	public void saveBenutzerFreund(BenutzerFreunde benutzerFreunde) {
		sessionFactory.getCurrentSession().saveOrUpdate(benutzerFreunde);
	}

	@Transactional
	public List<BenutzerFreunde> listBenutzerFreund() {
		// TODO Auto-generated method stub
		return null;
	}

	@Transactional
	public BenutzerFreunde getBenutzerFreundById(Integer id) {
		log.debug("Getting BenutzerFreund with ID: " + id);

		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<BenutzerFreunde> bf = session.createCriteria(BenutzerFreunde.class)
				.add(Restrictions.eq("id_BenutzerFreund", id)).list();

		return bf.get(0);
	}

	@Transactional
	public BenutzerFreunde findBenutzerFreundByUsername(String name) {
		return null;
	}

}
