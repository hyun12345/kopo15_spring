package kr.ac.kopo.danjiresort.service;

import java.util.List;

import kr.ac.kopo.danjiresort.domain.Room;

public interface RoomService {
	
	//-------------------simple--------------------------------------------------------
	Long count();
	Room selectOne(long id);
	List<Room> selectAll();
	List<Room> selectAllByPagination(int page, int itemSizePerPage);
	int createOne(Room room);
	void updateOne(Room room);
	void deleteOne(Room room);
	int deleteAll();
	
	//-------------------complex--------------------------------------------------------
	boolean isRoomExist(Room room);
	void deleteOne(long id);
}
