package kr.ac.kopo.danjiresort.dao;

import java.util.List;

import kr.ac.kopo.danjiresort.domain.Reservation;

public interface ReservationDao {
	Long count();
	Reservation selectOne(long id);
	List<Reservation> selectAll();
	List<Reservation> selectAllByPagination(int page, int itemSizePerPage);
	//���������̼� : �������� ����� ������ �� ����
	int createOne(Reservation reservation);
	void updateOne(Reservation reservation);
	void deleteOne(Reservation reservation);
	int deleteAll();
//	int countSuitroom(String date, int room_id);
//	List<Reservation> selectReservations(String date, int room_id);
//	Reservation selectReservations(String date);
	Reservation selectReservationByDate(String date, int room_id);
}
