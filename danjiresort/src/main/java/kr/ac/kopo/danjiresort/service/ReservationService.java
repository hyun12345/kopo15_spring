package kr.ac.kopo.danjiresort.service;

import java.util.List;

import kr.ac.kopo.danjiresort.domain.Reservation;
import kr.ac.kopo.danjiresort.vo.ReservationVO;

public interface ReservationService {
	
	//-------------------simple--------------------------------------------------------
	Long count();
	Reservation selectOne(long id);
	List<Reservation> selectAll();
	List<Reservation> selectAllByPagination(int page, int itemSizePerPage);
	int createOne(Reservation reservation);
	void updateOne(Reservation reservation);
	void deleteOne(Reservation reservation);
	int deleteAll();
	
	//-------------------complex--------------------------------------------------------
	boolean isReservationExist(Reservation reservation);
	void deleteOne(long id);
//	List<ReservationVO> setReservation(String date, String day);
//	List<ReservationVO> setReservation(String date);
	List<ReservationVO> setReservation(String date, String day, String reservation1, String reservation2, String reservation3);
	Reservation selectReservations(String date, int room_id);
}
