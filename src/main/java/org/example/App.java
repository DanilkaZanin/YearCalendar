package org.example;


import org.example.model.MonthCalendar;
import org.example.printer.CalendarPrinter;
import org.example.printer.ConsoleCalendarPrinter;
import org.example.service.CalendarService;
import org.example.service.GregorianCalendarService;

import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите год: ");
        int year = scanner.nextInt();

        CalendarService generator = new GregorianCalendarService();
        CalendarPrinter printer = new ConsoleCalendarPrinter();

        List<MonthCalendar> calendar = generator.generateYear(year);
        printer.print(calendar);
    }
}
