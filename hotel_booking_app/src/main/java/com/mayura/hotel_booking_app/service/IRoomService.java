package com.mayura.hotel_booking_app.service;

import org.springframework.web.multipart.MultipartFile;

import com.mayura.hotel_booking_app.model.Room;

import java.math.BigDecimal;

public interface IRoomService {
    Room addNewRoom(MultipartFile image, String roomType, BigDecimal price);
}
