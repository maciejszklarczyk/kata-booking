package proob

import cucumber.api.PendingException
import groovy.transform.Field



this.metaClass.mixin(cucumber.api.groovy.Hooks)
this.metaClass.mixin(cucumber.api.groovy.EN)

@Field RoomRepository roomRepository
@Field Room room
@Field Hotel hotel
@Field Person person


Given(~/^there is a hotel$/) { ->
    roomRepository = new InMemoryRoomRepository();
    hotel = new Hotel(roomRepository);
}
Given(~/^there is a free room$/) { ->
    roomRepository.addRoom();
    roomRepository.addRoom();
    hotel.freeRooms;
}
When(~/^person A books it$/) { ->
    person = new Person();
    room = hotel.getSingleFreeRoom();
    hotel.bookRoom(person,room);

}
Then(~/^it is booked by person a$/) { ->
    hotel.getRoomRepository().whoBooked(room);
}
And(~/^it can no longer be booked$/) { ->
    room.getIsFree();
}