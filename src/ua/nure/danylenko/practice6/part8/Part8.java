package ua.nure.danylenko.practice6.part8;

import java.util.function.IntPredicate;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Part8 {

    public static void main (String ...args){

        //знаходимо голосні та приголосні
        // у строці.тільки букви і пробіли
        // використати toChararray & charAt
        //a, e, i, o, u and sometimes y
        System.out.println("Checking out...");

        vowelsConsCounter("HellO");
        vowelsConsCounter("there is a quiet Mouse");
        vowelsConsCounter("I am happy");


    }

    private static void vowelsConsCounter(String input){

        int vowels = 0;
        int consonants = 0;

        String vowelStr ="aeiouy";
        String editedInput=input.trim().toLowerCase();

        char[]array = editedInput.toCharArray();
        char[]vowelArray = vowelStr.toCharArray();

        for(char ch:array){

            for(char vow:vowelArray){

                if(ch==vow){
                    vowels+=1;
                }
            }
            
        }

        consonants=editedInput.length() - vowels;

        System.out.printf("in \'%s\' string %s vowels and %s consonants", input, vowels, consonants);
        System.out.println();

    }

}
