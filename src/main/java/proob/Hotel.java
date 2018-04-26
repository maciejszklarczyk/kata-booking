package proob;

import java.util.HashSet;
import java.util.Set;

public class Hotel {
    private final RoomRepository roomRepository;
    Set<Room> freeRooms = new HashSet<>();

    public Hotel(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }
    public void getFreeRooms(){
        this.freeRooms=roomRepository.getFreeRooms();
    }
    public Room getSingleFreeRoom(){
        getFreeRooms();
        return freeRooms.iterator().next();
    }
    public void bookRoom(Person person, Room room){
        roomRepository.bookRoom(room,person);
    }
    public RoomRepository getRoomRepository(){
        return this.roomRepository;
    }

}
