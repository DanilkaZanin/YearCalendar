package org.example.service;


import org.example.model.MonthCalendar;
import org.example.util.CalendarConstants;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * Генерация григорианского календаря
 */
public class GregorianCalendarService implements CalendarService {
    private static final int GREGORIAN_CALENDAR_START_YEAR = 1583;
    private static final int MONTHS_IN_YEAR = 12;
    private static final int FIRST_DAY_OF_MONTH = 1;

    /**
     * Генерирует календарь на указанный год
     * @param year Год для генерации (должен быть >= 1583)
     * @return Список месяцев с календарными данными
     * @throws IllegalArgumentException Если год меньше 1583
     */
    @Override
    public List<MonthCalendar> generateYear(int year) {
        validateYear(year);

        List<MonthCalendar> yearCalendar = new ArrayList<>();
        for (int month = 1; month <= MONTHS_IN_YEAR; month++) {
            yearCalendar.add(generateMonth(year, month));
        }
        return yearCalendar;
    }

    private void validateYear(int year) {
        if (year < GREGORIAN_CALENDAR_START_YEAR) {
            throw new IllegalArgumentException(
                    "Григорианский календарь действует с " + GREGORIAN_CALENDAR_START_YEAR + " года");
        }
    }

    private MonthCalendar generateMonth(int year, int month) {
        LocalDate date = LocalDate.of(year, month, FIRST_DAY_OF_MONTH);
        return new MonthCalendar(
                CalendarConstants.MONTH_NAMES[month - 1],
                year,
                generateDaysOfMonth(date),
                date.getDayOfWeek().getValue()
        );
    }

    private List<Integer> generateDaysOfMonth(LocalDate firstDayOfMonth) {
        int daysInMonth = firstDayOfMonth.lengthOfMonth();
        List<Integer> days = new ArrayList<>();
        for (int day = 1; day <= daysInMonth; day++) {
            days.add(day);
        }
        return days;
    }
}
