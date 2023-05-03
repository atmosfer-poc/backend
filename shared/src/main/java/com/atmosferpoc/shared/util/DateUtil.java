package com.atmosferpoc.shared.util;

import lombok.SneakyThrows;
import lombok.experimental.UtilityClass;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.Objects;
import java.util.TimeZone;

@UtilityClass
public class DateUtil {
    private static SimpleDateFormat DATE_TIME_FORMATTER = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssXXX");
    private static SimpleDateFormat DATE_USER_FORMATTER = new SimpleDateFormat("dd-MM-yyyy");

    @SneakyThrows
    public synchronized String toDate(Date date) {
        if (Objects.isNull(date)) {
            return null;
        }
        DATE_TIME_FORMATTER.setTimeZone(TimeZone.getDefault());
        return DATE_TIME_FORMATTER.format(date);
    }

    public static LocalDate toLocalDate(Date date) {
        return date.toInstant()
                .atZone(ZoneId.systemDefault())
                .toLocalDate();
    }

    public static String toString(Date date) {
        if (Objects.isNull(date)) {
            return null;
        }
        return LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault()).toString();
    }

    public static String toUserFriendlyString(Date date) {
        if (Objects.isNull(date)) {
            return null;
        }
        return DATE_USER_FORMATTER.format(date);
    }

    public static Date secondToDate(Long s) {
        if (Objects.isNull(s)) {
            return null;
        }
        return new Timestamp(s * 1000);
    }

    public Date addHoursToJavaUtilDate(Date date, int hours) {
        var calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.HOUR_OF_DAY, hours);
        return calendar.getTime();
    }

    public Date current() {
        return addHoursToJavaUtilDate(new Date(), 3);
    }
}
