package proob;

import java.util.Set;

public class Hotel {
    private final RoomRepository roomRepository;

    public Hotel(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }
    public Set<Room> getFreeRooms(){
        return roomRepository.getFreeRooms();
    }
}
