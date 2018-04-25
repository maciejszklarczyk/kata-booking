package proob;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Stepdefs {
    private RoomRepository roomRepository;
    private Hotel hotel;
    private Room room;
    private Person customer;


    @Given("^there is a free room$")
    public void there_is_a_free_room() {
        roomRepository = new InMemoryRoomRepository();
        hotel = new Hotel(roomRepository);
    }

    @When("^person ([A-Z])\\w+ books it$")
    public void person_a_books_it(Room room, Person customer){
        roomRepository.bookRoom(room, customer);
    }

    @Then("^it is booked by person ([A-Z])\\w+$")
    public void it_is_booked_by_person_a(Room room){
        roomRepository.whoBooked(room);
    }

    @And("^it can no longer be booked$")
    public void it_can_no_longer_be_booked(Room room){
        boolean isFree = room.getFree();
    }

}
