package seedu.addressbook.data.person;

import seedu.addressbook.data.exception.IllegalValueException;

/**
 * Represents a Person's address in the address book.
 * Guarantees: immutable; is valid as declared in {@link #isValidAddress(String)}
 */
public class Address {

    public static final String EXAMPLE = "a/123, Clementi Ave 3, #12-34, 231534";
    public static final String MESSAGE_ADDRESS_CONSTRAINTS = "Person addresses must be in "
            + "the a/BLOCK, STREET, UNIT, POSTAL_CODE format";
    
    private static final int BLOCK_INDEX = 0;
    private static final int STREET_INDEX = 1;
    private static final int UNIT_INDEX = 2;
    private static final int POSTAL_INDEX = 3;
    
    private static final int ADDRESS_COMPONENTS = 4;
    
    private static final String SPLIT_REGEX = ",";

    public final String value;
    private boolean isPrivate;

    private final Block block;
    private final Street street;
    private final Unit unit;
    private final PostalCode postalCode;
    
    /**
     * Validates given address.
     *
     * @throws IllegalValueException if given address string is invalid.
     */
    public Address(String address, boolean isPrivate) throws IllegalValueException {
        String trimmedAddress = address.trim();             
 
        this.isPrivate = isPrivate;
        if (!isValidAddress(trimmedAddress)) {
            throw new IllegalValueException(MESSAGE_ADDRESS_CONSTRAINTS);
        }
        
        String blockNo = address.split(SPLIT_REGEX)[BLOCK_INDEX];
        String streetName = address.split(SPLIT_REGEX)[STREET_INDEX];
        String unitNo = address.split(SPLIT_REGEX)[UNIT_INDEX];
        String postalCodeNo = address.split(SPLIT_REGEX)[POSTAL_INDEX];
        
        this.value = trimmedAddress;
        this.block = new Block(blockNo);
        this.street = new Street(streetName);
        this.unit = new Unit(unitNo);
        this.postalCode = new PostalCode(postalCodeNo);
    }

    /**
     * Returns true if a given string is a valid address.
     */
    public static boolean isValidAddress(String test) {
        return test.split(SPLIT_REGEX).length==ADDRESS_COMPONENTS;
    }

    @Override
    public String toString() {
        return value;
    }
    
    
    public String getBlock() {
        return block.toString();
    }
    
    public String getStreet() {
        return street.toString();
    }
    
    public String getUnit() {
        return unit.toString();
    }
    
    public String getPostalCode() {
        return postalCode.toString();
    }
    
    @Override
    public boolean equals(Object other) {
        return other == this // short circuit if same object
                || (other instanceof Address // instanceof handles nulls
                && this.value.equals(((Address) other).value)); // state check
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

    public boolean isPrivate() {
        return isPrivate;
    }
}
