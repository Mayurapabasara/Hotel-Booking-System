package com.mayura.hotel_booking_app.service;

import java.io.IOException;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.mayura.hotel_booking_app.model.Room;
import com.mayura.hotel_booking_app.repository.RoomRepository;
import com.mayura.hotel_booking_app.response.RoomResponse;

import javax.sql.rowset.serial.SerialBlob;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class RoomService implements IRoomService{
	
	@Autowired
	private RoomRepository roomRepository;
	

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


	@Override
	 public List<RoomResponse> getAllRooms() {
        List<Room> rooms = roomRepository.findAll();

        return rooms.stream()
                .map(room -> new RoomResponse(
                        room.getId(),
                        room.getRoomType(),
                        room.getRoomPrice()
                ))
                .collect(Collectors.toList());
    }


	@Override
	public Room getRoomById(Long id) {
        return roomRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Room not found with id: " + id));
	}


	@Override
	public Room updateRoom(Long id, MultipartFile photo, String roomType, BigDecimal roomPrice) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void deleteRoom(Long id) {
		// TODO Auto-generated method stub
		
	}

}
