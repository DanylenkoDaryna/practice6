package ua.nure.danylenko.practice6.part4;

public class Part4 {

    public static void main(String[] args){
        Range range = new Range(3, 10);
        for (Integer el : range) {
            System.out.printf("%d ", el);
        }
        // result: 3 4 5 6 7 8 9 10
        System.out.println();

        range = new Range(3, 10, true);
        for (Integer el : range) {
            System.out.printf("%d ", el);
        }
        // result: 10 9 8 7 6 5 4 3
        System.out.println();
    }
}