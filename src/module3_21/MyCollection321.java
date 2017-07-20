package module3_21;

import java.util.Arrays;

/**
 * Created by tetya on 20.07.2017.
 */
public class MyCollection321 {
    int[] oldColl ;
    int[] coll ;
    int[] coll1 ;
    int oldCapacity;
    int newCapacity;
    int position; //collection is empty
    int size = 0 ;

    public MyCollection321() {
        this.oldCapacity = 20;
        this.oldColl = new int[oldCapacity];
        this.coll = new int[oldCapacity];
        this.position = -1;
        this.size = 0;
    }

    public Integer get(int index){
        if (index<size){
            return coll[index];
        } else return  null;
    }
    //збільшення розміру масиву. якщо його недостатньо
    public void ensureCapacity(int minCapacity){//minCapacity - розмір нового масиву
        if (coll.length+1 == minCapacity){
            oldColl = coll;
            newCapacity = oldCapacity + 10;//(int)oldCapacity*3/2+1;
            oldCapacity = newCapacity;
            coll = new int[newCapacity];
            System.arraycopy(oldColl,0,coll,0,size);
        }
    }

    public int getCapacity(){
        return coll.length;
    }

    public void addEl(Integer el) throws CustomException {
        if (el != null) {
            ensureCapacity(size+1);
            position++;
            coll[position] =  el;
            //при добавлении нового элемента все элементы увеличивают своё значение на добавляемый элемент
            for (int i = 0; i < position; i++) {
                coll[i] += el;
            }
            size++;
        }else {
            //System.out.println("Element can't be NULL");
            throw new CustomException("Element can't be NULL");
        }
    }

    public void addElByPos(int el, int pos) throws CustomException {
        if ((pos>=0)&(pos<size)) {
            if (el != 0) {
                ensureCapacity(size + 1);
                //при добавлении нового элемента все элементы увеличивают своё значение на добавляемый элемент
                for (int i = 0; i < size; i++) {
                    coll[i] += el;
                }
                for (int i = size; i >= pos; i--) {
                    coll[i] = coll[i - 1];
                }
                coll[pos] = el;
                size++;
            } else {
                //System.out.println("Element can't be NULL");
                 throw new CustomException("Element can't be NULL");
            }
        } else throw new CustomException("this position not correct");
    }

    public void delElByPos(int pos) throws CustomException {
        if ((pos>=0)&(pos<size)){
            int el = coll[pos];
            System.out.println(el);
            //при удалении - уменьшают своё значение на удаляемый элемент
            for (int i = 0; i < pos; i++) {
                coll[i] -= el;
            }
            for (int i = pos; i < coll.length - 1; i++) {
                coll[i] = coll[i + 1] - el;
            }
            size--;
        } else throw new CustomException("this position not exist");
    }

    //поиск элемента по значению
    public int[] getIndex (int el){
        int index[] = new int[size];int iIndex = 0;
        for (int k:index ) {k = -1;}
        int i = 0;
        while ((i<coll.length)){
            if ((coll[i]==el)){
                index[iIndex] = i;
                iIndex++;
            }
            i++;
        }
        return index;
    }
    //поиск элемента по индексу
    public int findEl (int index)throws CustomException {
        if ((index<0)|(index>=size)){
            throw new CustomException("this position not exist");
        }
        return coll[index];

    }

    //поиска максимального элемента
    public int getMax (){
        int[] c = new int[size];
        System.arraycopy(coll,0,c,0,size);
        return Arrays.stream(c)
                //.mapToInt(e -> e)
                .max()
                .getAsInt();
    }
    //поиска минимального элемента
    public int getMin (){
        int[] c = new int[size];
        System.arraycopy(coll,0,c,0,size);
        return Arrays.stream(c)
                //.mapToInt(e -> e)
                .min()
                .getAsInt();
    }
    //поиска среднего арифметического всех элементов
    public double getAverage (){
        int[] c = new int[size];
        System.arraycopy(coll,0,c,0,size);
        //IntStream.of(numbers).average();
        return Arrays.stream(c)
                //.mapToInt(e -> e)       //Для использования метода average нужно Stream<Integer> привести к IntStream
                .average()
                .getAsDouble();
    }

}
