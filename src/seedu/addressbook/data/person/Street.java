package seedu.addressbook.data.person;

public class Street {

    private String street;
    
    public Street (String street) {
        this.street = street;
    }
    
    @Override
    public String toString() {
        return street;
    }
}
