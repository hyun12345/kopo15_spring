package kr.ac.kopo.danjiresort.domain;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
@Entity
@Table(name="reservation")
public class Reservation {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	@Column(name="id", unique=true, nullable=false)
	@XmlElement
	private int id;
	
	@Column
	@XmlElement
	private Date date;
	
	//user ���̺��� �ܷ�Ű�� �����ϱ� ���Ͽ� user column ����
	@ManyToOne
	@XmlElement
	private User user;
	
	//user ���̺��� �ܷ�Ű�� �����ϱ� ���Ͽ� user column ����
//	@OneToOne
	@ManyToOne
	@XmlElement
	private Room room;
	
	@Column
	@XmlElement
	private String comment;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Room getRoom() {
		return room;
	}

	public void setRoom(Room room) {
		this.room = room;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
	
}