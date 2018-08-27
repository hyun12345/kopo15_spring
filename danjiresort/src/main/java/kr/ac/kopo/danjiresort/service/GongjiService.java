package kr.ac.kopo.danjiresort.service;
//package kr.ac.kopo.board.service;
//
//import java.util.List;
//
//import kr.ac.kopo.board.domain.Reservation;
//import kr.ac.kopo.board.vo.PaginationVO;
//
//public interface GongjiService {
//	
//	//-------------------simple--------------------------------------------------------
//	Long count();
//	Reservation selectOne(int id);
//	List<Reservation> selectAll();
//	List<Reservation> selectAllByPagination(int page, int itemSizePerPage);
//	int createOne(Reservation gongji);
//	void updateOne(Reservation gongji);
//	void deleteOne(Reservation gongji);
//	int deleteAll();
//	//GongjiDao에서 중복되는 부분
//	
//	//-------------------complex--------------------------------------------------------
//	boolean isGongjiExist(Reservation gongji);
//	void deleteOne(int id);
//	PaginationVO calcPagination(int page, int itemSizePerPage);
//	void updateOne(int id);
//	int selectRecnt(Reservation rootid, int relevel, int recnt);
////	int selectRecnt(int rootid, int relevel, int recnt);
//	int updateRecnt(int rootid, int recnt);
//
//	void deleteGongji(Reservation rootid, int strecnt, int endrecnt);
//	
//	Reservation selectOnewithCheckPoint(long userId, long gongjiId);
//	
//}
