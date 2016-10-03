package be.vdab.entities;

import java.io.Serializable;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotBlank;

import be.vdab.valueobjects.Adres;

@Entity
@Table(name = "brouwers")
public class Brouwer implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@NotBlank
	private String naam;
	@NotNull
	@Valid
	@Embedded
	private Adres adres;
	@Min(0)
	private Integer omzet;
	
	public Brouwer() {}

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
