package ua.nure.danylenko.practice6.part1;


import java.io.Serializable;

public class Word implements Serializable {

    private static final long serialVersionUID = 121212;
    String content;
    int frequency;

    Word(String word){
        this.content=word;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null){
            return false;
        }

        if (this.getClass() != obj.getClass()){
            return false;
        }

        Word word = (Word)obj;
        return content.compareTo(word.content) == 0;
    }

    @Override
    public int hashCode() {
        return content.hashCode();
    }
}
