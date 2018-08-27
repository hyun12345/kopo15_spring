package kr.ac.kopo.board.domain;

import java.util.Date;
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
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	@Column(name="id", unique=true, nullable=false)
	@XmlElement
	private int id;
	
	@Column
	@XmlElement
	private String username;
	
	@Column
	@XmlElement
	private String password;
	
	@Column
	@XmlElement
	private String name;
	
	@Column
	@XmlElement
	private String email;
	
	@Column
	@XmlElement
	private Date created;
	
	@Column
	@XmlElement
	private int point;
	
	@OneToMany(mappedBy="user", cascade=CascadeType.ALL)
	private Set<Gongji> GongjiList;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	public Set<Gongji> getGongjiList() {
		return GongjiList;
	}

	public void setGongjiList(Set<Gongji> gongjiList) {
		GongjiList = gongjiList;
	}

	public int getPoint() {
		return point;
	}

	public void setPoint(int point) {
		this.point = point;
	}
	
}
