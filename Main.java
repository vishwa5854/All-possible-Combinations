package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.print("Enter a string : ");
        Scanner scanner = new Scanner(System.in);
        String lol = scanner.nextLine();
        ArrayList<String> input = new ArrayList<>();
        for(int i=0;i<lol.length();i++){
            input.add(lol.substring(i,i+1));
        }
        process(lol,input);
        for(String a : input){
            System.out.println(a);
        }
        System.out.println(input.size());
    }

    private static void process(String lol, ArrayList<String> input) {
        for(int i=0;i<lol.length()-1;i++) {
            int temp = input.size();
            generateTwoAtATime(temp,input,lol.length(),lol);
            if (temp > 0) {
                input.subList(0, temp).clear();
            }
        }
    }

    private static void generateTwoAtATime(int end, ArrayList<String> input, int initial, String lol) {
        for(int i = 0; i<end; i++){
            for(int j=0;j<initial;j++){
                if(!contains(input.get(i),lol.charAt(j))) {
                    input.add(input.get(i) + lol.charAt(j));
                }
            }
        }
    }

    private static boolean contains(String a, char b){
        int count = 0;
        for(int i=0;i<a.length();i++){
            if(a.charAt(i) == b){
                count++;
            }
        }
        return count > 0;
    }
}
