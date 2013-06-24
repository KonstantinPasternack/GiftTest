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
@Table(name = "Friend", catalog = "giftbox")
public class Friend implements java.io.Serializable {

	private static final long serialVersionUID = -3980207929435754611L;

	private Integer id_Friend;
	private Benutzer benutzer;
	private Benutzer benutzerFriend;

	public Friend() {
	}

	public Friend(Benutzer benutzer, Benutzer benutzerFriend) {
		this.benutzer = benutzer;
		this.benutzerFriend = benutzerFriend;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id_Friend", unique = true, nullable = false)
	public Integer getIdBenutzerFriend() {
		return this.id_Friend;
	}

	public void setIdBenutzerFriend(Integer idBenutzerFriend) {
		this.id_Friend = idBenutzerFriend;
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
		return this.benutzerFriend;
	}

	public void setBenutzerFreund(Benutzer benutzerFriend) {
		this.benutzerFriend = benutzerFriend;
	}

}
