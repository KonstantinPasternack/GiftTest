package de.giftbox.domain;

public class GeschenkInListe {

	
	Integer geschenk_id;
	Integer geschenkliste_id;
	Integer benutzer_id;

	public Integer getBenutzer_id() {
		return benutzer_id;
	}

	public void setBenutzer_id(Integer benutzer_id) {
		this.benutzer_id = benutzer_id;
	}

	public Integer getGeschenk_id() {
		return geschenk_id;
	}

	public void setGeschenk_id(Integer geschenk_id) {
		this.geschenk_id = geschenk_id;
	}

	public Integer getGeschenkliste_id() {
		return geschenkliste_id;
	}

	public void setGeschenkliste_id(Integer geschenkliste_id) {
		this.geschenkliste_id = geschenkliste_id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((geschenk_id == null) ? 0 : geschenk_id.hashCode());
		result = prime
				* result
				+ ((geschenkliste_id == null) ? 0 : geschenkliste_id.hashCode());
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
		GeschenkInListe other = (GeschenkInListe) obj;
		if (geschenk_id == null) {
			if (other.geschenk_id != null)
				return false;
		} else if (!geschenk_id.equals(other.geschenk_id))
			return false;
		if (geschenkliste_id == null) {
			if (other.geschenkliste_id != null)
				return false;
		} else if (!geschenkliste_id.equals(other.geschenkliste_id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "GeschenkInListe [geschenk_id=" + geschenk_id
				+ ", geschenkliste_id=" + geschenkliste_id + ", benutzer_id="
				+ benutzer_id + "]";
	}



}
