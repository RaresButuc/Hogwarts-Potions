package com.codecool.hogwarts_potions.service;

import com.codecool.hogwarts_potions.interfaces.RoomsRepository;
import com.codecool.hogwarts_potions.model.PetType;
import com.codecool.hogwarts_potions.model.Room;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class RoomService {

    private final RoomsRepository roomsRepository;

    public RoomService(RoomsRepository roomsRepository) {
        this.roomsRepository = roomsRepository;
    }

    public List<Room> getAllRooms() {
        //TODO
        return roomsRepository.findAll();
    }

    public void addRoom(Room room) {
        //TODO
        roomsRepository.save(room);
    }

    public Room getRoomById(Long id) {
        //TODO
        if (roomsRepository.findById(id).orElse(null) != null) {
            return roomsRepository.getById(id);
        }
        return null;
    }

    public void updateRoomById(Long id, Room updatedRoom) {
        //TODO
        if (roomsRepository.findById(id).orElse(null) != null) {
            roomsRepository.getById(id).setCapacity(updatedRoom.getCapacity());
            roomsRepository.getById(id).setResidents(updatedRoom.getResidents());
            roomsRepository.save(roomsRepository.getById(id));
        } else {
            System.out.println("Not found!");
        }
    }

    public void deleteRoomById(Long id) {
        //TODO
        roomsRepository.deleteById(id);
    }

    public List<Room> getRoomsForRatOwners() {
        //TODO
//        return allRooms.stream()
//                .filter(e -> e.getResidents().stream().noneMatch(j -> j.getPetType() == PetType.OWL || j.getPetType() == PetType.CAT))
//                .collect(Collectors.toList());
        return getAllRooms().stream()
                .filter(e -> e.getResidents().stream().noneMatch(j -> j.getPetType() == PetType.OWL || j.getPetType() == PetType.CAT))
                .collect(Collectors.toList());
    }
}
