package com.mayura.hotel_booking_app.response;

import java.math.BigDecimal;
import java.sql.Blob;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class RoomResponse {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String roomType;
	
	private BigDecimal roomPrice;
	
	private boolean isBooked ;
	
	@Lob
	private Blob photo;
	
	private List<BookingResponse>bookings;

}
