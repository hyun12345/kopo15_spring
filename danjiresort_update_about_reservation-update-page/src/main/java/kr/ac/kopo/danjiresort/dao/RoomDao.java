package kr.ac.kopo.danjiresort.dao;

import java.util.List;

import kr.ac.kopo.danjiresort.domain.Room;

public interface RoomDao {
	Long count();
	Room selectOne(long id);
	List<Room> selectAll();
	List<Room> selectAllByPagination(int page, int itemSizePerPage);
	int createOne(Room room);
	void updateOne(Room room);
	void deleteOne(Room room);
	int deleteAll();
}
