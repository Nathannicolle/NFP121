package domain;

public class BadMinuteException extends Exception {
    public BadMinuteException(int m) {
        super("Bad value for minutes (" + m + ") for a new time");
    }
}
