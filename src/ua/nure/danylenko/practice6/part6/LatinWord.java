package ua.nure.danylenko.practice6.part6;

public class LatinWord implements Comparable{
    String content;
    int frequency;
    int letters;

    LatinWord(String word){
        this.content=word;
        this.frequency=1;
        this.letters=0;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null){
            return false;
        }

        if (this.getClass() != obj.getClass()){
            return false;
        }

        LatinWord word = (LatinWord)obj;

        return content.compareTo(word.content) == 0;
    }

    @Override
    public int hashCode() {
        return content.hashCode();
    }

    @Override
    public String toString() {
        return ""+content+": "+frequency+System.lineSeparator();
    }

    @Override
    public int compareTo(Object o) {
        LatinWord lw=(LatinWord)o;
        return Character.compare(this.content.charAt(0), lw.content.charAt(0));
    }
}


