package domain;

public class BadHourException extends Exception {
    public BadHourException(int h) {
        super("Bad value for hour (" + h + ") for a new time");
    }
}
