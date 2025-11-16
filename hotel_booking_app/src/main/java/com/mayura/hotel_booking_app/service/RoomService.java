package com.mayura.hotel_booking_app.service;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;

import org.springframework.web.multipart.MultipartFile;

import com.mayura.hotel_booking_app.model.Room;
import com.mayura.hotel_booking_app.repository.RoomRepository;
import javax.sql.rowset.serial.SerialBlob;

import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
public class RoomService implements IRoomService{
	
	private final RoomRepository roomRepository = null;
	

	@Override
	public Room addNewRoom(MultipartFile file, String roomType, BigDecimal roomPrice) {
		

		Room room = new Room();
		room.setRoomType(roomType);
		room.setRoomPrice(roomPrice);
		
		
		
		
		if(!file.isEmpty()) {
		
			byte[] photoBytes = null;
			
			
		
			try {
				photoBytes = file.getBytes();
			} 
			catch (IOException e) {
				
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
		
			SerialBlob photoBlob = null;
			try {
				photoBlob = new SerialBlob(photoBytes);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			room.setPhoto(photoBlob);
		}
		
		
		
		return roomRepository.save(room);
	}

}
