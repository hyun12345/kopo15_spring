package kr.co.uclick.repository;


import javax.persistence.QueryHint;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

import kr.co.uclick.entity.Phone;

@Repository
//DB호출/access(Data Access Object) : MVC 중 M
public interface PhoneRepository 
		extends JpaRepository<Phone, Long>, QuerydslPredicateExecutor<Phone>{
	
	//QueryCache 적용
	@QueryHints(value= {
            @QueryHint(name="org.hibernate.cacheable", value="true"),
            @QueryHint(name="org.hibernate.cacheMode", value="NORMAL"),
            @QueryHint(name="org.hibernate.cacheRegion", value="phone-search")
    })
//	@QueryHints({ @QueryHint(name = "org.hibernate.cacheable", value ="true") })
	public Phone findPhoneByNumber(String number);
	
}



