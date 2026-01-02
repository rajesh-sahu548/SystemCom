package hcl_training_assignment_3;


import java.util.TreeMap;
import java.util.Map;
import java.util.Set;
import java.util.Collection;
import java.util.Comparator;

public class TreeMapDemo {

    public static void main(String[] args) {

        // ===============================
        // Constructors of TreeMap
        // ===============================

        TreeMap<Integer, String> tm1 = new TreeMap<>();
        // Default constructor (natural sorting – ascending)

        TreeMap<Integer, String> tm2 =
                new TreeMap<>(Comparator.reverseOrder());
        // Comparator constructor (descending order)

        TreeMap<Integer, String> tm3 = new TreeMap<>(tm1);
        // Map constructor (copy)

        // ===============================
        // 15 Methods of TreeMap
        // ===============================

        tm1.put(1, "Java");                 // 1. put()
        tm1.put(3, "Python");
        tm1.put(2, "C++");
        // tm1 = {1=Java, 2=C++, 3=Python}

        System.out.println(tm1.get(2));     // 2. get()
        // Output: C++

        tm1.remove(3);                      // 3. remove(key)
        // tm1 = {1=Java, 2=C++}

        System.out.println(tm1.containsKey(1)); // 4. containsKey()
        // Output: true

        System.out.println(tm1.containsValue("Java")); // 5. containsValue()
        // Output: true

        System.out.println(tm1.firstKey()); // 6. firstKey()
        // Output: 1

        System.out.println(tm1.lastKey());  // 7. lastKey()
        // Output: 2

        System.out.println(tm1.higherKey(1)); // 8. higherKey()
        // Output: 2

        System.out.println(tm1.lowerKey(2));  // 9. lowerKey()
        // Output: 1

        Set<Integer> keys = tm1.keySet();   // 10. keySet()
        System.out.println(keys);
        // Output: [1, 2]

        Collection<String> values = tm1.values(); // 11. values()
        System.out.println(values);
        // Output: [Java, C++]

        Set<Map.Entry<Integer, String>> entries = tm1.entrySet(); // 12. entrySet()
        System.out.println(entries);
        // Output: [1=Java, 2=C++]

        System.out.println(tm1.size());     // 13. size()
        // Output: 2

        System.out.println(tm1.isEmpty());  // 14. isEmpty()
        // Output: false

        tm1.clear();                        // 15. clear()
        System.out.println(tm1);
        // Output: {}
    }
}
