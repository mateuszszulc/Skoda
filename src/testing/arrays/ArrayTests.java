package testing.arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: mateusz
 * Date: 28.02.12
 * Time: 23:47
 */

public class ArrayTests {
    public static void main(String[] args) {
        int[] intList = new int[10];
        intList[9] = 5;
//        for (int i : intList )
//        {
//            System.out.println("");
//        }

        List<Integer> lista = new ArrayList();
        lista.add(1);
        lista.add(2);

        for (Integer i : lista) {
            System.out.println(i);
        }

    }
}
