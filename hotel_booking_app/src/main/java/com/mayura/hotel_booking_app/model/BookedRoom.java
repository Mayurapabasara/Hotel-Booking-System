package com.mayura.hotel_booking_app.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor


public class BookedRoom {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long bookingId;
	
	
	@Column(name = "check_In")
	private LocalDate checkInDate;
	
	@Column(name = "check_Out")
	private LocalDate checkOutDate;
	
	@Column(name = "Gust_FullName")
	private String guestFullName;
	
	@Column(name = "Gust_Email")
	private String guestEmail;
	
	@Column(name = "guest")
	private int totalNumOfGuets;
	
	@Column(name = "children")
	private int NumChildrens;
	
	@Column(name = "adults")
	private int NumOfAdults;
	
	@Column(name = "confimation_code")
	private String bookingConfirmationCode;
	
	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "room_id")
	private Room room;
	
	
	
	
	
	
	
	
	
	public void calculateTotalNumberOfGuest() {
		
		this.totalNumOfGuets = this.NumChildrens + this.NumOfAdults;
	}

	public int getNumChildrens() {
		return NumChildrens;
	}

	public void setNumChildrens(int numChildrens) {
		NumChildrens = numChildrens;
		calculateTotalNumberOfGuest();
	}

	public int getNumOfAdults() {
		return NumOfAdults;
	}

	public void setNumOfAdults(int numOfAdults) {
		NumOfAdults = numOfAdults;
		calculateTotalNumberOfGuest();
	}
	
	
	
	
	
	
	
	
	

	public BookedRoom(String bookingConfirmationCode) {
		super();
		this.bookingConfirmationCode = bookingConfirmationCode;
	}

	public String getBookingConfirmationCode() {
		return bookingConfirmationCode;
	}

	public void setBookingConfirmationCode(String bookingConfirmationCode) {
		this.bookingConfirmationCode = bookingConfirmationCode;
	}
	
	
	
	
	
	

	
	

}
