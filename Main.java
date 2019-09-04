package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static int i = 1;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the input String : ");
        String lol = scanner.nextLine();
        List<String> c = new ArrayList<>();
        for(int m=0;m<lol.length();m++){
            c.add(String.valueOf(lol.charAt(m)));
        }
        String finalString = "";
        process(c, finalString);
    }

    private static void process(List<String> c, String finalString) {
        if (c.size() == 1) {
            System.out.println(i++ + finalString.concat(c.get(0)));
            return; // just moves back to the previous function recursive call
        }
        for (int i = 0; i < c.size(); i++) {
            String remove = c.remove(i);
            process(new ArrayList<>(c), finalString.concat(remove));
            c.add(i, remove);
        }
    }
}
