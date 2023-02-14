package domain;

import java.util.StringTokenizer;

public class TimeV2 {
    private static int HOURS_PER_DAY = 24;
    private static int MINUTES_PER_HOUR = 60;
    private static  int MINUTES_PER_DAY = 1440;
    private int minutes;
    public TimeV2() { // int hour, int minutes
        this.minutes = MINUTES_PER_DAY / 2;
    }

    public TimeV2(String s) throws BadHourException, BadMinuteException, BadFormatException
    {
        if(!s.matches("^[0-9]{1,2}:[0-9]{1,2}$")) throw new BadFormatException(s);
        StringTokenizer st = new StringTokenizer(s, ":");
        hour = Integer.parseInt(st.nextToken());
        if(hour < 0  && hour >= 24) throw new BadHourException(hour);
        minutes = Integer.parseInt(st.nextToken());
        if(minutes < 0  && minutes >= 60) throw new BadMinuteException(minutes);
    }

    public TimeV2(int h, int m) throws BadHourException, BadMinuteException {
        if(hour < 0 && hour >= 24) throw new BadHourException(hour);
        hour = h;
        if(minutes < 0 && minutes >= 60) throw new BadMinuteException(minutes);
        minutes = m;
    }

    public int hour() {
        return  minutes / MINUTES_PER_HOUR;
    }

    public int minute() {
        return minutes;
    }

    public void oneMinuteLater() {
        minutes++;
        if(minutes == 60) {
            minutes = 0;
            oneHourLater();
        }
    }

    public void oneHourLater() {
        hour++;
        if(hour == 24) {
            hour = 0;
        }
    }

    public void oneHourEarlier() {
        hour--;
        if(hour < 0) {
            hour = 23;
        }
    }

    public void oneMinuteEarlier() {
        minutes--;
        if(minutes < 0) {
            minutes = 59;
            oneHourEarlier();
        }
    }

    public String toString() {
        String s = (hour < 10) ? "0" : "";
        s += hour;
        s += ":";
        s += (minutes < 10) ? "0" : "";
        s += minutes;
        return s;
    }
}
