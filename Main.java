package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.print("Enter the String : ");
        Scanner scanner = new Scanner(System.in);
        String lol = scanner.nextLine();
        ArrayList<String> input = new ArrayList<>();
        for(int i=0;i<lol.length();i++){
            input.add(lol.substring(i,i+1));
        }
        process(lol, input);
        ArrayList<String> output = new ArrayList<>();
        removeRedundancies(input,lol,output);

    }

    private static void removeRedundancies(ArrayList<String> input,String lol,ArrayList<String> output){
        for(String a : input){
            if(a.length() == lol.length()){
                output.add(a);
            }
        }
        String[] temp = new String[output.size()];
        for(int i=0;i<output.size();i++){
            temp[i] = output.get(i);
        }
        removeRedundantAttributes(output, temp);
        for(String a : output){
            System.out.println(a);
        }
    }

    private static void removeRedundantAttributes(ArrayList<String> output, String[] temp) {
        for (String s : temp) {
            int count = 0;
            for(int i=0;i<s.length();i++){
                for(int j=0;j<s.length();j++){
                    if(s.charAt(i) == s.charAt(j)){
                        count++;
                    }
                }
            }
            if(count > 4){
                output.remove(s);
            }
        }
    }

    private static void process(String lol, ArrayList<String> input) {
        int start = 0;
        int stop = lol.length();
        for(int i=0;i<lol.length()-1;i++) {
            generateTwoAtATime(start,stop,input,lol.length());
            start = stop;
            stop = input.size();
        }
    }

    private static void generateTwoAtATime(int start,int end,ArrayList<String> med,int initial) {
        for(int i=start;i<end;i++){
            for(int j=0;j<initial;j++){
                med.add(med.get(i) + med.get(j));
            }
        }
    }
}
