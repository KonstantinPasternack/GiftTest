package de.giftbox.domain;

// Generated 29.05.2013 13:40:32 by Hibernate Tools 4.0.0

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * GeschenklisteHasGeschenkId generated by hbm2java
 */
@Embeddable
public class GeschenklisteHasGeschenkId implements java.io.Serializable {
	
	private static final long serialVersionUID = 3142472406106303976L;
	
	private int geschenklisteIdGeschenkliste;
	private int geschenklisteIdGeschenk;
	private int geschenklisteIdBenutzer;

	public GeschenklisteHasGeschenkId() {
	}

	public GeschenklisteHasGeschenkId(int geschenklisteIdGeschenkliste,
			int geschenklisteIdGeschenk, int geschenklisteIdBenutzer) {
		this.geschenklisteIdGeschenkliste = geschenklisteIdGeschenkliste;
		this.geschenklisteIdGeschenk = geschenklisteIdGeschenk;
		this.geschenklisteIdBenutzer = geschenklisteIdBenutzer;
	}

	@Column(name = "Geschenkliste_idGeschenkliste", nullable = false)
	public int getGeschenklisteIdGeschenkliste() {
		return this.geschenklisteIdGeschenkliste;
	}

	public void setGeschenklisteIdGeschenkliste(int geschenklisteIdGeschenkliste) {
		this.geschenklisteIdGeschenkliste = geschenklisteIdGeschenkliste;
	}

	@Column(name = "Geschenkliste_idGeschenk", nullable = false)
	public int getGeschenklisteIdGeschenk() {
		return this.geschenklisteIdGeschenk;
	}

	public void setGeschenklisteIdGeschenk(int geschenklisteIdGeschenk) {
		this.geschenklisteIdGeschenk = geschenklisteIdGeschenk;
	}

	@Column(name = "Geschenkliste_idBenutzer", nullable = false)
	public int getGeschenklisteIdBenutzer() {
		return this.geschenklisteIdBenutzer;
	}

	public void setGeschenklisteIdBenutzer(int geschenklisteIdBenutzer) {
		this.geschenklisteIdBenutzer = geschenklisteIdBenutzer;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof GeschenklisteHasGeschenkId))
			return false;
		GeschenklisteHasGeschenkId castOther = (GeschenklisteHasGeschenkId) other;

		return (this.getGeschenklisteIdGeschenkliste() == castOther
				.getGeschenklisteIdGeschenkliste())
				&& (this.getGeschenklisteIdGeschenk() == castOther
						.getGeschenklisteIdGeschenk())
				&& (this.getGeschenklisteIdBenutzer() == castOther
						.getGeschenklisteIdBenutzer());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + this.getGeschenklisteIdGeschenkliste();
		result = 37 * result + this.getGeschenklisteIdGeschenk();
		result = 37 * result + this.getGeschenklisteIdBenutzer();
		return result;
	}

	@Override
	public String toString() {
		return "{geschenklisteIdGeschenkliste:"
				+ geschenklisteIdGeschenkliste + ", geschenklisteIdGeschenk:"
				+ geschenklisteIdGeschenk + ", geschenklisteIdBenutzer:"
				+ geschenklisteIdBenutzer + "}";
	}
	
	

}
