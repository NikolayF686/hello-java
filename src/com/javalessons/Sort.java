package com.javalessons;

import java.io.*;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Sort {
    public static void main(String[] args) throws IOException {
       /* BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file_name = reader.readLine();
        InputStream file_stream = new FileInputStream(file_name);
        int[] array = new int[256];
        while (file_stream.available() > 0) {
            int value = file_stream.read();
            array[value] = value;
        }
        System.out.println(Arrays.toString(array));
        //Осталось только убрать нули и вывести в консоль уже отсортированные байты:
        int[] array1 =  Arrays.stream(array).filter(x -> x != 0).toArray();
        for (int j : array1) {
            System.out.print(j + " ");
        }*/

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String url = reader.readLine();
        String paramsSubString = url.substring(url.lastIndexOf("?") + 1);//выделяем подстроку от знака вопроса до конца строки
        String[] splitParams = paramsSubString.split("&");//заносим в массив значения до разделителя & и после разделителя &
        String objValue = null;

        StringBuilder resultBuilder = new StringBuilder();
        for (String splitParam : splitParams) {
            String[] paramAndValue = splitParam.split("=");
            resultBuilder.append(paramAndValue[0]);
            resultBuilder.append(" ");

            if (paramAndValue[0].equals("obj")) {
                objValue = paramAndValue[1];
            }
        }
///
        System.out.println(resultBuilder.toString().trim());

        if (objValue != null) {
            try {
                alert(Double.parseDouble(objValue));
            } catch (NumberFormatException nfe) {
                alert(objValue);
            }
        }
    }
    public static void alert(double value) {
        System.out.println("double: " + value);
    }

    public static void alert(String value) {
        System.out.println("String: " + value);
    }

}
