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
@Table(name = "friend", catalog = "giftbox")
public class Friend implements java.io.Serializable {

	private static final long serialVersionUID = -3980207929435754611L;

	private Integer id_Friend;
	private Integer benutzer;
	private Integer benutzerFriend;

	public Friend() {
	}

	public Friend(Integer benutzer, Integer benutzerFriend) {
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

//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "benutzer_fk", nullable = false)
	@Column(name = "benutzer_fk", nullable = true)
	public Integer getBenutzer() {
		return this.benutzer;
	}

	public void setBenutzer(Integer benutzer) {
		this.benutzer = benutzer;
	}

//	@ManyToOne(fetch = FetchType.LAZY)
//	@JoinColumn(name = "benutzerFreund_fk", nullable = false)
	@Column(name = "benutzerFreund_fk")
	public Integer getBenutzerFreund() {
		return this.benutzerFriend;
	}

	public void setBenutzerFreund(Integer benutzerFriend) {
		this.benutzerFriend = benutzerFriend;
	}

	@Override
	public String toString() {
		return "Friend [id_Friend=" + id_Friend + ", benutzer=" + benutzer
				+ ", benutzerFriend=" + benutzerFriend + "]";
	}

}
