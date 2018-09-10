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
	
	private String suitroom;
	private String doubleroom;
	private String singleroom;
//	private Date date;

//	public ReservationVO(String date) {
//		
//		this.date = date;
//		this.day = day;
////		this.reservation1 = reservation1;
////		this.reservation2 = reservation2;
////		this.reservation3 = reservation3;
//	}
	
	public ReservationVO(String date, String day, String suitroom, String doubleroom, String singleroom) {
		
		this.date = date;
		this.day = day;
		this.suitroom = suitroom;
		this.doubleroom = doubleroom;
		this.singleroom = singleroom;
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

	public String getSuitroom() {
		return suitroom;
	}

	public void setSuitroom(String suitroom) {
		this.suitroom = suitroom;
	}

	public String getDoubleroom() {
		return doubleroom;
	}

	public void setDoubleroom(String doubleroom) {
		this.doubleroom = doubleroom;
	}

	public String getSingleroom() {
		return singleroom;
	}

	public void setSingleroom(String singleroom) {
		this.singleroom = singleroom;
	}

}
