package de.giftbox.daoImpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;

import de.giftbox.dao.GeschenklisteDAO;
import de.giftbox.domain.Geschenkliste;

public class GeschenklisteDAOImpl implements GeschenklisteDAO {

	private HibernateTemplate hibernateTemplate;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.hibernateTemplate = new HibernateTemplate(sessionFactory);
	}

	@Override
	public void saveGeschenkliste(Geschenkliste geschenkliste) {
		hibernateTemplate.saveOrUpdate(geschenkliste);
	}

	@Override
	public void deleteGeschenkliste(Geschenkliste geschenkliste) {
		hibernateTemplate.delete(geschenkliste);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Geschenkliste> listGeschenkliste() {
		return hibernateTemplate.find("from Geschenkliste");
	}
}
