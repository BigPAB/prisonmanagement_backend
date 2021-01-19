package ht.com.grean.gprisonbackend.controller;

import ht.com.grean.gprisonbackend.model.Room;
import ht.com.grean.gprisonbackend.service.RoomService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/room")
public class RoomController {

	private RoomService roomService;

	public RoomController(RoomService roomService) {
		this.roomService = roomService;
	}

	@PostMapping(path="/")
	public void saveRoom(HttpServletRequest request, @RequestBody Room room){
		roomService.saveRoom(room);
	}

	@GetMapping(path="/")
	public ResponseEntity<Room> listRooms(HttpServletRequest request){
		try {
			return new ResponseEntity(roomService.listRooms(), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping(path="/{id}")
	public ResponseEntity<Room> getRoomById(HttpServletRequest request, @PathVariable Integer id){
		try {
			return new ResponseEntity(roomService.getRoomById(id), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
	}
}
