package ru.polinaegubova.summator;

public class Main {

    public static void main(String[] args) {
        if (args.length != 2) {
            System.err.println("Usage: [filename] [arg1] [arg2] returns sum of arg1 and arg2");
            return;
        }

        int arg1, arg2;
        try {
            arg1 = Integer.parseInt(args[0]);
            arg2 = Integer.parseInt(args[1]);
        } catch (NumberFormatException e) {
            System.err.println("Could not parse integer arguments");
            return;
        }

        System.out.println(Summator.sum(arg1, arg2));
    }
}
