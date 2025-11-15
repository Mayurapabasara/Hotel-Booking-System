 package com.mayura.hotel_booking_app.model;

import java.math.BigDecimal;
import java.sql.Blob;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
public class Room {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String roomType;
	
	private BigDecimal roomPrice;
	
	private boolean isBooked = false;
	
	@Lob
	private Blob photo;
	
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL) //Cascade determines how operations on a parent entity are propagated to related child entities.
	private List<BookedRoom> bookings;

	public Room() {
		
		this.bookings = new ArrayList<>();
	}
	
	
	
	
	
	
	
	public void addBooking(BookedRoom booking) {
		if(bookings == null) {
			bookings = new ArrayList<>();
		}
		
		bookings.add(booking);
		booking.setRoom(this);
		
		isBooked = true;
		
		String bookingCode = RandomStringUtils.randomNumberic(10);
		booking.setBookingConfirmationCode(bookingCode);
	}

	
	
	
	
	
	
	
	
	

	private String RandomStringConfirmationCode() {
		// TODO Auto-generated method stub
		return null;
	}
	

}
