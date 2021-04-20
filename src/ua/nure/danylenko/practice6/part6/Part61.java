package ua.nure.danylenko.practice6.part6;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

public class Part61 {
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
            }
        }

        sortFrequency(container);
    }

    private static void sortFrequency(List<LatinWord> container){
        for(int i=container.size()-1; i>=1; i--){
            for(int j=0; j<i; j++) {
                if(container.get(j).frequency<container.get(j+1).frequency){
                    LatinWord temp1 = container.get(j);
                    container.set(j, container.get(j + 1));
                    container.set((j + 1), temp1);
                }
            }
        }

        for(int m=3-1; m>=1; m--){
            for(int n=0; n<m; n++) {
                if (container.get(n + 1).compareTo(container.get(n)) > 0) {
                    LatinWord temp1 = container.get(n);
                    container.set(n, container.get(n + 1));
                    container.set((n + 1), temp1);
                }
            }
        }

        for(int i=0; i<3; i++){
            System.out.println(container.get(i).content+" ==> "+
                    container.get(i).frequency);
        }
    }

}
