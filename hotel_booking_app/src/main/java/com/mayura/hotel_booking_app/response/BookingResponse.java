package com.mayura.hotel_booking_app.response;

import java.math.BigDecimal;
import java.sql.Blob;
import java.time.LocalDate;
import java.util.List;

import org.apache.tomcat.util.codec.binary.Base64;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BookingResponse {

	
	private Long id;
	
	private LocalDate checkInDate;
	
	private LocalDate checkOutDate;
	
	private String gustName;
	
	
	
	
	
	
	private String roomType;
	
	private BigDecimal roomPrice;
	
	private boolean isBooked ;
	
	private String photo;
	
	private List<BookingResponse>bookings;
	
	
	
	
	
	
	

	public BookingResponse(Long id, String roomType, BigDecimal roomPrice) {
		super();
		this.id = id;
		this.roomType = roomType;
		this.roomPrice = roomPrice;
	}

	public BookingResponse(Long id, String roomType, BigDecimal roomPrice, boolean isBooked, byte[] photoBytes,
			List<BookingResponse> bookings) {
		
		super();
		this.id = id;
		this.roomType = roomType;
		this.roomPrice = roomPrice;
		this.isBooked = isBooked;
		
		this.photo = (photoBytes != null)
				? Base64.encodeBase64String(photoBytes) 
						: null;
		
		
		this.bookings = bookings;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
