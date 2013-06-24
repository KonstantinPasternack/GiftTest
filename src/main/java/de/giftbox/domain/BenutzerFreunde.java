package de.giftbox.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "benutzerFreunde", catalog = "giftbox")
public class BenutzerFreunde implements java.io.Serializable {

	private static final long serialVersionUID = -3980207929435754611L;

	private Integer id_BenutzerFreunde;
	private Benutzer benutzer;
	private Benutzer benutzerFreund;

	public BenutzerFreunde() {
	}

	public BenutzerFreunde(Benutzer benutzer, Benutzer benutzerFreund) {
		this.benutzer = benutzer;
		this.benutzerFreund = benutzerFreund;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id_BenutzerFreunde", unique = true, nullable = false)
	public Integer getIdBenutzerFreunde() {
		return this.id_BenutzerFreunde;
	}

	public void setIdBenutzerFreunde(Integer idBenutzerFreunde) {
		this.id_BenutzerFreunde = idBenutzerFreunde;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "benutzer_fk", nullable = false)
	public Benutzer getBenutzer() {
		return this.benutzer;
	}

	public void setBenutzer(Benutzer benutzer) {
		this.benutzer = benutzer;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "benutzerFreund_fk", nullable = false)
	public Benutzer getBenutzerFreund() {
		return this.benutzerFreund;
	}

	public void setBenutzerFreund(Benutzer benutzerFreund) {
		this.benutzerFreund = benutzerFreund;
	}

}
