package proob;

import java.util.Set;

public interface RoomRepository {

    void addRoom();
    Set<Room> getFreeRooms();
    void bookRoom(Room room, Person customer);
    Person whoBooked(Room room);
}
