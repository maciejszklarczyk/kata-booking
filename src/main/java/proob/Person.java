package proob;

import java.util.UUID;

public class Person {
    private final UUID id;
    public String name;
    public String vorname;

    public Person() {
        id = UUID.randomUUID();
    }


}
