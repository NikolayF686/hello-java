package com.taskcore.task18.task1810;

import java.io.*;

/* 
DownloadException

1 Считывать с консоли имена файлов.
2 Если файл меньше 1000 байт, то:
2.1 Закрыть потоки работы с файлами.
2.2 Выбросить исключение DownloadException.


Requirements:
1. Программа должна считать имена файлов с консоли.
2. Для чтения из файлов используй поток FileInputStream.
3. Программа должна работать, пока введенный файл не окажется меньше 1000 байт.
4. Программа должна завершиться исключением DownloadException.
5. Поток FileInputStream должен быть закрыт.
*/

public class Solution {
    public static void main(String[] args) throws IOException, DownloadException {
        while (true) {//крутим бесконечный цикл
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//читаем с консоли в буффер строку
            String file = reader.readLine();
            File one = new File(file);
            //На основании этой строки создаем объект файл
            InputStream stream = new FileInputStream(one);// создаем поток InputStream из этого файла
            if (one.length() < 1000) {
                //если размер файла меньше 1000 байт тогда закрываем поток и выкидываем исключение.
                stream.close();
                throw new DownloadException();
            }
            //D:\\1\12.txt
        }

    }

    public static class DownloadException extends Exception {

    }
}
