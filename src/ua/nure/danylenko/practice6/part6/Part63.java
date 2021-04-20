package ua.nure.danylenko.practice6.part6;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Part63 {
    public static void main(String[] args) throws IOException {
        List<LatinWord> container = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        try (BufferedReader in1 = new BufferedReader(new
                InputStreamReader(
                new FileInputStream(args[1])))) {
            String line;
            while ((line = in1.readLine()) != null) {
                sb.append(line).append(System.lineSeparator());
            }
        }
        String[] words = sb.toString().split(" |(\r\n)|\n|\r");
        for(String str:words){
            LatinWord word = new LatinWord(str);
            if(container.contains(word)){
                int index=container.indexOf(word);
                container.get(index).frequency=container.get(index).frequency+1;
            }else{
                container.add(word);
                int index=container.indexOf(word);
                container.get(index).letters=word.content.length();
            }
        }

        sortDuplicates(container);
    }

    private static void sortDuplicates(List<LatinWord> container) {
        List<LatinWord> result = new ArrayList<>();
        int i=0;
        while(result.size()!=3){
            if (container.get(i).frequency > 1) {
                result.add(container.get(i));
            }
            i=i+1;
        }


        for (LatinWord word:result) {
            StringBuilder sb = new StringBuilder();
            word.content=sb.append(word.content.toUpperCase(Locale.ENGLISH)).reverse().toString();
            System.out.println(word.content);
        }


    }
}
