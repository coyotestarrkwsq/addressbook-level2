package seedu.addressbook.data.person;

public class PostalCode {
    
    private String postalCode;
    
    public PostalCode(String postalCode) {
        this.postalCode = postalCode;
    }
    
    @Override
    public String toString() {
        return postalCode;
    }
}
