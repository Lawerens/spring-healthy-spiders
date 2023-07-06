package com.hodowla.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name="pajaki")
public class Pajaki {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@NotNull(message="nie moze byc puste!")
	@Size(min=1)
	@Size(max=45, message="za duzo znakow!")
	@Column(name="Rodzaj")
	private String rodzaj;
	
	@NotNull(message="nie moze byc puste!")
	@Size(min=1)
	@Size(max=45, message="za duzo znakow!")
	@Column(name="Gatunek")
	private String gatunek;
	
	@NotNull(message="nie moze byc puste!")
	@Size(min=1)
	@Size(max=45, message="za duzo znakow!")
	@Column(name="Rozmiar")
	private String rozmiar;
	
	@Column(name="Wylinka")
	private String wylinka;
	
	public Pajaki() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRodzaj() {
		return rodzaj;
	}

	public void setRodzaj(String rodzaj) {
		this.rodzaj = rodzaj;
	}

	public String getGatunek() {
		return gatunek;
	}

	public void setGatunek(String gatunek) {
		this.gatunek = gatunek;
	}

	public String getRozmiar() {
		return rozmiar;
	}

	public void setRozmiar(String rozmiar) {
		this.rozmiar = rozmiar;
	}

	public String getWylinka() {
		return wylinka;
	}

	public void setWylinka(String wylinka) {
		this.wylinka = wylinka;
	}

	@Override
	public String toString() {
		return "Pajak [id=" + id + ", rodzaj=" + rodzaj + ", gatunek="
				+ gatunek + ", rozmiar=" + rozmiar + ", wylinka="
				+ wylinka + "]";
	}

	
}
