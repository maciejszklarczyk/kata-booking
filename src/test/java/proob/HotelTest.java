package proob;

import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

public class HotelTest {
    private Hotel hotel;
    Set<Room> rooms = new HashSet<>();

    @Before
    public void setUp() {
        RoomRepository roomRepository = new InMemoryRoomRepository();
        hotel = new Hotel(roomRepository);
        hotel.getRoomRepository().addRoom();
    }

    @Test
    public void areFreeRoomsExist() {
        assertNotNull(hotel.getSingleFreeRoom());
    }

    @Test
    public void roomCannotBeBookedAnymore() {
        Person personA = new Person();
        Room room = hotel.getSingleFreeRoom();
        hotel.bookRoom(personA, room);
        assertTrue(!room.getIsFree());
    }

    /*
    Scenario: Locking room for booking
    Given there is a free room
    When a person begins to book that room
    Then the room becomes unavailable
     */

    @Test
    public void lockingRoomForBooking(){
        Room freeRoom = hotel.getSingleFreeRoom();
        Person personA = new Person();
        freeRoom.setBookedBy(personA);
        assertFalse(freeRoom.getIsFree());
    }

    /*
    Scenario: Releasing booking lock if no booking made
    Given a person started booking
    When 10 minutes elapses and the booking is still not complete
    Then the room becomes available again
    And person A cannot complete booking
     */

    @Test
    public void relasingBookingLockIfNoBookingMade(){
        Room freeRoom = hotel.getSingleFreeRoom();
        Person personA = new Person();
        freeRoom.setBookedBy(personA);

        //ten minutes check

        if(!freeRoom.getIsFree() && freeRoom.getBookedBy() == null){
            freeRoom.setIsFree(true);
        }
    }
}
