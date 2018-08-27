package kr.ac.kopo.danjiresort.vo;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

public class ReservationVO {

	private String date;
	private String day;
	
	private String reservation1;
	private String reservation2;
	private String reservation3;
//	private Date date;

//	public ReservationVO(String date) {
//		
//		this.date = date;
//		this.day = day;
////		this.reservation1 = reservation1;
////		this.reservation2 = reservation2;
////		this.reservation3 = reservation3;
//	}
	
	public ReservationVO(String date, String day, String reservation1, String reservation2, String reservation3) {
		
		this.date = date;
		this.day = day;
		this.reservation1 = reservation1;
		this.reservation2 = reservation2;
		this.reservation3 = reservation3;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public String getReservation1() {
		return reservation1;
	}

	public void setReservation1(String reservation1) {
		this.reservation1 = reservation1;
	}

	public String getReservation2() {
		return reservation2;
	}

	public void setReservation2(String reservation2) {
		this.reservation2 = reservation2;
	}

	public String getReservation3() {
		return reservation3;
	}

	public void setReservation3(String reservation3) {
		this.reservation3 = reservation3;
	}
}
