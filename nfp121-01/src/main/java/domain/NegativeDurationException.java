package domain;

public class NegativeDurationException extends Exception {
    public NegativeDurationException(DurationV1 d) {
        super("Impossible to have a negative duration (" + d + ")");
    }
}
