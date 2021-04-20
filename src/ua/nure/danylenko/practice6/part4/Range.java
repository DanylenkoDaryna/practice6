package ua.nure.danylenko.practice6.part4;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Range implements Iterable<Integer>{
    private int maxBorder;
    private int minBorder;
    private boolean reverseFlag;

    Range(int n, int m) {
        if(n>=m){
            maxBorder=n;
            minBorder=m;
        }else{
            maxBorder=m;
            minBorder=n;
        }
    }

    Range(int n, int m, boolean reverse) {
        reverseFlag=reverse;
        if(n>=m){
            maxBorder=n;
            minBorder=m;
        }else{
            maxBorder=m;
            minBorder=n;
        }
    }

    class IteratorImpl implements Iterator<Integer> {

        // index of next element to return
        private int cursor;


        IteratorImpl(){
            if(!Range.this.reverseFlag){
                cursor=Range.this.minBorder;
            }else{
                cursor=Range.this.maxBorder;
            }
        }


        @Override
        public boolean hasNext() {
            if(!Range.this.reverseFlag){
                return cursor<=Range.this.maxBorder;
            }else{
                return cursor>=Range.this.minBorder;
            }
        }

        @Override
        public Integer next() {
            if (cursor > Range.this.maxBorder||cursor < Range.this.minBorder) {
                throw new NoSuchElementException();
            }
            int temp = cursor;
            if(!Range.this.reverseFlag) {
                cursor = cursor + 1;
            }else{
                cursor = cursor - 1;
            }
            return (Integer)temp;
        }

    }


    @Override
    public Iterator<Integer> iterator() {
        return new IteratorImpl();
    }

}
