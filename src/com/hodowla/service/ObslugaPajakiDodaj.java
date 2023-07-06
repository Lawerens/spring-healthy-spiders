package com.hodowla.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hodowla.dao.SpiderDAO;
import com.hodowla.entity.Pajaki;


@Service
public class ObslugaPajakiDodaj implements ObslugaPajaki {
	@Autowired
	private SpiderDAO spiderDAO;
	
	@Override
	@Transactional
	public List<Pajaki> getPajak() {
		return spiderDAO.getSpiders();
	}

	@Override
	@Transactional
	public void zapiszPajaka(Pajaki theSpider) {
		spiderDAO.zapiszPajaka(theSpider);
	}

	@Override
	@Transactional
	public Pajaki getPajak(int ID_edytuj) {
		return spiderDAO.getPajak(ID_edytuj);
	}

	@Override
	@Transactional
	public void usunPajaka(int ID_usun) {
		spiderDAO.usunPajaka(ID_usun);
	}

	@Override
	@Transactional
	public List<Pajaki> wyszukajPajaka(String szukanaNazwa) {
		return spiderDAO.wyszukajPajaka(szukanaNazwa);
	}

	@Override
	@Transactional
	public List<Pajaki> sortujPajakaR() {
		return spiderDAO.sortujPajakaR();
	}

	@Override
	@Transactional
	public List<Pajaki> sortujPajakaM() {
		return spiderDAO.sortujPajakaM();
	}
}