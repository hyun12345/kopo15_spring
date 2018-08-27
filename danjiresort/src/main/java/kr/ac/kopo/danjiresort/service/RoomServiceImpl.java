package kr.ac.kopo.danjiresort.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.kopo.danjiresort.dao.RoomDao;
import kr.ac.kopo.danjiresort.domain.Room;

@Service
public class RoomServiceImpl implements RoomService {

	@Autowired
	RoomDao roomDao;
	
	@Override
	public Long count() {
		return roomDao.count();
	}

	@Override
	public Room selectOne(long id) {
		return roomDao.selectOne(id);
	}

	@Override
	public List<Room> selectAll() {
		return roomDao.selectAll();
	}

	@Override
	public List<Room> selectAllByPagination(int page, int itemSizePerPage) {
		return roomDao.selectAllByPagination(page, itemSizePerPage);
	}

	@Override
	public int createOne(Room room) {
		return roomDao.createOne(room);
	}

	@Override
	public void updateOne(Room room) {
		roomDao.updateOne(room);
	}

	@Override
	public void deleteOne(Room room) {
		roomDao.deleteOne(room);
	}

	@Override
	public int deleteAll() {
		return roomDao.deleteAll();
	}
	
	@Override
	public boolean isRoomExist(Room room) {
		Room r = roomDao.selectOne(room.getId());
		return r == null ? false : true;
	}
	
	@Override
	public void deleteOne(long id) {
		Room r = roomDao.selectOne(id);
		roomDao.deleteOne(r);
	}
	
}
