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
            if(single.getIsFree()){
                freeRooms.add(single);
            }
        }
        return freeRooms;
    }

    @Override
    public Set<Room> getBookedRooms() {
        Set<Room> bookedRooms = new HashSet<>();
        for(Room single:Rooms){
            if(!single.getIsFree()){
                bookedRooms.add(single);
            }
        }
        return bookedRooms;
    }

    @Override
    public void bookRoom(Room room,Person customer) {
        room.setBookedBy(customer);
    }

    @Override
    public Person whoBooked(Room room) {
        if(room.getIsFree()){
            return null;
        } else {
            return room.getBookedBy();
        }
    }

    @Override
    public Room getBookedRoomByPerson(Person person) {
        Set<Room> bookedRooms = getBookedRooms();
        Room room = new Room();
        for(Room single:bookedRooms){
            if(single.getBookedBy() == person){
                room = single;
            } else {
                room = null;
            }
        }
        return room;
    }

    @Override
    public void freeTheRoom(Room room) {
        room.setBookedBy(null);
        room.setIsFree(true);

    }

    @Override
    public void cancelBooking(Room room,Person person) {
        freeTheRoom(room);

    }
}
