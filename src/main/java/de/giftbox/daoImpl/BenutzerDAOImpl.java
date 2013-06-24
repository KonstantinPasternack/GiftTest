package de.giftbox.daoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import de.giftbox.dao.BenutzerDAO;
import de.giftbox.domain.Benutzer;

@Repository
public class BenutzerDAOImpl implements BenutzerDAO {

	private static final Logger log = LoggerFactory
			.getLogger(BenutzerDAOImpl.class);

	@Autowired
	SessionFactory sessionFactory;

	// Methode, die einen Benutzer speichert
	@Transactional
	public void saveBenutzer(Benutzer benutzer) {
		sessionFactory.getCurrentSession().saveOrUpdate(benutzer);
		// hibernateTemplate.saveOrUpdate(benutzer);
	}

	// Methode, die einen Benutzer ueber eine ID zurueckliefert
	@Transactional
	public Benutzer getBenutzerById(Integer id) {
		log.debug("Getting Benutzer with ID: " + id);

		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<Benutzer> b = session.createCriteria(Benutzer.class)
				.add(Restrictions.eq("id_Benutzer", id)).list();

		if (b.size()>0){
			return b.get(0);
		}
		else {
			Benutzer ben = new Benutzer();
			ben.setId_Benutzer(-1);
			ben.setEmail("");
			ben.setUsername("");
			ben.setKommentar("");
			return ben;
		}
	}

	// Methode, die einen Benutzer ueber einen Usernamen zurueckliefert
	@Transactional
	public Benutzer findBenutzerByUsername(String username) {
		Session session = sessionFactory.getCurrentSession();
		//
		@SuppressWarnings("unchecked")
		List<Benutzer> b = session.createCriteria(Benutzer.class)
				.add(Restrictions.eq("username", username)).list();

		if (b.size()>0){
			return b.get(0);
		}
		else {
			Benutzer ben = new Benutzer();
			ben.setId_Benutzer(-1);
			ben.setEmail("");
			ben.setUsername("");
			ben.setKommentar("");
			return ben;
		}
	}

	// Methode, die eine Liste von allen Benutzer zurueckliefert
	@SuppressWarnings("unchecked")
	@Transactional
	public List<Benutzer> listBenutzer() {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Benutzer.class);
		// criteria.add(Restrictions.eq("name", "blabla"));
		return criteria.list();
		// TODO Methode umschreiben
	}

}
