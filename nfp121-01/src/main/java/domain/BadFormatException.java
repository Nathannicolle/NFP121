package domain;

public class BadFormatException extends Exception {
    public BadFormatException(String s) {
        super("Bad format for string (" + s + ")");
    }
}
