package ru.polinaegubova.reflection;

import java.lang.reflect.Field;

public class Main {

    static class MyClass {

        private int value;
        MyClass() { value = 100; }
        public void setValue(int value) {this.value = value; }
    }

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {

        MyClass myClass = new MyClass();

        long time1 = System.currentTimeMillis();

        for (int i = 0; i < 2000000; i++) {
            myClass.setValue(i);
        }

        long time2 = System.currentTimeMillis();

        final Field valueField = myClass.getClass().getDeclaredField("value");
        valueField.setAccessible(true);
        for (int i = 0; i < 2000000; i++){
            valueField.setInt(myClass, i);
        }

        long time3 = System.currentTimeMillis();

        System.out.println("Start time (ms): " + time1);
        System.out.println("Time after setValue (ms): " + time2);
        System.out.println("Time after reflection (ms): " + time3);
    }
}
