package proob

import cucumber.api.PendingException
import groovy.transform.Field


this.metaClass.mixin(cucumber.api.groovy.Hooks)
this.metaClass.mixin(cucumber.api.groovy.EN)

@Field RoomRepository roomRepository
@Field Room room
@Field Hotel hotel
@Field Person person
@Field Set<Room> rooms
@Field LinkedList<BookHistory> roomHistory
@Field int number

//scenario 1
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
    hotel.bookRoom(person, room);

}
Then(~/^it is booked by person a$/) { ->
    hotel.getRoomRepository().whoBooked(room);
}
And(~/^it can no longer be booked$/) { ->
    room.getIsFree();
}

//scenario 2
Given(~/^person A has a booking$/) { ->
    room = roomRepository.getBookedRoomByPerson(person);
}
When(~/^he cancels his booking$/) { ->
    hotel.cancelBooking(person,room);
}
Then(~/^the room becomes free$/) { ->
    roomRepository.freeTheRoom(room);
}

//scenario 3
Given(~/^there are a list of free rooms with some bookings made$/) { ->
    rooms = hotel.getAllRooms();
}
When(~/^the list of bookings is displayed$/) { ->
    roomRepository.listAllFromSet(rooms);
}
Then(~/^each room points to a person booking it or is it available$/) { ->
    room.toString();
}

//scenario 5
Given(~/^multiple people booked the same room$/) { ->
    room = new Room();
    roomHistory = hotel.roomRepository.getRoomHistory(room);
}
When(~/^a booking history is printed$/) { ->
    hotel.roomRepository.showRoomHistory(roomHistory);
}
Then(~/^the list of historical bookings display name of people booking and time the booking was made or canceled$/) { ->
    hotel.roomRepository.showRoomHistory(roomHistory);

}
//scenario 4
Given(~/^person a owes person b (\d+)\$$/) { int arg1 ->
    Person personA = new Person();
    Person personB = new Person();
    personA.addDept(personB,arg1);
}

And(~/^person b owes person c (\d+)\$$/) { int arg1 ->
    Person personB = new Person();
    Person personC = new Person();
    personB.addDept(personC,arg1);
}
When(~/^person a borrows person c (\d+)\$$/) { int arg1 ->
    Person personA = new Person();
    Person personC = new Person();
    personA.borrow(personC,arg1);
}