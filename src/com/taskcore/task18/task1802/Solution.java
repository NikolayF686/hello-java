package com.taskcore.task18.task1802;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/* 
Минимальный байт
Ввести с консоли имя файла.
Найти минимальный байт в файле, вывести его на экран.
Закрыть поток ввода-вывода.


Requirements:
1. Программа должна считывать имя файла с консоли.
2. Для чтения из файла используй поток FileInputStream.
3. В консоль должен выводиться минимальный байт, считанный из файла.
4. Поток чтения из файла должен быть закрыт.
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String way = reader.readLine();
        FileInputStream stream = new FileInputStream(way);
        int min = Integer.MAX_VALUE;
        while(stream.available()>0){//пока количество байт в потоке больше 0, цикл крутится
            int val = stream.read();
            if(val<min){
                min=val;
            }
        }
        stream.close();
        reader.close();
        System.out.println(min);
        //   D:\\1\12.txt
    }
}
