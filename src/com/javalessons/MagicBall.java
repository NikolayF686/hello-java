package com.javalessons;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class MagicBall {
    ///
    private static final String CERTAIN = "Бесспорно";
    private static final String DEFINITELY = "Определённо да";
    private static final String MOST_LIKELY = "Вероятнее всего";
    private static final String OUTLOOK_GOOD = "Хорошие перспективы";
    private static final String ASK_AGAIN_LATER = "Спроси позже";
    private static final String TRY_AGAIN = "Попробуй снова";
    private static final String NO = "Мой ответ — нет";
    private static final String VERY_DOUBTFUL = "Весьма сомнительно";

  /*  public static String getPrediction() {
        Random x = new Random();
        String[] Array = {CERTAIN, DEFINITELY, MOST_LIKELY, OUTLOOK_GOOD, ASK_AGAIN_LATER, TRY_AGAIN, NO, VERY_DOUBTFUL};
        int y;
        y = x.nextInt(8);
String z = null;
        if (y > 8) {
            return z;
        } else return Array[y];

     //   int y = new Random().nextInt(8); альтернативное объявление и создание объекта класса Random;
    }
}*/


    public static String getPrediction() {
        Random x = new Random();
        String[] Array = {CERTAIN, DEFINITELY, MOST_LIKELY, OUTLOOK_GOOD, ASK_AGAIN_LATER, TRY_AGAIN, NO, VERY_DOUBTFUL};
        int y;
        y = x.nextInt(8);
        switch (y) {
            case 0:
                return Array[0];
            case 1:
                return Array[1];
            case 2:
                return Array[2];
            case 3:
                return Array[3];
            case 4:
                return Array[4];
            case 5:
                return Array[5];
            case 6:
                return Array[6];
            case 7:
                return Array[7];
            default:
                return null;

        }
    }
}