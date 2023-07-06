package com.hodowla.service;

import java.util.List;

import com.hodowla.entity.Pajaki;

public interface ObslugaPajaki {
	public List<Pajaki> getPajak();

	public void zapiszPajaka(Pajaki theSpider);

	public Pajaki getPajak(int ID_edytuj);

	public void usunPajaka(int iD_usun);

	public List<Pajaki> wyszukajPajaka(String szukanaNazwa);
	
	public List<Pajaki> sortujPajakaR();

	public List<Pajaki> sortujPajakaM();
}
