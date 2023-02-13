package test;

import domain.BadFormatException;
import domain.BadHourException;
import domain.BadMinuteException;
import domain.Time;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class TimeTest {
    @Test
    void constructorTest() {
        Time t = new Time();
        assertEquals(12, t.hour());
        assertEquals(0, t.minute());
        t = new Time(13, 15);
        assertEquals(13, t.hour());
        assertEquals(15, t.minute());
        t = new Time("08;20");
        assertEquals(8, t.hour());
        assertEquals(20, t.minute());
    }

    @Test
    void constructorExceptionTest() {
        Exception e;
        e = assertThrows(BadFormatException.class, () -> new Time("8h20"));
        e = assertThrows(BadHourException.class, () -> new Time(24, 0));
        e = assertThrows(BadMinuteException.class, () -> new Time(24, 45))
    }

    @Test
    void oneMinuteLaterTest() throws BadHourException, BadMinuteException {
        Time t = new Time(15, 20);
        t.oneMinuteLater();
        assertEquals(15, t.hour());
        assertEquals(21, t.minute());

        t = new Time(15, 59);
        t.oneMinuteLater();
        assertEquals(16, t.hour());
        assertEquals(0, t.minute());

        t = new Time(23, 59);
        t.oneMinuteLater();
        assertEquals(0, t.hour());
        assertEquals(0, t.minute());
    }

    @Test
    void oneHourLaterTest() {
        Time t = new Time(15, 20);
        t.oneHourLater();
        assertEquals(16, t.hour());
        assertEquals(20, t.minute());

        t = new Time(23, 15);
        t.oneHourLater();
        assertEquals(0, t.hour());
        assertEquals(15, t.minute());
    }

    @Test
    void oneHourEarlierTest() {
        Time t = new Time(10, 8);
        t.oneHourEarlier();
        assertEquals(9, t.hour());
        assertEquals(8, t.minute());
        t = new Time(0, 15);
        t.oneHourEarlier();
        assertEquals(23, t.hour());
        assertEquals(15, t.minute());
    }

    @Test
    void oneMinuteEarlier() {
        Time t = new Time(15, 20);
        t.oneMinuteEarlier();
        assertEquals(15, t.hour());
        assertEquals(19, t.minute());

        t = new Time(15, 0);
        t.oneMinuteEarlier();
        assertEquals(14, t.hour());
        assertEquals(59, t.minute());

        t = new Time(0, 0);
        t.oneMinuteEarlier();
        assertEquals(23, t.hour());
        assertEquals(59, t.minute());
    }

    @Test
    void toStringTest() {
        Time t = new Time(10, 27);
        assertEquals("10:27", t.toString());
        t = new Time(8, 23);
        assertEquals("08:23", t.toString());
    }
}
