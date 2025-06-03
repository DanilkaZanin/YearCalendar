package org.example.model;

import java.util.List;

/**
 * Модель данных для представления календаря одного месяца
 *
 * @param monthName      Название месяца (на русском)
 * @param year           Год
 * @param days           Список дней месяца (1-31)
 * @param startDayOfWeek День недели первого дня месяца (1-Пн, 7-Вс)
 */
public record MonthCalendar(String monthName, int year, List<Integer> days, int startDayOfWeek) { }
