package kr.ac.kopo.board.dao;

import java.util.List;

import kr.ac.kopo.board.domain.User;

public interface UserDao {
	Long count();
	User selectOne(long id);
	List<User> selectAll();
	List<User> selectAllByPagination(int page, int itemSizePerPage);
	int createOne(User user);
	void updateOne(User user);
	void deleteOne(User user);
	int deleteAll();
}
