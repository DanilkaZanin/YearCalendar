package org.example.printer;

import org.example.model.MonthCalendar;

import java.util.List;

/**
 * Вывод календаря
 */
public interface CalendarPrinter {
    /**
     * Выводит календарь на год
     * @param yearCalendar Список месяцев с данными
     */
    void print(List<MonthCalendar> yearCalendar);
}
