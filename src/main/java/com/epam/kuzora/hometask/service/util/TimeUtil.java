package com.epam.kuzora.hometask.service.util;

import java.time.OffsetDateTime;

public class TimeUtil {
    public static OffsetDateTime parseOffsetTimeFromString(String time) {
        return OffsetDateTime.parse(time);
    }

    public static OffsetDateTime getCurrentTime() {
        return OffsetDateTime.now();
    }
}
