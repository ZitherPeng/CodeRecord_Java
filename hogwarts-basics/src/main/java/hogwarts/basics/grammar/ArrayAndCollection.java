package hogwarts.basics.grammar;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;

public class ArrayAndCollection {

    /**
     * this method is used to test Array
     */
    @Test
    public void ArrayTest() {
        int[] intArrA = new int[5];
        System.out.println(intArrA[4]);

        String[] stringsArr = {"sd", "sd"};
        /* test For-Each */
        for (String string : stringsArr) {
            System.out.println(string);
        }
    }


    /**
     * this method test ArrayList and LinkedList add speed
     */
    @Test
    public void ListTest() {
        ArrayList arrayList = new ArrayList();
        LinkedList linkedList = new LinkedList();

        /* Arraylist add  elements add count time*/
        long arraylistStartTime = System.currentTimeMillis();
        for (int i = 0; i < 500000; i++) {
            arrayList.add(i);
        }
        long arraylistStopTime = System.currentTimeMillis();
        long arraylistExcuteTime = arraylistStopTime - arraylistStartTime;


        /* LinkedList add elements add count time*/
        long linkedlistStartTime = System.currentTimeMillis();
        for (int i = 0; i < 500000; i++) {
            linkedList.add(i);
        }
        long linkedlistStopTime = System.currentTimeMillis();
        long linkedlistExcuteTime = linkedlistStopTime - linkedlistStartTime;

        System.out.println(arraylistExcuteTime + " and " + linkedlistExcuteTime);

    }
}
