package de.giftbox.daoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import de.giftbox.dao.GeschenklisteDAO;
import de.giftbox.domain.Geschenkliste;

public class GeschenklisteDAOImpl implements GeschenklisteDAO {

	private static final Logger log = LoggerFactory
			.getLogger(GeschenklisteDAOImpl.class);

	@Autowired
	SessionFactory sessionFactory;
	
	@Transactional
	public void saveGeschenkliste(Geschenkliste geschenkliste) {
		sessionFactory.getCurrentSession().save(geschenkliste);
	}

	@Override
	public void deleteGeschenkliste(Geschenkliste geschenkliste) {
		//hibernateTemplate.delete(geschenkliste);
	}

	@Override
	@Transactional
	@SuppressWarnings("unchecked")
	public List<Geschenkliste> listGeschenkliste() {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Geschenkliste.class);
		return criteria.list();
	}

	@Override
	@Transactional
	public Geschenkliste getGeschenklisteById(int id) {
		log.debug("Getting Geschenkliste with ID: " + id);
		
		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<Geschenkliste> geschenkliste = session.createCriteria(Geschenkliste.class)
				.add(Restrictions.eq("idGeschenkliste", id)).list();

		return geschenkliste.get(0);
	}
	
	@Transactional
	public List<Geschenkliste> getGeschenklisteByUserId(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		String sql = "SELECT * FROM `geschenkliste` WHERE benutzer_fk="
				+ id;
		Query query = session.createSQLQuery(sql).addEntity(Geschenkliste.class);

		@SuppressWarnings("unchecked")
		List<Geschenkliste> listb = query.list();
		return listb;

	}
}
