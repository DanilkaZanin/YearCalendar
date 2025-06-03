package org.example.service;

import org.example.model.MonthCalendar;

import java.util.List;

/**
 * Генерация календаря
 */
public interface CalendarService {
    /**
     * Генерация календаря на год
     */
    List<MonthCalendar> generateYear(int year);
}
