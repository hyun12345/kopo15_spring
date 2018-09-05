package kr.co.uclick.repository;

import java.util.List;

import javax.persistence.QueryHint;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

import kr.co.uclick.entity.User;

@Repository
//DB호출/access(Data Access Object) : MVC 중 M
public interface UserRepository 
		extends JpaRepository<User, Long>, QuerydslPredicateExecutor<User> {
	
	//QueryCache 적용
	@QueryHints(value= {
            @QueryHint(name="org.hibernate.cacheable", value="true"),
            @QueryHint(name="org.hibernate.cacheMode", value="NORMAL"),
            @QueryHint(name="org.hibernate.cacheRegion", value="user-search-like")
    })
	public List<User> findUserByNameLike(String name);
	

	
}


