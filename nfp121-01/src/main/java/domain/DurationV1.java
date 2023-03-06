package domain;

import java.util.StringTokenizer;

public class Duree extends Clock {

    public Duree() {
        super(1,0);
        h = 1;
        m = 0;
    }

    public void oneHourMore() {
        h++;
    }

    public Duree(int hour, int minute) throws BadHourException, BadMinuteException {
        super();
        if(hour < 0) throw new BadHourException(hour);
        h = hour;
        if(minute < 0 || minute >= MINUTES_PER_HOUR) throw new BadMinuteException(minute);
        m = minute;
    }
    public Duree(String s) throws BadHourException, BadMinuteException, BadFormatException {
        super();
        if(!s.matches("^[0-9]+h[0-5][0-9]$")) throw new BadFormatException(s);
        StringTokenizer st = new StringTokenizer(s, ":");
        h = Integer.parseInt(st.nextToken());
        if(h < 0) throw new BadHourException(h);
        m = Integer.parseInt(st.nextToken());
        if(m < 0 || m >= MINUTES_PER_HOUR) throw new BadMinuteException(m);
    }


    public void oneHourLess() throws NegativeDurationException {
        if(h <1) throw new NegativeDurationException(this);
        h--;
        if(h < 0) h = HOURS_PER_DAY - 1;
    }


    public void oneMinuteLess() throws NegativeDurationException {
        m--;
        if(m < 0) {
            m = MINUTES_PER_HOUR - 1;
            oneHourLess();
        }
    }

    public String toString() {
        String s = "v1 ";
        s += h + "h";
        s+= (m < 10) ? "0" : "";
        s+=m;
        return s;
    }

}