package domain;

public class Duration {
    private int duration;
    public Duration() {

    }

    public void oneMinuteLater() {
        duration++;
    }

    public void oneMinuteEarlier() {
        if(duration > 0) {
            duration--;
        }
    }

    @Override
    public String toString() {
        return "Durée : " + this.duration;
    }
}
