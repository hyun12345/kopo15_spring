package kr.ac.kopo.board.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

//import kr.ac.kopo.board.domain.Gongji;
import kr.ac.kopo.board.domain.User;

@Aspect
@Component
public class ServiceAspect {
	
	//kr.ac.kopo.board.aop.UserDaoImpl.selectOne
	
	//kr.ac.kopo.board.aop.UserServiceImpl.selectOne
	//*..*Service..selectOne
	//->구체적 타겟 설정(선정)
	//*..* : 복수 패키지와 일치 / 모든 인수와 일치시킬 수 있음
	
	//함수 실행하기 전 출력되는 before()함수 생성
	//메서드 시작 시 동작하는 어드바이스
	@Before("execution(* *..*Service..selectOne(long))")
	//포인트컷 : 집어넣을 코드 포인트로 집음 / * : return
	public void before() {
		System.out.println("selectOne Before! ***");
	//어드바이스
	}
	
	//메서드 종료 후 동작하는 어드바이스
	@After("execution(* *..*Service..selectOne(long))")
	public void after() {
		System.out.println("selectOne After! ***");
	}
	
	//메서드 호출이 예외를 내보내지 않고 종료했을 때 동작하는 어드바이스 : 예외 발생하지 않으면 출력
	@AfterReturning(value="execution(* *..*Service..selectOne(long))", returning="user")
	public void afterReturning(User user) {
//	@AfterReturning(value="execution(* selectOne(long))", returning="gongji")
//	public void afterReturning(Gongji gongji) {
		System.out.println("selectOne AfterReturning! ***\n");
	}

	//메서드 호출 전후에 동작하는 어드바이스
	@Around("execution(* *..*Service..selectOne(long))")
	public User around(ProceedingJoinPoint pjp) throws Throwable {
		System.out.println("selectOne Around! before ***");
		User user = (User)pjp.proceed();
//	public Gongji around(ProceedingJoinPoint pjp) throws Throwable {
//		System.out.println("selectOne Around! before ***");
//		Gongji gongji = (Gongji)pjp.proceed();
		System.out.println("selectOne Around! after ***");
		return user;
//		return gongji;

	}
	
	//메서드 호출이 예외를 던졌을 때 동작하는 어드바이스 : 예외가 발생하면 출력
	@AfterThrowing(value="execution(* selectOne(long))", throwing="ex")
	public void afterThrowing(Throwable ex) {
		System.out.println("selectOne Throwing! ***\n");
	}
}
