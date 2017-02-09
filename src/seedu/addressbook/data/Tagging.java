package seedu.addressbook.data;

import seedu.addressbook.data.person.*;
import seedu.addressbook.data.tag.Tag;

public class Tagging {
    private Tag tag;
    private Person person;
    private TagStatus status;
    private enum TagStatus {ADDED, REMOVED}; 
    
    public Tagging (Tag tag, Person person, TagStatus status) {
        this.tag = tag;
        this.person = person;
        this.status = status;
        
    }
    
    public Person getPerson() {
        return person;
    }
    
    public Tag getTag() {
        return tag;
    }
    
    public TagStatus getTagStatus() {
        return status;
    }
}
