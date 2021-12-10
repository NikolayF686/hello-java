package com.javalessons3;



import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;


public class Solutions {

    private static final long MIN_DAY = LocalDate.of(1990, 1, 1).toEpochDay();
    private static final long MAX_DAY = LocalDate.of(2020, 12, 31).toEpochDay();

    private static long maxNano = 86399999999999L;

    public static LocalDate generateDate() {
        long randomDay = ThreadLocalRandom.current().nextLong(MIN_DAY, MAX_DAY);
        return LocalDate.ofEpochDay(randomDay);
    }

    public static LocalTime generateTime() {
        long randomTime = ThreadLocalRandom.current().nextLong(0, maxNano);
        return LocalTime.ofNanoOfDay(randomTime);
    }

    public static List<LocalTime> generateTimeList() {
        List<LocalTime> timeList = new ArrayList<>();
        int size = ThreadLocalRandom.current().nextInt(1, 5);
        for (int i = 0; i < size; i++) {
            timeList.add(generateTime());
        }
        return timeList;
    }

    public static Map<LocalDate, List<LocalTime>> generateDateMap() {
        Map<LocalDate, List<LocalTime>> dateMap = new HashMap<>();
        int size = ThreadLocalRandom.current().nextInt(3, 7);
        for (int i = 0; i < size; i++) {
            dateMap.put(generateDate(), generateTimeList());
        }
        return dateMap;
    }

    public static void main(String[] args) throws IOException {

        Map<LocalDate, List<LocalTime>> dateMap = Solutions.generateDateMap();
        printCollection(dateMap.entrySet());
        Set<LocalDateTime> dateSet = convert(dateMap);
        printCollection(dateSet);

    }

    static Set<LocalDateTime> convert(Map<LocalDate, List<LocalTime>> sourceMap){
        Set<Map.Entry<LocalDate, List<LocalTime>>> entries = sourceMap.entrySet();
        HashSet<LocalDateTime> localdatetime = new HashSet<>();
        for (Map.Entry<LocalDate, List<LocalTime>> pair : entries) {
            LocalDate date = pair.getKey();
            List<LocalTime> time = pair.getValue();

            for (LocalTime x: time) {
                LocalDateTime all = LocalDateTime.of(date, x);
                localdatetime.add(all);
            }
        }

        return localdatetime;
    }
    static void printCollection(Collection<?> collection) {
        System.out.println("-----------------------------------------------------");
        collection.forEach(System.out::println);
    }
}