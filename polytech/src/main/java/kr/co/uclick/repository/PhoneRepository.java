package kr.co.uclick.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

import kr.co.uclick.entity.Phone;

@Repository
//DB호출/access(Data Access Object) : MVC 중 M
public interface PhoneRepository 
		extends JpaRepository<Phone, Long>, QuerydslPredicateExecutor<Phone>{
	
	public Phone findPhoneByNumber(String number);
	public List<Phone> findPhoneByNumberContaining(String number);

}
