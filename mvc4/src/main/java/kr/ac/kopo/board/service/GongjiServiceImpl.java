package kr.ac.kopo.board.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.ac.kopo.board.dao.GongjiDao;
import kr.ac.kopo.board.dao.UserDao;
import kr.ac.kopo.board.domain.Gongji;
import kr.ac.kopo.board.domain.User;
import kr.ac.kopo.board.vo.PaginationVO;

@Transactional
//�������� �߻��ص� ����Ʈ ���� ������Ʈ ���� �ʵ���  Transaction �����Ͽ� rollback �ǵ��� ��
@Service
public class GongjiServiceImpl implements GongjiService {

	@Autowired
	GongjiDao gongjiDao;
	
	@Autowired
	UserDao userDao;
	
	@Override
	public Long count() {
		return gongjiDao.count();
	}

	@Override
	public Gongji selectOne(int id) {
		return gongjiDao.selectOne(id);
	}

	@Override
	public List<Gongji> selectAll() {
		return gongjiDao.selectAll();
	}

	@Override
	public List<Gongji> selectAllByPagination(int page, int itemSizePerPage) {
		return gongjiDao.selectAllByPagination(page, itemSizePerPage);
	}

	@Override
	public int createOne(Gongji gongji) {
		return gongjiDao.createOne(gongji);
	}

	@Override
	public void updateOne(Gongji gongji) {
		gongjiDao.updateOne(gongji);
	}
	
	@Override
	public void deleteOne(Gongji gongji) {
		gongjiDao.deleteOne(gongji);
	}
	
	@Override
	public int deleteAll() {
		return gongjiDao.deleteAll();
	}
	
	@Override
	public boolean isGongjiExist(Gongji gongji) {
		Gongji g = gongjiDao.selectOne(gongji.getId());
		return g == null ? false : true;
	}
	
	@Override
	public void deleteOne(int id) {
		Gongji g = gongjiDao.selectOne(id);
		gongjiDao.deleteOne(g);
	}

	@Override
	public PaginationVO calcPagination(int page, int itemSizePerPage) {
		PaginationVO p = new PaginationVO();
		long count = count();
		int paginationSize = 10;
		
		int first = 1;
		p.setFirst(first);
		
		int total_page = 0;

			total_page = (int) (count -1) / itemSizePerPage +1; 

		p.setTotal_page(total_page);
		

		int last = total_page;
		p.setLast(last);
		
		int start = ((page - 1) / paginationSize) * paginationSize + 1;
		p.setStart(start);
		
		int prev = start - paginationSize;
		if(prev < 1) prev = 1;
		p.setPrev(prev);

		int next = start + paginationSize;
		if(last < next) next = last;
		p.setNext(next);
		
		int end = start + paginationSize - 1;
		//���������� ��µǴ� �ִ� ������ ���� 10�� ���
		if(end >= last) end = last;
		p.setEnd(end);
		
		
		return p;
	}

	@Override
	public void updateOne(int id) {
			Gongji g = gongjiDao.selectOne(id);
			gongjiDao.updateOne(g);
			
	}



	@Override
	public int selectRecnt(int rootid, int relevel, int recnt) {
		return gongjiDao.selectRecnt(rootid, relevel, recnt);
		
	}
	
	@Override
	public void deleteGongji(int rootid, int strecnt, int endrecnt) {
		gongjiDao.deleteGongji(rootid, strecnt, endrecnt);		
	}

	@Override
	public int updateRecnt(int rootid, int recnt) {
		return gongjiDao.updateRecnt(rootid, recnt);	
	}

//	@Transactional
	//�޼ҵ忡 �����ص� rollback ����
	@Override
	public Gongji selectOnewithCheckPoint(long userId, long gongjiId) {
		User user = userDao.selectOne(userId);
		if(user.getPoint() >= 10) {
			user.setPoint(user.getPoint() - 10);
			userDao.updateOne(user);
//			int i = 1/0;
			return gongjiDao.selectOne(gongjiId);
		} else {
			return null;
		}
	}
	
//	int start = page;
//	if(start < first) {
//		start = first;
//	} else if(start > last) {
//		start = last;
//	}
//	int start = (int)(Math.floor((page - 1) / paginationSize)) * paginationSize + 1;
	
//	@Override
//	public void deleteGongji(Gongji rootid, int strecnt, int endrecnt) {
//		gongjiDao.deleteGongji(rootid, strecnt, endrecnt);		
//	}
	
//	@Override
//	public int selectRecnt(Gongji rootid, int relevel, int recnt) {
//		return gongjiDao.selectRecnt(rootid, relevel, recnt);
//		
//	}
	
////	if (count % itemSizePerPage == 0) 
//		total_page = (int) (count -1) / itemSizePerPage +1; 
////	 else 
////		total_page = (int) count / itemSizePerPage + 1; 
//	
//	//(int) (Math.ceil((double)count / itemSizePerPage));
}
