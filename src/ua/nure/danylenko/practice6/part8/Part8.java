package ua.nure.danylenko.practice6.part8;


import java.util.List;
import java.util.stream.Collectors;

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

        vowelsConsCounter2("HellO");
        vowelsConsCounter2("there is a quiet Mouse");
        vowelsConsCounter2("I am happy");

        vowelsConsCounter3("HellO");
        vowelsConsCounter3("there is a quiet Mouse");
        vowelsConsCounter3("I am happy");

    }



    private static void vowelsConsCounter(String input){

        System.out.println("Method 1");

        int vowels = 0;
        int consonants;

        String vowelStr ="aeiouy";
        String editedInput=input.toLowerCase().replaceAll(" ","");

        char[] inputArray = editedInput.toCharArray();
        char[]vowelArray = vowelStr.toCharArray();


        for(char letter :inputArray){

            for(char vowel:vowelArray){
                if(letter==vowel){
                    vowels+=1;
                }
            }

        }

        consonants = inputArray.length - vowels;

        System.out.printf("in \'%s\' string %s vowels and %s consonants", input, vowels, consonants);
        System.out.println();

    }

    private static void vowelsConsCounter2(String input){

        System.out.println("Method 2");

        int vowels = 0;
        int consonants;
        char[] editedInput=input.toLowerCase().replaceAll(" ","").toCharArray();

        String vowelStr ="aeiouy";
        for(int i=0; i<editedInput.length; i++){
            for(int j=0; j<vowelStr.length(); j++){

                if(editedInput[i]==vowelStr.charAt(j)){
                    vowels+=1;
                }
            }
        }

        consonants = editedInput.length - vowels;

        System.out.printf("in \'%s\' string %s vowels and %s consonants", input, vowels, consonants);
        System.out.println();

    }

    private static void vowelsConsCounter3(String input){

        System.out.println("Method 3");

        String editedInput=input.toLowerCase().replaceAll(" ","");
        String vowelStr ="aeiouy";

        List<Integer> letters = editedInput.chars().boxed().collect(Collectors.toList());

        long vChars = letters.stream()
                .filter(letter -> vowelStr.indexOf(letter)!=-1).count();


        System.out.printf("in \'%s\' string %s vowels and %s consonants", input, vChars, letters.size()-vChars);
        System.out.println();

    }

}
