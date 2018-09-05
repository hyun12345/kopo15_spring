package kr.ac.kopo.danjiresort.service;

import java.util.List;

import kr.ac.kopo.danjiresort.domain.User;

public interface UserService {
	
	//-------------------simple--------------------------------------------------------
	Long count();
	User selectOne(int id);
	List<User> selectAll();
	List<User> selectAllByPagination(int page, int itemSizePerPage);
	int createOne(User user);
	void updateOne(User user);
	void deleteOne(User user);
	int deleteAll();
	
	//-------------------complex--------------------------------------------------------
	boolean isUserExist(User user);
	void deleteOne(int id);
}
