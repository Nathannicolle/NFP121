package domain;

public interface Time {
    static int HOUR_PER_DAY = 24;
    static int MINUTES_PER_HOUR = 60;
    int hour();
    int minute();
    void oneMinuteLater();
    void oneMinuteEarlier() throws NegativeDurationException;
    void oneHourLater();
    void oneHourEarlier() throws  NegativeDurationException;
    String toString();
}
