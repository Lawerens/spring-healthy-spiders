package com.hodowla.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hodowla.entity.Pajaki;

@Repository
public class SpiderDAODodaj implements SpiderDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Pajaki> getSpiders() {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Pajaki> theQuery = currentSession.createQuery("FROM Pajaki order by ID", Pajaki.class);
		List<Pajaki> spiders = theQuery.getResultList();
		return spiders;
	}

	@Override
	public void zapiszPajaka(Pajaki theSpider) {
		Session currentSession = sessionFactory.getCurrentSession();
		currentSession.saveOrUpdate(theSpider);
	}

	@Override
	public Pajaki getPajak(int ID_edytuj) {
		Session currentSession = sessionFactory.getCurrentSession();
		Pajaki theSpider = currentSession.get(Pajaki.class, ID_edytuj);
		return theSpider;
	}

	@Override
	public void usunPajaka(int ID_usun) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query theQuery = currentSession.createQuery("delete from Pajaki where id=:pajakiId");
		theQuery.setParameter("pajakiId", ID_usun);
		theQuery.executeUpdate();
	}

	@Override
	public List<Pajaki> wyszukajPajaka(String szukanaNazwa) {
		Session currentSession = sessionFactory.getCurrentSession();
		Query theQuery = null;
		if(szukanaNazwa != null && szukanaNazwa.trim().length() > 0) {
			theQuery = currentSession.createQuery("from Pajaki where lower(Rodzaj) like: Rodzaj or lower(Gatunek) like: Rodzaj", Pajaki.class);
			theQuery.setParameter("Rodzaj", "%" + szukanaNazwa.toLowerCase() + "%");
		}
		else {
			theQuery = currentSession.createQuery("FROM Pajaki", Pajaki.class);
		}
		List<Pajaki> spiders = theQuery.getResultList();
		return spiders;
	}

	@Override
	public List<Pajaki> sortujPajakaR() {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Pajaki> theQuery = currentSession.createQuery("FROM Pajaki order by wylinka", Pajaki.class);
		List<Pajaki> spiders = theQuery.getResultList();
		return spiders;
	}

	@Override
	public List<Pajaki> sortujPajakaM() {
		Session currentSession = sessionFactory.getCurrentSession();
		Query<Pajaki> theQuery = currentSession.createQuery("FROM Pajaki order by wylinka DESC", Pajaki.class);
		List<Pajaki> spiders = theQuery.getResultList();
		return spiders;
	}
	
	
}
