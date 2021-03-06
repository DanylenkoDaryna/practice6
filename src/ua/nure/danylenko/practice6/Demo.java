package ua.nure.danylenko.practice6;

import ua.nure.danylenko.practice6.part1.Part1;
import ua.nure.danylenko.practice6.part2.Part2;
import ua.nure.danylenko.practice6.part3.Part3;
import ua.nure.danylenko.practice6.part4.Part4;
import ua.nure.danylenko.practice6.part5.Part5;
import ua.nure.danylenko.practice6.part6.Part6;

import java.io.IOException;

public class Demo {

    public static void main(String[] args) throws IOException {
        Part1.main(args);
        Part2.main(args);
        Part3.main(args);
        Part4.main(args);
        Part5.main(args);
        System.out.println("~~~~~~~~~~~~Part6");
        Part6.main(new String[] {"--input", "part6.txt", "--task", "frequency"});
        Part6.main(new String[] {"--input", "part6.txt", "--task", "length"});
        Part6.main(new String[] {"-i", "part6.txt", "-t", "duplicates"});

    }

}
