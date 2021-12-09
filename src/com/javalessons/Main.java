package com.javalessons;

/*
Кубический калькулятор в кубе
*/


import java.util.LinkedList;
import java.util.Set;
import java.util.TreeSet;

class Beach implements Comparable<Beach>{

    private String name;      //название
    private float distance;   //расстояние
    private int quality;    //качество

    public Beach(String name, float distance, int quality) {
        this.name = name;
        this.distance = distance;
        this.quality = quality;
    }

    public synchronized String getName() {
        return name;
    }

    public synchronized void setName(String name) {
        this.name = name;
    }

    public synchronized float getDistance() {
        return distance;
    }

    public synchronized void setDistance(float distance) {
        this.distance = distance;
    }

    public synchronized int getQuality() {
        return quality;
    }

    public synchronized void setQuality(int quality) {
        this.quality = quality;
    }

public static void main(String[] args) {
        Set set = new TreeSet();
    set.add(new Beach("qwer",3,540));
        set.add(new Beach("qwer",30,54));

        for(Object o:set){
            System.out.println(o);

        }




 /*   public static void main(String[] args) throws IOException {
String [] array = new String[]{null,"Вася",null,"Петя",null,"Миша"};

        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] == null && array[j]!=null) {
                    String k = array[j];
                    array[j] = array[i];
                    array[i] = k;
                }
            }nce) {
        this.distance = distance;
    }

   /* public synchronized int getQuality() {
        return quality;
    }*/

  /*  public synchronized void setQuality(int quality) {
        this.quality = quality;
    }*/


    }


    @Override
    public synchronized int compareTo(Beach o) {

    int result=0;
    int result1;
    int result2;
        //int quality = Integer.compare(this.quality, o.getQuality());
        int quality = Integer.compare(o.getQuality(),this.quality );
        //int distance = (Double.compare(this.distance, o.getDistance()));
       // if(quality<0) {quality=1;}
       int distance = (Double.compare( o.getDistance(),this.distance));

        int quality1 = Integer.compare(this.quality, o.getQuality());
        int distance1 = (Double.compare(this.distance, o.getDistance()));
        result1 = quality + distance;
        result2 = quality1 + distance1;
        result =result1+result2;


        return result;
       // int quality = Integer.compare(o.getQuality(),this.quality );

        //int distance = (Float.compare(this.distance, o.getDistance()));
        //int distance = (Float.compare( o.getDistance(),this.distance));
        //if(distance<0) {distance=1;}
        //int result = quality+distance;




       /* if (this.quality > o.getQuality() && this.distance < o.getDistance()) {
            return 1;
        } if (this.quality < o.getQuality() && this.distance > o.getDistance()) return -1;
        /*
        } else if (this.quality < o.getQuality() && this.distance > o.getDistance()) {
            return -1;
        } else if (this.quality == o.getQuality() && this.distance == getDistance()) return 0;

        int qua = this.quality - o.getQuality();//
        float dis = this.distance - o.getDistance();
        return qua == 0 && dis ==0 ? 0 : qua && dis;*/

    }
    @Override
    public String toString() {
        return "Main{" +
                "name='" + name + '\'' +
                ", distance=" + distance +
                ", quality=" + quality +
                '}';
    }
}


