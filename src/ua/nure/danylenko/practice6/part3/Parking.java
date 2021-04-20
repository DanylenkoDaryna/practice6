package ua.nure.danylenko.practice6.part3;

import java.util.ArrayList;
import java.util.List;

public class Parking {

    private int numOfPlaces;
    private List<Integer> places;

    Parking(int number){
        numOfPlaces=number;
        places=new ArrayList<>();
        for (int i=0; i<numOfPlaces; i++){
            places.add(0);
        }
    }

    // Метод возвращает true, если машину удалось поставить на стоянку
    protected boolean arrive(int k){
        if(k>places.size()-1){
            throw new IllegalArgumentException();
        }

       if(places.get(k)==0){
           places.set(k,1);
           return true;
       }else{
           int offset=k;
           while(offset!=places.size()-1){
               offset=offset+1;
               if(places.get(offset)==0) {
                   places.set(offset, 1);
                   return true;
               }
           }
           offset=0;
           while(offset!=k){
               if(places.get(offset)==0) {
                   places.set(offset, 1);
                   return true;
               }
               offset=offset+1;
           }
       }
       return false;

    }

    // Метод возвращает true, если в позиции k находилась машина
    protected boolean depart(int k){
        if(k>places.size()-1){
            throw new IllegalArgumentException();
        }

        if(places.get(k)==1){
            places.set(k,0);
            return true;
        }
        return false;
    }

    //Методы бросает исключение IllegalArgumentException, если k находится вне диапазона [0, n-1].

    public void print(){

        for(Integer j:places){
            System.out.print(j);
        }
        System.out.println();
    }

}
