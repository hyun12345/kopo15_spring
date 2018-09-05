package kr.co.uclick.entity;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.springframework.cache.annotation.Cacheable;

@Cacheable
@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Entity
@Table(name="user")
public class User {
 
	@Id
	@Column(name="id", unique=true, nullable=false)
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
 
	@Column(name="name", nullable=false, length=20)
	private String name;
	
	@Column(name="address", nullable=false)
	private String address;
	
	@Column(name="age", nullable=false)
	private int age;
	
	@Column(name="gender", nullable=false, length=4)
	private String gender;
	
	@Column(name="enrolldate", nullable=false, length=20)
	private String enrolldate;
 
//	@Cacheable
	@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.NONE)
	@OneToMany(mappedBy="user", fetch=FetchType.EAGER, cascade = CascadeType.MERGE)
	private Collection<Phone> phones;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getEnrolldate() {
		return enrolldate;
	}

	public void setEnrolldate(String enrolldate) {
		this.enrolldate = enrolldate;
	}

	public Collection<Phone> getPhones() {
		return phones;
	}

	public void setPhones(Collection<Phone> phone) {
		this.phones = phone;
	}
}