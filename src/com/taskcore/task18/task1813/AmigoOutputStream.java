package com.taskcore.task18.task1813;


import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

/* 
AmigoOutputStream

1 Измени класс AmigoOutputStream так, чтобы он стал Wrapper-ом для класса FileOutputStream.
Используй наследование.
2 При вызове метода close() должны выполняться следующая последовательность действий:
2.1 Вызвать метод flush().
2.2 Записать в конец файла фразу "JavaRush © All rights reserved.", используй метод getBytes().
2.3 Закрыть поток методом close().


Requirements:
1. Метод main изменять нельзя.
2. Класс AmigoOutputStream должен наследоваться от класса FileOutputStream.
3. Класс AmigoOutputStream должен принимать в конструкторе объект типа FileOutputStream.
4. Все методы write(), flush(), close() в классе AmigoOutputStream должны делегировать свое выполнение объекту FileOutputStream.
5. Метод close() должен сначала вызвать метод flush(), затем записать в конец файла текст, затем закрыть поток.
*/

public class AmigoOutputStream extends FileOutputStream {
    //public static String fileName = "C:/tmp/result.txt";
    public static String fileName = "D:/1/12.txt";
    FileOutputStream field;

    //Создаем конструктор декоратора в котором вызываем родительский объект, но уже в двуме параметрами :
    //1й параметр это путь к файлу, 2й параметр это append true, разрешаем дозаписывать в конец файла
    AmigoOutputStream(FileOutputStream field) throws FileNotFoundException {
       // Из моего решения
        // super(String.valueOf(field), true);

        // Из правильного решения
        super(fileName,true); //вызываем конструктор родителя передаем в него путь к файлу
        this.field=field;// поле декоратора инициализируем объектом FileOutputStream, который будем декорировать

    }


    public static void main(String[] args) throws FileNotFoundException {
        new AmigoOutputStream(new FileOutputStream(fileName));
        //для того чтобы файл дописывался необходимо изменить порядок создания объекта, добавить параметр append c
        // флагом true и закрыть поток
        //new AmigoOutputStream(new FileOutputStream(fileName, true)).close();
    }

    // переопределяем методы
    //добавляем в методы делегирование вызова (передачу вызова объекту FileOutputStream , родителю)
    @Override
    public void write(int b) throws IOException {
        field.write(b);
    }

    public void write(byte[] b) throws IOException {
        field.write(b);
    }

    @Override
    public void write(byte[] b, int off, int len) throws IOException {
        field.write(b, off, len);
    }

    @Override
    public void flush() throws IOException {
        field.flush();
    }

    @Override
    public void close() throws IOException {
        //изменяем реализацию родительского метода close(), добавляем сюда дополнительный вызов, field.flush(),
        //field.write() с параметром строко дозаписанной в конец имеющегося файла, и метод close()
        //получается эти методы делегируют свое выполнение объекту FileOutputStream
        //вызывая их у обертки AmigoOutputStream, она передает вызов классу FileOutputStream который оборачивает.
        field.flush();
        field.write("JavaRush © All rights reserved.".getBytes(StandardCharsets.UTF_8));
        field.close();
    }

}
