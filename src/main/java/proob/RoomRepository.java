package proob;

import java.util.LinkedList;
import java.util.Set;

public interface RoomRepository {

    void addRoom();

    Set<Room> getFreeRooms();

    Set<Room> getBookedRooms();

    void bookRoom(Room room, Person customer);

    Person whoBooked(Room room);

    Room getBookedRoomByPerson(Person person);

    void freeTheRoom(Room room);

    void cancelBooking(Room room, Person person);

    Set<Room> getRooms();

    void listAllFromSet(Set<Room> rooms);

    LinkedList<BookHistory> getRoomHistory(Room room);

    void showRoomHistory(LinkedList<BookHistory> roomHistory);

}
