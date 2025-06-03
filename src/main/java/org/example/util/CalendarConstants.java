package org.example.util;

/**
 *  Utility класс для констант календаря
 */
public final class CalendarConstants {
    private CalendarConstants() {
        throw new AssertionError("Нельзя создать экземпляр утилитарного класса");
    }

    public static final String WEEK = "Пн Вт Ср Чт Пт Сб Вс";

    public static final String[] MONTH_NAMES = {
            "Январь", "Февраль", "Март", "Апрель", "Май", "Июнь",
            "Июль", "Август", "Сентябрь", "Октябрь", "Ноябрь", "Декабрь"
    };
}
