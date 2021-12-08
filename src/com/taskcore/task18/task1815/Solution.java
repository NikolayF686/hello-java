package com.taskcore.task18.task1815;

import java.util.List;

/* 
Таблица
Измени класс TableInterfaceWrapper так, чтобы он стал Wrapper-ом для TableInterface.
Метод setModel должен вывести в консоль количество элементов в списке перед обновлением модели
(вызовом метода setModel у объекта типа TableInterface).
Метод getHeaderText должен возвращать текст в верхнем регистре - используй метод toUpperCase().


Requirements:
1. Класс TableInterfaceWrapper должен реализовывать интерфейс TableInterface.
2. Класс TableInterfaceWrapper должен инициализировать в конструкторе поле типа TableInterface.
3. Метод setModel() должен вывести в консоль количество элементов в новом листе перед обновлением модели.
4. Метод getHeaderText() должен возвращать текст в верхнем регистре.
5. Метод setHeaderText() должен устанавливать текст для заголовка без изменений.
*/

public class Solution {
    public class TableInterfaceWrapper implements TableInterface {
        /*Данная обертка для интерфейса будет работать
         для ТЕХ КЛАССОВ КОТОРЫЕ РЕАЛИЗУЮТ ИНТЕРФЕЙС TableInterface
        TableInterface table2 = new TableInterfaceWrapper(new Table());
        table2.setModel(); - вызывает метод класса  TableInterfaceWrapper.
        Создаем свою реализацию методов доступных в интерфейсе который реализуем
        Создаем поле в которое будем принимать оборачиваемый объект реализующий интерфейс TableInterface

         */
        TableInterface table;

        // В конструкторе принимаем инициализируем поле входящим объектом
        public TableInterfaceWrapper(TableInterface table) {
            this.table = table;

        }

        // переопределяем методы доступные в интерфейсе и задаем реализацию этих методов согласно условия
        @Override
        public void setModel(List rows) {
            System.out.println(rows.size());//выводим в консоль количество элементов в коллекции
            table.setModel(rows);//делегируем вызов метода объекту который оборачиваем
        }

        @Override
        public String getHeaderText() {
            return table.getHeaderText().toUpperCase();
        }
        //
        // метод возвращает значение - текст в верхнем регистре
        @Override
        public void setHeaderText(String newHeaderText) {
            table.setHeaderText(newHeaderText);
        }
        //метод отрабатывает без изменений.
    }

    public interface TableInterface {
        void setModel(List rows);

        String getHeaderText();

        void setHeaderText(String newHeaderText);
    }

    public static void main(String[] args) {
    }
}