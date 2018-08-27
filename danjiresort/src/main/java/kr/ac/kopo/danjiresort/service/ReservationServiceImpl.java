package kr.ac.kopo.danjiresort.service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.kopo.danjiresort.dao.ReservationDao;
import kr.ac.kopo.danjiresort.domain.Reservation;
import kr.ac.kopo.danjiresort.vo.ReservationVO;

@Service
public class ReservationServiceImpl implements ReservationService {

	@Autowired
	ReservationDao reservationDao;
	
	@Override
	public Long count() {
		return reservationDao.count();
	}

	@Override
	public Reservation selectOne(long id) {
		return reservationDao.selectOne(id);
	}

	@Override
	public List<Reservation> selectAll() {
		return reservationDao.selectAll();
	}

	@Override
	public List<Reservation> selectAllByPagination(int page, int itemSizePerPage) {
		return reservationDao.selectAllByPagination(page, itemSizePerPage);
	}

	@Override
	public int createOne(Reservation reservation) {
		return reservationDao.createOne(reservation);
	}

	@Override
	public void updateOne(Reservation reservation) {
		reservationDao.updateOne(reservation);
	}

	@Override
	public void deleteOne(Reservation reservation) {
		reservationDao.deleteOne(reservation);
	}

	@Override
	public int deleteAll() {
		return reservationDao.deleteAll();
	}
	
	@Override
	public boolean isReservationExist(Reservation reservation) {
		Reservation resv = reservationDao.selectOne(reservation.getId());
		return resv == null ? false : true;
	}
	
	@Override
	public void deleteOne(long id) {
		Reservation resv = reservationDao.selectOne(id);
		reservationDao.deleteOne(resv);
	}

//	@Override
//	public List<ReservationVO> setReservation(String date, String day) {
//		List<ReservationVO> reservations = new ArrayList<>();
//		Calendar cal = Calendar.getInstance();
//		SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
//		SimpleDateFormat dayformat = new SimpleDateFormat("(EE)");
//		
//		for (int i=1; i <31; i++){
//			cal.add(cal.DATE, +1);	
//			reservations.add(new ReservationVO(dateformat.format(cal.getTime()), dayformat.format(cal.getTime())));
//		}
//		
//		return reservations;
//	}
	
//	@Override
//	public List<ReservationVO> setReservation(String date) {
//		List<ReservationVO> reservations = new ArrayList<>();
//		Calendar cal = Calendar.getInstance();
//		SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd (EE)");
//		
//		for (int i=1; i <31; i++){
//			cal.add(cal.DATE, +1);	
//			reservations.add(new ReservationVO(dateformat.format(cal.getTime())));
//		}
//		
//		return reservations;
//	}
	
	@Override
	public List<ReservationVO> setReservation(String date, String day, String reservation1, String reservation2, String reservation3) {
		List<ReservationVO> reservations = new ArrayList<>();
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
		SimpleDateFormat dayformat = new SimpleDateFormat("(EE)");
		
		for (int i=1; i <31; i++){
			cal.add(cal.DATE, +1);	
			reservations.add(new ReservationVO(dateformat.format(cal.getTime()), dayformat.format(cal.getTime()), reservation1, reservation2, reservation3));
		}
		
		return reservations;
	}

	@Override
	public Reservation selectReservations(String date, int room_id) {
		Reservation reservation = new Reservation();
		
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd");
		
		Reservation reservationRoom = reservationDao.selectReservations(dateformat.format(cal.getTime()), reservation.getRoom().getId());
		
		return reservationRoom;
	}
}
