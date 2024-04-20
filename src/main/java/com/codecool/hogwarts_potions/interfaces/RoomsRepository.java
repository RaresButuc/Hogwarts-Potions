package com.codecool.hogwarts_potions.interfaces;

import com.codecool.hogwarts_potions.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomsRepository extends JpaRepository<Room, Long> {
}
