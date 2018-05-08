package proob;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;

public class Person {
    private final UUID id;
    public String name;
    public String vorname;
    private Map<Person,Integer> debtStatus = new LinkedHashMap<>();
    public Person() {
        id = UUID.randomUUID();
    }
    public void addDept (Person whoPersonOwe, int oweValue){
        debtStatus.put(whoPersonOwe,oweValue);
    }
    public void payDept (Person whoPersonOwe, int oweValue){

    }
    public Map<Person,Integer> getDebtStatus(){
        return this.debtStatus;
    }
    public void borrow(Person whoToBorrow, int value){
        whoToBorrow.addDept(this, value);
        if(whoToBorrow.getDebtStatus().entrySet().iterator().hasNext()){
            Person whoToPay = whoToBorrow.getDebtStatus().entrySet().iterator().next().getKey();
            //messed up, need refractor
        }
    }


}
