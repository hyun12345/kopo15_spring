package kr.ac.kopo.danjiresort.dao;

import java.util.List;

import kr.ac.kopo.danjiresort.domain.User;

public interface UserDao {
	Long count();
	User selectOne(long id);
	List<User> selectAll();
	List<User> selectAllByPagination(int page, int itemSizePerPage);
	int createOne(User user);
	void updateOne(User user);
	void deleteOne(User user);
	int deleteAll();
	
	User selectOneByAuth(String auth);
}
