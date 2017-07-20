package module3_21;

/**
 * Created by tetya on 20.07.2017.
 */
public class Main {
    public static void main(String[] args) throws CustomException {


    MyCollection321 myCollection = new MyCollection321();
    for (int i = 0; i < 20 ; i++) {
        myCollection.addEl(2);
    }
    print(myCollection);

    myCollection.addElByPos(100,100);//not correct position
    print(myCollection);

    myCollection.addElByPos(1000,11);
    print(myCollection);


     myCollection.delElByPos(-1);//not correct position
    print(myCollection);



    }

    public static void print(MyCollection321 m){
        System.out.println("==========================================================");
        System.out.println("capacity" + m.getCapacity());
        System.out.println("size "+ m.size);
        System.out.print("all: " );
        for (int i = 0; i < m.size; i++) { System.out.print(" " + m.get(i)); }
        System.out.println("");
        System.out.println("Max: " + m.getMax());
        System.out.println("Min: " + m.getMin());
        System.out.println("Average: " + m.getAverage());
    }

    public static void generateException(String information) throws CustomException {
        throw new CustomException(information);
    }
}
