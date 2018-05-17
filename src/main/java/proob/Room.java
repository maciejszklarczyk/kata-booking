package proob;

import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

public class Room {
    private final UUID id;
    private boolean isFree;
    private Person bookedBy;
    private LinkedList<BookHistory> history;

    public Room() {
        id = UUID.randomUUID();
        isFree = true;
        history = new LinkedList<>();
    }

    public UUID getId() {
        return this.id;
    }

    public boolean getIsFree() {
        return this.isFree;
    }

    public void setIsFree(boolean value) {
        this.isFree = value;
    }

    public void setBookedBy(Person customer) {
        setIsFree(false);

        this.bookedBy = customer;
        BookHistory bookHistoryObject = new BookHistory(customer);

        this.history.add(bookHistoryObject);
    }

    public Person getBookedBy() {
        return this.bookedBy;
    }

    @Override
    public String toString() {
        if(this.isFree){
            return "Room ID: " + this.getId() + " is now free." ;
        } else {
            return "Room ID: " + this.getId() + " is booked by " + this.getBookedBy().name + " " + this.getBookedBy().vorname;
        }
    }

    public LinkedList<BookHistory> getHistory() {
        return this.history;
    }

}
