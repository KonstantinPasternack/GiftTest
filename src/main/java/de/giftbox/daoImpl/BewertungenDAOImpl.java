package de.giftbox.daoImpl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateTemplate;

import de.giftbox.dao.BewertungenDAO;
import de.giftbox.domain.Bewertungen;

public class BewertungenDAOImpl implements BewertungenDAO {

	private HibernateTemplate hibernateTemplate;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.hibernateTemplate = new HibernateTemplate(sessionFactory);
	}

	@Override
	public void saveBewertung(Bewertungen bewertungen) {
		hibernateTemplate.saveOrUpdate(bewertungen);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<Bewertungen> listBewertungen() {
		return hibernateTemplate.find("from Bewertungen");
	}
}
