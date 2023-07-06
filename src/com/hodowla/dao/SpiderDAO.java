package com.hodowla.dao;

import java.util.List;

import com.hodowla.entity.Pajaki;

public interface SpiderDAO {
	public List<Pajaki> getSpiders();

	public void zapiszPajaka(Pajaki theSpider);

	public Pajaki getPajak(int ID_edytuj);

	public void usunPajaka(int iD_usun);

	public List<Pajaki> wyszukajPajaka(String szukanaNazwa);
	
	public List<Pajaki> sortujPajakaR();

	public List<Pajaki> sortujPajakaM();
}
