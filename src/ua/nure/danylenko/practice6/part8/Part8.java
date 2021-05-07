package ua.nure.danylenko.practice6.part8;

import java.util.stream.Stream;

public class Part8 {

    public static void main (String ...args){

        //знаходимо голосні та приголосні
        // у строці.тільки букви і пробіли
        // використати toChararray & charAt
        System.out.println("Checking out...");

        vowelsConsCounter("HellO");
        vowelsConsCounter("there is a quiet Mouse");
        vowelsConsCounter("I am happy");

    }

    public static void vowelsConsCounter(String input){

        int vowels = 0;
        int consonants = 0;
        char[]array = input.trim().toCharArray();
       
        System.out.printf("in \'%s\' string %s vowels and %s consonants", input,vowels,consonants);
        System.out.println();

    }

}
