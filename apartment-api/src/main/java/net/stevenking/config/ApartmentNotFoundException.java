package net.stevenking.config;

public class ApartmentNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ApartmentNotFoundException(long id) {
        super("Could not find Apartment " + id);
    }
}
