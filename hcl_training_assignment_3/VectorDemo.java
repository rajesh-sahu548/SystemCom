package hcl_training_assignment_3;


//package hcl.training.assignment3;

import java.util.Iterator;
import java.util.Vector;
import java.util.Arrays;

public class VectorDemo {

    public static void main(String[] args) {

        // ===============================
        // Constructors of Vector
        // ===============================

        Vector<Integer> v1 = new Vector<>();        // Default constructor
        Vector<Integer> v2 = new Vector<>(5);       // Initial capacity
        Vector<Integer> v3 = new Vector<>(5, 2);    // Capacity + increment
        Vector<Integer> v4 = new Vector<>(Arrays.asList(10, 20, 30)); // Collection

        // ===============================
        // 15 Methods of Vector
        // ===============================

        v1.add(1);                 // 1. add()
        v1.addElement(2);          // 2. addElement()
        v1.add(3);
        // v1 = [1, 2, 3]

        v1.addAll(v4);             // 3. addAll()
        // v1 = [1, 2, 3, 10, 20, 30]

        System.out.println(v1.get(0));   // 4. get()
        // Output: 1

        v1.set(0, 100);            // 5. set()
        // v1 = [100, 2, 3, 10, 20, 30]

        v1.remove(1);              // 6. remove(index)
        // v1 = [100, 3, 10, 20, 30]

        v1.removeElement(20);      // 7. removeElement()
        // v1 = [100, 3, 10, 30]

        System.out.println(v1.contains(10)); // 8. contains()
        // Output: true

        System.out.println(v1.indexOf(10));  // 9. indexOf()
        // Output: 2

        v1.add(10);
        // v1 = [100, 3, 10, 30, 10]

        System.out.println(v1.lastIndexOf(10)); // 10. lastIndexOf()
        // Output: 4

        System.out.println(v1.size());     // 11. size()
        // Output: 5

        System.out.println(v1.capacity()); // 12. capacity()
        // Output: 10  (default capacity grows automatically)

        System.out.println(v1.isEmpty());  // 13. isEmpty()
        // Output: false

        // 14. iterator()
        Iterator<Integer> itr = v1.iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }
        /*
        Output:
        100
        3
        10
        30
        10
        */

        v1.clear();                // 15. clear()
        System.out.println(v1);
        // Output: []
    }
}

