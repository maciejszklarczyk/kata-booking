package proob;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class InMemoryRoomRepository implements RoomRepository {

    private Set<Room> Rooms = new HashSet<>();
    @Override
    public void addRoom() {
        Room room = new Room();
        Rooms.add(room);
    }

    @Override
    public Set<Room> getFreeRooms() {
        Set<Room> freeRooms = new HashSet<>();
        for(Room single:Rooms){
            if(single.getFree()){
                freeRooms.add(single);
            }
        }
        return freeRooms;
    }

    @Override
    public void bookRoom(Room room,Person customer) {
        room.setBookedBy(customer);
    }

    @Override
    public Person whoBooked(Room room) {
        if(room.getFree()){
            return null;
        } else {
            return room.getBookedBy();
        }
    }
}
