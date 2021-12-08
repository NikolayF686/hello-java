package com.taskcore.task18.task1809;

import java.io.*;

/* 
Реверс файла
*/

public class Solution {


    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String line_1 = reader.readLine();
        InputStream stream_1 = new FileInputStream(line_1);

        BufferedReader reader_2 = new BufferedReader(new InputStreamReader(System.in));
        String line_2 = reader_2.readLine();
        OutputStream stream_2 = new FileOutputStream(line_2);


        byte[] buffer = new byte[stream_1.available()];
        //задаем размер буффера массива количеством доступных байтов в потоке

        //можно было создать объект файл а затем вызвать метод по определению его размера.
        while (stream_1.available() > 0) {//пока в потоке есть байты  крутим цикл
            int val = stream_1.read(buffer);
            byte temp;
            for (int i = 0; i < buffer.length / 2; i++) {//выполняем разворот массива
                temp = buffer[i];
                buffer[i] = buffer[buffer.length - i - 1];
                buffer[buffer.length - i - 1] = temp;
            }
            //как вариант можно читать буффер с конца и писать сразу во второй файл в обратном порядке
            stream_2.write(buffer, 0, val);

        }
        stream_1.close();
        stream_2.close();


        // путь к файлу для тестирования кода
        // D:\\1\12.txt  D:\\1\13.txt

        /* Решения с Java Rush

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String inputFile = reader.readLine();
        String outputFile = reader.readLine();

        try (FileInputStream fileInputStream = new FileInputStream(inputFile);
             FileOutputStream fileOutputStream = new FileOutputStream(outputFile)) {

            List<Integer> inputBytes = new ArrayList<>();
            while (fileInputStream.available() > 0) {
                inputBytes.add(fileInputStream.read());
            }
            Collections.reverse(inputBytes);
            for (Integer aByte : inputBytes) {
                fileOutputStream.write(aByte);
            }
        }*/
    }
}

