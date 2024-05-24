package org.example;

import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.*;

/**
 * Marking will be based upon producing a readable, well engineered solution rather than factors
 * such as speed of processing or other performance-based optimizations, which are less
 * important.
 *
 *
 package org.example;

 import java.time.LocalDate;
 import java.util.Collection;
 import java.util.List;

 /**
 * Marking will be based upon producing a readable, well engineered solution rather than factors
 * such as speed of processing or other performance-based optimizations, which are less
 * important.
 *
 * Implement in single class. Don't chane constructor and signature method.
 */
public class DateSorter {
    public static void main(String[] args) {
        LocalDate date1 = LocalDate.parse("2004-07-01");
        LocalDate date2 = LocalDate.parse("2005-01-02");
        LocalDate date3 = LocalDate.parse("2007-01-01");
        LocalDate date4 = LocalDate.parse("2032-05-03");
        LocalDate date5 = LocalDate.parse("2010-02-15");
        LocalDate date6 = LocalDate.parse("2021-03-18");
        LocalDate date7 = LocalDate.parse("2016-04-21");
        LocalDate date8 = LocalDate.parse("2050-06-03");
        LocalDate date9 = LocalDate.parse("1998-08-10");
        List<LocalDate> localDates = List.of(date1, date2, date3, date4, date5, date6, date7, date8, date9);
        DateSorter dateSorter = new DateSorter();
        dateSorter.sortDates(localDates).forEach(System.out::println);
    }

    /**
     * The implementation of this method should sort dates.
     * The output should be in the following order:
     * Dates with an 'r' in the month,
     * sorted ascending (first to last),
     * then dates without an 'r' in the month,
     * sorted descending (last to first).
     * For example, October dates would come before May dates,
     * because October has an 'r' in it.
     * thus: (2004-07-01, 2005-01-02, 2007-01-01, 2032-05-03)
     * would sort to
     * (2005-01-02, 2007-01-01, 2032-05-03, 2004-07-01)
     *
     * @param unsortedDates - an unsorted list of dates
     * @return the collection of dates now sorted as per the spec
     */
    public Collection<LocalDate> sortDates(List<LocalDate> unsortedDates) {
        List<LocalDate> datesWithRSymbol = unsortedDates.stream()
                .filter(date -> date.getMonth().getDisplayName(TextStyle.FULL, Locale.ENGLISH).toLowerCase().contains("r"))
                .sorted()
                .toList();
        List<LocalDate> datesWithoutRSymbol = unsortedDates.stream()
                .filter(date -> !date.getMonth().getDisplayName(TextStyle.FULL, Locale.ENGLISH).toLowerCase().contains("r"))
                .sorted(Comparator.reverseOrder())
                .toList();
        List<LocalDate> sortedList = new ArrayList<>();

        sortedList.addAll(datesWithRSymbol);
        sortedList.addAll(datesWithoutRSymbol);
        return sortedList;
    }
}