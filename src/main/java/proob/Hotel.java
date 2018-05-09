package proob;

import java.util.HashSet;
import java.util.Set;

public class Hotel {
    private final RoomRepository roomRepository;
    Set<Room> freeRooms = new HashSet<>();
    Set<Room> allRooms = new HashSet<>();

    public Hotel(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    public void getFreeRooms() {
        this.freeRooms = this.roomRepository.getFreeRooms();
    }

    public Room getSingleFreeRoom() {
        getFreeRooms();
        return freeRooms.iterator().next();
    }

    public void bookRoom(Person person, Room room) {
        roomRepository.bookRoom(room, person);
    }

    public void cancelBooking(Person person, Room room) {
        roomRepository.cancelBooking(room, person);
    }

    public RoomRepository getRoomRepository() {
        return this.roomRepository;
    }

    public void setAllRooms() {
        this.allRooms = roomRepository.getRooms();
    }

    public Set<Room> getAllRooms() {
        return this.allRooms;
    }

}
