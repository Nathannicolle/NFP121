package domain;

public class Duration {
    private int duration;
    private int hour;
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

    public void oneHourLater() {
        duration += 60;
    }

    public void oneHourEarlier() {
        if(duration >= 60) {
            duration -= 60;
        }
    }

    @Override
    public String toString() {
        return "Durée : " + this.duration + " minutes";
    }

    public int getDuration() {
        return this.duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}
