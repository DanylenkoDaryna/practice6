package ua.nure.danylenko.practice6.part3;

public class Part3 {

    public static void main(String[] args){
        Parking parking = new Parking(4);
        // 0010, true
        boolean temp=parking.arrive(2);
        System.out.print(temp+", ");
        parking.print();
        // 0011, true
        temp=parking.arrive(3);
        System.out.print(temp+", ");
        parking.print();

        // 1011, true
        temp=parking.arrive(2);
        System.out.print(temp+", ");
        parking.print();

        // 1111, true
        temp=parking.arrive(2);
        System.out.print(temp+", ");
        parking.print();

        // 1111, false
        temp=parking.arrive(2);
        System.out.print(temp+", ");
        parking.print();
        //1011, true
        temp=parking.depart(1);
        System.out.print(temp+", ");
        parking.print();
        //// 1011, false
        temp=parking.depart(1);
        System.out.print(temp+", ");
        parking.print();

    }
}
