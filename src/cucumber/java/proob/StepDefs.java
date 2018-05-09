package proob;

import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import java.io.*;

import static org.junit.Assert.assertEquals;

public class StepDefs {
    private RoomRepository roomRepository;
    private Hotel hotel;

    @Given("^there is a hotel$")
    public void thereIsAHotel() throws Throwable {
        roomRepository = new InMemoryRoomRepository();
        hotel = new Hotel(roomRepository);
    }

    @Given("^there is a free room$")
    public void thereIsAFreeRoom() throws Throwable {
    }

    @When("^person A books it$")
    public void personABooksIt() throws Throwable {
    }

    @Then("^it is booked by person a$")
    public void itIsBookedByPersonA() throws Throwable {
    }

    @And("^it can no longer be booked$")
    public void itCanNoLongerBeBooked() throws Throwable {
    }

    @Given("^person A has a booking$")
    public void personAHasABooking() throws Throwable {
    }

    @When("^he cancels his booking$")
    public void heCancelsHisBooking() throws Throwable {
    }

    @Then("^the room becomes free$")
    public void theRoomBecomesFree() throws Throwable {
    }

    @Given("^there are a list of free rooms with some bookings made$")
    public void thereAreAListOfFreeRoomsWithSomeBookingsMade() throws Throwable {
    }

    @When("^the list of bookings is displayed$")
    public void theListOfBookingsIsDisplayed() throws Throwable {
    }

    @Then("^each room points to a person booking it or is it available$")
    public void eachRoomPointsToAPersonBookingItOrIsItAvailable() throws Throwable {
    }

//    @Given("^person a owes person b (\\d+)$")
//    public void personAOwesPersonB$(int arg0) throws Throwable {
//    }
//
//    @And("^person b owes person c (\\d+)$")
//    public void personBOwesPersonC$(int arg0) throws Throwable {
//    }
//
//    @When("^person a borrows person c (\\d+)$")
//    public void personABorrowsPersonC$(int arg0) throws Throwable {
//    }


    @Given("^multiple people booked the same room$")
    public void multiplePeopleBookedTheSameRoom() throws Throwable {
    }

    @When("^a booking history is printed$")
    public void aBookingHistoryIsPrinted() throws Throwable {
    }

    @Then("^the list of historical bookings display name of people booking and time the booking was made or canceled$")
    public void theListOfHistoricalBookingsDisplayNameOfPeopleBookingAndTimeTheBookingWasMadeOrCanceled() throws Throwable {
    }
}
//@Given("^there is a free room$/")
//public void ThereIsARoom(){
//    roomRepository.addRoom();
//    roomRepository.addRoom();
//    hotel.freeRooms;
//}
//When(~/^person A books it$/) { ->
//    person = new Person();
//    room = hotel.getSingleFreeRoom();
//    hotel.bookRoom(person, room);
//
//}
//Then(~/^it is booked by person a$/) { ->
//    hotel.getRoomRepository().whoBooked(room);
//}
//And(~/^it can no longer be booked$/) { ->
//    room.getIsFree();
//}
//
////scenario 2
//Given(~/^person A has a booking$/) { ->
//    room = roomRepository.getBookedRoomByPerson(person);
//}
//When(~/^he cancels his booking$/) { ->
//    hotel.cancelBooking(person,room);
//}
//Then(~/^the room becomes free$/) { ->
//    roomRepository.freeTheRoom(room);
//}
//
////scenario 3
//Given(~/^there are a list of free rooms with some bookings made$/) { ->
//    rooms = hotel.getAllRooms();
//}
//When(~/^the list of bookings is displayed$/) { ->
//    roomRepository.listAllFromSet(rooms);
//}
//Then(~/^each room points to a person booking it or is it available$/) { ->
//    room.toString();
//}
//
////scenario 5
//Given(~/^multiple people booked the same room$/) { ->
//    room = new Room();
//    roomHistory = hotel.roomRepository.getRoomHistory(room);
//}
//When(~/^a booking history is printed$/) { ->
//    hotel.roomRepository.showRoomHistory(roomHistory);
//}
//Then(~/^the list of historical bookings display name of people booking and time the booking was made or canceled$/) { ->
//    hotel.roomRepository.showRoomHistory(roomHistory);
//
//}
////scenario 4
//Given(~/^person a owes person b (\d+)\$$/) { int arg1 ->
//    Person personA = new Person();
//    Person personB = new Person();
//    personA.addDept(personB,arg1);
//}
//
//And(~/^person b owes person c (\d+)\$$/) { int arg1 ->
//    Person personB = new Person();
//    Person personC = new Person();
//    personB.addDept(personC,arg1);
//}
//When(~/^person a borrows person c (\d+)\$$/) { int arg1 ->
//    Person personA = new Person();
//    Person personC = new Person();
//    personA.borrow(personC,arg1);
//}
//    }
