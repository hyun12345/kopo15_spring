package kr.ac.kopo.board.dao;

import java.util.List;

import kr.ac.kopo.board.domain.Gongji;

public interface GongjiDao {
	Long count();
	Gongji selectOne(long id);
	List<Gongji> selectAll();
	List<Gongji> selectAllByPagination(int page, int itemSizePerPage);
	//���������̼� : �������� ����� ������ �� ����
	int createOne(Gongji gongji);
	void updateOne(Gongji gongji);
	void deleteOne(Gongji gongji);
	int deleteAll();
//	int selectRecnt(Gongji rootid, int relevel, int recnt);
	int selectRecnt(int rootid, int relevel, int recnt);
	int updateRecnt(int rootid, int recnt);

//	void deleteGongji(Gongji rootid, int strecnt, int endrecnt);
	void deleteGongji(int rootid, int strecnt, int endrecnt);
}
