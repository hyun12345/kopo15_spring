package kr.ac.kopo.danjiresort.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.kopo.danjiresort.dao.UserDao;
import kr.ac.kopo.danjiresort.domain.User;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao userDao;
	
	@Override
	public Long count() {
		return userDao.count();
	}

	@Override
	public User selectOne(long id) {
		return userDao.selectOne(id);
	}

	@Override
	public List<User> selectAll() {
		return userDao.selectAll();
	}

	@Override
	public List<User> selectAllByPagination(int page, int itemSizePerPage) {
		return userDao.selectAllByPagination(page, itemSizePerPage);
	}

	@Override
	public int createOne(User user) {
		return userDao.createOne(user);
	}

	@Override
	public void updateOne(User user) {
		userDao.updateOne(user);
	}

	@Override
	public void deleteOne(User user) {
		userDao.deleteOne(user);
	}

	@Override
	public int deleteAll() {
		return userDao.deleteAll();
	}
	
	@Override
	public boolean isUserExist(User user) {
		User u = userDao.selectOne(user.getId());
		return u == null ? false : true;
	}
	
	@Override
	public void deleteOne(long id) {
		User u = userDao.selectOne(id);
		userDao.deleteOne(u);
	}
	
}
