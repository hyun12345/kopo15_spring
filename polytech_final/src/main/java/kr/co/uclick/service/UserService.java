package kr.co.uclick.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.QueryHint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.jpa.repository.QueryHints;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StopWatch;

import com.google.common.collect.Lists;

import kr.co.uclick.entity.QUser;
import kr.co.uclick.entity.User;
import kr.co.uclick.repository.UserRepository;

@Service
@Transactional
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	
	public void delete(User user) {
		userRepository.delete(user);
	}

	@Transactional(readOnly = true)
	public List<User> findAll() {
		return userRepository.findAll();
	}

	public void save(User user) {
		userRepository.save(user);
	}

	public User findById(Long userId) {
		Optional<User> user = userRepository.findById(userId);
		return user.get();
	}
	
	@Transactional(readOnly = true)
	public List<User> findUserByNameLike(String name) {
		Iterable<User> originaluserList = userRepository.findAll(QUser.user.name.likeIgnoreCase("%" + name + "%"));
		List<User> userList = Lists.newArrayList(originaluserList);
		//Iterable 형태의 배열을 List로 형변환하여 리스트 출력
		return userList;
	}
	
//	@CacheEvict(value = "area", allEntries = true)
//	public void updateOne(User user) {
//		StopWatch sw = new StopWatch();
//		sw.start();
//		userRepository.updateOne(user);
//		sw.stop();
//	}
}
