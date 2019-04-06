package ru.polinaegubova.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {

    static class MyClass {

        private int value;
        MyClass() { value = 100; }
        public void setValue(int value) {this.value = value; }
        private void printHello() { value = 10; }
    }

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, NoSuchMethodException, InvocationTargetException {

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

        for (int i = 0; i < 2000000; i++) {
            myClass.printHello();
        }

        long time4 = System.currentTimeMillis();

        final Method method = myClass.getClass().getDeclaredMethod("printHello");
        method.setAccessible(true);
        for (int i = 0; i < 2000000; i++) {
            method.invoke(myClass);
        }

        long time5 = System.currentTimeMillis();

        System.out.println("Start time for setter (ms): " + time1);
        System.out.println("Time after setValue (ms): " + time2);
        System.out.println("Time after reflection (ms): " + time3);
        System.out.println();
        System.out.println("Start time for method (ms): " + time3);
        System.out.println("Time after execute metod (ms): " + time4);
        System.out.println("Time after reflection (ms): " + time5);

    }
}
