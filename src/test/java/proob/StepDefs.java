package proob;

import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.io.*;
import java.util.LinkedList;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

public class StepDefs {
    private RoomRepository roomRepository;
    private Hotel hotel;
    private Person personA;

    @Given("^there is a hotel$")
    public void thereIsAHotel() throws Throwable {
        roomRepository = new InMemoryRoomRepository();
        hotel = new Hotel(roomRepository);
    }


    //scenario 1
    @Given("^there is a free room$")
    public void thereIsAFreeRoom() throws Throwable {
        roomRepository.addRoom();
        roomRepository.addRoom();
    }

    @When("^person A books it$")
    public void personABooksIt() throws Throwable {
        Room room = hotel.getSingleFreeRoom();
        hotel.bookRoom(personA, room);
    }

    @Then("^it is booked by person a$")
    public void itIsBookedByPersonA() throws Throwable {
        Room room = roomRepository.getBookedRoomByPerson(personA);
        Person whoBooked = hotel.getRoomRepository().whoBooked(room);
    }

    @And("^it can no longer be booked$")
    public void itCanNoLongerBeBooked() throws Throwable {
//        room.getIsFree();
    }


    //scenario 2
    @Given("^person A has a booking$")
    public void personAHasABooking() throws Throwable {
        Room room = roomRepository.getBookedRoomByPerson(personA);
        assertNotNull(room);
    }

    @When("^he cancels his booking$")
    public void heCancelsHisBooking() throws Throwable {
        Room room = roomRepository.getBookedRoomByPerson(personA);
        hotel.cancelBooking(personA, room);
    }

    @Then("^the room becomes free$")
    public void theRoomBecomesFree() throws Throwable {
//        roomRepository.freeTheRoom(room);
    }


    //scenario 3
    @Given("^person a owes person b (\\d+)$")
    public void personAOwesPersonB$(int arg0) throws Throwable {
        Person personA = new Person();
        Person personB = new Person();
        personA.addDept(personB, arg0);
    }

    @And("^person b owes person c (\\d+)$")
    public void personBOwesPersonC(int arg0) throws Throwable {
        Person personB = new Person();
        Person personC = new Person();
        personB.addDept(personC, arg0);
    }

    @When("^person a borrows person c (\\d+)$")
    public void personABorrowsPersonC(int arg0) throws Throwable {
        Person personA = new Person();
        Person personC = new Person();
        personA.borrow(personC, arg0);
    }


    //scenario 4
    @Given("^there are a list of free rooms with some bookings made$")
    public void thereAreAListOfFreeRoomsWithSomeBookingsMade() throws Throwable {
        Set<Room> rooms = hotel.getAllRooms();
    }

    @When("^the list of bookings is displayed$")
    public void theListOfBookingsIsDisplayed() throws Throwable {
//        roomRepository.listAllFromSet(rooms);
    }

    @Then("^each room points to a person booking it or is it available$")
    public void eachRoomPointsToAPersonBookingItOrIsItAvailable() throws Throwable {
//        room.toString();
    }


    //scenario 5
    @Given("^multiple people booked the same room$")
    public void multiplePeopleBookedTheSameRoom() throws Throwable {
        Room room = new Room();
        LinkedList<BookHistory>  roomHistory = hotel.getRoomRepository().getRoomHistory(room);
    }

    @When("^a booking history is printed$")
    public void aBookingHistoryIsPrinted() throws Throwable {
        Room room = new Room();
        LinkedList<BookHistory>  roomHistory = hotel.getRoomRepository().getRoomHistory(room);
        hotel.getRoomRepository().showRoomHistory(roomHistory);
    }

    @Then("^the list of historical bookings display name of people booking and time the booking was made or canceled$")
    public void theListOfHistoricalBookingsDisplayNameOfPeopleBookingAndTimeTheBookingWasMadeOrCanceled() throws Throwable {
//        hotel.roomRepository.showRoomHistory(roomHistory);
    }
}

