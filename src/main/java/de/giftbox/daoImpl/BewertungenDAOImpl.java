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
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

import de.giftbox.dao.BewertungenDAO;
import de.giftbox.domain.Benutzer;
import de.giftbox.domain.Bewertungen;

public class BewertungenDAOImpl implements BewertungenDAO {

	private static final Logger log = LoggerFactory
			.getLogger(BenutzerDAOImpl.class);

	@Autowired
	SessionFactory sessionFactory;

	@Transactional
	public void saveBewertung(Bewertungen bewertungen) {
		sessionFactory.getCurrentSession().saveOrUpdate(bewertungen);
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<Bewertungen> listBewertungen() {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Bewertungen.class);
		// criteria.add(Restrictions.eq("name", "blabla"));
		return criteria.list();
		// TODO Methode umschreiben
	}

	@Transactional
	public Bewertungen findBewertungenById(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Bewertungen.class);
		criteria.add(Restrictions.eq("id_Bewertungen", id));
		
		@SuppressWarnings("unchecked")
		List<Bewertungen> bewertungen = criteria.list();
		
		return bewertungen.get(0);
	}

	@Transactional
	public Double findAvgBewertungByGeschenkId(Integer id) {
		
		Session session = sessionFactory.getCurrentSession();
		String sql = "SELECT avg(bewertung) FROM bewertungen where geschenk_fk = :fk";
		Query query = session.createSQLQuery(sql);
		query.setParameter("fk", id);
		
		@SuppressWarnings("unchecked")
		List<Double> results = query.list();
		
		return results.get(0);
	}

	@Override
	public List<Bewertungen> findBewertungenByUserId(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Bewertungen.class).add(Restrictions.eq("benutzer", id));
		
		@SuppressWarnings("unchecked")
		List<Bewertungen> bewertungen = criteria.list();
		
		return bewertungen;
	}
}
