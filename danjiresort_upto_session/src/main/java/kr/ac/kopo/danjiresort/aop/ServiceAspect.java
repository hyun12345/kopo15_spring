package kr.ac.kopo.danjiresort.aop;
//package kr.ac.kopo.board.aop;
//
//import org.aspectj.lang.ProceedingJoinPoint;
//import org.aspectj.lang.annotation.After;
//import org.aspectj.lang.annotation.AfterReturning;
//import org.aspectj.lang.annotation.AfterThrowing;
//import org.aspectj.lang.annotation.Around;
//import org.aspectj.lang.annotation.Aspect;
//import org.aspectj.lang.annotation.Before;
//import org.springframework.stereotype.Component;
//
////import kr.ac.kopo.board.domain.Gongji;
//import kr.ac.kopo.board.domain.User;
//
//@Aspect
//@Component
//public class ServiceAspect {
//	
//	//kr.ac.kopo.board.aop.UserDaoImpl.selectOne
//	
//	//kr.ac.kopo.board.aop.UserServiceImpl.selectOne
//	//*..*Service..selectOne
//	//->��ü�� Ÿ�� ����(����)
//	//*..* : ���� ��Ű���� ��ġ / ��� �μ��� ��ġ��ų �� ����
//	
//	//�Լ� �����ϱ� �� ��µǴ� before()�Լ� ����
//	//�޼��� ���� �� �����ϴ� �����̽�
//	@Before("execution(* *..*Service..selectOne(long))")
//	//����Ʈ�� : ������� �ڵ� ����Ʈ�� ���� / * : return
//	public void before() {
//		System.out.println("selectOne Before! ***");
//	//�����̽�
//	}
//	
//	//�޼��� ���� �� �����ϴ� �����̽�
//	@After("execution(* *..*Service..selectOne(long))")
//	public void after() {
//		System.out.println("selectOne After! ***");
//	}
//	
//	//�޼��� ȣ���� ���ܸ� �������� �ʰ� �������� �� �����ϴ� �����̽� : ���� �߻����� ������ ���
//	@AfterReturning(value="execution(* *..*Service..selectOne(long))", returning="user")
//	public void afterReturning(User user) {
////	@AfterReturning(value="execution(* selectOne(long))", returning="gongji")
////	public void afterReturning(Gongji gongji) {
//		System.out.println("selectOne AfterReturning! ***\n");
//	}
//
//	//�޼��� ȣ�� ���Ŀ� �����ϴ� �����̽�
//	@Around("execution(* *..*Service..selectOne(long))")
//	public User around(ProceedingJoinPoint pjp) throws Throwable {
//		System.out.println("selectOne Around! before ***");
//		User user = (User)pjp.proceed();
////	public Gongji around(ProceedingJoinPoint pjp) throws Throwable {
////		System.out.println("selectOne Around! before ***");
////		Gongji gongji = (Gongji)pjp.proceed();
//		System.out.println("selectOne Around! after ***");
//		return user;
////		return gongji;
//
//	}
//	
//	//�޼��� ȣ���� ���ܸ� ������ �� �����ϴ� �����̽� : ���ܰ� �߻��ϸ� ���
//	@AfterThrowing(value="execution(* selectOne(long))", throwing="ex")
//	public void afterThrowing(Throwable ex) {
//		System.out.println("selectOne Throwing! ***\n");
//	}
//}
