package kr.ac.kopo.board.service;

import java.util.List;

import kr.ac.kopo.board.domain.User;

public interface UserService {
	
	//-------------------simple--------------------------------------------------------
	Long count();
	User selectOne(long id);
	List<User> selectAll();
	List<User> selectAllByPagination(int page, int itemSizePerPage);
	int createOne(User user);
	void updateOne(User user);
	void deleteOne(User user);
	int deleteAll();
	
	//-------------------complex--------------------------------------------------------
	boolean isUserExist(User user);
	void deleteOne(long id);
}
