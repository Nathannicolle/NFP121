package domain;

import java.util.StringTokenizer;

public class DurationV1 extends Clock {
    public static int HOURS_PER_DAY = 24;
    public static int MINUTES_PER_HOUR = 60;
    private int hour = 1;
    private int minutes;

    public DurationV1() { // int hour, int minutes
        this.hour = 12;
        this.minutes = 0;
    }

    public DurationV1(String s) throws BadHourException, BadMinuteException, BadFormatException
    {
        if(!s.matches("^[0-9]{1,2}:[0-9]{1,2}$")) throw new BadFormatException(s);
        StringTokenizer st = new StringTokenizer(s, ":");
        hour = Integer.parseInt(st.nextToken());
        if(hour < 0  && hour >= 24) throw new BadHourException(hour);
        minutes = Integer.parseInt(st.nextToken());
        if(minutes < 0  && minutes >= 60) throw new BadMinuteException(minutes);
    }

    public DurationV1(int h, int m) throws BadHourException, BadMinuteException {
        if(hour < 0 && hour >= 24) throw new BadHourException(hour);
        hour = h;
        if(minutes < 0 && minutes >= 60) throw new BadMinuteException(minutes);
        minutes = m;
    }
}
