package com.mayura.hotel_booking_app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mayura.hotel_booking_app.model.Room;

public interface RoomRepository extends JpaRepository<Room, Long> {

}
