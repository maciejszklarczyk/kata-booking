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

    public void setIsFree(boolean value) {
        this.isFree = value;
    }

    public void setBookedBy(Person customer) {
        this.bookedBy = customer;
        setIsFree(false);
    }

    public Person getBookedBy() {
        return this.bookedBy;
    }
}
