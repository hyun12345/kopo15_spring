package kr.ac.kopo.board.domain;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
@Entity
@Table(name="gongji")
public class Gongji {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	@Column(name="id", unique=true, nullable=false)
	@XmlElement
	private int id;
	
	@Column
	@XmlElement
	private String title;
	
	@Column
	@XmlElement
	private Date date;
	
	@Column
	@XmlElement
	private String content;
	
	@Column(nullable=false)
	@XmlElement
	private int rootid;
	
	@Column(nullable=false)
	@XmlElement
	private int recnt;
	
	@Column(nullable=false)
	@XmlElement
	private int relevel;
	
	@Column(nullable=false)
	@XmlElement
	private int viewcnt;
	
	@ManyToOne(cascade = CascadeType.ALL, targetEntity = Gongji.class)
	@JoinColumn(name = "parent", referencedColumnName = "id")
	@JsonBackReference
//	@XmlElement
	private Gongji parent;
	
	@OneToMany(mappedBy="parent", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JsonManagedReference
	private Set<Gongji> children;
	
	//user 테이블과 외래키로 연결하기 위하여 user column 생성
	@ManyToOne
	@XmlElement
	private User user;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	public int getRootid() {
		return rootid;
	}

	public void setRootid(int rootid) {
		this.rootid = rootid;
	}
	
	public int getRecnt() {
		return recnt;
	}

	public void setRecnt(int recnt) {
		this.recnt = recnt;
	}

	public int getRelevel() {
		return relevel;
	}

	public void setRelevel(int relevel) {
		this.relevel = relevel;
	}

	public int getViewcnt() {
		return viewcnt;
	}

	public void setViewcnt(int viewcnt) {
		this.viewcnt = viewcnt;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public Gongji getParent() {
		return parent;
	}

	public void setParent(Gongji parent) {
		this.parent = parent;
	}

	public Set<Gongji> getChildren() {
		return children;
	}

	public void setChildren(Set<Gongji> children) {
		this.children = children;
	}
	
	public boolean isNewGongji() {
        
        Date now = new Date();

        long diff = now.getTime() - date.getTime();
        
        int diffHour = (int) (diff / 1000 / 60 / 60);
        
        if (diffHour > 12) {
            return false;
        } else {
            return true;
        }
    }
	
	
//	@ManyToOne(cascade = CascadeType.ALL, targetEntity = Gongji.class)
//	//@ManyToOne : 부모측이 자식의 외부키 열과 조인
//	@JoinColumn(name = "rootid", referencedColumnName = "id")
//	//@JoinColumn : 내부 속성(참조키 컬럼 입력) -> 자동키 적용
//	//referencedColumnName 사용하여 ManyToOne 관계 설정 위해 부모측에 어떤 칼럼이 사용되어야 하는지 설정
//	//참조 칼럼의 이름(조인하는 칼럼 명)을 id로 설정
//	@JsonBackReference
////	@XmlElement
//	//id와 rootid의 값이 같을 때에도 xml 조회되도록 주석처리
//	private Gongji rootid;

//	public Gongji getRootid() {
//	return rootid;
//}
//
////Gongji 객체 rootid를 대입하여 setRootid() 메소드 활용하여 rootid 값 설정
//public void setRootid(Gongji rootid) {
//	this.rootid = rootid;
//}
	
	
//	@OneToMany(mappedBy="rootid", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
//	//fetch = FetchType.EAGER : 조회시 연관 객체 검색 / FetchType.LAZY : 조회시 연관 객체 검색하지 않음
//	@JsonManagedReference
//	private Set<Gongji> replies;
	
//	public Set<Gongji> getReplies() {
//	return replies;
//}
//
//public void setReplies(Set<Gongji> replies) {
//	this.replies = replies;
//}
	
}
