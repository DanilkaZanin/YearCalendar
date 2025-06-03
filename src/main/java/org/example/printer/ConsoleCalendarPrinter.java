package org.example.printer;


import org.example.model.MonthCalendar;
import org.example.util.CalendarConstants;

import java.util.List;
import java.util.Objects;

/**
 * Вывод календаря в консоль.
 * Форматирует каждый месяц в виде таблицы с днями недели,
 * начиная с понедельника.
 */
public class ConsoleCalendarPrinter implements CalendarPrinter {
    private static final int DAYS_IN_WEEK = 7;
    private static final String DAY_FORMAT = "%2d ";
    private static final String EMPTY_CELL = "   ";

    /**
     * Вывод календаря за год в консоль
     * @param yearCalendar Список месяцев для отображения
     * @throws NullPointerException если переданный список null
     */
    @Override
    public void print(List<MonthCalendar> yearCalendar) {
        Objects.requireNonNull(yearCalendar, "Year calendar не может быть null");
        yearCalendar.forEach(this::printMonth);
    }

    /**
     * Выводит один месяц календаря в отформатированном виде.
     *
     * @param month данные месяца для отображения
     */
    private void printMonth(MonthCalendar month) {
        printMonthHeader(month);
        printMonthDays(month);
    }

    private void printMonthHeader(MonthCalendar month) {
        System.out.printf("\n%s %d\n", month.monthName(), month.year());
        System.out.println(CalendarConstants.WEEK);
    }

    private void printMonthDays(MonthCalendar month) {
        printLeadingSpaces(month);
        printDaysWithWeekBreaks(month);
        System.out.println();
    }

    private void printLeadingSpaces(MonthCalendar month) {
        int padding = month.startDayOfWeek() - 1;
        for (int i = 0; i < padding; i++) {
            System.out.print(EMPTY_CELL);
        }
    }

    private void printDaysWithWeekBreaks(MonthCalendar month) {
        int dayCounter = 1;
        for (int day : month.days()) {
            System.out.printf(DAY_FORMAT, day);
            if ((month.startDayOfWeek() - 1 + dayCounter++) % DAYS_IN_WEEK == 0) {
                System.out.println();
            }
        }
    }
}
