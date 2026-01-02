package hcl_training_assignment_3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class ArrayListDemo {

    public static void main(String[] args) {

        // ===============================
        // Constructors of ArrayList
        // ===============================

        // 1. Default Constructor
        ArrayList<String> list1 = new ArrayList<>();

        // 2. Constructor with Initial Capacity
        ArrayList<String> list2 = new ArrayList<>(5);

        // 3. Constructor with Collection
        ArrayList<String> list3 =
                new ArrayList<>(Arrays.asList("Java", "Python", "C++"));

        // ===============================
        // 15 Methods of ArrayList
        // ===============================

        list1.add("Apple");                       // 1. add()
        list1.add("Banana");

        list1.add(1, "Mango");                    // 2. add(index, element)

        list1.addAll(list3);                      // 3. addAll(collection)

        list1.addAll(2, list2);                   // 4. addAll(index, collection)

        System.out.println(list1.get(0));         // 5. get()

        list1.set(0, "Orange");                   // 6. set()

        list1.remove(1);                          // 7. remove(index)

        list1.remove("Java");                     // 8. remove(object)

        System.out.println(list1.contains("C++"));// 9. contains()

        System.out.println(list1.indexOf("C++")); // 10. indexOf()

        list1.add("C++");
        System.out.println(list1.lastIndexOf("C++")); // 11. lastIndexOf()

        System.out.println(list1.size());         // 12. size()

        System.out.println(list1.isEmpty());      // 13. isEmpty()

        Iterator<String> itr = list1.iterator();  // 14. iterator()
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }

        list1.clear();                            // 15. clear()
        System.out.println(list1);
    }
}