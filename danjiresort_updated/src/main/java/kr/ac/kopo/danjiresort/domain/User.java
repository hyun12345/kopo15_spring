package kr.ac.kopo.danjiresort.domain;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
@Entity
@Table(name="users")
public class User {
//테이블명을 user로 하여 생성할 경우 오류 발생할 가능성 있으므로 users로 설정
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	@Column(name="id", unique=true, nullable=false)
	@XmlElement
	private int id;
	
	@Column
	@XmlElement
	private String passwd;
	
	@Column
	@XmlElement
	private String name;
	
	@Column
	@XmlElement
	private String addr;
	
	@Column
	@XmlElement
	private String telnum;
	
	@Column
	@XmlElement
	private String auth;
	
	@OneToMany(mappedBy="user", cascade=CascadeType.ALL)
	private List<Reservation> ReservationList;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

	public String getTelnum() {
		return telnum;
	}

	public void setTelnum(String telnum) {
		this.telnum = telnum;
	}

	public String getAuth() {
		return auth;
	}

	public void setAuth(String auth) {
		this.auth = auth;
	}

	public List<Reservation> getReservationList() {
		return ReservationList;
	}

	public void setReservationList(List<Reservation> reservationList) {
		ReservationList = reservationList;
	}
	
}
