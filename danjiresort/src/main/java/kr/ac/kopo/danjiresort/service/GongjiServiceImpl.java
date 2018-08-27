package kr.ac.kopo.danjiresort.service;
//package kr.ac.kopo.board.service;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import kr.ac.kopo.board.dao.GongjiDao;
//import kr.ac.kopo.board.dao.UserDao;
//import kr.ac.kopo.board.domain.Reservation;
//import kr.ac.kopo.board.domain.User;
//import kr.ac.kopo.board.vo.PaginationVO;
//
//@Transactional
////오류사항 발생해도 포인트 차감 업데이트 되지 않도록  Transaction 설정하여 rollback 되도록 함
//@Service
//public class GongjiServiceImpl implements GongjiService {
//
//	@Autowired
//	GongjiDao gongjiDao;
//	
//	@Autowired
//	UserDao userDao;
//	
//	@Override
//	public Long count() {
//		return gongjiDao.count();
//	}
//
//	@Override
//	public Reservation selectOne(int id) {
//		return gongjiDao.selectOne(id);
//	}
//
//	@Override
//	public List<Reservation> selectAll() {
//		return gongjiDao.selectAll();
//	}
//
//	@Override
//	public List<Reservation> selectAllByPagination(int page, int itemSizePerPage) {
//		return gongjiDao.selectAllByPagination(page, itemSizePerPage);
//	}
//
//	@Override
//	public int createOne(Reservation gongji) {
//		return gongjiDao.createOne(gongji);
//	}
//
//	@Override
//	public void updateOne(Reservation gongji) {
//		gongjiDao.updateOne(gongji);
//	}
//	
//	@Override
//	public void deleteOne(Reservation gongji) {
//		gongjiDao.deleteOne(gongji);
//	}
//	
//	@Override
//	public int deleteAll() {
//		return gongjiDao.deleteAll();
//	}
//	
//	@Override
//	public boolean isGongjiExist(Reservation gongji) {
//		Reservation g = gongjiDao.selectOne(gongji.getId());
//		return g == null ? false : true;
//	}
//	
//	@Override
//	public void deleteOne(int id) {
//		Reservation g = gongjiDao.selectOne(id);
//		gongjiDao.deleteOne(g);
//	}
//
//	@Override
//	public PaginationVO calcPagination(int page, int itemSizePerPage) {
//		PaginationVO p = new PaginationVO();
//		long count = count();
//		int paginationSize = 10;
//		
//		int first = 1;
//		p.setFirst(first);
//		
//		int total_page = 0;
////		if (count % itemSizePerPage == 0) 
//			total_page = (int) (count -1) / itemSizePerPage +1; 
////		 else 
////			total_page = (int) count / itemSizePerPage + 1; 
//		
//		//(int) (Math.ceil((double)count / itemSizePerPage));
//		p.setTotal_page(total_page);
//		
//
//		int last = total_page;
//		p.setLast(last);
//		
//
////		int start = page;
////		if(start < first) {
////			start = first;
////		} else if(start > last) {
////			start = last;
////		}
////		int start = (int)(Math.floor((page - 1) / paginationSize)) * paginationSize + 1;
//		int start = ((page - 1) / paginationSize) * paginationSize + 1;
//		p.setStart(start);
//		
//		int prev = start - paginationSize;
//		if(prev < 1) prev = 1;
//		p.setPrev(prev);
//
//		int next = start + paginationSize;
//		if(last < next) next = last;
//		p.setNext(next);
//		
//		int end = start + paginationSize - 1;
//		//웹피이지에 출력되는 최대 페이지 수가 10인 경우
//		if(end >= last) end = last;
//		p.setEnd(end);
//		
//		
//		return p;
//	}
//
//	@Override
//	public void updateOne(int id) {
//			Reservation g = gongjiDao.selectOne(id);
//			gongjiDao.updateOne(g);
//			
//	}
//
//	@Override
//	public int selectRecnt(Reservation rootid, int relevel, int recnt) {
//		return gongjiDao.selectRecnt(rootid, relevel, recnt);
//		
//	}
//
////	@Override
////	public int selectRecnt(int rootid, int relevel, int recnt) {
////		return gongjiDao.selectRecnt(rootid, relevel, recnt);
////		
////	}
//	
//	@Override
//	public void deleteGongji(Reservation rootid, int strecnt, int endrecnt) {
//		gongjiDao.deleteGongji(rootid, strecnt, endrecnt);		
//	}
//
//	@Override
//	public int updateRecnt(int rootid, int recnt) {
//		return gongjiDao.updateRecnt(rootid, recnt);	
//	}
//
////	@Transactional
//	//메소드에 설정해도 rollback 가능
//	@Override
//	public Reservation selectOnewithCheckPoint(long userId, long gongjiId) {
//		User user = userDao.selectOne(userId);
//		if(user.getPoint() >= 10) {
//			user.setPoint(user.getPoint() - 10);
//			userDao.updateOne(user);
//			
////			int i = 1/0;
//			
//			return gongjiDao.selectOne(gongjiId);
//		} else {
//			return null;
//		}
//	}
//}
