/**
 * Класс Calendar предоставляет методы для проверки выходных дней и нерабочего времени.
 */
import org.example.Calendar;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneId;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Класс содержит тесты для методов класса Calendar.
 */
class CalendarTest {

    /**
     * Тест метода isWeekend класса Calendar.
     */
    @Test
    void testIsWeekend() {
        // Проверка выходных дней из списка WEEKEND_DAYS_MAY_2024
        assertTrue(Calendar.isWeekend(LocalDate.of(2024, Month.MAY, 1))); // День из списка
        assertTrue(Calendar.isWeekend(LocalDate.of(2024, Month.MAY, 9))); // День из списка

        // Проверка субботы и воскресенья
        assertTrue(Calendar.isWeekend(LocalDate.of(2024, Month.MAY, 5))); // Суббота
        assertTrue(Calendar.isWeekend(LocalDate.of(2024, Month.MAY, 12))); // Воскресенье
        assertFalse(Calendar.isWeekend(LocalDate.of(2024, Month.MAY, 6))); // Будний день
    }

    /**
     * Тест метода isNonWorkingTime класса Calendar.
     */
    @Test
    void testIsNonWorkingTime() {
        // Проверка нерабочего времени
        ZoneId moscowTimeZone = ZoneId.of("Europe/Moscow");
        LocalDateTime nonWorkingTime = LocalDateTime.of(2024, Month.MAY, 1, 8, 0); // Досрочный час
        assertTrue(Calendar.isNonWorkingTime(nonWorkingTime));

        LocalDateTime workingTime = LocalDateTime.of(2024, Month.MAY, 2, 10, 0); // Рабочее время
        assertFalse(Calendar.isNonWorkingTime(workingTime));

        // Проверка на выходной день с учетом времени
        LocalDateTime weekendTime = LocalDateTime.of(2024, Month.MAY, 5, 10, 0); // Суббота, но в рабочее время
        assertTrue(Calendar.isNonWorkingTime(weekendTime));
    }
}