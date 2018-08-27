package kr.ac.kopo.board.service;

import java.util.List;

import kr.ac.kopo.board.domain.Gongji;
import kr.ac.kopo.board.vo.PaginationVO;

public interface GongjiService {
	
	//-------------------simple--------------------------------------------------------
	Long count();
	Gongji selectOne(int id);
	List<Gongji> selectAll();
	List<Gongji> selectAllByPagination(int page, int itemSizePerPage);
	int createOne(Gongji gongji);
	void updateOne(Gongji gongji);
	void deleteOne(Gongji gongji);
	int deleteAll();
	//GongjiDao에서 중복되는 부분
	
	//-------------------complex--------------------------------------------------------
	boolean isGongjiExist(Gongji gongji);
	void deleteOne(int id);
	PaginationVO calcPagination(int page, int itemSizePerPage);
	void updateOne(int id);
//	int selectRecnt(Gongji rootid, int relevel, int recnt);
	int selectRecnt(int rootid, int relevel, int recnt);
	int updateRecnt(int rootid, int recnt);

//	void deleteGongji(Gongji rootid, int strecnt, int endrecnt);
	void deleteGongji(int rootid, int strecnt, int endrecnt);

	Gongji selectOnewithCheckPoint(long userId, long gongjiId);
}
