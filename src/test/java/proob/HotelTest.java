package proob;
import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class HotelTest {
    private RoomRepository roomRepository;
    private Hotel hotel;
    Set<Room> rooms = new HashSet<>();
    @Before
    public void setUp(){
        roomRepository = new InMemoryRoomRepository();
        hotel = new Hotel(roomRepository);
        hotel.getRoomRepository().addRoom();
    }
    @Test
    public void areFreeRoomsExist(){
        assertNotNull(hotel.getSingleFreeRoom());
    }
    @Test
    public void roomCannotBeBookedAnymore(){
        Person personA = new Person();
        Room room = hotel.getSingleFreeRoom();
        hotel.bookRoom(personA, room);
        assertTrue(!room.getIsFree());
    }
}
