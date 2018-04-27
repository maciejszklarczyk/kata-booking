package proob;

import java.util.Date;

public class BookHistory {
    Person whoBooked;
    Date bookStart;
    Date bookEnds;

    BookHistory(Person person){
        this.whoBooked = person;
    }

    public Person getWhoBooked() {
        return whoBooked;
    }

    @Override
    public String toString() {
        return "Booked by: "
                + this.whoBooked.name
                + " "
                + this.whoBooked.vorname;
    }
}
