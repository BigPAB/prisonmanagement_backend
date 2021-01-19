package ht.com.grean.gprisonbackend.service;

import ht.com.grean.gprisonbackend.model.Room;
import ht.com.grean.gprisonbackend.repository.RoomRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RoomService {

    private RoomRepository roomRepository;

    public RoomService(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    public List<Room> listRooms () {
        return roomRepository.findAll();
    }

    public Integer saveRoom (Room room) {
        return (roomRepository.save(room)).getId();
    }

    public Optional<Room> getRoomById (Integer id){
        return roomRepository.findById(id);
    }


}
