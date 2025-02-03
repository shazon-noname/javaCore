package StreamAPI.airport;

import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class Flight {
    private static final ZoneId zoneId = ZoneId.systemDefault();
    private static final DateTimeFormatter HOUR_FORMAT;
    private final String code;
    private final Flight$Type type;
    private final Instant date;
    private final Aircraft aircraft;

    public Flight(String code, Flight$Type type, Instant date, Aircraft aircraft) {
        this.code = code;
        this.type = type;
        this.date = date;
        this.aircraft = aircraft;
    }

    public String getCode() {
        return this.code;
    }

    public Flight$Type getType() {
        return this.type;
    }

    public Instant getDate() {
        return this.date;
    }

    public Aircraft getAircraft() {
        return this.aircraft;
    }

    public String toString() {
        String dateFormatted = HOUR_FORMAT.format(this.date);
        return dateFormatted + " / " + this.code + " / " + this.type;
    }

    static {
        HOUR_FORMAT = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm").withZone(zoneId);
    }
}
