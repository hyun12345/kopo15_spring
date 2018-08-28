package kr.co.uclick.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

import kr.co.uclick.entity.User;

@Repository
//DB호출/access(Data Access Object) : MVC 중 M
public interface UserRepository 
		extends JpaRepository<User, Long>, QuerydslPredicateExecutor<User> {
	
	public List<User> findUserByNameLike(String name);
	
}


