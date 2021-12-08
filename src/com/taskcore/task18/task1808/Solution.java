package com.taskcore.task18.task1808;

import java.io.*;

/* 
Разделение файла
Считать с консоли три имени файла: файл1, файл2, файл3.
Разделить файл1 по следующему критерию:
Первую половину байт записать в файл2, вторую половину байт записать в файл3.
Если в файл1 количество байт нечетное, то файл2 должен содержать большую часть.
Закрыть потоки.


Requirements:
1. Программа должна три раза считать имена файлов с консоли.
2. Для чтения из файла используй поток FileInputStream, для записи в файлы - FileOutputStream
3. Первую половину байт из первого файла нужно записать во второй файл.
4. Вторую половину байт из первого файла нужно записать в третий файл.
5. Потоки FileInputStream и FileOutputStream должны быть закрыты.
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        File file_1 = new File(reader.readLine());//создаем объекты файлы предварительно прочитав для них имя из консоли
        //считываем 3 имени файла
        File file_2 = new File(reader.readLine());
        File file_3 = new File(reader.readLine());
        InputStream stream = new FileInputStream(file_1);
        //для 1го файла создаем поток чтения
        //в остальные 2 файла будем записывать поэтому создаем для них потоки записи.
        OutputStream stream_out_2 = new FileOutputStream(file_2);
        OutputStream stream_out_3 = new FileOutputStream(file_3);
        //создаем буффер для хранения байтов , размер буффера равенколичеству доступных байт в потоке
        byte[] buffer = new byte[stream.available()];
        //пока есть байты в потоке крутим цикл
        while (stream.available() > 0) {
            //считываем файл в буффер байтов и сохраняем количество прочитанных байтов в переменную count
            int count = stream.read(buffer);
            if (count % 2 != 0) {
                //если количество байтов не четное в файле 1 тогда во второй файл записываем большую часть
                //остальное в 3й файл

                stream_out_2.write(buffer, 0, (count / 2) + 1);
                stream_out_3.write(buffer, (count / 2) + 1, count - ((count / 2) + 1));
                //если количество байтов четное записываем поровну в каждый файл количество байтов
            } else {
                stream_out_2.write(buffer, 0, (count / 2));
                stream_out_3.write(buffer, (count / 2), (count / 2));
            }
        }
        // D:\\1\12.txt
        // D:\\1\13.txt
        // D:\\1\14.txt
        //закрываем потоки входящие и исходящие.
        stream.close();
        stream_out_2.close();
        stream_out_3.close();

    }
}
