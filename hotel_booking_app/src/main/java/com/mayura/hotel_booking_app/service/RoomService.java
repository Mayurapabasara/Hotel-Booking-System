package com.mayura.hotel_booking_app.service;

import java.math.BigDecimal;

import org.springframework.web.multipart.MultipartFile;

import com.mayura.hotel_booking_app.model.Room;
import com.mayura.hotel_booking_app.repository.RoomRepository;

import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
public class RoomService implements IRoomService{
	
	private final RoomRepository roomRepository = null;
	

	@Override
	public Room addNewRoom(MultipartFile file, String roomType, BigDecimal roomPrice) {
		

		Room room = new Room();
		room.setRoomtype(roomType);
		room.setRoomPrice(roomPrice);
		
		
		
		
		if(!file.isEmpty()) {
			
			byte[] photoBytes = file.getBytes();
			blob photoBlob = new SerialBlob(photoBytes);
			room.setPhoto(photoBlob)
		}
		
		
		
		return roomRepository.save(room);
	}

}
