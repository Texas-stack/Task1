package org.example;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;
import java.time.LocalDateTime;
import java.time.ZoneId;

/**
 * Класс Calendar предоставляет методы для проверки выходных дней и нерабочего времени.
 */
public class Calendar {

    /**
     * Список выходных дней в мае 2024 года.
     */
    private static final List<Integer> WEEKEND_DAYS_MAY_2024 = List.of(1, 9, 10);

    /**
     * Проверяет, является ли указанная дата выходным днем.
     *
     * @param date Дата для проверки.
     * @return true, если дата является выходным днем, иначе false.
     */
    public static boolean isWeekend(LocalDate date) {
        if (WEEKEND_DAYS_MAY_2024.contains(date.getDayOfMonth())) {
            return true;
        } else {
            return date.getDayOfWeek() == DayOfWeek.SATURDAY || date.getDayOfWeek() == DayOfWeek.SUNDAY;
        }
    }

    /**
     * Проверяет, является ли указанное время нерабочим временем.
     *
     * @param dateTime Время для проверки.
     * @return true, если время является нерабочим, иначе false.
     */
    public static boolean isNonWorkingTime(LocalDateTime dateTime) {
        ZoneId moscowTimeZone = ZoneId.of("Europe/Moscow");
        int moscowWorkingHoursStart = 9;
        int moscowWorkingHoursEnd = 18;

        // Проверка выходных дней
        if (dateTime.getDayOfWeek() == DayOfWeek.SATURDAY || dateTime.getDayOfWeek() == DayOfWeek.SUNDAY
                || WEEKEND_DAYS_MAY_2024.contains(dateTime.getDayOfMonth())) {
            return true;
        }

        int moscowHour = dateTime.atZone(moscowTimeZone).getHour();
        return moscowHour < moscowWorkingHoursStart || moscowHour >= moscowWorkingHoursEnd;
    }
}