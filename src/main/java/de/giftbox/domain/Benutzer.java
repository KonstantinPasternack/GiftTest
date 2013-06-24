package de.giftbox.domain;

// Generated 29.05.2013 13:40:32 by Hibernate Tools 4.0.0

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Benutzer generated by hbm2java
 */
@Entity
@Table(name = "benutzer", catalog = "giftbox")
public class Benutzer implements java.io.Serializable {

	private static final long serialVersionUID = -2051207650344258994L;

	private Integer idBenutzer;
	private String username;
	private String passwort;
	private String kommentar;
	private String email;
//	private Set<Geschenkliste> geschenklisten = new HashSet<Geschenkliste>(0);
//	private Set<GeschenklisteHasGeschenk> geschenklisteHasGeschenk = new HashSet<GeschenklisteHasGeschenk>(
//			0);
//	private Set<Bewertungen> bewertungen = new HashSet<Bewertungen>(0);

	public Benutzer() {
	}

	public Benutzer(String email) {
		this.email = email;
	}

	public Benutzer(String username, String passwort, String kommentar,
			String email, Set<Geschenkliste> geschenklisten,
			Set<GeschenklisteHasGeschenk> geschenklisteHasGeschenk,
			Set<Bewertungen> bewertungen) {
		this.username = username;
		this.passwort = passwort;
		this.kommentar = kommentar;
		this.email = email;
//		this.geschenklisten = geschenklisten;
//		this.geschenklisteHasGeschenk = geschenklisteHasGeschenk;
//		this.bewertungen = bewertungen;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id_Benutzer", unique = true, nullable = false)
	public Integer getId_Benutzer() {
		return this.idBenutzer;
	}

	public void setId_Benutzer(Integer idBenutzer) {
		this.idBenutzer = idBenutzer;
	}

	@Column(name = "username", length = 45)
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "passwort", length = 45)
	public String getPasswort() {
		return this.passwort;
	}

	public void setPasswort(String passwort) {
		this.passwort = passwort;
	}

	@Column(name = "kommentar", length = 45)
	public String getKommentar() {
		return this.kommentar;
	}

	public void setKommentar(String kommentar) {
		this.kommentar = kommentar;
	}

	@Column(name = "email", nullable = false, length = 45)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Benutzer [idBenutzer=" + idBenutzer + ", username=" + username
				+ ", passwort=" + passwort + ", kommentar=" + kommentar
				+ ", email=" + email + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result
				+ ((idBenutzer == null) ? 0 : idBenutzer.hashCode());
		result = prime * result
				+ ((kommentar == null) ? 0 : kommentar.hashCode());
		result = prime * result
				+ ((passwort == null) ? 0 : passwort.hashCode());
		result = prime * result
				+ ((username == null) ? 0 : username.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Benutzer other = (Benutzer) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (idBenutzer == null) {
			if (other.idBenutzer != null)
				return false;
		} else if (!idBenutzer.equals(other.idBenutzer))
			return false;
		if (kommentar == null) {
			if (other.kommentar != null)
				return false;
		} else if (!kommentar.equals(other.kommentar))
			return false;
		if (passwort == null) {
			if (other.passwort != null)
				return false;
		} else if (!passwort.equals(other.passwort))
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}

//	@ManyToMany(fetch = FetchType.LAZY)
//	@JoinTable(name = "benutzer_has_geschenkliste", catalog = "giftbox", joinColumns = { @JoinColumn(name = "id_Benutzer", nullable = false, updatable = false) }, inverseJoinColumns = { @JoinColumn(name = "id_Geschenkliste", nullable = false, updatable = false) })
//	public Set<Geschenkliste> getGeschenklisten() {
//		return this.geschenklisten;
//	}
//
//	public void setGeschenklisten(Set<Geschenkliste> geschenklisten) {
//		this.geschenklisten = geschenklisten;
//	}
//
//	@OneToMany(fetch = FetchType.LAZY, mappedBy = "benutzer")
//	public Set<GeschenklisteHasGeschenk> getGeschenklisteHasGeschenk() {
//		return this.geschenklisteHasGeschenk;
//	}
//
//	public void setGeschenklisteHasGeschenk(
//			Set<GeschenklisteHasGeschenk> geschenklisteHasGeschenk) {
//		this.geschenklisteHasGeschenk = geschenklisteHasGeschenk;
//	}
//
//	@OneToMany(fetch = FetchType.LAZY, mappedBy = "benutzer")
//	public Set<Bewertungen> getBewertungen() {
//		return this.bewertungen;
//	}
//
//	public void setBewertungen(Set<Bewertungen> bewertungen) {
//		this.bewertungen = bewertungen;
//	}
	
	

}
