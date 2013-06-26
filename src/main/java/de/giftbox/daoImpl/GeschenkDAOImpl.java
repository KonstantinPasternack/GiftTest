package de.giftbox.daoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import de.giftbox.dao.GeschenkDAO;
import de.giftbox.domain.Benutzer;
import de.giftbox.domain.Geschenk;
import de.giftbox.domain.GeschenkInListe;

@Repository
public class GeschenkDAOImpl implements GeschenkDAO {

	private static final Logger log = LoggerFactory
			.getLogger(GeschenkDAOImpl.class);

	@Autowired
	SessionFactory sessionFactory;

	@Transactional
	public void saveGeschenk(Geschenk geschenk) {
		sessionFactory.getCurrentSession().saveOrUpdate(geschenk);
		// hibernateTemplate.saveOrUpdate(benutzer);
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<Geschenk> listGeschenk() {
		Session session = sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(Geschenk.class);
		// criteria.add(Restrictions.eq("name", "blabla"));
		return criteria.list();
	}

	public void deleteGeschenk(Geschenk geschenk) {
		sessionFactory.getCurrentSession().delete(geschenk);

	}

	@Transactional
	public Geschenk getGeschenkById(Integer id) {
		log.debug("Getting Geschenk with ID: " + id);

		Session session = sessionFactory.getCurrentSession();
		@SuppressWarnings("unchecked")
		List<Geschenk> geschenke = session.createCriteria(Geschenk.class)
				.add(Restrictions.eq("id_Geschenk", id)).list();

		return geschenke.get(0);
	}

	@Transactional
	public Integer getLastAddedGeschenk() {

		log.debug("Getting last added Geschenk");

		Session session = sessionFactory.getCurrentSession();

		@SuppressWarnings("unchecked")
		List<Geschenk> geschenke = session.createCriteria(Geschenk.class)
				.addOrder(Order.desc("id_Geschenk")).list();

		Integer lastAdded = geschenke.get(0).getId_Geschenk();

		log.debug("Last added geschenk has ID: " + lastAdded);

		return lastAdded;
	}

	@Transactional
	public void saveGeschenkInListe(GeschenkInListe geschenk) {
		Session session = sessionFactory.getCurrentSession();
		String sql = "INSERT INTO geschenkliste_has_geschenk VALUES ("
				+ geschenk.getBenutzer_id() + ","
				+ geschenk.getGeschenkliste_id() + ","
				+ geschenk.getGeschenk_id() + ")";
		Query query = session.createSQLQuery(sql);
		query.executeUpdate();
	}

}
