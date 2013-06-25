package de.giftbox.domain;

// Generated 29.05.2013 13:40:32 by Hibernate Tools 4.0.0

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Bewertungen generated by hbm2java
 */
@Entity
@Table(name = "bewertungen", catalog = "giftbox")
public class Bewertungen implements java.io.Serializable {

	private static final long serialVersionUID = -3980207929435754611L;
	
	private Integer id_Bewertung;
	private Integer geschenk;
	private Integer benutzer;
	private String bewertung;

	public Bewertungen() {
	}

	public Bewertungen(Integer geschenk, Integer benutzer, String bewertung) {
		this.geschenk = geschenk;
		this.benutzer = benutzer;
		this.bewertung = bewertung;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id_Bewertungen", unique = true, nullable = false)
	public Integer getIdBewertungen() {
		return this.id_Bewertung;
	}

	public void setIdBewertungen(Integer idBewertungen) {
		this.id_Bewertung = idBewertungen;
	}

//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "geschenk_fk", nullable = false)
	@Column(name = "geschenk_fk")
	public Integer getGeschenk() {
		return this.geschenk;
	}

	public void setGeschenk(Integer geschenk) {
		this.geschenk = geschenk;
	}

//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "benutzer_fk", nullable = false)
	@Column(name = "benutzer_fk")
	public Integer getBenutzer() {
		return this.benutzer;
	}

	public void setBenutzer(Integer benutzer) {
		this.benutzer = benutzer;
	}

	@Column(name = "bewertung", nullable = false, length = 1)
	public String getBewertung() {
		return this.bewertung;
	}

	public void setBewertung(String bewertung) {
		this.bewertung = bewertung;
	}

}
