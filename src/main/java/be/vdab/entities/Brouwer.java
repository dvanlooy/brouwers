package be.vdab.entities;

import java.io.Serializable;

import be.vdab.valueobjects.Adres;

public class Brouwer implements Serializable {
	private static final long serialVersionUID = 1L;
	private long id;
	private String naam;
	private Adres adres;
	private Integer omzet;

	public Brouwer(String naam, Adres adres, Integer omzet) {
		this.naam = naam;
		this.adres = adres;
		this.omzet = omzet;
	}

	public Brouwer(long id, String naam, Adres adres, Integer omzet) {
		this(naam, adres, omzet);
		this.id = id;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNaam() {
		return naam;
	}

	public void setNaam(String naam) {
		this.naam = naam;
	}

	public Adres getAdres() {
		return adres;
	}

	public void setAdres(Adres adres) {
		this.adres = adres;
	}

	public Integer getOmzet() {
		return omzet;
	}

	public void setOmzet(Integer omzet) {
		this.omzet = omzet;
	}
}
