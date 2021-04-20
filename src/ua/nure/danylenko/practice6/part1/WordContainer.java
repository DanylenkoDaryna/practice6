package ua.nure.danylenko.practice6.part1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class WordContainer extends ArrayList {

    private static final long serialVersionUID = 21212;
    private transient List<Word> list;

    WordContainer(){
        list = new ArrayList<>();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(Word w:list){
            sb.append("[").append(w.content).append(" = ").append(w.frequency).
                    append("]");
        }
        return sb.toString();
    }

    @Override
    public boolean add(Object o) {
        Word word=(Word)o;
        if(!list.contains(word)){
           word.frequency=word.frequency+1;
           return list.add(word);
        }else{
            int i=list.indexOf(word);
            list.get(i).frequency = list.get(i).frequency+1;
        }
        return false;
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    public static void main(String[] args){
        WordContainer wc = new WordContainer();

        Scanner s = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        while (s.hasNextLine()) {
            String line = s.nextLine();
            if(line.contains("stop")) {
                int stopIndex=line.indexOf("stop");
                sb.append(line.substring(0,stopIndex)).append(System.lineSeparator());
                break;
            }else{
                sb.append(line).append(System.lineSeparator());
            }
        }
        String[] words = sb.toString().split(" |(\r\n)|\r|\n");
        for(String str:words){
            wc.add(new Word(str));
        }
        wc.sortFrequency();
    }

    private void sortFrequency(){
        for(int i=list.size()-1; i>=1; i--){
            for(int j=0; j<i; j++) {
                if (list.get(j).frequency < list.get(j + 1).frequency) {
                    Word temp = list.get(j);
                    list.set(j, list.get(j + 1));
                    list.set((j + 1), temp);
                }
            }
        }
        for(int k=0; k<list.size()-1; k++){
            for(int n=0; n<k; n++) {
                if (isFrequencyEquals(n)&&isContentEquals(n)) {
                        Word temp1 = list.get(n);
                        list.set(n, list.get(n + 1));
                        list.set((n + 1), temp1);
                }
            }
        }
        for (Word aList : list) {
            System.out.println(aList.content + " : " +
                    aList.frequency);
        }
    }

    private boolean isFrequencyEquals(int n) {
        return list.get(n).frequency == list.get(n + 1).frequency;
    }

    private boolean isContentEquals(int n) {
        return list.get(n + 1).content.compareTo(list.get(n).content) < 0;
    }

}
