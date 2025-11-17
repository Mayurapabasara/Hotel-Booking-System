package com.mayura.hotel_booking_app.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.mayura.hotel_booking_app.model.Room;
import com.mayura.hotel_booking_app.response.RoomResponse;

public interface IRoomService {

    Room addNewRoom(MultipartFile photo, String roomType, BigDecimal roomPrice);

    List<RoomResponse> getAllRooms();

    Room getRoomById(Long id);

    Room updateRoom(Long id, MultipartFile photo, String roomType, BigDecimal roomPrice);

    void deleteRoom(Long id);
}
