package proob;

import java.util.UUID;

public class Room {
    private final UUID id;
    private boolean isFree;
    private Person bookedBy;

    public Room() {
        id = UUID.randomUUID();
        isFree = true;
    }

    public boolean getIsFree() {
        return this.isFree;
    }

    public void setBookedBy(Person customer) {
        this.bookedBy = customer;
        this.isFree = false;
    }

    public Person getBookedBy() {
        return this.bookedBy;
    }
}
