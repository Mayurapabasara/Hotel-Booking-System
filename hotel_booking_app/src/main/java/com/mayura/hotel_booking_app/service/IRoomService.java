package com.mayura.hotel_booking_app.service;

import java.math.BigDecimal;

import org.springframework.web.multipart.MultipartFile;

import com.mayura.hotel_booking_app.model.Room;

public interface IRoomService {
	
	Room addNewRoom(MultipartFile photo, String roomType, BigDecimal roomPrice);

}
