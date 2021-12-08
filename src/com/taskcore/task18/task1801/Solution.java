package com.taskcore.task18.task1801;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* 
Максимальный байт
Ввести с консоли имя файла.
Найти максимальный байт в файле, вывести его на экран.
Закрыть поток ввода-вывода.


Requirements:
1. Программа должна считывать имя файла с консоли.
2. Для чтения из файла используй поток FileInputStream.
3. В консоль должен выводиться максимальный байт, считанный из файла.
4. Поток чтения из файла должен быть закрыт.
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String way = reader.readLine();
        FileInputStream stream = new FileInputStream(way);
        int max = 0;
        //byte [] buffer = new byte[4096];
        while (stream.available() >0) {
            int read_byte = stream.read();
            if (read_byte > max) {
                max = read_byte;

            }
            //System.out.println(read_byte); г9у3я
            //System.out.println(max);
        }
        reader.close();
        stream.close();
        System.out.println(max);

    }
}
