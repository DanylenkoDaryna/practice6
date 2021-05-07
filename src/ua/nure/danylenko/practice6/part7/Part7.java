package ua.nure.danylenko.practice6.part7;

public class Part7 {

    public static void main (String ...args){
        //перевірка паліндрому
    //пунктуація, символи мають також перевірятися на правило паліндрому
    //верхній та нижній регістр виключення
        //Civic
        System.out.println("Checking out...");
        System.out.println("is tree a palindrome? - " + palindromeChecker("tree"));
        System.out.println("is \'appa\' a palindrome? - " + palindromeChecker("appa"));
        System.out.println("is \'der sun tenet nus red\' a palindrome? - " +
                palindromeChecker("der sun tenet nus red"));
        System.out.println("is \'der sun tenet nus red.\' a palindrome? - " +
                palindromeChecker("der sun tenet nus red."));
        System.out.println("is \'der sun - tenet - nus red\' a palindrome? - " +
                palindromeChecker("der sun - tenet - nus red"));
        System.out.println("is \'Civic\' a palindrome? - " + palindromeChecker("Civic"));
        System.out.println("is \'Civic \' a palindrome? - " + palindromeChecker("Civic "));
        System.out.println("is \'CivIc\' a palindrome? - " + palindromeChecker("Civic"));

        System.out.println("is \'maDam\' a palindrome? - " + palindromeChecker("maDam"));
        System.out.println("is \'raceCar\' a palindrome? - " + palindromeChecker("raceCar"));
        System.out.println("is \'aBba\' a palindrome? - " + palindromeChecker("aBba"));
        System.out.println("is \'swims\' a palindrome? - " + palindromeChecker("swims"));
        System.out.println("is \'wIfi\' a palindrome? - " + palindromeChecker("wIfi"));

    }

    private static boolean palindromeChecker(String input){
        boolean result = false;
        char[] arr = input.toLowerCase().toCharArray();
        int j=arr.length-1;
        for (char element:arr) {
                if(element==arr[j]){
                    result = true;
                    if(input.indexOf(element)>(arr.length/2)){
                        break;
                    }
                }else{
                    result = false;
                    break;
                }
            j--;
        }

        return result;
    }

}
